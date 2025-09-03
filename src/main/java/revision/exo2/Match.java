package revision.exo2;

import java.time.LocalDate;

public class Match {
  private final int id;
  private final LocalDate date;
  private final String location;
  private final Fighter fighter1;
  private final Fighter fighter2;

  public Match(int id, LocalDate date, String location, Fighter fighter1, Fighter fighter2) {
    this.id = id;
    this.date = date;
    this.location = location;
    this.fighter1 = fighter1;
    this.fighter2 = fighter2;
  }

  public Fighter getFighter1() {
    return fighter1;
  }

  public Fighter getFighter2() {
    return fighter2;
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
