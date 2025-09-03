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
        for(OrderDish orderDish : orderedDishes){
            total += orderDish.getDish().getPrice() * orderDish.getQuantity();
        }
        return total;
    }

    public void combineOrder(Order order){
        int ancientQuantity = 0;
        boolean found = false;
      for (OrderDish newOrderDish : order.getOrderedDishes()){
          found = false;
          for(OrderDish existingOrderDish : orderedDishes){
              if(newOrderDish.getDish() == existingOrderDish.getDish()){
                  found = true;
                  ancientQuantity = existingOrderDish.getQuantity();
                  existingOrderDish.setQuantity(newOrderDish.getQuantity() +  ancientQuantity);
                  break;
              }
          }
          if(found == false){
              orderedDishes.add(newOrderDish);
          }
      }
    }



}
