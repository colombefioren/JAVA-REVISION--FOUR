package revision.exo2;

import java.time.LocalDate;

public class OfficialMatch extends FriendlyMatch {
  public OfficialMatch(
      int id, LocalDate date, String location, Fighter fighter1, Fighter fighter2) {
    super(id, date, location, fighter1, fighter2);
  }
}
