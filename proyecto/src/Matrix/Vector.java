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

    public Imaginary norm(){
        Imaginary total = new Imaginary();
        for(int i = 0; i < this.size; i++)
            total = total.sum(this.get(i).multiply(this.get(i)));
        return total;
    }

    public Imaginary dot(Vector v){
        if(this.size != v.size) return null;

        Imaginary total = new Imaginary();
        for(int i = 0; i < this.size; i++){
            total = total.sum(this.get(i).multiply(v.get(i)));
        }
        return total;
    }

    //public Vector cross(Vector v){}


    //ESTO A LO MEJOR ES EXCLUSIVO DE 2D y 3D

    //public Imaginary distance(Vector v){}
    //public Imaginary angle(Vector v){}

}
