package risc.shared;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to store player information.
 */

public class PlayerInfo implements Serializable {
  private String playerName;
  private int playerSequence;
  private Color playerColor;

  private static ArrayList<Color> defaultColors = new ArrayList<>();
  private static final long serialVersionUID = 0x00000001;

  static {
    defaultColors.add(new Color("red"));
    defaultColors.add(new Color("yellow"));
    defaultColors.add(new Color("blue"));
    defaultColors.add(new Color("green"));
    defaultColors.add(new Color("purple"));
  }

  /**creates a PlayerInfo object with given name, sequence, and color.
   * @param name is the player's playerName.
   * @param seq is the player's playerSequence.
   * @param color is the playe's playerColor.
   */

  public PlayerInfo(String name, int seq, Color color) {
    this.playerName = name;
    this.playerSequence = seq;
    this.playerColor = color;
  }

  /**creates a default PlayerInfo object with sequence number only.
   * @param seq is the player's playerSequence.
   */

  public PlayerInfo(int seq) { this("player_" + seq, seq, defaultColors.get(seq)); }

  /**creates a non-player PlayerInfo object.
   */

  public PlayerInfo() { this("Neutral", -1, new Color("white")); }

  /**gets the PlayerInfo object's name.
   * @return the playerName.
   */
  public String getName() { return this.playerName; }

  /**gets the PlayerInfo object's sequence.
   * @return the playerSequence.
   */
  public int getSeq() { return this.playerSequence; }

  /**gets the PlayerInfo object's Color.
   * @return the playerColor.
   */
  public Color getColor() { return this.playerColor; }

  /** returns a String representation of the PlayerInfo Object.
   * @return the String representation.
   */

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    String divider = "----------------\n";

    builder.append(divider);
    builder.append("Name    |");
    builder.append(this.getName());
    builder.append("\n");
    builder.append("Sequence|");
    builder.append(this.getSeq());
    builder.append("\n");
    builder.append("Color   |");
    builder.append(this.getColor().toString());
    builder.append("\n");
    builder.append(divider);

    return builder.toString();
  }

  /**returns the hashcode of the PlayerInfo object.
   * @return the hashcode by calling toStirng()'s hashCode().
   */

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  /**compares if input object is equivalent to this PlayerInfo object.
   * @return true if they are, otherwise false.
   */

  @Override
  public boolean equals(Object rhs) {
    if (!(rhs == null) && rhs.getClass().equals(this.getClass())) {
      PlayerInfo rhsPlayerInfo = (PlayerInfo)rhs;
      return (this.getName().equals(rhsPlayerInfo.getName()) &&
              this.getSeq() == rhsPlayerInfo.getSeq() &&
              this.getColor().equals(rhsPlayerInfo.getColor()));
    }
    return false;
  }
}
