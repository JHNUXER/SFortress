package sfortress.graphics;

public class Renderer extends JPanel {
  private BufferedImage image;
  
  private static Position crr(Position p) {
    double x = p.x;
    double y = p.y;
    double z = p.z;
    int X = (int) x;
    int Y = (int) y;
    int Z = (int) z;
    X = (x-X >= 0.5)?X+1:X;
    Y = (y-Y >= 0.5)?Y+1:Y;
    Z = (z-Z >= 0.5)?Z+1:Z;
    return new Position((double) X,(double) Y,(double) Z);
  }
  private static Position[] gcps(Position p) {
    double x = p.x;
    double y = p.y;
    double z = p.z;
    double X = (double) ((int) x);
    double Y = (double) ((int) y);
    double Z = (double) ((int) z);
    double xDiff = x-X;
    double yDiff = y-Y;
    double zDiff = z-Z;
    double xN = (xDiff >= 0.5)?X+1:X-1;
    double yN = (yDiff >= 0.5)?Y+1:Y-1;
    double zN = (zDiff >= 0.5)?Z+1:Z-1;
    
    return new Position[] {
      new Position(x,y,z),
      new Position(xN,y,z),
      new Position(x,yN,z),
      new Position(x,y,zN),
      new Position(xN,yN,z),
      new Position(xN,y,zN),
      new Position(x,yN,zN),
      new Position(xN,yN,zN)
    };
  }
  
  public void draw() {
    Graphics g = image.createGraphics();
    public Viewer viewer = SFortress.game.world.getViewer();
    Position pPos = viewer.position.convertTo("pixels");
    Position cPos = viewer.position.convertTo("chunks");
    cPos = crr(cPos);
    Position[] cP = gcps(cPos);
    Position[] cPz = new Position[] {cP[0],cP[1],cP[2],cP[3]};
    cP = null;
    for (int i = 0; i < cPz.length; i++) {
      BufferedImage image = cPz[i].draw();
      g.drawImage(image,,,null);
    }
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage();
  }
}
