package risc.shared;

import java.util.List;

public interface Modifier {
  public boolean isEffective();
  public boolean isAppliable(List<Enums.Target> target,
                             List<Enums.Time> time,
                             List<Enums.Scale> scale);
  public String getDescription();
  public void setDescription(String newDescription);
  public double apply(double original);
  public Enums.Target getTarget();
  public Enums.Scale getScale();
  public boolean isPercentage();
  public void changeRounds(int r);
  public boolean tickRound();
}
