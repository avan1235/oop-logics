package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.mimuw.logic.FormulaFactory.*;
import static pl.edu.mimuw.logic.Solver.*;

class SolverTest {
	@Test
	void test1() {
		final Formula a = var("a"),
		        b = var("b"),
		        c = var("c"),
		        d = var("d"),
		        t = t(),
		        f = f();
		
		Valuation valuation = new Valuation();
		valuation.addVariable("a", true);
		valuation.addVariable("b", true);
		valuation.addVariable("c", false);
		valuation.addVariable("d", false);
		
		assertEquals(a.eval(valuation), true);
		assertEquals(b.eval(valuation), true);
		assertEquals(c.eval(valuation), false);
		assertEquals(d.eval(valuation), false);
		
		final Formula aAndB = and(a, b),
		        aAndC = and(a, c),
		        cAndD = and(c, d),
		        aOrB = or(a, b),
		        aOrC = or(a, c),
		        cOrD = or(c, d),
		        aXorB = xor(a, b),
		        aXorC = xor(a, c),
		        cXorD = xor(c, d);
		
		assertEquals(aAndB.eval(valuation), true);
		assertEquals(aAndC.eval(valuation), false);
		assertEquals(cAndD.eval(valuation), false);
		assertEquals(aOrB.eval(valuation), true);
		assertEquals(aOrC.eval(valuation), true);
		assertEquals(cOrD.eval(valuation), false);
		assertEquals(aXorB.eval(valuation), false);
		assertEquals(aXorC.eval(valuation), true);
		assertEquals(cXorD.eval(valuation), false);
	}
	
	@Test
	void test2() {
		final Formula x = var("x"),
		        y = var("y"),
		        z = var("z"),
		        t = t(),
		        f = f();
		
		Valuation valuation1 = new Valuation();
		valuation1.addVariable("x", false);
		valuation1.addVariable("y", true);
		valuation1.addVariable("z", true);
		
		Valuation valuation2 = new Valuation();
		valuation2.addVariable("x", true);
		valuation2.addVariable("y", true);
		valuation2.addVariable("z", false);
		
		Valuation valuation3 = new Valuation();
		valuation3.addVariable("x", false);
		valuation3.addVariable("y", false);
		valuation3.addVariable("z", true);
		
		final Formula formula1 =
		iff(
			implies(
				z,
				iff(
					xor(
						f,
						y
					),
					and(
						x,
						y
					)
				)
			),
			neg(
				or(
					xor(
						and(
							x,
							t
						),
						implies(
							y,
							z
						)
					),
					implies(
						xor(
							y,
							z
						),
						t
					)
				)
			)
		),
		
		formula2 =
		and(
			or(
				neg(
					xor(
						x,
						neg(
							y
						)
					)
				),
				implies(
					y,
					neg(
						and(
							y,
							z
						)
					)
				)
			),
			xor(
				neg(
					or(
						x,
						neg(
							x
						)
					)
				),
				f
			)
		);
		
		assertEquals(formula1.eval(valuation1), true);
		assertEquals(formula1.eval(valuation2), false);
		assertEquals(formula1.eval(valuation3), false);
		
		assertEquals(formula2.eval(valuation1), false);
		assertEquals(formula2.eval(valuation2), false);
		assertEquals(formula2.eval(valuation3), false);
		
		final Valuation solution = solve(formula1);
		assertEquals(solution.getValue("x"), false);
		assertEquals(solution.getValue("y"), true);
		assertEquals(solution.getValue("z"), true);
		
		assertEquals(solve(formula2), null);
	}
}
