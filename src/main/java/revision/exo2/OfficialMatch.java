package revision.exo2;

import java.time.LocalDate;

public class OfficialMatch extends FriendlyMatch {
  public OfficialMatch(
      int id, LocalDate date, String location, Fighter fighter1, Fighter fighter2) {
    super(id, date, location, fighter1, fighter2);
  }

  @Override
  public void finish() {
    super.finish();
    if (this.getPoint1() > this.getPoint2()) {
      super.getFighter1().Victory();
    }
    else if(this.getPoint1() < this.getPoint2()){
      super.getFighter2().Victory();
    }else{
      super.getFighter1().Null();
      super.getFighter2().Null();
    }
  }
}
