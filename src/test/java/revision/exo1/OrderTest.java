package revision.exo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {
    Dish dish1;
    Dish dish2;
    Dish dish3;
    Order order1;
    Order order2;
    Client client1;
    Client client2;
    OrderDish orderDish1;
    OrderDish orderDish2;
    OrderDish orderDish3;
    OrderDish orderDish4;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    OrderDish orderDish5;

    @BeforeEach
    void setup(){
        ingredient1 = new Ingredient(1,"Tomato");
        ingredient2 = new Ingredient(2,"Cheese");
        ingredient3 = new Ingredient(3,"Bread");
        dish1 = new Dish(1,"Pizza",10,DishType.MAIN, Arrays.asList(ingredient1,ingredient2));
        dish2 = new Dish(2,"Sandwich",50,DishType.SNACK,Arrays.asList(ingredient1,ingredient3));
        dish3 = new Dish(3,"Burger",100,DishType.MAIN,Collections.singletonList(ingredient2));
        client1 = new Client(1,"John","0612345678");
        client2 = new Client(2,"Jane","0698765432");
        order1 = new Order(1, LocalDate.now(),client1);
        order2 = new Order(2,LocalDate.now(),client2);
        orderDish1 = new OrderDish(1,dish1,order1,1);
        orderDish2 = new OrderDish(2,dish2,order2,2);
        orderDish3 = new OrderDish(3,dish1,order1,1);
        orderDish4 = new OrderDish(4,dish3,order1,1);
        orderDish5 = new OrderDish(5,dish1,order2,1);

        order1.setOrderedDishes(Arrays.asList(orderDish1,orderDish3));
    }

    @Test
    void test_should_return_true_when_ingredient_is_present_ok(){
        assertTrue(dish3.isIngredientPresent(ingredient2));
    }

    @Test
    void test_should_return_false_when_ingredient_is_not_present_ok(){
        assertFalse(dish3.isIngredientPresent(ingredient1));
    }

    @Test
    void test_should_return_true_when_order_is_empty_ok(){
        assertTrue(order2.isOrderEmpty());
    }

    @Test
    void test_should_return_false_when_order_is_not_empty_ok(){
        assertFalse(order1.isOrderEmpty());
    }

    @Test
    void test_should_return_total_ordered_dishes_with_quantity_ok(){
        HashMap<Dish, Integer> orderedDishesWithQuantity = new HashMap<>();
        orderedDishesWithQuantity.put(dish1,2);
        assertEquals(orderedDishesWithQuantity,order1.getDishesQuantity());
    }

    @Test
    void test_should_return_total_price_of_ordered_dishes_ok(){
        assertEquals(20,order1.totalPrice());
    }

    @Test
    void test_should_return_the_new_ordered_dishes_list_when_combining_ok(){
        order2.setOrderedDishes(Arrays.asList(orderDish2, orderDish4, orderDish5));
        order1.combineOrder(order2);

        HashMap<Dish, Integer> expectedQuantities = new HashMap<>();
        expectedQuantities.put(dish1, 3);
        expectedQuantities.put(dish2, 2);
        expectedQuantities.put(dish3, 1);

        assertEquals(expectedQuantities, order1.getDishesQuantity());
    }

}