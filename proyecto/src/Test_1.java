

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

        //RAIZ
        Imaginary ro = new Imaginary(-2, 2);
        Imaginary[] list = ro.root(3);
        System.out.println("RAIZ: \t" + ro + "^1/3");
        for(Imaginary i: list)
            System.out.println(i);

                // TODO ----- MATRICES -----  //

        System.out.println("\n\tMATRICES");
        Matrix m1 = new Matrix(3,2);
        Real[] numbers1 = Real.toReal(-3, 0,2,5,8,-7);
        m1.fill(numbers1);

        Matrix m2 = new Matrix(3,2);
        Real[] numbers2 = Real.toReal(7, -5,4,-2,1,-4);
        m2.fill(numbers2);

        Matrix m3 = new Matrix(2,3);
        m3.set(0,0,new Real(2));
        m3.set(0,1,new Real(3));
        m3.set(0,2,new Real(4));
        m3.set(1,0,new Real(5));
        m3.set(1,1,new Real(6));
        m3.set(1,2,new Real(7));

        System.out.println("\nMATRIZ A:\n" + m1 + "\nMATRIZ B:\n" + m2 + "\nMATRIZ C:\n" + m3 );

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

        Matrix mg = new Matrix(4, 5);
        Real[] numbers3 = Real.toReal(1,-2,2,-3,15,3,4,-1,1,-6,2,-3,2,-1,17,1,1,-3,-2,-7);
        mg.fill(numbers3);

        System.out.println("\nMATRIZ G:\n" + mg);
        //GAUSS
        System.out.println("GAUSS G: \n" + mg.gauss());
        //GAUSS JORDAN
        System.out.println("JORDAN G: \n" + mg.gaussJordan());

                // TODO ----- MATRIZ CUADRADA -----  //

        System.out.println("\tMATRICES CUADRADAS\n");
        SquareMatrix mc1 = new SquareMatrix(4);
        Real[] numbers4 = Real.toReal(1,1, -1, 1, 2, 5, -3, 3, -1, 5, -2, 3, 2, 11, -4, 4);
        mc1.fill(numbers4);

        SquareMatrix mc2 = new SquareMatrix();
        Real[] numbers5 = Real.toReal(5,2,-3,0,8,-1,-4,5,2);
        mc2.fill(numbers5);

        SquareMatrix mc3 = new SquareMatrix(2);
        Real[] numbers6 = Real.toReal(5,-3,6,4);
        mc3.fill(numbers6);

        System.out.println("MATRIZ CUADRADA A:\n" + mc1 + "MATRIZ CUADRADA B:\n" + mc2 + "MATRIZ CUADRADA C:\n" + mc3);
        //POTENCIA
        System.out.println("POTENCIA A^3: \n" + mc1.pow(3));
        //DETERMINANTE
        System.out.println("DETERMINANTE B: \n" + mc2.determinant());
        System.out.println("DETERMINANTE C: \n" + mc3.determinant() + "\n");
        //IDENTIDAD
        System.out.println("IDENTIDAD 3x3: \n" + SquareMatrix.identity(3));     //OCUPA A GAUSS

                // TODO ----- VECTORES -----  //

        System.out.println("\tVECTORES\n");

        Vector vpp1 = new Vector(3);
        vpp1.set(0,new Real(-3));
        vpp1.set(1,new Real(-2));
        vpp1.set(2, new Real(5));

        Vector vpp2 = new Vector(3);
        vpp2.set(0,new Real(6));
        vpp2.set(1,new Real(-10));
        vpp2.set(2, new Real(-1));


        System.out.println("VECTOR A: " + vpp1 + "VECTOR B: " + vpp2);
        System.out.println("PROD.PUNTO A*B: \n" + vpp1.dot(vpp2));
        System.out.println("PROD.CRUZ AXB: \n" + vpp1.cross(vpp2));

    }

}