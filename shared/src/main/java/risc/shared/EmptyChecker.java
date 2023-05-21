package risc.shared;

public class EmptyChecker implements Checker {
  @Override
  public String check(Status status, Map map, Request request) {
    return null;
  }
}
