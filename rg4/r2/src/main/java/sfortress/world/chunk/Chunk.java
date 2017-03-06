package sfortress.world.chunk;

public class Chunk {
  private World world;
  public TileSlot[][][] slots;
  public int scale;
  
  public Chunk(Object l1,World w,int scale) {
    this.world = w;
    synchronized (l1) {
      l1.wait();
    }
    this.scale = scale;
    slots = new TileSlot[scale][scale][scale];
    for (int x = 0; x < scale; x++) {
      for (int y = 0; y < scale; y++) {
        for (int z = 0; z < scale; z++) {
          slots[x][y][z] = new TileSlot();
        }
      }
    }
    synchronized(this) {
      l1.notifyAll();
    }
  }
  
  public void unpause(Object o) {
    synchronized(this) {
      o.notifyAll();
    }
  }
  public void pause(Object o) {
    synchronized(o){
      o.wait();
    }
  }
  
  public void generate(Object l1) {
    pause(l1);
    for (int x = 0; x < scale; x++) {
      for (int y = 0; y < scale; y++) {
        for (int z = 0; z < scale; z++) {
          slots[x][y][z].generate();
        }
      }
    }
    unpause(l1);
  }
  public void tick(Object l1) {
    pause(l1);
    for (int x = 0; x < scale; x++) {
      for (int y = 0; y < scale; y++) {
        for (int z = 0; z < scale; z++) {
          slots[x][y][z].tick();
        }
      }
    }
    unpause(l1);
  }
}
