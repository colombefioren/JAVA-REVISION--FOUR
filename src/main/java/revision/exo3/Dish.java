package revision.exo3;

public class Dish {
  private final int id;
  private final String name;

  public Dish(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
