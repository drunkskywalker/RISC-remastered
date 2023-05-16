package risc.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ColorTest {
  @Test
  public void test() {
    assertThrows(IllegalArgumentException.class, () -> new Color(256, 0, 0));
    assertThrows(IllegalArgumentException.class, () -> new Color(-1, 0, 0));
    assertThrows(IllegalArgumentException.class, () -> new Color("azure"));
    assertThrows(IllegalArgumentException.class,
                 () -> Color.registerName("azure", 0, 256, 0));
    Color c0 = new Color(0, 0, 0);

    Color.registerName("azure", 0, 128, 255);

    Color c1 = new Color("red");

    Color c2 = new Color("azure");
    assertEquals(c0.toString(), "black");
    assertEquals(c1.toString(), "red");
    assertEquals(c2.toString(), "azure");
    Color c3 = new Color();

    assertEquals(c0, c3);
    assertNotEquals(c3, null);
    assertNotEquals(c3, "black");
    String b = "black";
    assertEquals(c3.hashCode(), b.hashCode());
    Color c4 = new Color(189, 51, 164);

    assertEquals(c4.toString(), "#BD33A4");
    Color.registerName("byzantine", 189, 51, 164);
    assertEquals(c4.toString(), "byzantine");
    assertThrows(IllegalArgumentException.class, () -> c4.changeColor(256, 0, 0));

    c4.changeColor(0, 255, 0);
    assertEquals(c4, new Color("green"));
  }
}
