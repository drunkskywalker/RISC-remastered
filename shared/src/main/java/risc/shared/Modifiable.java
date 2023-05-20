package risc.shared;

import java.util.List;

public interface Modifiable {
  public void addModifier(Modifier m);
  public List<Modifier> getModifiers(Enums.Target target, Enums.Scale scale);
  public List<Modifier> getAllModifiers();
  public List<Modifier> getAllModifiersRecursive();

  public static double applyModifiers(double input, List<Modifier> modifiers) {
    double percentage = 1.0;
    double value = input;
    for (Modifier m : modifiers) {
      if (m.isEffective()) {
        if (m.isPercentage()) {
          percentage = m.apply(percentage);
        }
        else {
          value = m.apply(value);
        }
      }
    }
    value = value * percentage;
    return value;
  }
}
