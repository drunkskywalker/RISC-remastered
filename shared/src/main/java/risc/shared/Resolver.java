package risc.shared;

import java.util.List;

public interface Resolver {
  public String validate(Status status, Map map, Request request);
  public void resolve(Status status, Map map, Request request);
}
