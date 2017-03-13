package sfortress.computer.software;

public class Shell {
  public static Object run(File file) {
    Object retVal = null;
    
    java.io.File tFile = file.toFile();
    
    if (tFile.getName().toLowerCase().endsWith(".py")) {
      PythonInterpreter interpreter = new PythonInterpreter();
      interpreter.run(file);
    }
  }
}
