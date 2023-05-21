package risc.shared;

public class MoveOwnershipChecker implements Checker {
  private Checker next;

  public MoveOwnershipChecker(EmptyChecker next) { this.next = next; }

  @Override
  public String check(Status status, Map map, Request request) {
    // TODO Auto-generated method stub

    return next.check(status, map, request);
  }
}
