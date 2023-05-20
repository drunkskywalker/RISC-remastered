package risc.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnitInfoTest {
  @Test
  public void test() {
    UnitInfo a = UnitInfo.getUnitInfo("Siege Tower");
    assertThrows(IllegalArgumentException.class,
                 () -> UnitInfo.getUnitInfo("Siege Artillery"));
    UnitInfo b = UnitInfo.getUnitInfo("Siege Tower");
    assertTrue(a == b);
  }
}
