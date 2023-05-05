package Matrix;

import Expressions.*;


public class Matrix{

    private final Imaginary[][] matrix;
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
        this.matrix = new Imaginary[this.rows][this.cols];
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

    public int set(int rows, int cols, Imaginary number){
        if(rows < 0 || rows >= this.rows || cols < 0 || cols >= this.cols) return 1;
        this.matrix[rows][cols] = number;
        return 0;
    }

    // OPERATIONS

    //public Matrix sum(Matrix m){}
    //public Matrix subtract(Matrix m){}
    //public Matrix multiply(Matrix m){}
    //public Matrix gauss(){}
    //public Matrix gaussJordan(){}
    //public Matrix transpose(){}

    //public Matrix fill(Imaginary... numbers){}
    //public Matrix escalar(Imaginary number){}
    //public Matriz identity(double size){}
    //Algo de tamaños tras operaciones


    @Override
    public String toString() {
        String s = "";
        for(Expression[] curr: this.matrix){
            for (Expression e : curr)
                s += e != null? e.toString() + "  " : "0  ";
            s += "\n";
        }
        return s;
    }
    /*
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    /*
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }*/
}
