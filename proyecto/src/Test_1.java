

import Expressions.*;
import Matrix.*;

public class Test_1 {

    public static void main(String[] args) {

                // TODO ----- IMAGINARIOS -----  //

        System.out.println("\n\tIMAGINARIOS\n");
        //SUMA
        Imaginary is1 = new Imaginary("5+2i");
        Imaginary is2 = new Imaginary(4,7);
        System.out.println("SUMA: \t" + is1 + " + " + is2 + " = " + is1.sum(is2));
        //RESTA
        Imaginary ir1 = new Imaginary("3-2i");
        Imaginary ir2 = new Imaginary(6,-4);
        System.out.println("RESTA: \t" + ir1 + " - " + ir2 + " = "  + ir1.subtract(ir2));
        //Multiplicacion
        Imaginary im1 = new Imaginary("-6+1i");
        Imaginary im2 = new Imaginary(-3,-5);
        System.out.println("MULTI: \t" + im1 + " * " + im2 + " = " + im1.multiply(im2));
        //DIVISION
        Imaginary id1 = new Imaginary(-4,5);
        Imaginary id2 = new Imaginary(8,-2);
        System.out.println("DIVISIÓN: \t" + id1 + " / " + id2 + " = " + id1.divide(id2));
        //POTENCIA
        int exponent = 3;
        Imaginary ip1 = new Imaginary(2,2);
        System.out.println("POTENCIA: \t" + ip1 + "^" + exponent + " = " + ip1.power(exponent));
        //CONJUGADO
        Imaginary ic1 = new Imaginary(-5,3);
        System.out.println("CONJUGADO: \t" + ic1 + "C = " + ic1.conjugated());
        //POLAR
        Imaginary ipo1 = new Imaginary(2,16);
        System.out.println("FORMA POLAR: \t" + ipo1 + "P = "+ ipo1.toPolar());
        //EXPONENCIAL
        Imaginary ie1 = new Imaginary(-4,6);
        System.out.println("EXPONENCIAL: \t" + ie1 + "E = "+ ie1.toExponential());

                // TODO ----- MATRICES -----  //
        /*
        System.out.println("\tMATRICES\n");
        Matrix m1 = new Matrix(3,2);
        m1.set(0,0,new Real(-3));
        m1.set(0,1,new Real(0));
        m1.set(1,0,new Real(2));
        m1.set(1,1,new Real(5));
        m1.set(2,0,new Real(8));
        m1.set(2,1,new Real(-7));
        Matrix m2 = new Matrix(3,2);
        m2.set(0,0,new Real(7));
        m2.set(0,1,new Real(-5));
        m2.set(1,0,new Real(4));
        m2.set(1,1,new Real(-2));
        m2.set(2,0,new Real(1));
        m2.set(2,1,new Real(-4));
        Matrix m3 = new Matrix(2,3);
        m3.set(0,0,new Real(2));
        m3.set(0,1,new Real(3));
        m3.set(0,2,new Real(4));
        m3.set(1,0,new Real(5));
        m3.set(1,1,new Real(6));
        m3.set(1,2,new Real(7));
        System.out.println("MATRIZ A:\n" + m1 + "MATRIZ B:\n" + m2 + "MATRIZ C:\n" + m3);
        //SUMA
        System.out.println("SUMA A+B: \n" + m1.sum(m2));
        //RESTA
        System.out.println("RESTA A-B: \n" + m1.substract(m2));
        //MULTIPLICACION
        System.out.println("MULTIPLICACION A*C: \n" + m1.multiply(m3));
        //TRANSPUESTA
        System.out.println("TRANSPUESTA A^T: \n" + m1.transpose());
        //ESCALAR
        System.out.println("ESCALAR 3 * A: \n" + m1.escalar(new Real(3)));
        //GAUSS
        //System.out.println("GAUSS A: \n" + m1.gauss());
        //GAUSS JORDAN
        //System.out.println("GAUSS A: \n" + m1.gaussJordan());
        */
                // TODO ----- MATRIZ CUADRADA -----  //
        /*
        System.out.println("\tMATRICES CUADRADAS\n");
        SquareMatrix mc1 = new SquareMatrix(3);
        mc1.set(0,0,new Real(1));
        mc1.set(0,1,new Real(2));
        mc1.set(0,2,new Real(3));
        mc1.set(1,0,new Real(4));
        mc1.set(1,1,new Real(5));
        mc1.set(1,2,new Real(6));
        mc1.set(2,0,new Real(7));
        mc1.set(2,1,new Real(8));
        mc1.set(2,2,new Real(9));
        System.out.println("MATRIZ CUADRADA A:\n" + mc1);
        //POTENCIA
        //System.out.println("POTENCIA A: \n" + mc1.pow(3));
        //IDENTIDAD
        SquareMatrix mi1 = new SquareMatrix();
        System.out.println("IDENTIDAD B: \n" + mi1.identity(3));
        //DETERMINANTE
        //System.out.println("DETERMINANTE A: \n" + mi1.determinant());
        */
                // TODO ----- VECTORES -----  //
        /*
        //PRODUCTO PUNTO
        Vector vpp1 = new Vector(2);
        vpp1.set(0,new Real(-3));
        vpp1.set(0,new Real(5));
        Vector vpp2 = new Vector(2);
        vpp2.set(0,new Real(2));
        vpp2.set(0,new Real(-4));
        System.out.println("VECTOR A: " + vpp1 + "VECTOR B: " + vpp2);
        //System.out.println("PROD.PUNTO A*B: \n" + vpp1.dot(vpp2));
        //System.out.println("PROD.CRUZ AXB: \n" + vpp1.cross(vpp2));
        */
    }

}