package revision.exo2;

import java.time.LocalDate;

public class FriendlyMatch {
  private final int id;
  private final LocalDate date;
  private final String location;
  private final Fighter fighter1;
  private final Fighter fighter2;
  private int point1;
  private int point2;
  private boolean finished;

  public FriendlyMatch(
      int id, LocalDate date, String location, Fighter fighter1, Fighter fighter2) {
    this.id = id;
    this.date = date;
    this.location = location;
    this.fighter1 = fighter1;
    this.fighter2 = fighter2;
    this.finished = false;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setPoint1(int point1) {
    this.point1 = point1;
  }

  public void setPoint2(int point2) {
    this.point2 = point2;
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

  public int getPoint1() {
    return point1;
  }

  public int getPoint2() {
    return point2;
  }

  public String getLocation() {
    return location;
  }

  public void finish() {
    this.finished = true;
  }
}
