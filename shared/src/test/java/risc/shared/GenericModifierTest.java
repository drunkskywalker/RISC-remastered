package risc.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GenericModifierTest {
  @Test
  public void test() {
    Modifier m0 = new GenericModifier(
        1, Enums.Target.FOOD, Enums.Scale.TILE, Enums.Time.PRODUCTION, false, 5, 0);

    Modifier m1 = new GenericModifier(
        0.5, Enums.Target.TECH, Enums.Scale.MAP, Enums.Time.PRODUCTION, true, 1);

    assertTrue(m0.isEffective());
    assertTrue(m1.isEffective());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> new GenericModifier(1,
                                            Enums.Target.MAGIC,
                                            Enums.Scale.TILE,
                                            Enums.Time.PRODUCTION,
                                            false,
                                            -2,
                                            0));

    assertThrows(IllegalArgumentException.class,
                 ()
                     -> new GenericModifier(1,
                                            Enums.Target.MAGIC,
                                            Enums.Scale.TILE,
                                            Enums.Time.PRODUCTION,
                                            false,
                                            0,
                                            0));

    while (m0.tickRound()) {
      assertTrue(m0.isEffective());
    }
    assertTrue(!m0.isEffective());

    m0.setDescription("Test modifier");
    assertEquals(m0.getDescription(), "Test modifier");
    m0.setDescription("Change modifier");
    assertEquals(m0.getDescription(), "Change modifier");

    assertThrows(IllegalArgumentException.class, () -> m1.changeRounds(1));

    double x1 = 12;
    double x2 = m0.apply(x1);
    assertEquals(x2, 13.);
    assertEquals(m0.getTarget(), Enums.Target.FOOD);
    assertTrue(!m0.isPercentage());
    assertEquals(m0.getScale(), Enums.Scale.TILE);
    List<Enums.Target> t = new ArrayList<Enums.Target>();
    t.add(Enums.Target.FOOD);
    t.add(Enums.Target.HP_REGEN);
    t.add(Enums.Target.TECH);
    List<Enums.Scale> s = null;
    List<Enums.Time> ti = new ArrayList<>();
    ti.add(Enums.Time.ATTACK);
    assertTrue(!m0.isAppliable(t, ti, s));
    ti.add(Enums.Time.PRODUCTION);
    assertTrue(m0.isAppliable(t, ti, s));
    assertTrue(m1.isAppliable(t, ti, s));
    s = new ArrayList<>();
    s.add(Enums.Scale.TILE);
    assertTrue(!m1.isAppliable(t, ti, s));
    s.add(Enums.Scale.MAP);
    assertTrue(m1.isAppliable(t, ti, s));
  }
}
