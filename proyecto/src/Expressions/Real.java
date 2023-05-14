package Expressions;

public class Real extends Imaginary{

    public Real(){
    }

    public Real(double n){
        this.realPart = n;
    }

    public double toNumber(){
        return this.realPart;
    }

    public static Real[] toReal(double... numbers){
        Real []reals = new Real[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            reals[i] = new Real(numbers[i]);
        }
        return reals;
    }
}
