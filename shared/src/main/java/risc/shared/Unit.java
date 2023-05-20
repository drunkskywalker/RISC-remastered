package risc.shared;

public interface Unit extends Modifiable {
  public PlayerInfo getOwner();
  public UnitInfo getInfo();
  public boolean visibleTo(PlayerInfo target);
}
