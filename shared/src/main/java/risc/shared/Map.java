package risc.shared;

import java.util.List;
import risc.shared.Enums.*;

public interface Map extends Modifiable {
  public void assignTo(int tileId, PlayerInfo owner);

  public double getProduction(PlayerInfo owner, Enums.Target resource);

  public boolean isAdjacent(int id0, int id1);
  public boolean hasPath(PlayerInfo player, int id0, int id1);
  public double getDistance(PlayerInfo player, int id0, int id1);

  //public Visibility getVisibility(PlayerInfo player);

  public void resolveRequests(List<Request> requests);
}
