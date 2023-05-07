package Matrix;

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

    //public Vector cross(Vector v){}

}
