package Matrix;

import Expressions.Expression;

public class Matrix{

    private static int matrix = Expresion[][];
    private static int rows;
    private static int cols;
    protected static int MIN_SIZE = 1;
    private static int DEFAULT_SIZE = 3;

    public Matrix(){};

    public Matrix(){};

    public Matrix(int, int){};

    public static int getRows() {
        return rows;
    }

    public static int getCols() {
        return cols;
    }

    public int get(int, int){
        return 0;
    };

    public int set(int, int, Expression){
        return 0;
    }

    public int set(int, int, double){
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
