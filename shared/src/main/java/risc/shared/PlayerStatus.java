package risc.shared;

import java.util.ArrayList;
import java.util.List;
import risc.shared.Enums.*;

public class PlayerStatus implements Status {
  private PlayerInfo playerInfo;

  private List<Modifier> modifiers = new ArrayList<>();
  private Map map;

  private double foodAccumulation;
  private double techAccumulation;
  private double magicAccumulation;
  private int techResearchLevel;
  private double techResearchProgress;
  private int magicResearchLevel;
  private double magicResearchProgress;

  public double getProduction(Target resource) {
    double result = map.getProduction(playerInfo, resource);

    List<Modifier> modifiers = getModifiers(resource, Scale.MAP);
    result = Modifiable.applyModifiers(result, modifiers);
    return result;
  }

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

    result.addAll(map.getAllModifiersRecursive());

    return result;
  }
}
