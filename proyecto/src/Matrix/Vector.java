package Matrix;

import Expressions.Imaginary;

/**
 * Clase hija de matriz que permite realizar operaciones propia de los vectores
 */
public class Vector extends Matrix {

    /**
     * Tamaño del vector
     */
    protected int size;

    /**
     * Devuelve un vector de tamaño 3
     */
    public Vector(){
        super(1, DEFAULT_SIZE);
        this.size = this.cols;

    }

    /**
     * Devulve un vector del tamaño solicitado
     * @param index Tamaño deseado para el vector
     */
    public Vector(int index){
        super(1, index);
        this.size = this.cols;

    }

    /**
     * Obtiene el elemento de la posición n dentro del vector
     * @param index Posición del elemento deseado
     * @return Elemento deseado o en su defecto null
     */
    public Imaginary get(int index){
        if(index >= this.size) return null;
        return (Imaginary) super.get(0, index);
    }

    /**
     * Declara el valor dentro de una posición del vector
     * @param index Posición con valor a cambiar
     * @param number Número a agregar dentro del vector
     */
    public void set(int index, Imaginary number){
        if(index >= this.size) return;
        super.set(0, index, number);
    }


        //OPERATIONS

    /**
     * Realiza el producto punto entre dos vectores
     * @param v Vector equivalente al segundoo factor de la operación
     * @return Número resultado de la operación
     */
    public Imaginary dot(Vector v){
        if(this.size != v.size) return null;

        Imaginary total = new Imaginary();
        for(int i = 0; i < this.size; i++){
            total = total.sum(this.get(i).multiply(v.get(i)));
        }
        return total;
    }

    /**
     * Realiza el producto cruz entre dos vectores si ambos poseen un tamaño de 3
     * @param v Vector equivalente al segundo termino de la operación
     * @return Vetor de tamaño 3 resultante de la operación
     */
    public Vector cross(Vector v){
        if(this.size != 3 || v.size !=3) return null;
        Vector v3 = new Vector(3);
        v3.set(0, this.get(1).multiply(v.get(2)).subtract(this.get(2).multiply(v.get(1))));
        v3.set(1, this.get(2).multiply(v.get(0)).subtract(this.get(0).multiply(v.get(2))));
        v3.set(2, this.get(0).multiply(v.get(1)).subtract(this.get(1).multiply(v.get(0))));

        return v3;
    }



}
