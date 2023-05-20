package risc.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactionGeneratorTest {
  @Test
  public void test() {
    FactionGenerator fg = new FactionGenerator();
    Faction f0 = fg.getFaction(FactionGenerator.RulerCode.A0);
    assertEquals(f0.name, "Continental Popular Sovereignty");
  }
}
