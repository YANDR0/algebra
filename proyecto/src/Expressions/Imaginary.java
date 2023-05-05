package Expressions;

import com.sun.source.tree.ReturnTree;

import java.text.BreakIterator;

public class Imaginary implements Expression{

    public double realPart = 0;
    public double imaginaryPart = 0;

    //Constructores

    public Imaginary(){}

    public Imaginary(double real, double imaginary){
        this.realPart = real;
        this.imaginaryPart = imaginary;
    }

    // LUEGO
    //public Imaginary(String number){}

    // GETTERS AND SETTERS

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void set(double real, double imaginary){
        this.setRealPart(real);
        this.setImaginaryPart(imaginary);
    }

    //LUEGO
    //public void set(String number){}

    //OPERATIONS

    public Imaginary sum(Expression n){
        if(!(n instanceof Imaginary)) return null;

        Imaginary i = (Imaginary) n;
        Imaginary num = new Imaginary();
        num.realPart = this.realPart +  i.realPart;
        num.imaginaryPart = this.imaginaryPart + i.imaginaryPart;

        return num;
    }

    public Imaginary subtract(Expression n){
        if(!(n instanceof Imaginary)) return null;

        Imaginary i = (Imaginary) n;
        Imaginary num = new Imaginary();
        num.realPart = this.realPart -  i.realPart;
        num.imaginaryPart = this.imaginaryPart - i.imaginaryPart;

        return num;
    }

    public Imaginary multiply(Expression n){
        if(!(n instanceof Imaginary)) return null;

        Imaginary i = (Imaginary) n;
        Imaginary num = new Imaginary();
        num.realPart = (this.realPart *  i.realPart) - (this.imaginaryPart * i.imaginaryPart);
        num.imaginaryPart = (this.realPart + i.imaginaryPart) + (this.imaginaryPart + i.realPart);

        return num;
    }

    public Imaginary divide(Expression n){
        if(!(n instanceof Imaginary)) return null;

        Imaginary i = (Imaginary) n;
        if(i.realPart == 0 && i.imaginaryPart == 0) return null;

        Imaginary number = this.multiply(i.conjugated());
        double den = (i.realPart * i.realPart) - (i.imaginaryPart * i.imaginaryPart);
        number.realPart = number.realPart / den;
        number.imaginaryPart = number.imaginaryPart/ den;

        return number;
    }
    public Imaginary power(int e){
        if (e < 0) return null;
        if (e == 0) return new Imaginary(1,0);
        Imaginary base = this;
        for (int i = 0; i < e; i++){
            base = base.multiply(this);
        }
        return base;
    }

    public Imaginary conjugated(){
        return new Imaginary(this.realPart, -1 * this.imaginaryPart );
    }

    //GENERALS

    @Override
    public String toString() {
        return String.format("%.2g + %.2gi", this.realPart, this.imaginaryPart);
    }

    @Override
    public Imaginary clone() {
        return new Imaginary(this.realPart, this.realPart);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Imaginary)) return false;

        Imaginary i = (Imaginary) obj;
        return (this.realPart == i.realPart && this.imaginaryPart == i.imaginaryPart);
    }

    // LUEGO
    private static Imaginary fromString(String s){
        s = s.replace(" ", "").replace("-","*-").replace("+","*+");
        String[] split = s.split("\\*");
        try {
            return new Imaginary(Double.parseDouble(split[0]),Double.parseDouble(split[1]));
        }catch (Exception e){
            return null;
        }
    }

    public String toPolar(){
        double r = this.module();
        double angle = this.angle();
        return String.format("%f(cos(%f) + isin(%f))",r,angle,angle);
    }
    public String toExponential(){
        double r = this.module();
        double angle = this.angle();
        return String.format("%fe^%fi",r,angle);
    }
    public double module(){
        return (Math.sqrt(Math.pow(this.imaginaryPart,2)+Math.pow(this.realPart,2)));
    }
    public double angle(){
        return this.realPart > 0 ? Math.atan(this.imaginaryPart/this.realPart) :
                Math.atan(this.imaginaryPart/this.realPart) + Math.PI;
    }
    public Imaginary[] toImaginary(String... numbers){
        Imaginary []imaginary = new Imaginary[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            imaginary[i] = Imaginary.fromString(numbers[i]);
        }
        return imaginary;
    }
    //public static noséXD roots(double number, double root){}
}
