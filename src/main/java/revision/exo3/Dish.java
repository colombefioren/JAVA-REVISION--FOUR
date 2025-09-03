package revision.exo3;

import java.util.List;

public class Dish {
  private final int id;
  private final String name;
  private List<PriceRecord> priceRecordList;

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

  public double getCurrentPrice(){
    return priceRecordList.getLast().getPrice();
  }
}
