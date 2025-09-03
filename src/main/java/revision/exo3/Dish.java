package revision.exo3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dish {
  private final int id;
  private final String name;
  private List<PriceRecord> priceRecordList;

  public Dish(int id, String name) {
    this.id = id;
    this.name = name;
    this.priceRecordList = new ArrayList<>();
  }

  public List<PriceRecord> getPriceRecordList() {
    return priceRecordList;
  }

  public void setPriceRecordList(List<PriceRecord> priceRecordList) {
    this.priceRecordList = priceRecordList;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCurrentPrice() {
    return priceRecordList.getLast().getPrice();
  }

  public double getPriceAtAnInstant(Instant date) {
    return priceRecordList.stream()
        .filter(priceRecord -> priceRecord.getDate().isBefore(date))
        .max(Comparator.comparing(PriceRecord::getDate))
        .map(PriceRecord::getPrice)
        .get();
  }
}
