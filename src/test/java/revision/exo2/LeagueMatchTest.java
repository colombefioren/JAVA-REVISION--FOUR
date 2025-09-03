package revision.exo2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeagueMatchTest {
  Fighter fighter1;
  Fighter fighter2;
  LeagueMatch leagueMatch;
  FriendlyMatch friendlyMatch;
  OfficialMatch officialMatch;
  TitleMatch titleMatch;

  @BeforeEach
  public void setUp() {
    fighter1 = new Fighter("1uuid", "Roberto", "Roberto The Fighter", 35);
    fighter2 = new Fighter("2uuid", "Jose", "Jose The Fighter", 30);
    friendlyMatch = new FriendlyMatch(1, LocalDate.now(), "Anjanahary", fighter1, fighter2);
    officialMatch = new OfficialMatch(2, LocalDate.now(), "Anjanahary", fighter1, fighter2);
    titleMatch = new TitleMatch(3, LocalDate.now(), "Anjanahary", fighter1, fighter2, "Champion");
    leagueMatch = new LeagueMatch("The League");
    leagueMatch.getFighters().addAll(Arrays.asList(fighter1, fighter2));
    leagueMatch.addMatch(friendlyMatch);
    leagueMatch.addMatch(officialMatch);
    leagueMatch.addMatch(titleMatch);
  }

  @Test
  public void testGetListOfMatchOfUser() {
    assertEquals(3, leagueMatch.getEveryMatchOfFighter(fighter1).size());
  }

  @Test
  public void testDuringOfficialMatch() {
    officialMatch.setPoint1(2);
    officialMatch.setPoint2(10);
    officialMatch.finish();
    assertEquals(1, fighter1.getDefeat());
    assertEquals(1, fighter2.getVictory());
  }

  @Test
  public void testDuringTitleMatch() {
    titleMatch.setPoint1(20);
    titleMatch.setPoint2(1);
    titleMatch.finish();
    assertEquals(1, fighter1.getTitleList().size());
    assertEquals(0, fighter2.getTitleList().size());
  }
}
