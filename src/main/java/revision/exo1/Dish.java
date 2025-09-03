package revision.exo1;

public class Dish {
    private final int id;
    private final String name;
    private final double price;
    private final DishType type;

    public Dish(int id, String name, double price, DishType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public DishType getType() {
        return type;
    }
}
