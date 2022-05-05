package pl.edu.mimuw.logic;
import java.util.HashSet;

public class False extends Constant {
    public False() {

    }
    public boolean eval(Valuation valuation) {
        return false;
    }
    public String toString() {
        return "FALSE";
    }
}