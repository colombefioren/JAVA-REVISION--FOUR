package revision.exo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Fighter {
  private final String id;
  private final String name;
  private final String fighterName;
  private final int weight;
  private List<String> titleList;
  private HashMap<String, Integer> palmares = new HashMap<>();

  public Fighter(String id, String name, String fighterName, int weight) {
    this.id = id;
    this.name = name;
    this.fighterName = fighterName;
    this.weight = weight;
    this.titleList = new ArrayList<>();
    this.palmares = new HashMap<>();
    this.palmares.put("Victory", 0);
    this.palmares.put("Defeat", 0);
    this.palmares.put("Null", 0);
  }

  public void Victory(){
    this.palmares.put("Victory", this.palmares.get("Victory") + 1);
  }
  public void Defeat(){
    this.palmares.put("Defeat", this.palmares.get("Defeat") + 1);
  }

  public void Null(){
    this.palmares.put("Null", this.palmares.get("Null") + 1);
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

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) return false;
    if (obj.equals(this)) return true;
    Fighter other = (Fighter) obj;
    return id.equals(other.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
