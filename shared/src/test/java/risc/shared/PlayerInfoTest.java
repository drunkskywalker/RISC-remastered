package risc.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerInfoTest {
  @Test
  public void test() {
    PlayerInfo p1 = new PlayerInfo("player_1", 1, new Color("yellow"));
    PlayerInfo p2 = new PlayerInfo(1);
    assertEquals(p1, p2);
    assertEquals(p1.toString(), p2.toString());
    assertEquals(p1.hashCode(), p2.hashCode());
    assertNotEquals(p1, p2.toString());
  }
}
