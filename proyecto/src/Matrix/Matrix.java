package Matrix;

import Expressions.*;

/**
 * Clase dedicada a la creación y manejo de operaciones generales dentro de las matrices
 */
public class Matrix{

    /**
     * Matriz encargada del guardado de datos
     */
    protected final Imaginary[][] matrix;

    /**
     * Número de filas
     */
    protected final int rows;

    /**
     * Número de columnas
     */
    protected final int cols;

    /**
     * Tamaño mínimo de la matriz
     */
    public static int MIN_SIZE = 1;

    /**
     * Tamaño por defecto de la matriz
     */
    protected static int DEFAULT_SIZE = 3;

        //CONSTRUCTORES

    /**
     * Crea una matriz vacía de 3x3
     */
    public Matrix(){
        this(DEFAULT_SIZE);
    }

    /**
     * Crea una matriz vacia cuadrada de tamaño n
     * @param size Tamaño de la matriz
     */
    public Matrix(int size){
        this(size, size);
    }

    /**
     * Crea una matriz rectagular
     * @param rows Cantidad de filas
     * @param cols Cantidad de columnas
     */
    public Matrix(int rows, int cols){
        this.rows = Math.max(MIN_SIZE, rows);
        this.cols = Math.max(MIN_SIZE, cols);
        this.matrix = new Imaginary[this.rows][this.cols];
    }

        // GETTERS AND SETTERS

    /**
     * Regresa la cantidad de filas de la matriz
     * @return Entero igual al atributo rows
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Regresa la cantidad de columnas de la matriz
     * @return Entero igual al atributo cols
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Obtiene el tamñano de la matriz
     * @return Regresa un string de la forma "rows x cols"
     */
    public String getSize() { return this.rows + " x " + this.cols; }

    /**
     * Obtiene un elemento deseado dentro de la matriz
     * @param rows Posición dentro de las filas
     * @param cols Posición dentro de las columnas
     * @return Regresa el imaginario en la posición proporcionada
     */
    public Imaginary get(int rows, int cols){
        if(rows < 0 || rows >= this.rows || cols < 0 || cols >= this.cols) return null;
        return this.matrix[rows][cols];
    }

    /**
     * Declara un elemento dentro de la matriz
     * @param rows Posición dentro de las filas
     * @param cols Posición dentro de las columnas
     * @param number Elemento que se desea guardar en la posición proporcionada
     */
    public void set(int rows, int cols, Imaginary number){
        if(rows < 0 || rows >= this.rows || cols < 0 || cols >= this.cols) return;
        this.matrix[rows][cols] = number;
    }

        // OPERATIONS

    /**
     * Realiza la suma entre dos matrices del mismo tamaño
     * @param m Matrix equivalente al segundo sumando
     * @return Matriz resultado de la operación
     */
    public Matrix sum(Matrix m){
        if(!this.canSum(m)) return null;

        Matrix result = new Matrix(this.rows, this.cols);

        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.cols; j++)
                result.set(i, j, (this.get(i,j).sum(m.get(i,j))));

