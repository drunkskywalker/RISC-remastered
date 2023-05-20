package risc.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResearchNode {
  private static HashMap<Integer, ResearchNode> allNodes = new HashMap<>();
  static {
    allNodes.put(0x0000000, new ResearchNode(0x00000000, "Basic Agriculture"));
    allNodes.put(0x1000000, new ResearchNode(0x10000000, "Surface Mining"));
    allNodes.put(0x2000000, new ResearchNode(0x20000000, "Magic Escavation"));
    allNodes.put(0x3000000, new ResearchNode(0x30000000, "Northern Expedition Armament"));
    allNodes.put(0x4000000, new ResearchNode(0x40000000, "Wood-Iron Frame Building"));
  }
  public final long id;
  public final String name;
  private List<Integer> dependsOn = new ArrayList<>();
  private List<Integer> leadsTo = new ArrayList<>();
  public ResearchNode(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public static ResearchNode getNode(int id) { return allNodes.get(id); }
  public List<Integer> getDependency() { return dependsOn; }
  public List<Integer> getUnlock() { return leadsTo; }
}
