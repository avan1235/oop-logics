package pl.edu.mimuw.logic;

import java.util.List;
import java.util.ArrayList;

public interface Formula {
	boolean eval(Valuation valuation);
	
	String toString();
	
	List<String> yieldVariables();
}