        return result;
    }

    /**
     * Realiza la resta entre dos matrices del mismo tamaño
     * @param m Matriz equivalente al sustraendo
     * @return Matriz resultado de la operación
     */
    public Matrix substract(Matrix m){
        if(!this.canSum(m)) return null;

        Matrix result = new Matrix(this.rows, this.cols);

        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.cols; j++)
                result.set(i, j, (this.get(i,j).subtract(m.get(i,j))));

        return result;
    }

    /**
     * Realiza la multiplicación entre dos matrices compatibles
     * @param m Matriz equivalente al segundo factor
     * @return Matriz resultado de la operación
     */
    public Matrix multiply(Matrix m){
        if(!this.canMultiply(m)) return null;
        Matrix result = new Matrix(this.rows, m.cols);

        for(int r1 = 0; r1 < this.rows; r1++)
            for(int c2 = 0; c2 < m.cols; c2++){
                Imaginary cell = new Imaginary();
                for (int i = 0; i < this.cols; i++)
                    cell = cell.sum(this.get(r1, i).multiply(m.get(i,c2)));

                result.set(r1, c2, cell);
            }

        return result;
    }

    /**
     * Transforma una matriz a su forma transpuesta
     * @return Matriz resultado de la operación
     */
    public Matrix transpose(){
        Matrix result = new Matrix(this.cols, this.rows);

        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                result.set(j,i, (Imaginary) (this.get(i,j)));

        return result;
    }

    /**
     * Multiplica todos los elementos de una matriz por un escalar
     * @param number Factor que multiplica la matriz
     * @return Matriz resultado de la operación
     */
    public Matrix escalar(Imaginary number){

        Matrix m = new Matrix(this.rows, this.cols);
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                m.set(i,j, (Imaginary)(this.get(i,j).multiply(number)));
            }
        }
        return m;
    }


        // GAUSS y JORDAN

    private void switchRow(int source, int destiny){
        Imaginary[] s = this.matrix[source].clone();
        this.matrix[source] = this.matrix[destiny];
        this.matrix[destiny] = s;
    }

    private void subtractRows(int source, int destiny){
        for(int i = 0; i < this.cols; i++){
            matrix[destiny][i] = matrix[source][i].subtract(matrix[destiny][i]);
        }
    }

    private void multiplyRow(int row, Imaginary value){
        for(int i = 0; i < matrix[row].length; i++){
            matrix[row][i] = matrix[row][i].multiply(value);
        }
    }

    private void divideRow(int row, Imaginary value){
        for(int i = 0; i < matrix[row].length; i++){
            matrix[row][i] = matrix[row][i].divide(value);
        }
    }

    /**
     * Reduce la matriz a su forma triangular
     * @return Matriz resultado de la operación
     */
    public Matrix gauss(){
        int diagonal = Math.min(this.rows, this.cols);
        Matrix result = this.clone();

        boolean end;

        for(int i = 0; i < diagonal; i++){

            if(result.matrix[i][i].equals(new Imaginary(0,0))){
                end = true;
                for (int j = 1; j < this.rows; j++) {
                    if (!result.matrix[j][i].equals(new Imaginary(0,0))){
                        result.switchRow(i, j);
                        end = false;
                        break;
                    }
                }
                if(end) continue;
            }

            result.divideRow(i, result.matrix[i][i]);
            for(int j = i+1; j < this.rows+1; j++){
                if(j >= this.rows) break;
                result.multiplyRow(i, result.matrix[j][i]);
                result.subtractRows(i, j);
                result.divideRow(i, result.matrix[i][i]);
            }
        }

        return result;
    }

    /**
     * Reduce la matriz a una diagonal, realizando el método de gauss jordan
     * @return Matriz resultado de la operación
     */
    public Matrix gaussJordan(){
        int diagonal = Math.min(this.rows, this.cols);
        Matrix result = this.gauss();

        for(int i = 0; i < diagonal; i++) {
            result.divideRow(i, result.matrix[i][i]);
            for(int j = i-1; j > -1; j--){
                if(j < 0) break;
                result.multiplyRow(i, result.matrix[j][i]);
                result.subtractRows(i, j);
                result.divideRow(i, result.matrix[i][i]);
            }
        }
        for(int i = 0; i < diagonal; i++)
            result.divideRow(i, result.matrix[i][i]);

        return result;
    }


        //FUNCTIONALITY

    /**
     * Verifica si dos matrices pueden ser sumadas entre sí
     * @param m Segunda matriz
     * @return Comprobación de la compatibilidad
     */
    public boolean canSum(Matrix m){
        if(m == null) return false;
        return (this.rows == m.rows) && (this.cols == m.cols);
    }

    /**
     * Verifica si dos matrices pueden ser multiplicadas entre sí
     * @param m Segunda matriz
     * @return Comprobación de la compatibilidad
     */
    public boolean canMultiply(Matrix m){
        return (this.cols == m.rows);
    }

    /**
     * Rellena una matriz iniciando por las coordenadas 0,0
     * @param numbers Array o grupo de números
     */
    public void fill(Imaginary... numbers){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if(i * this.cols + j >= numbers.length) return;
                this.set(i,j, numbers[i*this.cols+j]);
            }
        }
    }

    /**
     * Transforma la matriz a un único array
     * @return Array que contiene todos los elementos de la matriz
     */
    public Imaginary[] toArray(){
        return this.toArray(this.rows, this.cols);
    }

    /**
     * Transforma la matriz a un array limitando la cantidad de filas y columas deseada
     * @param rows Número de filas a transformar
     * @param cols Número de columnas a trasformar
     * @return Array que contiene los elementos especificados
     */
    public Imaginary[] toArray(int rows, int cols){
        Imaginary[] result = new Imaginary[(rows) * (cols)];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i*j+j] = (Imaginary) this.get(i,j);
            }
        }
        return result;
    }

    /**
     * Transsforma una amtriz a un string
     * @return String formateado para parecer una matriz
     */
    @Override
    public String toString() {
        String s = "";
        for(Imaginary[] curr: this.matrix){
            for (Imaginary e : curr)
                s += e != null? e.toString() + "  " : "-  ";
            s += "\n";
        }
        return s;
    }

    /**
     * Permite duplicar una matriz como un nuevo objeto
     * @return Matiz con los mismos elementos de la original
     */
    @Override
    public Matrix clone() {
        Matrix clone = new Matrix(this.rows, this.cols);
        
        for(int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                clone.set(i,j,(Imaginary) this.get(i,j));
        return clone;
    }

    /**
     * Verifica si dos matrices son iguales tanto en atributos como en elementos
     * @param obj Objeto a comparar
     * @return Resultado de la comparación
     */
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
