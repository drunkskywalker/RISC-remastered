package risc.shared;

import java.util.ArrayList;
import java.util.List;
import risc.shared.Enums.*;

public abstract class GenericMap implements Map {
  protected ArrayList<Tile> tiles = new ArrayList<>();
  protected double[][] distanceMatrix = new double[100][100];
  protected Path[][] pathMatrix = new Path[100][100];
  protected List<Modifier> modifiers = new ArrayList<>();  // stores map modifiers

  //private double applyModifiers(double input, List<Modifier> modifiers) { return input; }

  /**gives the tile with specified id.
   * @param tileId is the tile id.
   * @return the tile with specified id.
   */
  private Tile getTile(int tileId) { return tiles.get(tileId); }

  /**assigns the tile determined by the tileId to the owner.
   * @param tileId is the tile id.
   * @param owner is the new owner's PlayerInfo.
   */

  @Override
  public void assignTo(int tileId, PlayerInfo owner) {
    this.getTile(tileId).setOwner(owner);
  }

  /**gives the production of a player with provided resource target.
   * @param owner is the player.
   * @param resource is the attribute to get.
   * @return the production of the player.
   */
  @Override
  public double getProduction(PlayerInfo owner, Target resource) {
    double result = 0;
    for (Tile t : tiles) {
      result += t.getProduction(resource);
    }

    List<Modifier> mds = getModifiers(resource, Scale.MAP);
    result = Modifiable.applyModifiers(result, mds);
    return result;
  }

  private double[][] calculateShortestPath(PlayerInfo player) {
    int size = tiles.size();
    double[][] ans = new double[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (!this.getTile(i).belongsTo(player) || !this.getTile(j).belongsTo(player)) {
          ans[i][j] = -1;
        }
        else {
          ans[i][j] = distanceMatrix[i][j];
        }
      }
    }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          if (ans[i][k] != -1 && ans[k][j] != -1 && ans[i][j] > ans[i][k] + ans[k][j]) {
            double newdist = ans[i][k] + ans[k][j];
            ans[i][j] = newdist;
          }
        }
      }
    }
    return ans;
  }

  @Override
  public boolean isAdjacent(int id0, int id1) {
    return distanceMatrix[id0][id1] != -1;
  }

  @Override
  public boolean hasPath(PlayerInfo player, int id0, int id1) {
    return this.calculateShortestPath(player)[id0][id1] != -1;
  }

  @Override
  public double getDistance(PlayerInfo player, int id0, int id1) {
    return this.calculateShortestPath(player)[id0][id1];
  }

  /*
  @Override
  public Visibility getVisibility(PlayerInfo player) {
    // TODO Auto-generated method stub
    return null;
  }
  */

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
    for (Tile t : tiles) {
      result.addAll(t.getAllModifiersRecursive());
    }
    return result;
  }
}
