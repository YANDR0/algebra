package Matrix;

import Expressions.*;


public class Matrix{

    protected final Imaginary[][] matrix;
    protected final int rows;
    protected final int cols;

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

    public String getSize() { return this.rows + " x " + this.cols; }

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

    public Matrix sum(Matrix m){
        if(!this.canSum(m)) return null;

        Matrix result= new Matrix(this.rows, this.cols);

        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.cols; j++)
                result.set(i, j, (Imaginary)(this.get(i,j).sum(m.get(i,j))));

        return result;
    }

    public Matrix substract(Matrix m){
        if(!this.canSum(m)) return null;

        Matrix result = new Matrix(this.rows, this.cols);

        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.cols; j++)
                result.set(i, j, (Imaginary)(this.get(i,j).subtract(m.get(i,j))));

        return result;
    }

    //Es mucho, luego veo XD ------------------------------------------------------------
    /*
    public Matrix multiply(Matrix m){
        if(!canMultiply(m)) return null;

        Matrix result = new Matrix(this.rows, m.cols);
    }*/

    public Matrix transpose(){
        Matrix result = new Matrix(this.cols, this.rows);

        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                result.set(j,i, (Imaginary) (this.get(i,j)));

        return result;
    }

    public Matrix escalar(Imaginary number){

        Matrix m = new Matrix(this.rows, this.cols);

        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                m.set(i,j, (Imaginary)(this.get(i,j).multiply(number)));
            }
        }

        return m;
    }


    //FUNCTIONALITY

    public boolean canSum(Matrix m){
        return (this.rows == m.rows) && (this.cols == m.cols);
    }

    public boolean canMultiply(Matrix m){
        return (this.cols == m.rows);
    }

    //public Matrix fill(Imaginary... numbers){}
    //Algo de tamaños tras operaciones

    //public Matrix gauss(){}
    //public Matrix gaussJordan(){}


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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Matrix)) return false;

        Matrix m = (Matrix)obj;
        if(!canSum(m)) return false;
        boolean result = true;

        for (int i = 0; i < this.rows ; i++)
            for (int j = 0; j < this.cols ; j++)
                result = result && this.get(i,j).equals(m.get(i,j));

        return super.equals(obj);
    }

}
