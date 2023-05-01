package Expressions;

public abstract interface Expression {

    Expression sum(Expression e);
    Expression subtract(Expression e);
    Expression multiply(Expression e);
    Expression divide(Expression e);

    @Override
    String toString();

    Expression clone();

    @Override
    boolean equals(Object o);
}
