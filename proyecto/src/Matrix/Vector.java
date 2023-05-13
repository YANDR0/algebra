package Matrix;

import Expressions.Imaginary;

public class Vector extends Matrix {

    protected int size;

    public Vector(){
        super(1, DEFAULT_SIZE);
        this.size = this.cols;

    }

    public Vector(int index){
        super(1, index);
        this.size = this.cols;

    }

    public Imaginary get(int index){
        if(index >= this.size) return null;
        return (Imaginary) super.get(0, index);
    }

    public void set(int index, Imaginary number){
        if(index >= this.size) return;
        super.set(0, index, number);
    }


    //OPERATIONS
    /*
    public Imaginary norm(){
        Imaginary total = new Imaginary();
        for(int i = 0; i < this.size; i++)
            total = total.sum(this.get(i).multiply(this.get(i)));
        return total;
    }
    */
    public Imaginary dot(Vector v){
        if(this.size != v.size) return null;

        Imaginary total = new Imaginary();
        for(int i = 0; i < this.size; i++){
            total = total.sum(this.get(i).multiply(v.get(i)));
        }
        return total;
    }

    public Vector cross(Vector v){
        if(this.size != 3 || v.size !=3) return null;
        Vector v3 = new Vector(3);
        v3.set(0, this.get(1).multiply(v.get(2)).subtract(this.get(2).multiply(v.get(1))));
        v3.set(1, this.get(2).multiply(v.get(0)).subtract(this.get(0).multiply(v.get(2))));
        v3.set(2, this.get(0).multiply(v.get(1)).subtract(this.get(1).multiply(v.get(0))));

        return v3;
    }



}
