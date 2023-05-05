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

    public Real[] toReal(double... numbers){
        Real []reals = new Real[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            reals[i] = new Real(numbers[i]);
        }
        return reals;
    }
}
