package EJ2;
public class Vector3D {
    private final double x, y, z;
    private static final double EPS = 1e-9;
    public Vector3D() { this(0, 0, 0); }
    public Vector3D(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }
    public Vector3D(double[] v) {
        if (v == null || v.length != 3)
            throw new IllegalArgumentException("Se esperan 3 componentes");
        this.x = v[0]; this.y = v[1]; this.z = v[2];
    }
    public Vector3D(Vector3D v) { this(v.x, v.y, v.z); }
    public Vector3D sumar(Vector3D v) {
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }
    public Vector3D multiplicar(double r) {
        return new Vector3D(r*this.x, r*this.y, r*this.z);
    }
    public double longitud() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    public Vector3D normalizado() {
        double norma = longitud();
        if (norma <= EPS) throw new ArithmeticException("No se puede normalizar el vector nulo");
        return new Vector3D(x/norma, y/norma, z/norma);
    }
    public double productoEscalar(Vector3D v) {
        return this.x*v.x + this.y*v.y + this.z*v.z;
    }
    public Vector3D productoVectorial(Vector3D v) {
        return new Vector3D(
            this.y*v.z - this.z*v.y,
            this.z*v.x - this.x*v.z,
            this.x*v.y - this.y*v.x
        );
    }
    public Vector3D proyeccion(Vector3D v) {
        double denom = v.longitud();
        if (denom <= EPS) throw new ArithmeticException("No se puede proyectar sobre vector nulo");
        double esc = this.productoEscalar(v) / (v.longitud()*v.longitud());
        return v.multiplicar(esc);
    }
    public double componente(Vector3D v) {
        double norma = v.longitud();
        if (norma <= EPS) throw new ArithmeticException("Vector nulo en componente");
        return this.productoEscalar(v) / norma;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}



