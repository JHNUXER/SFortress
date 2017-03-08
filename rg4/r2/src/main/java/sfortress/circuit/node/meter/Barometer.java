package sfortress.circuit.node.meter;

import static sfortress.SFortress.game.world;

public class Barometer implements CircuitNode {
  public float getPressure() {
    return world.getTileSlot(this.position).getPressure();
  }
  public void add(Circuit c) {
    this.circuit = c;
    c.addVar(new MethodCall<Barometer,Float>(this,"Pressure at " + this.position.toString(),"getPressure"));
  }
}
