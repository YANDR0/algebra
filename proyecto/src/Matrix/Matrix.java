package Matrix;

import Expressions.Expression;
import Expressions.Real;

public class Matrix{

    private Expression[][] matrix;
    private final int rows;
    private final int cols;

    public static int MIN_SIZE = 1;
    protected static int DEFAULT_SIZE = 3;

    //CONSTRUCTORES
    public Matrix(){
        this(DEFAULT_SIZE);
    }

    public Matrix(int size){
        this(size, size);
    }

    public Matrix(int rows, int cols){
        this.rows = Math.max(MIN_SIZE, rows);
        this.cols = Math.max(MIN_SIZE, cols);
        this.matrix = new Expression[this.rows][this.cols];

    }

    // GETTERS AND SETTERS
    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Expression get(int rows, int cols){
        if(rows < 0 || rows >= this.rows || cols < 0 || cols >= this.cols) return null;
        return this.matrix[rows][cols];
    }

    public int set(int rows, int cols, Expression number){
        if(rows < 0 || rows >= this.rows || cols < 0 || cols >= this.cols) return 1;
        this.matrix[rows][cols] = number;
        return 0;
    }

    public int set(int rows, int cols, double number){
        return set(rows, cols, new Real(number));
    }


    // QUE HUEVA, LUEGO VEO
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
