package risc.shared;

public class MoveResolver implements Resolver {
  @Override
  public String validate(Status status, Map map, Request request) {
    return null;
  }

  @Override
  public void resolve(Status status, Map map, Request request) {
    System.out.println("I am doing nothing. wee!");
  }
}
