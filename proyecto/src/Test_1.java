
import Expressions.*;
import Matrix.*;

public class Test_1 {

    public static void main(String[] args) {
        Imaginary p1 = Imaginary.fromString("8-2i");
        System.out.println(p1);
        Imaginary p2 = new Imaginary(-9,-12);
        System.out.println(p2);
        System.out.println(p1.divide(p2));





    }

}