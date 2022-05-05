package pl.edu.mimuw.logic;
import java.util.Map;
import java.util.HashMap;

public class Valuation {
    private Map<Variable, Boolean> varMap;
    public Valuation() {
        this.varMap = new HashMap<>();
    }
    public void setValue(Variable v, boolean b) {
        varMap.put(v,b);
    }
    public boolean readValue(Variable v) {
        return varMap.get(v);
    }
    public String toString() {
        var s = new StringBuilder();
        for (Map.Entry<Variable, Boolean> entry : varMap.entrySet()) {
            s.append(entry.getKey() + ": ").append(entry.getValue() + "\n");
        }
        return s.toString();
    }
}
