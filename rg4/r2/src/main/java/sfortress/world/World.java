package sfortress.world;

public class World {
  public String name;
  public Chunk[][][] chunks;
  public int scale;
  public int cScale;
  
  public World(Object l1,String name,int scale,int cScale) {
    pause(l1);
  }
  
  public void pause(Object o) {
    synchronized(o) {
      o.wait();
    }
  }
  public void unpause(Object o) {
    synchronized(this) {
      o.unpause();
    }
  }
}
