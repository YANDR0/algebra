package Expressions;

public class Real extends Imaginary{

    /**
     * Crea un número real equivalente a cero
     */
    public Real(){
    }

    /**
     * Crea un número real con su parte real igual a lo dado
     * @param n Valor del número
     */
    public Real(double n){
        this.realPart = n;
    }

    /**
     *
     * @return Devulve la parte real del objeto
     */
    public double toNumber(){
        return this.realPart;
    }

    /**
     * Convierte una gran cantidad de números a objetos del tipo Real
     * @param numbers Lista o serie de números a transformar
     * @return Lista de Reales equivalentes a lo dado
     */
    public static Real[] toReal(double... numbers){
        Real []reals = new Real[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            reals[i] = new Real(numbers[i]);
        }
        return reals;
    }
}
