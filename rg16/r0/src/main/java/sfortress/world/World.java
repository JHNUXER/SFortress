public class World {
  public String name;
  public Chunk[][][] chunks;
  public Vector dimensions;
  public int chunkScale;
  
  public World(Object lock,String name,Vector dimensions,int chunkScale) {
    this.name = name;
    this.dimensions = dimensions;
    this.chunkScale = chunkScale;
    
    for (int y = 0; y < dimensions.y; y++) {
      for (int x = 0; x < dimensions.x; x++) {
        for (int z = 0; z < dimensions.z; z++) {
          chunks[x][y][z] = new Chunk(lock,chunkScale);
        }
      }
    }
  }
  
  public void tick() {
    for (int y = 0; y < chunks.length; y++) {
      for (int x = 0; x < chunks[y].length; x++) {
        for (int z = 0; z < chunks[y][x].length; z++) {
          chunks[x][y][z].tick();
        }
      }
    }
  }
}
