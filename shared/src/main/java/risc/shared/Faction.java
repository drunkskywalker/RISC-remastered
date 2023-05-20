package risc.shared;

import java.util.ArrayList;
import java.util.List;
import risc.shared.Enums.Scale;
import risc.shared.Enums.Target;

public class Faction implements Modifiable {
  private ArrayList<Modifier> modifiers = new ArrayList<>();
  private Ruler ruler;

  public final String name;

  public Faction(String name, Ruler ruler) {
    this.name = name;
    this.ruler = ruler;
  }

  /**gives the ruler of this faction.
   * @return ruler of the faction.
   */
  public Ruler getRuler() { return this.ruler; }

  // Modifiable methods

  /**adds a new modifier.
   * 
   * @param m is the modifier to add.
   *
   */
  @Override
  public void addModifier(Modifier m) {
    this.modifiers.add(m);
  }

  /**recusively gives modifiers with given target type.
   * 
   * @param target is the type of attribute to get.
   * @param scale is the scale of the modifier.
   * @return a list of modifiers of that type.
   *
   */
  @Override
  public List<Modifier> getModifiers(Target target, Scale scale) {
    List<Modifier> temp = getAllModifiersRecursive();
    List<Modifier> result = new ArrayList<>();
    for (Modifier m : temp) {
      if (m.getTarget().equals(target) && m.getScale().equals(scale)) {
        result.add(m);
      }
    }
    return result;
  }

  /**gives all modifiers.
   * @return modifiers.
   */
  @Override
  public List<Modifier> getAllModifiers() {
    return modifiers;
  }

  /**gives all modifiers and all modifiers of the field which contains a modifiable object.
   * @return
   *
   */
  @Override
  public List<Modifier> getAllModifiersRecursive() {
    List<Modifier> result = modifiers;
    result.addAll(ruler.getAllModifiersRecursive());

    return result;
  }
}
