package pl.edu.mimuw.logic;

import java.util.List;

public interface Formula
{
	boolean eval(Valuation valuation);

	List <String> getVariables();
}