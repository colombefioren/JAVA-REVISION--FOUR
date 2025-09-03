package revision.exo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private final int id;
    private final LocalDate orderDate;
    private final Client client;
    private List<OrderDish> orderedDishes;


    public Order(int id, LocalDate orderDate, Client client, List<OrderDish> orderedDishes) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.orderedDishes = flattedOrderedDishes(orderedDishes);
    }

    public List<OrderDish> flattedOrderedDishes(List<OrderDish> orderedDishes) {
        HashMap<Dish, Integer> dishQuantities = new HashMap<>();

        for (OrderDish orderDish : orderedDishes) {
            dishQuantities.put(
                    orderDish.getDish(),
                    dishQuantities.getOrDefault(orderDish.getDish(), 0) + orderDish.getQuantity()
            );
        }

        List<OrderDish> flattened = new ArrayList<>();
        for (Dish dish : dishQuantities.keySet()) {
            orderedDishes.stream()
                    .filter(od -> od.getDish().equals(dish))
                    .findFirst()
                    .ifPresent(template -> flattened.add(new OrderDish(
                            template.getId(),
                            dish,
                            template.getOrder(),
                            dishQuantities.get(dish)
                    )));
        }

        return flattened;
    }



    public String showOrderedDishes(){
        StringBuilder sb = new StringBuilder();
        for(OrderDish orderDish : orderedDishes){
            sb.append(orderDish.getDish().getName()).append(" x").append(orderDish.getQuantity()).append("\n");
        }
        return sb.toString();
    }

    public void setOrderedDishes(List<OrderDish> orderedDishes) {
        this.orderedDishes = flattedOrderedDishes(orderedDishes);
    }

    public Order(int id, LocalDate orderDate, Client client) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.orderedDishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDate getOrderDate() {
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

    public HashMap<Dish, Integer> getDishesQuantity(){
        HashMap<Dish, Integer> dishes = new HashMap<>();
        for(OrderDish orderDish : orderedDishes){
            dishes.put(orderDish.getDish(), dishes.getOrDefault(orderDish.getDish(), 0) + orderDish.getQuantity());
        }
        return dishes;
    }
    public String showDishesWithQuantity(){
        StringBuilder sb = new StringBuilder();
        HashMap<Dish, Integer> dishes = getDishesQuantity();
        for(Dish dish : dishes.keySet()){
            sb.append(dish.getName()).append(" x").append(dishes.get(dish)).append("\n");
        }
        return sb.toString();
    }

    public double totalPrice(){
        double total = 0;
        for(OrderDish orderDish : orderedDishes){
            total += orderDish.getDish().getPrice() * orderDish.getQuantity();
        }
        return total;
    }

    public void combineOrder(Order order){
      for (OrderDish newOrderDish : order.getOrderedDishes()){
          boolean found = false;
          for(OrderDish existingOrderDish : orderedDishes){
              if(newOrderDish.getDish().equals(existingOrderDish.getDish())){
                  found = true;
                  existingOrderDish.setQuantity(newOrderDish.getQuantity() +  existingOrderDish.getQuantity());
                  break;
              }
          }
          if(!found){
              orderedDishes.add(newOrderDish);
          }
      }
    }

    public double totalPriceOfTypeDish(DishType type){
       double totalPrice = 0;
       for (OrderDish orderDish : orderedDishes){
           if(orderDish.getDish().getType() == type){
               totalPrice += orderDish.getDish().getPrice() * orderDish.getQuantity();
           }
       }
       return totalPrice;
    }

    public double getMostExpenseDish(){
        return orderedDishes.stream().mapToDouble(orderDish -> orderDish.getDish().getPrice()).max().orElse(0);
    }



    @Override
    public String toString(){
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", client=" + client +
                ", orderedDishes=" + orderedDishes +
                '}';
    }



}
