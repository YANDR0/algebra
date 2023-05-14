package Expressions;

public abstract interface Expression<T extends Expression> {


    T sum(T e);
    T subtract(T e);
    T multiply(T e);
    T divide(T e);

    @Override
    String toString();

    T clone();

    @Override
    boolean equals(Object o);

}
