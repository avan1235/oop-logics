package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SolverTest {

  @Test
  void test1() {

    var x= FormulaFactory.var("x");
    var y=FormulaFactory.var("y");
    Formula f0=FormulaFactory.not(x);
    Solver s0=new Solver(f0);
    assert(f0.eval(s0.getTrueValuation(0)));
    Formula f1=FormulaFactory.and(y,f0);
    Solver s1=new Solver(f1);
    assert(f1.eval(s1.getTrueValuation(0)));
    Formula f2=FormulaFactory.and(x,y);
    Solver s2=new Solver(f2);
    assert (f2.eval(s2.getTrueValuation(0)));
    Formula f3=FormulaFactory.or(f0,f1);
    Solver s3=new Solver(f3);
    assert (f3.eval(s3.getTrueValuation(0)));
    Formula f4=FormulaFactory.or(x,y);
    Solver s4=new Solver(f4);
    assert (f4.eval(s4.getTrueValuation(0)));
    Formula f5=FormulaFactory.implies(f4,f2);
    Solver s5=new Solver(f5);
    assert (f5.eval(s5.getTrueValuation(0)));
    Formula f6=FormulaFactory.implies(f5,f2);
    Solver s6=new Solver(f6);
    assert (f6.eval(s6.getTrueValuation(0)));
    Formula f7=FormulaFactory.implies(f5,f6);
    Solver s7=new Solver(f7);
    assert (f7.eval(s7.getTrueValuation(0)));
    Formula f8=FormulaFactory.iff(f2,f3);
    Solver s8=new Solver(f8);
    assert (f8.eval(s8.getTrueValuation(0)));
    Formula f9=FormulaFactory.iff(f5,f6);
    Solver s9=new Solver(f9);
    assert (f9.eval(s9.getTrueValuation(0)));
    Formula f10=FormulaFactory.iff(f6,f7);
    Solver s10=new Solver(f10);
    assert (f10.eval(s10.getTrueValuation(0)));
    Formula f11=FormulaFactory.and(x,FormulaFactory.not(x));
    Solver s11=new Solver(f11);
    assertFalse(f11.eval(s11.getTrueValuation(0)));
  }

  @Test
  void test2(){
    var x= FormulaFactory.t();
    var y=FormulaFactory.f();
    Formula f0=FormulaFactory.not(x);
    Solver s0=new Solver(f0);
    assertFalse(f0.eval(s0.getTrueValuation(0)));
    Formula f1=FormulaFactory.and(y,f0);
    Solver s1=new Solver(f1);
    assertFalse(f1.eval(s1.getTrueValuation(0)));
    Formula f2=FormulaFactory.and(x,y);
    Solver s2=new Solver(f2);
    assertFalse (f2.eval(s2.getTrueValuation(0)));
    Formula f3=FormulaFactory.or(f0,f1);
    Solver s3=new Solver(f3);
    assertFalse (f3.eval(s3.getTrueValuation(0)));
    Formula f4=FormulaFactory.or(x,y);
    Solver s4=new Solver(f4);
    assert (f4.eval(s4.getTrueValuation(0)));
    Formula f5=FormulaFactory.implies(f4,f2);
    Solver s5=new Solver(f5);
    assertFalse (f5.eval(s5.getTrueValuation(0)));
    Formula f6=FormulaFactory.implies(f5,f2);
    Solver s6=new Solver(f6);
    assert (f6.eval(s6.getTrueValuation(0)));
    Formula f7=FormulaFactory.implies(f5,f6);
    Solver s7=new Solver(f7);
    assert (f7.eval(s7.getTrueValuation(0)));
    Formula f8=FormulaFactory.iff(f2,f3);
    Solver s8=new Solver(f8);
    assert (f8.eval(s8.getTrueValuation(0)));
    Formula f9=FormulaFactory.iff(f5,f6);
    Solver s9=new Solver(f9);
    assertFalse (f9.eval(s9.getTrueValuation(0)));
    Formula f10=FormulaFactory.iff(f6,f7);
    Solver s10=new Solver(f10);
    assert (f10.eval(s10.getTrueValuation(0)));
    Formula f11=FormulaFactory.and(x,FormulaFactory.not(x));
    Solver s11=new Solver(f11);
    assertFalse(f11.eval(s11.getTrueValuation(0)));
  }

  @Test
  void test3(){
    var x= FormulaFactory.t();
    var y=FormulaFactory.var("y");
    Formula f0=FormulaFactory.not(x);
    Solver s0=new Solver(f0);
    assertFalse(f0.eval(s0.getTrueValuation(0)));
    Formula f1=FormulaFactory.and(y,f0);
    Solver s1=new Solver(f1);
    assertFalse(f1.eval(s1.getTrueValuation(0)));
    Formula f2=FormulaFactory.and(x,y);
    Solver s2=new Solver(f2);
    assert  (f2.eval(s2.getTrueValuation(0)));
    Formula f3=FormulaFactory.or(f0,f1);
    Solver s3=new Solver(f3);
    assertFalse(f3.eval(s3.getTrueValuation(0)));
    Formula f4=FormulaFactory.or(x,y);
    Solver s4=new Solver(f4);
    assert (f4.eval(s4.getTrueValuation(0)));
    Formula f5=FormulaFactory.implies(f4,f2);
    Solver s5=new Solver(f5);
    assert  (f5.eval(s5.getTrueValuation(0)));
    Formula f6=FormulaFactory.implies(f5,f2);
    Solver s6=new Solver(f6);
    assert (f6.eval(s6.getTrueValuation(0)));
    Formula f7=FormulaFactory.implies(f5,f6);
    Solver s7=new Solver(f7);
    assert (f7.eval(s7.getTrueValuation(0)));
    Formula f8=FormulaFactory.iff(f2,f3);
    Solver s8=new Solver(f8);
    assert (f8.eval(s8.getTrueValuation(0)));
    Formula f9=FormulaFactory.iff(f5,f6);
    Solver s9=new Solver(f9);
    assert  (f9.eval(s9.getTrueValuation(0)));
    Formula f10=FormulaFactory.iff(f6,f7);
    Solver s10=new Solver(f10);
    assert (f10.eval(s10.getTrueValuation(0)));
    Formula f11=FormulaFactory.and(x,FormulaFactory.not(x));
    Solver s11=new Solver(f11);
    assertFalse(f11.eval(s11.getTrueValuation(0)));
  }
}
