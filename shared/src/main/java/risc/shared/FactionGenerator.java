package risc.shared;

import java.util.HashMap;
import risc.shared.Enums.*;
public class FactionGenerator {
  private static HashMap<RulerCode, Faction> factionMap = new HashMap<>();
  private static Faction makeFaction(RulerCode rc) {
    //TODO: add modifiers

    Ruler r;
    Faction f;
    switch (rc) {
      case A0:
        r = new Ruler("Vanguards of Constitution");
        f = new Faction("Continental Popular Sovereignty", r);
        break;
      case A1:
        r = new Ruler("Directorial Government");
        f = new Faction("Continental Popular Sovereignty", r);
        break;
      case B0:
        r = new Ruler("Fanatic Mystics");
        f = new Faction("Peasantocracy Association of Northern Provinces", r);
        break;
      case B1:
        r = new Ruler("Agriprimacists");
        f = new Faction("Peasantocracy Association of Northern Provinces", r);
        break;
      case C0:
        r = new Ruler("Grand Marshal Loyalists");
        f = new Faction("Order of Thorn and Sword", r);
        break;
      case C1:
        r = new Ruler("Military Council");
        f = new Faction("Order of Thorn and Sword", r);
        break;
      case D0:
        r = new Ruler("House of Morgenstern");
        f = new Faction("League of Star and Rose", r);
        break;
      case D1:
        r = new Ruler("House of Karmesinrot");
        f = new Faction("League of Star and Rose", r);

        break;
      default:
        r = new Ruler("Placeholder");
        f = new Faction("Placeholder", r);
        break;
    }
    return f;
  }

  static {
    for (RulerCode r : RulerCode.values()) {
      factionMap.put(r, makeFaction(r));
    }
  }

  public static Faction getFaction(RulerCode rc) { return factionMap.get(rc); }
}
