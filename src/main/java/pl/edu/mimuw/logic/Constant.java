package pl.edu.mimuw.logic;
import java.util.Set;
import java.util.HashSet;

abstract class Constant implements Formula {
    public HashSet<Variable> getVariables() {
        return  new HashSet<Variable>() {};
    }
}