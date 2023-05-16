package risc.shared;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to denote Unit types and traits.
 */
public class UnitType {
  // unit's role on battlefield
  public enum Role {
    INFANTRY,
    CAVALRY,
    SIEGE,
    MAGICAL,
    AIRFORCE,
    HERO,
    CIVILIAN,
    ESPIONAGE;
  }
  ;

  // means of transportation
  public enum Transport {
    LAND,
    AIR,
    NAVAL,
    INFILTRATION;
  }
  ;

  // composition of the unit
  public enum Nature {
    PHYSICAL,
    SPIRITUAL,
    COMBINED;
  }
  ;

  public final String name;
  public final Role role;
  public final Transport transport;
  public final Nature nature;

  /**creates a UnitType object with given attributes.
   * 
   * @param name is the type name.
   * @param role is the unit role.
   * @param transport is how the unit moves across map.
   * @param nature is the nature of the unit.
   *
   */
  private UnitType(String name, Role role, Transport transport, Nature nature) {
    this.name = name;
    this.role = role;
    this.transport = transport;
    this.nature = nature;
  }

  /**returns the pre-created UnitType object, instead of creating a new object.
   * @param name is the UnitType name.
   * @return the corresponding UnitType object.
   * @throws IllegalArgumentException if the name is not pre-created.
   */

  public static UnitType getUnitType(String name) {
    if (UnitType.types.get(name) == null) {
      throw new IllegalArgumentException(
          "Illegal UnitType constructor: the unit specified by the given name does not exist: " +
          name);
    }
    return UnitType.types.get(name);
  }

  private static Map<String, UnitType> types = new HashMap<String, UnitType>();

  static {
    // debug
    types.put("Civilian",
              new UnitType("Civilian", Role.CIVILIAN, Transport.LAND, Nature.PHYSICAL));

    // infantry
    types.put(
        "Levy Conscript",
        new UnitType("Levy Conscript", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Citizen Militia",
        new UnitType("Citizen Militia", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put("Armsmen",
              new UnitType("Armsmen", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Line Infantry",
        new UnitType("Line Infantry", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "National Guard",
        new UnitType("National Guard", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Tundra Legion",
        new UnitType("Tundra Legion", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));

    // cavalry
    types.put("Courser",
              new UnitType("Courser", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));
    types.put("Wagenburg",
              new UnitType("Wagenburg", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));
    types.put("Dragoon",
              new UnitType("Dragoon", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));

    // siege
    types.put("Siege Tower",
              new UnitType("Siege Tower", Role.SIEGE, Transport.LAND, Nature.PHYSICAL));
    types.put("Artillery",
              new UnitType("Artillery", Role.SIEGE, Transport.LAND, Nature.PHYSICAL));
    types.put("Railway Gun",
              new UnitType("Railway Gun", Role.SIEGE, Transport.LAND, Nature.PHYSICAL));

    // magical
    types.put("Apprentice",
              new UnitType("Apprentice", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put(
        "Shadow Adept",
        new UnitType("Shadow Adept", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put("Light Adept",
              new UnitType("Light Adept", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put(
        "Grand Master",
        new UnitType("Grand Master", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put(
        "Grand Preacher",
        new UnitType("Grand Preacher", Role.MAGICAL, Transport.LAND, Nature.COMBINED));

    // air
    types.put(
        "Hot Air Balloon",
        new UnitType("Hot Air Balloon", Role.CIVILIAN, Transport.AIR, Nature.PHYSICAL));
    types.put("Gyrocopter",
              new UnitType("Gyrocopter", Role.AIRFORCE, Transport.AIR, Nature.PHYSICAL));
    types.put(
        "Aerostatic Craft",
        new UnitType("Aerostatic Craft", Role.AIRFORCE, Transport.AIR, Nature.PHYSICAL));

    // spy
    types.put("Internal Security",
              new UnitType(
                  "Internal Security", Role.ESPIONAGE, Transport.LAND, Nature.PHYSICAL));
    types.put("Informant",
              new UnitType(
                  "Informant", Role.ESPIONAGE, Transport.INFILTRATION, Nature.PHYSICAL));
    types.put("Saboteur",
              new UnitType(
                  "Saboteur", Role.ESPIONAGE, Transport.INFILTRATION, Nature.PHYSICAL));
    types.put("Agitator",
              new UnitType(
                  "Agitator", Role.ESPIONAGE, Transport.INFILTRATION, Nature.PHYSICAL));

    // summoned
    types.put("Phantom",
              new UnitType(
                  "Phantom", Role.ESPIONAGE, Transport.INFILTRATION, Nature.SPIRITUAL));
    types.put(
        "Black Rider",
        new UnitType(
            "Black Rider", Role.ESPIONAGE, Transport.INFILTRATION, Nature.SPIRITUAL));
    types.put("Obelisk of Light",
              new UnitType(
                  "Obelisk of Light", Role.CIVILIAN, Transport.LAND, Nature.SPIRITUAL));
  }
}
