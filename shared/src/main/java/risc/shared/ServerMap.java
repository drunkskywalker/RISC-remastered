package risc.shared;

import java.util.ArrayList;
import java.util.List;
import risc.shared.Enums.*;

public class ServerMap extends GenericMap {
  public ServerMap(List<Tile> tiles, double[][] distances, Path[][] paths) {
    super(tiles, distances, paths);
  }

  @Override
  public void resolveRequests(List<Request> requests) {
    // do something
  }
}
