package pl.edu.mimuw;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Two extends Formula{
  protected Formula left;
  protected Formula right;
  protected String name;


  public Two(Formula l, Formula r){
    this.left=l;
    this.right=r;
    this.name="TWO";
  }


  public String toString(){
    return "(" + left.toString() + " " + this.name + " " + right.toString() + ")";
  }



}
