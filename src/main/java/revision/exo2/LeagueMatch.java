package revision.exo2;

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
}
