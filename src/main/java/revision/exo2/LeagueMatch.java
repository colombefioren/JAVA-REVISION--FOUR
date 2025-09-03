package revision.exo2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeagueMatch {
  private final String name;
  private List<Fighter> fighters;
  private List<FriendlyMatch> matches;

  public LeagueMatch(String name, List<Fighter> fighters, List<FriendlyMatch> matches) {
    this.name = name;
    this.fighters = fighters;
    this.matches = matches;
  }

  public LeagueMatch(String name) {
    this.name = name;
    this.fighters = new ArrayList<>();
    this.matches = new ArrayList<>();
  }

  public void setFighters(List<Fighter> fighters) {
    this.fighters = fighters;
  }

  public void setMatches(List<FriendlyMatch> matches) {
    this.matches = matches;
  }

  public String getName() {
    return name;
  }

  public List<Fighter> getFighters() {
    return fighters;
  }

  public List<FriendlyMatch> getMatches() {
    return matches;
  }

  public FriendlyMatch createMatch(
      String typeMatch, int idMatch, String place, int date, Fighter fighter1, Fighter fighter2) {
    switch (typeMatch.toLowerCase()) {
      case "official":
        return new OfficialMatch(idMatch, LocalDate.now(), place, fighter1, fighter2);
      case "friendly":
        return new FriendlyMatch(idMatch, LocalDate.now(), place, fighter1, fighter2);
      case "titlematch":
      case "title match":
        return new TitleMatch(idMatch, LocalDate.now(), place, fighter1, fighter2);
      default:
        throw new IllegalArgumentException("Unknown match type");
    }
  }

  public List<FriendlyMatch> getEveryMatchOfFighter(Fighter fighter) {
    List<FriendlyMatch> matchesOfFighter = new ArrayList<>();
    for (FriendlyMatch match : matches) {
      if (match.getFighter1().equals(fighter) || match.getFighter2().equals(fighter)) {
        matchesOfFighter.add(match);
      }
    }
    return matchesOfFighter;
  }
}
