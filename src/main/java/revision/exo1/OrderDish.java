package revision.exo1;

public class OrderDish {
    private final int id;
    private final Dish dish;
    private final Order order;
    private int quantity;

    public OrderDish(int id, Dish dish, Order order, int quantity) {
        this.id = id;
        this.dish = dish;
        this.order = order;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Dish getDish() {
        return dish;
    }

    public Order getOrder() {
        return order;
    }

    public int getQuantity() {
        return quantity;
    }
}
