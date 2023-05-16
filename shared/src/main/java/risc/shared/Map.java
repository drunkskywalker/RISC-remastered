package risc.shared;

import java.util.List;

public interface Map {
  public enum Visibility {
    FULL,
    PARTIAL,
    OUTDATED,
    NONE,
  }
  ;
  public enum Path {
    DIRT_PATH,
    COBBLE_PATH,
    MACADAM_PATH,
    RAILWAY,
    PONTOON_BRIDGE,
    STONE_ARCH_BRIDGE,
    RAILWAY_BRIDGE,
  }
  ;
  public void assignTo(int tileId, PlayerInfo owner);

  public double getFoodProduction(PlayerInfo owner);
  public double getTechProduction(PlayerInfo owner);
  public double getMagicProduction(PlayerInfo owner);

  public boolean isAdjacent(int id0, int id1);
  public boolean hasPath(PlayerInfo player, int id0, int id1);
  public double getDistance(PlayerInfo player, int id0, int id1);

  public Visibility getVisibility(PlayerInfo player);

  public void resolveRequest(Request request);
}