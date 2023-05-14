package Matrix;

import Expressions.Imaginary;

public class SquareMatrix extends Matrix {

    public SquareMatrix(){}

    public SquareMatrix(int size){
        super(size);
    }

    public Matrix pow(double exponent) {
        Matrix result =  identity(this.rows);
        for (int i = 0; i < exponent; i++)
            result = (result.multiply(this));

        return result;
    }

    public static Matrix identity(int size){
        Matrix m = new Matrix(size);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Imaginary complex = i == j? new Imaginary(1, 0) : new Imaginary();
                m.set(i, j, complex);
            }
        }

        return m;
    }

    public Imaginary determinant(){
        if(this.rows > 3) return null;
        Imaginary result = new Imaginary();
        if(this.rows == 3) {
            result = result.sum(matrix[0][0].multiply(matrix[1][1]).multiply(matrix[2][2]));
            result = result.sum(matrix[0][1].multiply(matrix[1][2]).multiply(matrix[2][0]));
            result = result.sum(matrix[0][2].multiply(matrix[1][0]).multiply(matrix[2][1]));
            result = result.subtract(matrix[2][0].multiply(matrix[1][1]).multiply(matrix[0][2]));
            result = result.subtract(matrix[2][1].multiply(matrix[1][2]).multiply(matrix[0][0]));
            result = result.subtract(matrix[2][2].multiply(matrix[1][0]).multiply(matrix[0][1]));
        }
        if(this.rows == 2){
            result = result.sum(matrix[0][0].multiply(matrix[1][1]));
            result = result.subtract(matrix[1][0].multiply(matrix[0][1]));
        }

        if (this.rows == 1) result = this.matrix[0][0];

        return result == null? null: result;
    }

    public static SquareMatrix parseSquare(Matrix m) {
        int min = Math.min(m.rows, m.cols);
        SquareMatrix result = new SquareMatrix(min);
        Imaginary[] array = m.toArray(min, min);
        result.fill(array);
        return result;
    }

}
