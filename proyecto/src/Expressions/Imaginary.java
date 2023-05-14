
package Expressions;
import java.text.DecimalFormat;

public class Imaginary implements Expression<Imaginary>{

    protected double realPart = 0;
    protected double imaginaryPart = 0;

    //Constructores

    public Imaginary(){}

    public Imaginary(double real, double imaginary){
        this.realPart = real;
        this.imaginaryPart = imaginary;
    }

    public Imaginary(String number){
        Imaginary i = Imaginary.fromString(number);
        if(i != null){
            this.realPart = i.realPart;
            this.imaginaryPart = i.imaginaryPart;
        }

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
        this.setRealPart(real);
        this.setImaginaryPart(imaginary);
    }


    //OPERATIONS

    public Imaginary sum(Imaginary n){
        Imaginary num = new Imaginary();
        num.realPart = this.realPart +  n.realPart;
        num.imaginaryPart = this.imaginaryPart + n.imaginaryPart;

        return num;
    }

    public Imaginary subtract(Imaginary n){
        Imaginary num = new Imaginary();
        num.realPart = this.realPart -  n.realPart;
        num.imaginaryPart = this.imaginaryPart - n.imaginaryPart;

        return num;
    }

    public Imaginary multiply(Imaginary n){
        Imaginary num = new Imaginary();
        num.realPart = (this.realPart *  n.realPart) - (this.imaginaryPart * n.imaginaryPart);
        num.imaginaryPart = (this.realPart * n.imaginaryPart) + (this.imaginaryPart * n.realPart);

        return num;
    }

    public Imaginary divide(Imaginary n){
        if(n.realPart == 0 && n.imaginaryPart == 0) return null;

        Imaginary number = this.multiply(n.conjugated());
        double den = (n.realPart * n.realPart) + (n.imaginaryPart * n.imaginaryPart);
        number.realPart = number.realPart / den;
        number.imaginaryPart = number.imaginaryPart/ den;

        return number;
    }

    public Imaginary power(int e){
        if (e < 0) return null;
        Imaginary base = new Imaginary(1,0);
        for (int i = 0; i < e; i++){
            base = base.multiply(this);
        }
        return base;
    }

    public Imaginary[] root(int r){
        Imaginary[] results = new Imaginary[r];
        double angle = this.angle();
        double module = Math.pow(this.module(),1.0/r);

        for(int i = 0; i< r; i++){
            double argument = (angle + 2* Math.PI * i)/r;
            results[i] = new Imaginary(Math.cos(argument) * module, Math.sin(argument) * module);
        }

        return results;
    }

    public Imaginary conjugated(){
        return new Imaginary(this.realPart, -1 * this.imaginaryPart );
    }

    //GENERALS

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.####");
        String s = String.format("(%s", df.format(this.realPart));
        if(this.imaginaryPart == -1)
            s += "-i";
        else if(this.imaginaryPart < 0)
            s += String.format("%si", df.format(this.imaginaryPart));
        if(this.imaginaryPart == 1)
            s += "+i";
        else if(this.imaginaryPart > 0)
            s += String.format("+%si", df.format(this.imaginaryPart));

        return s + ")";
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

    // Otros
    public static Imaginary fromString(String s){
        s = s.replace(" ", "").replace("-","*-").replace("+","*+").replace("i","");
        String[] split = s.split("\\*");
        int min = split[0] == ""? 1:0;

        try {
            return new Imaginary(Double.parseDouble(split[min]),Double.parseDouble(split[min+1]));
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

}
