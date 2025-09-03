package revision.exo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Order {
    private final int id;
    private final Date orderDate;
    private final Client client;
    private final List<OrderDish> orderedDishes;


    public Order(int id, Date orderDate, Client client, List<OrderDish> orderedDishes) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.orderedDishes = orderedDishes;
    }

    public Order(int id, Date orderDate, Client client) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.orderedDishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Client getClient() {
        return client;
    }

    public boolean isOrderEmpty(){
        return orderedDishes.isEmpty();
    }

    public List<OrderDish> getOrderedDishes() {
        return orderedDishes;
    }

    public HashMap<OrderDish, Integer> getDishesQuantity(){
        HashMap<OrderDish, Integer> dishes = new HashMap<>();
        for(OrderDish dish : orderedDishes){
            dishes.put(dish, dishes.getOrDefault(dish, dish.getQuantity()) + dish.getQuantity());
        }
        return dishes;
    }

    public double totalPrice(){
        double total = 0;
        for(OrderDish dish : orderedDishes){
            total += dish.getDish().getPrice() * dish.getQuantity();
        }
        return total;
    }

    public void combineOrder(Order order){
      for (OrderDish newDish : order.getOrderedDishes()){
          for(OrderDish exisitingDish : orderedDishes){
              if(newDish.getDish() == exisitingDish.getDish())
          }
      }
    }



}
