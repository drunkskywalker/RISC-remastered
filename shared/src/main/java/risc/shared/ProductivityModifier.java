package risc.shared;

import java.util.List;

/**
 * A modifier class specifically for productivity modification. 
 * Characteristics: effective when calculating production, numeric.
 */

public class ProductivityModifier extends GenericModifier {
  /**Creates a time limited ProductivityModifier.
   * 
   * @param value is the numeric value of the modifier.
   * @param target is the attribute of the modifier.
   * @param scale is the scale where the modifier takes effect.
   * @param rounds is the time limit of the modifier.
   * @param id is the identifier of the modifier. 
   * @throws IllegalArgumentException if target is not one of the following: FOOD, TECH, MAGIC, or rounds is 0 or less than -1.
   *  
   */
  public ProductivityModifier(double value,
                              Target target,
                              Scale scale,
                              int rounds,
                              int id) {
    if (target != Target.FOOD && target != Target.TECH && target != Target.MAGIC) {
      throw new IllegalArgumentException(
          "Illegal ProductivityModifier constructor: the target of a ProductivityModifier must be one of the following: FOOD, TECH, MAGIC. Instead, target is " +
          target);
    }
    if (rounds == 0 && rounds < -1) {
      throw new IllegalArgumentException(
          "Illegal ProductivityModifier constructor: rounds must be a positive number (temporary) or -1 (permanent). Instead rounds is " +
          rounds);
    }
    this.value = value;
    this.target = target;
    this.scale = scale;
    this.id = id;
    this.rounds = rounds;
  }

  /**creates a permanent ProductivityModifier.
   * 
   * @param value is the numeric value of the modifier.
   * @param target is the attribute of the modifier.
   * @param scale is the scale where the modifier takes effect.
   * @param rounds is the time limit of the modifier.
   * @param id is the identifier of the modifier. 
   *
   */
  public ProductivityModifier(double value, Target target, Scale scale, int id) {
    this(value, target, scale, -1, id);
  }

  /**Checks if modifier is appliable with respect to given conditions.
   * @param target is the target attribute.
   * @param time is a list of appliable times.
   * @param scale is a list of appliable scales.
   * @return true if appliable, else return false.
   */
  @Override
  public boolean isAppliable(Target target, List<Time> time, List<Scale> scale) {
    return (this.target == target && scale.contains(this.scale));
  }
}
