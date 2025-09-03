package revision.exo1;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private final int id;
    private final String name;
    private final double price;
    private final DishType type;
    private final List<Ingredient> ingredients;

    public Dish(int id, String name, double price, DishType type, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.ingredients = ingredients;
    }

    public Dish(int id, String name, double price, DishType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.ingredients = new ArrayList<>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
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

    public boolean isIngredientPresent(Ingredient ingredient){
        return ingredients.contains(ingredient);
    }
}
