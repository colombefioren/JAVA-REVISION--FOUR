package revision.exo1;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Collections;

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

    @BeforeEach
    void setup(){
        dish1 = new Dish(1,"Pizza",10,DishType.MAIN);
        dish2 = new Dish(2,"Sandwich",50,DishType.SNACK);
        dish3 = new Dish(3,"Burger",100,DishType.MAIN);
        client1 = new Client(1,"John","0612345678");
        client2 = new Client(2,"Jane","0698765432");
        order1 = new Order(1, LocalDate.now(),client1);
        order2 = new Order(2,LocalDate.now(),client2);
        orderDish1 = new OrderDish(1,dish1,order1,1);
        orderDish2 = new OrderDish(2,dish2,order2,2);
        orderDish3 = new OrderDish(3,dish1,order1,1);
        orderDish4 = new OrderDish(4,dish3,order1,1);

        order1.setOrderedDishes(Collections.singletonList(orderDish1));


    }
}