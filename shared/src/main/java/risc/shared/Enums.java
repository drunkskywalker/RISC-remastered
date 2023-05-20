package risc.shared;

public class Enums {
  public enum Target {
    FOOD,
    TECH,
    MAGIC,
    COMBAT_STRENGTH,
    HP_REGEN,
    MORALE_DAMAGE,
    MORALE_REGEN,
    TURMOIL_DECAY,
    TURMOIL_GEN,
    RESEARCH,
    UPGRADE,
    TRAIN,
  }
  ;

  public enum Scale {
    UNIT,
    TILE,
    MAP,
    PLAYER,

  }
  ;
  public enum Time {
    MOVE,
    INFILTRATE,
    UPGRADE,
    BUILD,
    RESEARCH,
    ATTACK,
    DEFEND,
    PRODUCTION,
  }
  ;

  public enum Terrain {
    PLAIN,
    HILLS,
    MOUNTAIN,
    TUNDRA,
    FOREST,
    TAIGA,
    SWAMP,
    URBAN,
    DESERT;
  }
  ;
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
}
