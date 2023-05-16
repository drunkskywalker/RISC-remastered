package risc.shared;

import java.util.List;

public interface Modifiable {
  public Modifiable modify(List<Modifier> modifiers);
}
