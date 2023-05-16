package risc.shared;

import java.util.List;

public interface Modifier {
  public enum Target {
    FOOD,
    TECH,
    MAGIC,
    COMBAT_STRENGTH,
    HP_REGEN,
    MORALE_DAMAGE,
    MORALE_REGEN,
    TURMOIL_DECAY,
    TURMOIL_GEN,
    RESEARCH,
    UPGRADE,
    TRAIN,
  }
  ;

  public enum Time {
    MOVE,
    INFILTRATE,
    UPGRADE,
    BUILD,
    RESEARCH,
    ATTACK,
    DEFEND,
    PRODUCTION,
  }
  ;

  public enum Scale {
    TILE,
    TERRAIN,
    UNIT,
    MAP,
    PLAYER,
    GLOBAL,
  }
  ;

  public enum NumericType {
    PERCENTAGE,
    VALUE,
  }

  public boolean isEffective();
  public boolean isAppliable(Target target, List<Time> time, List<Scale> scale);
  public String getDescription();
  public void setDescription(String newDescription);
  public double apply(double original);
}
