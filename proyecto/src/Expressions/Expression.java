package Expressions;

public abstract interface Expression {

    int sum();
    int subtract();
    int multiply();
    int divide();

    @Override
    String toString();

    Expression clone();

    boolean equals();
}
