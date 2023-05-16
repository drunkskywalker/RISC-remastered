package risc.shared;

import java.util.ArrayList;
import java.util.List;

public class ServerMap implements Map {
  private ArrayList<Tile> tiles = new ArrayList<>();
  private double[][] distanceMatrix = new double[100][100];
  private Path[][] pathMatrix = new Path[100][100];
  private List<Modifier> modifiers = new ArrayList<>();

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

  /**gives the total food production of a player.
   * @param owner is the player.
   * @return the food production of the player.
   */

  @Override
  public double getFoodProduction(PlayerInfo owner) {
    double food = 0;
    for (Tile t : tiles) {
      if (t.belongsTo(owner)) {
        food += t.getFoodProduction();
      }
    }
    return food;
  }

  /**gives the total tech production of a player.
   * @param owner is the player.
   * @return the tech production of the player.
   */

  @Override
  public double getTechProduction(PlayerInfo owner) {
    double tech = 0;
    for (Tile t : tiles) {
      if (t.belongsTo(owner)) {
        tech += t.getTechProduction();
      }
    }
    return tech;
  }

  /**gives the total magic production of a player.
   * @param owner is the player.
   * @return the magic production of the player.
   */

  @Override
  public double getMagicProduction(PlayerInfo owner) {
    double magic = 0;
    for (Tile t : tiles) {
      if (t.belongsTo(owner)) {
        magic += t.getMagicProduction();
      }
    }
    return magic;
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

  @Override
  public Visibility getVisibility(PlayerInfo player) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void resolveRequest(Request request) {
    // TODO Auto-generated method stub
  }
}
