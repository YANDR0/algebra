package Expressions;

import java.security.DrbgParameters;

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
        Imaginary number = this.multiply(i.conjugated());
        double den = (i.realPart * i.realPart) - (i.imaginaryPart * i.imaginaryPart);
        number.realPart = number.realPart / den;
        number.imaginaryPart = number.imaginaryPart/ den;

        return number;
    }

    public Imaginary conjugated(){
        return new Imaginary(this.realPart, -1 * this.imaginaryPart );
    }

    //GENERALS

    @Override
    public String toString() {
        return String.format("%f + %fi", this.realPart, this.imaginaryPart);
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
    //private static float[] fromString(String s){}

}
