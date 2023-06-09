package risc.shared;

import java.util.ArrayList;
import java.util.List;
import risc.shared.Enums.*;

/**
 * an abstract class of Unit.
 */

public class GenericUnit implements Unit {
  public PlayerInfo owner;
  public UnitInfo info;
  private List<Modifier> modifiers = new ArrayList<>();

  public GenericUnit(PlayerInfo owner) {
    this.owner = owner;
    this.info = UnitInfo.getUnitInfo("Citizen Militia");
  }

  /**gives the unit owner.
   * @return the owner's PlayerInfo.
   */

  @Override
  public PlayerInfo getOwner() {
    return this.owner;
  }

  /**gives the unit info.
   * @return the unit's UnitInfo.
   */
  @Override
  public UnitInfo getInfo() {
    return this.info;
  }

  /**determines if this unit is visible to a player.
   * @return true.
   */
  @Override
  public boolean visibleTo(PlayerInfo target) {
    return true;
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
    return getAllModifiers();
  }
}
