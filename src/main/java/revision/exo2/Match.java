package revision.exo2;

import java.time.LocalDate;

public class Match {
  private final int id;
  private final LocalDate date;
  private final String location;

  public Match(int id, LocalDate date, String location) {
    this.id = id;
    this.date = date;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getLocation() {
    return location;
  }
}
