package Expressions;

public class Imaginary implements Expression{

    public double realPart = 1;
    public double imaginaryPart = 1;

    //Constructores

    public Imaginary(){

    }

    public Imaginary(double real, double imaginary){

    }

    public Imaginary(String number){

    }

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

    }

    public void set(String number){

    }

    //OPERATIONS

    public Imaginary sum(Expression n){
        return null;
    }

    public Imaginary subtract(Expression n){
        return null;
    }

    public Imaginary multiply(Expression n){
        return null;
    }

    public Imaginary divide(Expression n){
        return null;
    }

    //GENERALS

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Imaginary clone() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
