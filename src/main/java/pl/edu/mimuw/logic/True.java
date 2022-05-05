package pl.edu.mimuw.logic;
import java.util.HashSet;

public class True extends Constant {
    public True() {

    }
    public boolean eval(Valuation valuation) {
        return true;
    }
    public String toString() {
        return "TRUE";
    }
}