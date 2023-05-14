package Matrix;

import Expressions.Imaginary;

/**
 * Clase hija de matriz encargada de realizar operaciones propias de una matriz cuadrada
 */
public class SquareMatrix extends Matrix {

    /**
     * Devuleve una matriz de tamaño 3x3
     */
    public SquareMatrix(){}

    /**
     * Devuelve una amtriz cuadrada con tamaño n
     * @param size Entero equivalente al número de columnas y filas de la matriz
     */
    public SquareMatrix(int size){
        super(size);
    }

    /**
     * Permite obtener el resultado de una matriz elevada a un entero
     * @param exponent Exponente de la operación
     * @return Matriz resultaddo de la operación
     */
    public Matrix pow(double exponent) {
        Matrix result =  identity(this.rows);
        for (int i = 0; i < exponent; i++)
            result = (result.multiply(this));

        return result;
    }

    /**
     * Genera una matriz identidad, es decir, de diagonal 1 dde n tamaño
     * @param size Tamaño deseado para la matriz
     * @return Matriz resultaddo de la operación
     */
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

    /**
     * Permite obetener el determinante de una matriz con un tamaño igual o menor a 3
     * @return Número resultado de las operaciones
     */
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

    /**
     * Convierte una mtriz cualquiere a una cuadrada, recortando filas o columnas de ser necesario
     * @param m Matriz a trasformar
     * @return Matriz cuadrada resultado
     */
    public static SquareMatrix parseSquare(Matrix m) {
        int min = Math.min(m.rows, m.cols);
        SquareMatrix result = new SquareMatrix(min);
        Imaginary[] array = m.toArray(min, min);
        result.fill(array);
        return result;
    }

}
