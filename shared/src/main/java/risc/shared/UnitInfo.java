package risc.shared;

import java.util.HashMap;
import java.util.Map;
import risc.shared.Enums.*;
/**
 * A class to denote Unit types and traits.
 */

public class UnitInfo {
  // unit's role on battlefield

  public final String name;
  public final Role role;
  public final Transport transport;
  public final Nature nature;

  // unit's stat

  /*
  public final double
      maxHp;  // damage taken before unit is eliminated. 0 => unit cannot take damage.
  public final double
      maxMorale;  // damage taken before unit is unable to fight. regenerates when not in combat.

  
  public final double movement;

  public final double moveFoodCost;
  public final double moveTechCost;
  public final double moveMagicCost;

  public final int upgradeResearchId;

  public final double upgradeFoodCost;
  public final double upgradeTechCost;
  public final double upgradeMagicCost;

  public final double attack;        // damage dealt to other side
  public final double defense;       // ability to reduce damage in defense
  public final double breakthrough;  // ability to reduce damage in attack

  public final double combatFoodCost;
  public final double combatTechCost;
  public final double combatMagicCost;

  public final int
      specialCooldown;  // rounds needed to cooldown special ability. 0 => the ability is instant, -1 => the ability cannot recharge.

  public final double specialFoodCost;
  public final double specialTechCost;
  public final double specialMagicCost;
  */

  /**creates a UnitInfo object with given attributes.
   * 
   * @param name is the type name.
   * @param role is the unit role.
   * @param transport is how the unit moves across map.
   * @param nature is the nature of the unit.
   *
   */
  private UnitInfo(String name, Role role, Transport transport, Nature nature) {
    this.name = name;
    this.role = role;
    this.transport = transport;
    this.nature = nature;
  }

  /**returns the pre-created UnitInfo object, instead of creating a new object.
   * @param name is the UnitInfo name.
   * @return the corresponding UnitInfo object.
   * @throws IllegalArgumentException if the name is not pre-created.
   */

  public static UnitInfo getUnitInfo(String name) {
    if (UnitInfo.types.get(name) == null) {
      throw new IllegalArgumentException(
          "Illegal UnitInfo constructor: the unit specified by the given name does not exist: " +
          name);
    }
    return UnitInfo.types.get(name);
  }

  private static Map<String, UnitInfo> types = new HashMap<String, UnitInfo>();

  static {
    // debug
    types.put("Civilian",
              new UnitInfo("Civilian", Role.CIVILIAN, Transport.LAND, Nature.PHYSICAL));

    // infantry
    types.put(
        "Levy Conscript",
        new UnitInfo("Levy Conscript", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Citizen Militia",
        new UnitInfo("Citizen Militia", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put("Armsmen",
              new UnitInfo("Armsmen", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Line Infantry",
        new UnitInfo("Line Infantry", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "National Guard",
        new UnitInfo("National Guard", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Tundra Legion",
        new UnitInfo("Tundra Legion", Role.INFANTRY, Transport.LAND, Nature.PHYSICAL));

    // cavalry
    types.put("Courser",
              new UnitInfo("Courser", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));
    types.put("Wagenburg",
              new UnitInfo("Wagenburg", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));
    types.put("Dragoon",
              new UnitInfo("Dragoon", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));
    types.put(
        "Ironclad Vaporcarriage",
        new UnitInfo(
            "Ironclad Vaporcarriage", Role.CAVALRY, Transport.LAND, Nature.PHYSICAL));
    // siege
    types.put("Siege Tower",
              new UnitInfo("Siege Tower", Role.SIEGE, Transport.LAND, Nature.PHYSICAL));
    types.put("Artillery",
              new UnitInfo("Artillery", Role.SIEGE, Transport.LAND, Nature.PHYSICAL));
    types.put("Railway Gun",
              new UnitInfo("Railway Gun", Role.SIEGE, Transport.LAND, Nature.PHYSICAL));

    // magical
    types.put("Apprentice",
              new UnitInfo("Apprentice", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put(
        "Shadow Adept",
        new UnitInfo("Shadow Adept", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put("Light Adept",
              new UnitInfo("Light Adept", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put(
        "Grand Master",
        new UnitInfo("Grand Master", Role.MAGICAL, Transport.LAND, Nature.COMBINED));
    types.put(
        "Grand Preacher",
        new UnitInfo("Grand Preacher", Role.MAGICAL, Transport.LAND, Nature.COMBINED));

    // air
    types.put(
        "Hot Air Balloon",
        new UnitInfo("Hot Air Balloon", Role.CIVILIAN, Transport.AIR, Nature.PHYSICAL));
    types.put("Gyrocopter",
              new UnitInfo("Gyrocopter", Role.AIRFORCE, Transport.AIR, Nature.PHYSICAL));
    types.put(
        "Aerostatic Craft",
        new UnitInfo("Aerostatic Craft", Role.AIRFORCE, Transport.AIR, Nature.PHYSICAL));

    // spy
    types.put("Internal Security",
              new UnitInfo(
                  "Internal Security", Role.ESPIONAGE, Transport.LAND, Nature.PHYSICAL));
    types.put("Informant",
              new UnitInfo(
                  "Informant", Role.ESPIONAGE, Transport.INFILTRATION, Nature.PHYSICAL));
    types.put("Saboteur",
              new UnitInfo(
                  "Saboteur", Role.ESPIONAGE, Transport.INFILTRATION, Nature.PHYSICAL));
    types.put("Agitator",
              new UnitInfo(
                  "Agitator", Role.ESPIONAGE, Transport.INFILTRATION, Nature.PHYSICAL));

    // summoned
    types.put("Phantom",
              new UnitInfo(
                  "Phantom", Role.ESPIONAGE, Transport.INFILTRATION, Nature.SPIRITUAL));
    types.put(
        "Black Rider",
        new UnitInfo(
            "Black Rider", Role.ESPIONAGE, Transport.INFILTRATION, Nature.SPIRITUAL));
    types.put("Obelisk of Light",
              new UnitInfo(
                  "Obelisk of Light", Role.CIVILIAN, Transport.LAND, Nature.SPIRITUAL));
  }
}
