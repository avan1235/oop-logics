package pl.edu.mimuw;

import static pl.edu.mimuw.logic.FormulaFactory.*;
import pl.edu.mimuw.logic.Formula;

public class Main {
	public static void main(String[] args) {
		final Formula a = var("a"),
		        b = var("b"),
		        c = var("c"),
		        t = t(),
		        f = f();
		
		final Formula formula1 =
		implies(
			xor(
				and(
					a,
					b
				),
				iff(
					a,
					c
				)
			),
			and(
				or(
					b,
					c
				),
				or(
					neg(a),
					t
				)
			)
		),
		
		formula2 =
		and(
			implies(
				xor(
					xor(
						c,
						b
					),
					a
				),
				implies(
					or(
						neg(a),
						a
					),
					b
				)
			),
			iff(
				t,
				and(
					f,
					xor(
						a,
						b
					)
				)
			)
		);
		
		System.out.println("formula1 = " + formula1.toString());
		System.out.println("formula2 = " + formula2.toString());
	}
}
