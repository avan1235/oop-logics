package pl.edu.mimuw.logic;

import java.util.Map;

public class Valuation {
    Map<String, Boolean> map;

    public Valuation(Map<String,Boolean> map){
        this.map = map;
    }

    public boolean get(String name){
        return map.get(name);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
