package pl.edu.mimuw.logic;
import java.util.HashSet;
import java.util.Objects;

public class Variable implements Formula {
    protected String name;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return Objects.equals(name, variable.name);
    }
    public int hashCode() {
        return Objects.hash(this.name);
    }
    public Variable(String name) {
        this.name = name;
    }
    public boolean eval(Valuation v) {
        var b = v.readValue(this);
        return b;
    }
    public String toString() {
        return this.name;
    }
    public HashSet<Variable> getVariables() {
        var s = new HashSet<Variable>();
        s.add(this);
        return s;
    }
}