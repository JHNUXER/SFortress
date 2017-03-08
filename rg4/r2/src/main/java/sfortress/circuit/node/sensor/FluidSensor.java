package sfortress.circuit.node.sensor;

import static sfortress.SFortress.game.world;

public class FluidSensor implements CircuitNode {
  public boolean fluidExists() {
    return world.getTileSlot(this.position.convertTo("tile")).isFluidPresent();
  }
  public void add(Circuit c) {
    this.circuit = c;
    c.addVar(new MethodCall<FluidSensor,Boolean>(this,"Fluid Present at " + this.position,"fluidExists"));
  }
}
