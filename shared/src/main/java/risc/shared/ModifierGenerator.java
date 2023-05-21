package risc.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import risc.shared.Enums.*;

public class ModifierGenerator {
  private static HashMap<Long, List<Modifier> > modifiers = new HashMap<>();
  static {
    // the debug modifier list
    modifiers.put(Long.valueOf(0x00000000), new ArrayList<Modifier>());

    // NCIPC: default, occupied by A0/A1 (game start state)
    Modifier mdf_NCIPC_default0 = new GenericModifier(
        0.15, Target.TECH, Scale.PLAYER, Time.PRODUCTION, true, 0x10000000);
    Modifier mdf_NCIPC_default1 = new GenericModifier(
        0.05, Target.RESEARCH, Scale.PLAYER, Time.RESEARCH, true, 0x10000000);
    ArrayList<Modifier> NCIPC_default = new ArrayList<>();
    NCIPC_default.add(mdf_NCIPC_default0);
    NCIPC_default.add(mdf_NCIPC_default1);
    for (Modifier m : NCIPC_default) {
      m.setDescription(
          "Northern Combined Institute of Physics and Chemistry (NCIPC) has, to a certain degree, made the Northern Provinces what they are today, and continues to shape the land even during the ongoing conflict. With the assistance from Volksstaat Großostland's researchers and engineers, NCIPC has maintained a steady delivery of fresh and exotic ideas. For those looking forward to a path of discovery and progress in a new, different direction, whether because they were rejeced by the National Academy of Arcanum due to *lack of talent*, or simply tired of their pedanticness, NCIPC is their first choice, and probably only choice.");
    }
    modifiers.put(Long.valueOf(0x10000000), NCIPC_default);

    // NCIPC: occupied
    Modifier mdf_NCIPC_occupied = new GenericModifier(
        0.05, Target.TECH, Scale.PLAYER, Time.PRODUCTION, true, 0x10000001);
    mdf_NCIPC_occupied.setDescription(
        "Northern Combined Institute of Physics and Chemistry (NCIPC), now reluctantly provides scientific novelty to the occupiers. With the absence of the advice from Volksstaat Großostland and the general rejective attitude from researchers, NCIPC is merely a shell of its former self, only willing to work on the most basic projects.");
    ArrayList<Modifier> NCIPC_occupied = new ArrayList<>();
    NCIPC_occupied.add(mdf_NCIPC_occupied);
    modifiers.put(Long.valueOf(0x10000001), NCIPC_occupied);
  }

  public static List<Modifier> getModifiers(long id) { return modifiers.get(id); }
}
