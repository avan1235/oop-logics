package pl.edu.mimuw.logic;

public class FormulaFactory {
	private FormulaFactory() {}
	
	public static Formula and(Formula left, Formula right) {
		return new And(left, right);
	}
	
	public static Formula or(Formula left, Formula right) {
		return new Or(left, right);
	}
	
	public static Formula xor(Formula left, Formula right) {
		return new Xor(left, right);
	}
	
	public static Formula implies(Formula left, Formula right) {
		return new Implies(left, right);
	}
	
	public static Formula iff(Formula left, Formula right) {
		return new Iff(left, right);
	}
	
	public static Formula neg(Formula formula) {
		return new Neg(formula);
	}
	
	public static Formula var(String name) {
		return new Variable(name);
	}
	
	public static Formula t() {
		return new Constant(true);
	}
	
	public static Formula f() {
		return new Constant(false);
	}
}
