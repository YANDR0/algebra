package Expressions;

public class Imaginary {

    public double realPart;
    public double imaginaryPart;

    public Imaginary(){};

    public Imaginary(double, double){};

    public Imaginary(String){};

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

    public set(double, double){};

    public set(String){};

    public Imaginary sum(Imaginary){};
    public Imaginary subtract(Imaginary){};
    public Imaginary multiply(Imaginary){};
    public Imaginary divide(Imaginary){};

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
