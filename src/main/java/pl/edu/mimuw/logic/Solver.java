package pl.edu.mimuw.logic;

import java.util.ArrayList;

public class Solver {
  private Formula formula;
  private ArrayList<String>variables;
  private ArrayList<Boolean>values;
  private Valuation valuation;
  public Solver(Formula formula){
    this.formula=formula;
    this.variables=formula.getAllVariables();
    this.values=new ArrayList<Boolean>();
    for (int i=0;i< variables.size();i++)values.add(true);
    this.valuation=new Valuation(variables,values);
  }
  public Valuation getTrueValuation(int toBeModified){
    if(toBeModified>=this.values.size()||this.formula.eval(valuation))return valuation;
    for(int i=toBeModified;i< values.size();i++)values.set(i,true);
    valuation=this.getTrueValuation(toBeModified+1);
    if(this.formula.eval(valuation))return valuation;
    this.values.set(toBeModified,false);
    for(int i=toBeModified+1;i< values.size();i++)values.set(i,true);
    valuation=new Valuation(variables,values);
    valuation=this.getTrueValuation(toBeModified+1);
    return valuation;
  }

  @Override
  public String toString(){
    var sb=new StringBuilder();
    sb.append("Solver of Formula: ").append(this.formula.toString()).append("\n");
    return sb.toString();
  }
}
