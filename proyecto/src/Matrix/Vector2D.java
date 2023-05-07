package Matrix;

public class Vector2D extends Vector{

    public static int D_LENGHT3 = 3;

    public Vector2D(){
        super(D_LENGHT3);
    }

    public static Vector2D parse2D(Matrix m) {
        Vector2D v3 = new Vector2D();
        v3.fill(m.toArray());
        return v3;
    }

}
