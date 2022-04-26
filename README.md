# Logical Expressions

Your task is to design the model for logical expressions which can represent
propositional logic formulas which uses `and`, `or`, `not`, `implies`, `iff`,
constants `true` and `false`, and named variables like `x`, `y`, `z`.

You have to design your model in such an approach, to allow user to evaluate
your expression in some specified valuation which will assign values to named
variables. After designing your model, let's fill the `FormulaFactory` with
valid implementation and use it in samples/tests building.

Your classes need to be able to convert themselves to readable representation
which should be presented in `Main` class.

Your second goal is to write brute-force solver for your formulas' model.
Your solver should at first collect data about all variables that appear
in formula and then try all assignments of `true`/`false` to these variables,
looking for first assignment for which formula evaluates to `true`.
It should be implemented as `Solver` class.

Last step is to write a few (at least three) interesting (not trivial) unit tests
that will be readable by human and will check if found valuation by `Solver` is
a valid one. If you need some template, how to write unit tests in Java, take a look
at your [queue tests code](https://github.com/avan1235/oop-queue/blob/master/src/test/java/pl/edu/mimuw/queue/FIFOTest.java).
