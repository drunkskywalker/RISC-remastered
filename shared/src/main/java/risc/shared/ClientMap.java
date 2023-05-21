package risc.shared;

import java.util.List;
import risc.shared.Enums.*;

public class ClientMap extends GenericMap {
  public ClientMap(List<Tile> tiles, double[][] distances, Path[][] paths) {
    super(tiles, distances, paths);
  }
  @Override
  public void resolveRequests(List<Request> requests) {}
}
