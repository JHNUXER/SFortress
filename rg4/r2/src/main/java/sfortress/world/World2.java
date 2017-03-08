package sfortress.world;

public class Var<E> {
  private E value;
  private String name;
  
  public Var<E>(String name, E value) {
    this.value = value;
    this.name = name;
  }
  public Var<E>(E value, String name) {
   this.value = value;
   this.name = name;
  }
}
