package risc.shared;

import java.util.List;

public class GenericModifier implements Modifier {
  protected double value;
  protected Enums.Target target;
  protected Enums.Scale scale;
  protected Enums.Time time;
  protected long id;
  protected int rounds;
  protected String description;
  protected boolean isPercentage;

  /**Creates a time limited GenericModifier.
   * 
   * @param value is the numeric value of the modifier.
   * @param target is the attribute of the modifier.
   * @param scale is the scale where the modifier takes effect.
   * @param time is when the modifier takes effect.
   * @param rounds is the time limit of the modifier.
   * @param id is the identifier of the modifier. 
   *  
   */

  //   * @throws IllegalArgumentException if target is not one of the following: FOOD, TECH, MAGIC, or rounds is 0 or less than -1.

  public GenericModifier(double value,
                         Enums.Target target,
                         Enums.Scale scale,
                         Enums.Time time,
                         boolean isPercentage,
                         int rounds,
                         long id) {
    /*
    if (target != Enums.Target.FOOD && target != Enums.Target.TECH &&
        target != Enums.Target.MAGIC) {
      throw new IllegalArgumentException(
          "Illegal GenericModifier constructor: the target of a GenericModifier must be one of the following: FOOD, TECH, MAGIC. Instead, target is " +
          target);
    }
    */
    if (rounds == 0 || rounds < -1) {
      throw new IllegalArgumentException(
          "Illegal GenericModifier constructor: rounds must be a positive number (temporary) or -1 (permanent). Instead rounds is " +
          rounds);
    }
    this.value = value;
    this.target = target;
    this.scale = scale;
    this.time = time;
    this.isPercentage = isPercentage;
    this.id = id;
    this.rounds = rounds;
  }

  /**creates a permanent GenericModifier.
   * 
   * @param value is the numeric value of the modifier.
   * @param target is the attribute of the modifier.
   * @param scale is the scale where the modifier takes effect.
   * @param time is when the modifier takes effect.
   * @param rounds is the time limit of the modifier.
   * @param id is the identifier of the modifier. 
   *
   */
  public GenericModifier(double value,
                         Enums.Target target,
                         Enums.Scale scale,
                         Enums.Time time,
                         boolean isPercentage,
                         long id) {
    this(value, target, scale, time, isPercentage, -1, id);
  }

  /**changes the rounds remaining for the modifier to be effective. 
   * @param r is the number of rounds to change. positive to increase the rounds, negative to decrease the rounds.
   * @throws IllegalArgumentException if rounds is -1, as this Modifier should be permanent and not to be changed.
   */
  @Override
  public void changeRounds(int r) {
    if (this.rounds == -1) {
      throw new IllegalArgumentException(
          "Illegal Modifier changeRounds: modifier is permanently effectively, but method tries to change its effect round count.");
    }
    this.rounds += r;
  }

  /**ticks the effective time down by one round, as normally would do at end turn.
   * @return true is the modifier is still effective, false otherwise.
   */
  @Override
  public boolean tickRound() {
    try {
      changeRounds(-1);
    }
    catch (IllegalArgumentException e) {
      // absolutely do nothing
    }
    return isEffective();
  }

  /**checks if the modifier is effective.
   * 
   * @return true if the modifier is permanent or has not yet ended. false otherwise.
   */
  @Override
  public boolean isEffective() {
    return !(this.rounds == 0);
  }

  /**gives the modifier description.
   * @return the description.
   */

  public String getDescription() { return this.description; }

  /**updates the modifier description.
   * @param newDescription is the new description.
   */
  public void setDescription(String newDescription) { this.description = newDescription; }

  /**Applies modifier to given value.
   * @param input is the value to be modified.
   * @return the modified value.
   */
  @Override
  public double apply(double input) {
    return input + value;
  }

  /**gives target attribute of the modifier.
   * @return target of the modifier.
   */
  @Override
  public Enums.Target getTarget() {
    return this.target;
  }

  /**gives scale of the modifier.
   * @return scale of the modifier.
   */
  @Override
  public Enums.Scale getScale() {
    return this.scale;
  }

  /**gives if the modifier is a percentage increase.
   * @return true if percentage, false if value.
   */
  @Override
  public boolean isPercentage() {
    return isPercentage;
  }

  /**Checks if modifier is appliable with respect to given conditions. conditions are given as null if no specific condition is set.  
   * @param target is the target attribute.
   * @param time is a list of appliable times.
   * @param scale is a list of appliable scales.
   * @return true if appliable, else return false.
   */
  @Override
  public boolean isAppliable(List<Enums.Target> target,
                             List<Enums.Time> time,
                             List<Enums.Scale> scale) {
    boolean targetMatch = (target == null) || (target.contains(this.target));
    boolean timeMatch = (time == null) || (time.contains(this.time));
    boolean scaleMatch = (scale == null) || (scale.contains(this.scale));

    return (targetMatch && timeMatch && scaleMatch);
  }
}
