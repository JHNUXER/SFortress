package sfortress.tile.functional;

import static sfortress.Game.world;

public interface Fan {
  public float pressureRate;
  public Direction facing;
  
  public static void movePressure(Fan f) {
    TileSlot s = world.getTileSlot(f.facing,1f);
    s.pressure += pressureRate;
    s = world.getTileSlot(f.facing,-1f);
    s.pressure -= pressureRate;
  }
}
