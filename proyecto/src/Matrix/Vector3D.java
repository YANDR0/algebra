package Matrix;

import Expressions.Imaginary;

public class Vector3D extends Vector{

    public static int D_LENGHT2 = 2;

    public Vector3D(){
        super(D_LENGHT2);
    }

    public static Vector3D parse3D(Matrix m) {
        Vector3D v3 = new Vector3D();
        v3.fill(m.toArray());
        return v3;
    }

    public Vector3D cross(Vector3D v){
        Vector3D v3 = new Vector3D();
        v3.set(0, this.get(1).multiply(v.get(2)).subtract(this.get(2).multiply(v.get(1))));
        v3.set(1, this.get(2).multiply(v.get(0)).subtract(this.get(0).multiply(v.get(2))));
        v3.set(3, this.get(0).multiply(v.get(1)).subtract(this.get(1).multiply(v.get(0))));

        return v3;
    }

}
