package sfortress.circuit;

public class Circuit {
  public String name;
  public ArrayList<CircuitNode> nodes = new ArrayList<CircuitNode>();
  public ArrayList<Var> vars = new ArrayList<Var>();
  
  public Circuit(String name) {
    this.name = name;
  }
  
  public void add(CircuitNode node) {
    node.add(this);
    nodes.add(node);
  }
  public void addVar(Var var) {
    vars.add(var);
  }
  
  public Var getVar(String name) {
    Var v = null;
    for (int i = 0; i < vars.length; i++) {
      if (vars.get(i).name == name) {
        v = vars.get(i);
        break;
      }
    }
    return v;
  }
}
