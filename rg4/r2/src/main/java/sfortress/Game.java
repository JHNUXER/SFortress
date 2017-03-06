package sfortress;

public class Game {
  public String name;
  public Method run;
  
  public Game(Class cls) {
    cls.getDeclaredField("name","".class);
    this.spriteScale = ((Integer) cls.getDeclaredField("spriteScale",Integer)).getValue();
    this.run = cls.getDeclaredMethod("run",null);
  }
  public Game(File file) {
    Class mainClass = null;
    try {
      URL url = file.toURI().toURL();
      URL[] urls = new URL[] {url};
      mainClass = new URLClassLoader(urls).loadClass(file.getName().replace(".jar","").toLowerCase().replace(" ","_")+".Game");
    }
    this(mainClass);
  }
}
