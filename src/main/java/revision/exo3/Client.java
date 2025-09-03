package revision.exo3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Client {
  private final int id;
  private final String firstName;
  private final String lastName;
  private final String phoneNumber;
  private final String email;
  private List<Order> orderList;

  public Client(int id, String firstName, String lastName, String phoneNumber, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.orderList = new ArrayList<>();
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public List<Order> getOrderList() {
    return orderList;
  }

  public List<Order> getOrderBetweenInstants(Instant instant1, Instant instant2) {
    List<Order> result = new ArrayList<>();
    for (Order order : orderList) {
      Instant orderDate = order.getDateDeCreation();
      boolean after = (instant1 == null || orderDate.isAfter(instant1));
      boolean before = (instant2 == null || orderDate.isBefore(instant2));
      if (after && before) {
        result.add(order);
      }
    }
    return result;
  }
}
