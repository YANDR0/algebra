package Matrix;

import Expressions.Imaginary;

public class SquareMatrix extends Matrix {

    public SquareMatrix(){}

    public SquareMatrix(int size){
        super(size);
    }

    public Matrix identity(int size){
        Matrix m = new Matrix(size);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Imaginary complex = i == j? new Imaginary(1, 0) : new Imaginary();
                m.set(i, j, complex);
            }
        }

        return m;
    }

    //public Imaginary determinant(){}

    public SquareMatrix pow(double exponent){
        SquareMatrix result = new SquareMatrix(Integer.parseInt(this.getSize()));
        double valor = 0;
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
               for(int k = 0; k < exponent; k++){
                   valor = j * j;
               }
            }
        }
        return result;
    }

    //public SquareMatrix inverse(){}
    //public static SquareMatrix parseSquare() {}

}
