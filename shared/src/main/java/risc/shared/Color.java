package risc.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * A class to store player color.  
 */

public class Color implements Serializable {
  private int red;
  private int green;
  private int blue;

  private static final long serialVersionUID = 0x00000000;

  private static final DualHashBidiMap<String, ArrayList<Integer> > nameMap =
      new DualHashBidiMap<>();

  static {
    nameMap.put("red", new ArrayList<Integer>(Arrays.asList(255, 0, 0)));
    nameMap.put("green", new ArrayList<Integer>(Arrays.asList(0, 255, 0)));
    nameMap.put("blue", new ArrayList<Integer>(Arrays.asList(0, 0, 255)));
    nameMap.put("yellow", new ArrayList<Integer>(Arrays.asList(255, 255, 0)));
    nameMap.put("purple", new ArrayList<Integer>(Arrays.asList(255, 0, 255)));

    nameMap.put("black", new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
    nameMap.put("white", new ArrayList<Integer>(Arrays.asList(255, 255, 255)));
  }

  /**creates a Color object with given RGB value.
   * @param R is red.
   * @param G is green.
   * @param B is blue.
   * @throws IllegalArgumentException if R, G, or B is not within range [0, 255]. 
   */

  public Color(int R, int G, int B) {
    if (R < 0 || R > 255 || G < 0 || G > 255 || B < 0 || B > 255) {
      throw new IllegalArgumentException(
          "Illegal Color constuctor: Input out of range of [0, 255]]: " + R + ", " + G +
          ", " + B);
    }
    this.red = R;
    this.green = G;
    this.blue = B;
  }

  /**creates a Color object with given color name.
   * @param name is color name.
   * @throws IllegalArgumentException if given name is not in the map. 
   */

  public Color(String name) {
    if (!nameMap.containsKey(name)) {
      throw new IllegalArgumentException(
          "Illegal Color constructor: Input name is not recognized: " + name);
    }
    ArrayList<Integer> RGB = nameMap.get(name);
    this.red = RGB.get(0);
    this.green = RGB.get(1);
    this.blue = RGB.get(2);
  }

  /**creates a default black Color object. 
   * red, green, blue will all be set to 0.
   */

  public Color() { this(0, 0, 0); }

  /**gives the RGB values in an  ArrayList.
   * @return the  ArrayList<Integer> contain the RGB values.
   */

  public ArrayList<Integer> getRGB() {
    return new ArrayList<Integer>(Arrays.asList(red, green, blue));
  }

  /**changes the Color object's RGB to new RGB value.
   * @param R is red.
   * @param G is green.
   * @param B is blue.
   * @throws IllegalArgumentException if R, G, or B is not within range [0, 255]. 
   */

  public void changeColor(int R, int G, int B) {
    if (R < 0 || R > 255 || G < 0 || G > 255 || B < 0 || B > 255) {
      throw new IllegalArgumentException(
          "Illegal Color changeColor: Input out of range of [0, 255]: " + R + ", " + G +
          ", " + B);
    }
    this.red = R;
    this.green = G;
    this.blue = B;
  }

  /**registers the name and correspnding RGB value in the name map.
   * @param name is the name.  
   * @param R is red.
   * @param G is green.
   * @param B is blue.
   * @throws IllegalArgumentException if R, G, or B is not within range [0, 255]. 
   */
  public static void registerName(String name, int R, int G, int B) {
    if (R < 0 || R > 255 || G < 0 || G > 255 || B < 0 || B > 255) {
      throw new IllegalArgumentException(
          "Illegal Color registerName: Input out of range of [0, 255]: " + R + ", " + G +
          ", " + B);
    }
    nameMap.put(name, new ArrayList<Integer>(Arrays.asList(R, G, B)));
  }

  /**returns the name of the Color object.
   * @return the corresponding String of the RGB value in the nameMap if present, otherwise #RRGGBB in hex. 
   */

  @Override
  public String toString() {
    String preset = nameMap.inverseBidiMap().get(getRGB());
    if (preset != null) {
      return preset;
    }
    else {
      StringBuilder nameBuilder = new StringBuilder();
      nameBuilder.append(String.format("#%02X%02X%02X", red, green, blue));
      return nameBuilder.toString();
    }
  }

  /**returns the hashcode of the Color object.
   * @return the hashcode by calling toStirng()'s hashCode().
   */

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  /**compares if input object is equivalent to this Color object.
   * @return true if they are, otherwise false.
   */

  @Override
  public boolean equals(Object rhs) {
    if (!(rhs == null) && rhs.getClass().equals(this.getClass())) {
      Color rhsColor = (Color)rhs;
      return (rhsColor.red == this.red && rhsColor.green == this.green &&
              rhsColor.blue == this.blue);
    }
    return false;
  }
}
