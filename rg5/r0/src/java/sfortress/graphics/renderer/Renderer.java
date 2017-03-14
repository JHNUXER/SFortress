package sfortress.graphics.renderer;

public class Renderer extends JPanel {
  private World world;
  private GameWindow window;
  
  pulic Renderer(GameWindow window) {
    this.window = window;
    this.world = SFortress.game.world;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
