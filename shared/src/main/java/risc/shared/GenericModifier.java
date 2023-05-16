package risc.shared;

public abstract class GenericModifier implements Modifier {
  protected double value;
  protected Target target;
  protected Scale scale;
  protected int id;
  protected int rounds;
  protected String description;

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
}
