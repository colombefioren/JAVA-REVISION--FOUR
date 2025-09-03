package revision.exo3;

import java.time.Instant;

public class PriceRecord {
  private final int id;
  private Instant date;
  private double price;
  private String reason;

  public PriceRecord(int id, Instant date, double price, String reason) {
    this.id = id;
    this.date = date;
    this.price = price;
    this.reason = reason;
  }

  public int getId() {
    return id;
  }

  public Instant getDate() {
    return date;
  }

  public double getPrice() {
    return price;
  }

  public String getReason() {
    return reason;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
