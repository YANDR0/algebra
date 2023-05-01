package Matrix;

import Expressions.Expression;

public class Matrix{

    private static Expression[][] matrix;
    private static int rows;
    private static int cols;

    public static int MIN_SIZE = 1;
    protected static int DEFAULT_SIZE = 3;

    public Matrix(){}

    public Matrix(int size){}

    public Matrix(int rows, int cols){}

    public static int getRows() {
        return rows;
    }

    public static int getCols() {
        return cols;
    }

    public int get(int rows, int cols){
        return 0;
    };

    public int set(int rows, int cols, Expression number){
        return 0;
    }

    public int set(int rows, int cols, double number){
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
