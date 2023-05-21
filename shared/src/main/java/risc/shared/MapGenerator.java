package risc.shared;

import java.util.List;
import risc.shared.Enums.Path;
/**
 * A class to construct maps
 */

public class MapGenerator {
  //  0-9: A0/A1
  // 10-19: B0/B1
  // 20-29: C0/C1
  // 30-39: D0/D1
  // 40-59:  M

  private List<Tile> generateTiles(List<PlayerInfo> players) { return null; }
  private double[][] generateDistance() { return null; }
  private Path[][] generatePath() { return null; }

  public ServerMap generateServer(List<PlayerInfo> players) {
    ServerMap serverMap =
        new ServerMap(generateTiles(players), generateDistance(), generatePath());
    return serverMap;
  }

  public ClientMap generateClient(List<PlayerInfo> players) {
    ClientMap clientMap =
        new ClientMap(generateTiles(players), generateDistance(), generatePath());
    return clientMap;
  }
}
