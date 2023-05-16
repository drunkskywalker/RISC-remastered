package risc.shared;

public interface Unit {
  public PlayerInfo getOwner();
  public UnitType getType();
  public boolean visibleTo(PlayerInfo target);
}
