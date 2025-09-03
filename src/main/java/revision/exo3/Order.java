package revision.exo3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {
  private final int id;
  private final Instant dateDeCreation;
  private final Client client;
  private List<Dish> orderedDishes;

  public Order(int id, Instant dateDeCreation, Client client) {
    this.id = id;
    this.dateDeCreation = dateDeCreation;
    this.client = client;
    this.orderedDishes = new ArrayList<>();
  }

  public void setOrderedDishes(List<Dish> orderedDishes) {
    this.orderedDishes = orderedDishes;
  }

  public int getId() {
    return id;
  }

  public Instant getDateDeCreation() {
    return dateDeCreation;
  }

  public Client getClient() {
    return client;
  }

  public List<Dish> getOrderedDishes() {
    return orderedDishes;
  }
}
