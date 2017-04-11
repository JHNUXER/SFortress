public class Chunk {
  public TileSlot[][][] slots;
  public ArrayList<Entity> entities = new ArrayList<Entity>();
  public int scale;
  
  public Chunk(Object lock,int scale,int height) {
    synchronized(lock) {
      this.scale = scale;
      slots = new TileSlot[scale][scale][scale];
      for (int y = 0; y < slots.length; y++) {
        for (int x = 0; x < slots[y].length; x++) {
          for (int z = 0; z < slots[y][x].length; z++) {
            slots[x][y][z] = new TileSlot();
          }
        }
      }
    }
  }
  
  public void tick(Object lock) {
    synchronized(lock) {
      slots = new TileSlot[scale][scale][scale];
      for (int y = 0; y < slots.length; y++) {
        for (int x = 0; x < slots[y].length; x++) {
          for (int z = 0; z < slots[y][x].length; z++) {
            slots[x][y][z].tick();
          }
        }
      }
    }
  }
  
  public BufferedImage draw(int height) {
    int imgD = scale * Game.spriteScale;
    BufferedImage image = new BufferedImage(imgD,imgD,BufferedImage.TYPE_INT_ARGB);
    Graphics graphics = image.createGraphics();
    int z = height;
    for (int y = 0; y < slots.length; y++) {
      for (int x = 0; x < slots[y].length; x++) {
        graphics.drawImage(slots[y][x][z].draw(),0,0,null);
      }
    }
    for (int i = 0; i < entities.size(); i++) {
      Position k = entities.get(i).localPosition.convertTo("pixels");
      graphics.drawImage(entities.get(i).draw(),k.x,k.y,null);
    }
  }
}
