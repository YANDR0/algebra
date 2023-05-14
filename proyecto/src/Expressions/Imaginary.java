
package Expressions;
import java.text.DecimalFormat;

/**
 * Clase dedicada a la creación de expresiones imaginarias.
 */
public class Imaginary implements Expression<Imaginary>{

    /**
     * Componente de la expresión que representa la parte real.
     */
    protected double realPart = 0;

    /**
     * Componente de la expresión que representa la parte imaginaria.
     */
    protected double imaginaryPart = 0;

        //Constructores

    /**
     * Crea una expresión vacia
     */
    public Imaginary(){}

    /**
     * Crea una expresion con valor real e imaginario
     * @param real Valor de la parte real
     * @param imaginary Valor de la parte imaginaria
     */
    public Imaginary(double real, double imaginary){
        this.realPart = real;
        this.imaginaryPart = imaginary;
    }

    /**
     * Crea una expresión en base a un string que entrega el usuario
     * @param number Expresión completa detectando la parte real e imaginaria
     */
    public Imaginary(String number){
        Imaginary i = Imaginary.fromString(number);
        if(i != null){
            this.realPart = i.realPart;
            this.imaginaryPart = i.imaginaryPart;
        }

    }

        // GETTERS AND SETTERS

    /**
     * Regresa la parte imaginaria de la expresión
     * @return Double igual a la parte imaginaria
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Regresa la parte real de la expresión
     * @return Double igual a la parte real
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Declara la parte imaginaria
     * @param imaginaryPart Entrada del usuario
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Declara la parte real.
     * @param realPart Entrada del usuario
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     * Declara la expresión completa
     * @param real Entrada de la parte real
     * @param imaginary Entrada de la parte imaginaria
     */
    public void set(double real, double imaginary){
        this.setRealPart(real);
        this.setImaginaryPart(imaginary);
    }


        //OPERATIONS

    /**
     * Realiza la suma de numeros complejos
     * @param n valor de del segundo sumando de la operación
     * @return Resultado de la suma
     */
    public Imaginary sum(Imaginary n){
        Imaginary num = new Imaginary();
        num.realPart = this.realPart +  n.realPart;
        num.imaginaryPart = this.imaginaryPart + n.imaginaryPart;

        return num;
    }

    /**
     * Realiza la resta de numeros complejos
     * @param n valor del sustraendo de la operación
     * @return Resultado de la resta.
     */
    public Imaginary subtract(Imaginary n){
        Imaginary num = new Imaginary();
        num.realPart = this.realPart -  n.realPart;
        num.imaginaryPart = this.imaginaryPart - n.imaginaryPart;

        return num;
    }

    /**
     * Realiza la multiplicación de numeros complejos
     * @param n valor del segundo factor de la operación
     * @return Resultado de la multiplicación
     */
    public Imaginary multiply(Imaginary n){
        Imaginary num = new Imaginary();
        num.realPart = (this.realPart *  n.realPart) - (this.imaginaryPart * n.imaginaryPart);
        num.imaginaryPart = (this.realPart * n.imaginaryPart) + (this.imaginaryPart * n.realPart);

        return num;
    }

    /**
     * Realiza la división de numeros complejos
     * @param n Valor del denominador de la operación
     * @return Resultado de la división
     */
    public Imaginary divide(Imaginary n){
        if(n.realPart == 0 && n.imaginaryPart == 0) return null;

        Imaginary number = this.multiply(n.conjugated());
        double den = (n.realPart * n.realPart) + (n.imaginaryPart * n.imaginaryPart);
        number.realPart = number.realPart / den;
        number.imaginaryPart = number.imaginaryPart/ den;

        return number;
    }

    /**
     * Realiza la potencia de número complejo
     * @param e valor del exponente
     * @return Resultado de la base elevado al exponente
     */
    public Imaginary power(int e){
        if (e < 0) return null;
        Imaginary base = new Imaginary(1,0);
        for (int i = 0; i < e; i++){
            base = base.multiply(this);
        }
        return base;
    }

    /**
     * Realiza la raíz de numero complejo
     * @param r valor de la raiz
     * @return Los distintos resultado de la raiz deseada al número complejo
     */
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

    /**
     * Realiza la forma conjugada de la expresión
     * @return el valor conjugado
     */
    public Imaginary conjugated(){
        return new Imaginary(this.realPart, -1 * this.imaginaryPart );
    }

        //GENERALS

    /**
     * Genera la cadena de texto dividiendola y añadiendo lo necesario para conformar una expresion compleja
     * @return cadena de texto de numeros complejos
     */
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

    /**
     * Clona la expresión compleja
     * @return  Una clonacion de la expresion compleja
     */
    @Override
    public Imaginary clone() {
        return new Imaginary(this.realPart, this.realPart);
    }

    /**
     * Comprueba si son iguales dos expresiones complejas
     * @param obj expresion compleja.
     * @return un booleano determinadno si son iguales o no
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Imaginary)) return false;

        Imaginary i = (Imaginary) obj;
        return (this.realPart == i.realPart && this.imaginaryPart == i.imaginaryPart);
    }

        // Otros

    /**
     * Devuelve los valores real e imaginario en un objeto a partir de un string
     * @param s cadena de texto que simula una expresion de numeros complejos
     * @return valor real e imaginario.
     */
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

    /**
     * Coloca un formato adecuado para la forma polar de una expresión compleja
     * @return cadena de texto de la forma polar
     */
    public String toPolar(){
        double r = this.module();
        double angle = this.angle();
        return String.format("%f(cos(%f) + isin(%f))",r,angle,angle);
    }

    /**
     * Coloca un formato adecuado para el exponencial de una expresión compleja.
     * @return cadena de texto adecuada para el exponencial.
     */
    public String toExponential(){
        double r = this.module();
        double angle = this.angle();
        return String.format("%fe^%fi",r,angle);
    }

    /**
     * Determina el modulo de la expresion compleja.
     * @return el resultado del modulo.
     */
    public double module(){
        return (Math.sqrt(Math.pow(this.imaginaryPart,2)+Math.pow(this.realPart,2)));
    }

    /**
     * Determina el angulo de una expresión compleja.
     * @return el resultado del angulo.
     */
    public double angle(){
        return this.realPart > 0 ? Math.atan(this.imaginaryPart/this.realPart) :
                Math.atan(this.imaginaryPart/this.realPart) + Math.PI;
    }

    /**
     * Convierte un grupo de cadenas de texto a una o más expresiones complejas
     * @param numbers cadena completa que conforma la expresión
     * @return Grupo de objetos resultantes
     */
    public Imaginary[] toImaginary(String... numbers){
        Imaginary []imaginary = new Imaginary[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            imaginary[i] = Imaginary.fromString(numbers[i]);
        }
        return imaginary;
    }

}
