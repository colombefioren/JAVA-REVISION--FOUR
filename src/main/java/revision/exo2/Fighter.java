package revision.exo2;

import java.util.ArrayList;
import java.util.List;

public class Fighter {
  private final String id;
  private final String name;
  private final String fighterName;
  private final int weight;
  private List<String> titleList;

  public Fighter(String id, String name, String fighterName, int weight) {
    this.id = id;
    this.name = name;
    this.fighterName = fighterName;
    this.weight = weight;
    this.titleList = new ArrayList<>();
  }

  public Fighter(String id, String name, String fighterName, int weight, List<String> titleList) {
    this.id = id;
    this.name = name;
    this.fighterName = fighterName;
    this.weight = weight;
    this.titleList = titleList;
  }

  public void setTitleList(List<String> titleList) {
    this.titleList = titleList;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getFighterName() {
    return fighterName;
  }

  public int getWeight() {
    return weight;
  }

  public List<String> getTitleList() {
    return titleList;
  }
}
