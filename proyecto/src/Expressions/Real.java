package Expressions;

public class Real extends Imaginary{

    public Real(){
    }

    public Real(double n){
        this.realPart = n;
    }

    @Override
    public String toString() {
        return String.valueOf(this.realPart);
    }

    public double toNumber(){
        return this.realPart;
    }
}
