package risc.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a tile of land.
 */

public class Tile {  //implements Modifiable {
  enum Terrain {
    PLAIN,
    HILLS,
    MOUNTAIN,
    TUNDRA,
    FOREST,
    TAIGA,
    SWAMP,
    URBAN,
    DESERT;
  }
  ;

  public final int id;
  public final String name;

  private PlayerInfo ownerInfo;

  private double foodProduction;
  private double techProduction;
  private double magicProduction;

  private double turmoil = 0;
  private int cloakTurns = 0;
  private int scoratchedEarthTurns = 0;
  private int fortificationLevel;

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

  /**assigns tile to the given owner.
   * 
   * @param owner is the new owner of the Tile object.
   *
   */
  public void setOwner(PlayerInfo owner) { this.ownerInfo = owner; }

  /**determines if a tile belongs to a player.
   * @param target is the player to check.
   * @return true if the tile belongs to target, false otherwise.
   */
  public boolean belongsTo(PlayerInfo target) { return this.ownerInfo.equals(target); }

  /**gets the food production of the tile.
   * @return the food production after modifiers.
   */

  public double getFoodProduction() { return this.foodProduction; }

  /**gets the tech production of the tile.
   * 
   * @return the tech production after modifiers.
   *
   */

  public double getTechProduction() { return this.techProduction; }

  /**gets the magic production of the tile.
   * 
   * @return the magic production after modifiers.
   *
   */

  public double getMagicProduction() { return this.magicProduction; }

  /**adds a new modifier to the tile.
   * 
   * @param m is the modifier to add.
   *
   */
  public void addModifier(Modifier m) { this.modifiers.add(m); }

  /*
  @Override
  public Tile modify(List<Modifier> modifiers) {
    List<Modifier> numericModifiers = new ArrayList<>();
    List<Modifier> gameRuleModifiers = new ArrayList<>();
    for (Modifier m : modifiers) {
      if (m instanceof NumericModifier) {
        numericModifiers.add(m);
      }
      if (m instanceof GameRuleModifier) {
        gameRuleModifiers.add(m);
      }
    }
  }
  */

  private void modifyNumeric(Tile toModify, List<Modifier> modifiers) {}
}
