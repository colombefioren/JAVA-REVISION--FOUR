package revision.exo2;

import java.time.LocalDate;

public class TitleMatch extends FriendlyMatch {
  public final String title;

  public TitleMatch(
      int id, LocalDate date, String location, Fighter fighter1, Fighter fighter2, String title) {
    super(id, date, location, fighter1, fighter2);
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public void finish() {
    super.finish();
    if (this.getPoint1() > this.getPoint2()) {
      super.getFighter1().Victory();
      super.getFighter2().Defeat();
      super.getFighter1().addTitle(title);
    } else if (this.getPoint1() < this.getPoint2()) {
      super.getFighter2().Victory();
      super.getFighter1().Defeat();
      super.getFighter2().addTitle(title);
    } else {
      super.getFighter1().Null();
      super.getFighter2().Null();
    }
  }
}
