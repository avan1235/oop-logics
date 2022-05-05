package pl.edu.mimuw.logic;


public class Solution {
    private Valuation valuation;
    private boolean isSolvable;
    public Solution(Valuation valuation, boolean isSolvable) {
        this.valuation = valuation;
        this.isSolvable = isSolvable;
    }
    public Valuation getValuation() {
        return this.valuation;
    }
    public boolean getIsSolvable() {
        return this.isSolvable;
    }
}