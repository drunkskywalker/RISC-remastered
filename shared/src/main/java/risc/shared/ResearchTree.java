package risc.shared;

import java.util.ArrayList;
import java.util.List;

public class ResearchTree {
  private static List<ResearchNode> roots = new ArrayList<>();
  static {
    roots.add(ResearchNode.getNode(0x00000000));
    roots.add(ResearchNode.getNode(0x10000000));
    roots.add(ResearchNode.getNode(0x20000000));
    roots.add(ResearchNode.getNode(0x30000000));
    roots.add(ResearchNode.getNode(0x40000000));
  }

  private List<ResearchNode> researched = new ArrayList<>();

  public ResearchTree() {
    for (ResearchNode rn : roots) {
      this.researched.add(rn);
    }
  }

  public boolean hasResearched(int id) {
    for (ResearchNode rn : researched) {
      if (rn.id == id) {
        return true;
      }
    }
    return false;
  }

  public void research(int id) {
    ResearchNode r = ResearchNode.getNode(id);
    researched.add(r);
  }

  public List<Integer> getDependency(int id, boolean recursive) {
    ResearchNode self = ResearchNode.getNode(id);
    List<Integer> result = self.getDependency();
    if (recursive) {
      for (Integer i : result) {
        result.addAll(getDependency(i, true));
      }
    }
    return result;
  }
}
