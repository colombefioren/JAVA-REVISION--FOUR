package revision.exo1;

import java.util.Date;

public class Order {
    private final int id;
    private final Date orderDate;
    private final Client client;


    public Order(int id, Date orderDate, Client client) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
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
}
