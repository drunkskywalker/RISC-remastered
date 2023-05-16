package risc.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnitTypeTest {
  @Test
  public void test() {
    UnitType a = UnitType.getUnitType("Siege Tower");
    assertThrows(IllegalArgumentException.class,
                 () -> UnitType.getUnitType("Siege Artillery"));
    UnitType b = UnitType.getUnitType("Siege Tower");
    assertTrue(a == b);
  }
}
