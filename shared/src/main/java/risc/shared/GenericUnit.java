package risc.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * an abstract class of Unit.
 */

public abstract class GenericUnit implements Unit, Modifiable {
  public PlayerInfo owner;
  public UnitType type;

  private int moveCost = 1;
  private List<Modifier> modifiers = new ArrayList<>();

  public GenericUnit(PlayerInfo owner) {
    this.owner = owner;
    this.type = UnitType.getUnitType("Civilian");
  }

  /**gives the unit owner.
   * @return the owner's PlayerInfo.
   */

  @Override
  public PlayerInfo getOwner() {
    return this.owner;
  }

  /**gives the unit type.
   * @return the owner's UnitType.
   */
  @Override
  public UnitType getType() {
    return this.type;
  }

  /**determines if this unit is visible to a player.
   * @return true.
   */
  @Override
  public boolean visibleTo(PlayerInfo target) {
    return true;
  }
}
