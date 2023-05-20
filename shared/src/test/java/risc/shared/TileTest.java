package risc.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TileTest {
  @Test
  public void test() {
    Tile t0 = new Tile(0, "Shire", Enums.Terrain.PLAIN);
    Tile t1 = new Tile(1, "Bree", Enums.Terrain.HILLS);
    assertEquals(t0.name, "Shire");
    assertTrue(t0.id == 0);

    PlayerInfo p0 = new PlayerInfo(0);
    PlayerInfo p1 = new PlayerInfo(1);
    t0.setOwner(p0);
    assertTrue(t0.belongsTo(p0));
    Unit u0 = new GenericUnit(p0);
    t0.addUnit(u0);
    assertTrue(!t0.belongsTo(p1));
    t0.setOwner(p1);
    assertTrue(t0.belongsTo(p1));
    double prod0 = t0.getProduction(Enums.Target.FOOD);
    assertTrue(prod0 == 0);
    Modifier m0 = new GenericModifier(
        1, Enums.Target.TECH, Enums.Scale.TILE, Enums.Time.PRODUCTION, false, 0);
    t0.addModifier(m0);
    prod0 = t0.getProduction(Enums.Target.TECH);

    assertTrue(Math.abs(prod0 - 1) <= 0.0001);
    Modifier m1 = new GenericModifier(
        1, Enums.Target.TECH, Enums.Scale.TILE, Enums.Time.PRODUCTION, true, 1, 1);
    Modifier m2 = new GenericModifier(
        1, Enums.Target.MAGIC, Enums.Scale.TILE, Enums.Time.PRODUCTION, true, 1, 2);

    t0.addModifier(m1);
    t0.addModifier(m2);
    prod0 = t0.getProduction(Enums.Target.MAGIC);
    assertTrue(prod0 == 0);
    prod0 = t0.getProduction(Enums.Target.TECH);
    assertTrue(Math.abs(prod0 - 2) <= 0.0001);
    m1.tickRound();
    prod0 = t0.getProduction(Enums.Target.TECH);

    assertTrue(Math.abs(prod0 - 1) <= 0.0001);

    List<Modifier> m = t0.getAllModifiers();
    assertThrows(IllegalArgumentException.class,
                 () -> t0.getProduction(Enums.Target.COMBAT_STRENGTH));
  }
}
