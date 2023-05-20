package risc.shared;

import java.util.ArrayList;
import java.util.List;
import risc.shared.Enums.*;

/**
 * A class to represent a tile of land.
 */

public class Tile implements Modifiable {
  public final int id;
  public final String name;

  private PlayerInfo ownerInfo;

  private double foodProduction;
  private double techProduction;
  private double magicProduction;

  private double turmoil = 0;
  private int cloakTurns = 0;
  private int scoratchedEarthTurns = 0;
  private int fortificationLevel = 0;

  private Terrain terrain;
  private ArrayList<Modifier> modifiers = new ArrayList<>();
  private ArrayList<Unit> units = new ArrayList<Unit>();

  /**creates a Tile object, starting to be neutral.
   * 
   * @param id is the tile id.
   * @param name is the tile name.
   *
   */

  public Tile(int id, String name, Terrain terrain) {
    this.id = id;
    this.name = name;
    this.ownerInfo = new PlayerInfo();
    this.terrain = terrain;

    addTerrainMod(terrain);
  }

  private void addTerrainMod(Terrain terrain) {
    switch (terrain) {
      case PLAIN:

        break;
      default:
        break;
    }
  }

  /**adds a unit to the tile.
   * @param u is the unit to add.
   */
  public void addUnit(Unit u) { this.units.add(u); }

  /**assigns tile to the given owner. 
   * @param owner is the new owner of the Tile object.
   */
  public void setOwner(PlayerInfo owner) { this.ownerInfo = owner; }

  /**determines if a tile belongs to a player.
   * @param target is the player to check.
   * @return true if the tile belongs to target, false otherwise.
   */
  public boolean belongsTo(PlayerInfo target) { return this.ownerInfo.equals(target); }

  /**gets the production with corresponding type of resource.
   * @param resource is the resource to get.
   * @return the corresponding production after modifiers of Tile and unit.
   *@throws IllegalArgumentException if resource is not FOOD, TECH, or MAGIC.
   */
  public double getProduction(Target resource) {
    double result;
    List<Modifier> ms = getModifiers(resource, Scale.TILE);
    switch (resource) {
      case FOOD:

        result = this.foodProduction;
        break;
      case TECH:
        result = this.techProduction;
        break;
      case MAGIC:
        result = this.magicProduction;
        break;

      default:
        throw new IllegalArgumentException(
            "Illegal Tile getProduction: expecting resource to be FOOD, TECH or MAGIC, but got " +
            resource);
    }

    return Modifiable.applyModifiers(result, ms);
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
    for (Unit u : units) {
      result.addAll(u.getAllModifiersRecursive());
    }
    return result;
  }
}
