package EJ1;
public class AlgebraVectorial {
    private final double x, y, z;
    private static final double EPS = 1e-9;
    public AlgebraVectorial() { this(0, 0, 0); }
    public AlgebraVectorial(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }
    public AlgebraVectorial(double[] v) {
        if (v == null || v.length != 3)
            throw new IllegalArgumentException("Se esperan 3 componentes");
        this.x = v[0]; this.y = v[1]; this.z = v[2];
    }
    private double norm2() { return x*x + y*y + z*z; }
    private double norm() { return Math.sqrt(norm2()); }
    private AlgebraVectorial add(AlgebraVectorial b) { return new AlgebraVectorial(x+b.x, y+b.y, z+b.z); }
    private AlgebraVectorial sub(AlgebraVectorial b) { return new AlgebraVectorial(x-b.x, y-b.y, z-b.z); }
    private AlgebraVectorial scale(double r) { return new AlgebraVectorial(r*x, r*y, r*z); }
    private double dot(AlgebraVectorial b) { return x*b.x + y*b.y + z*b.z; }
    private AlgebraVectorial cross(AlgebraVectorial b) {
        return new AlgebraVectorial(
            y*b.z - z*b.y,
            z*b.x - x*b.z,
            x*b.y - y*b.x
        );
    }
    public boolean esPerp_a(AlgebraVectorial b) {
        return Math.abs(this.add(b).norm() - this.sub(b).norm()) <= EPS;
    }
    public boolean esPerp_a(double[] b) { return esPerp_a(new AlgebraVectorial(b)); }
    public boolean esPerp_b(AlgebraVectorial b) {
        return Math.abs(this.sub(b).norm() - b.sub(this).norm()) <= EPS;
    }
    public boolean esPerp_b(double[] b) { return esPerp_b(new AlgebraVectorial(b)); }
    public boolean esPerp_c(AlgebraVectorial b) {
        return Math.abs(this.dot(b)) <= EPS;
    }
    public boolean esPerp_c(double[] b) { return esPerp_c(new AlgebraVectorial(b)); }
    public boolean esPerp_d(AlgebraVectorial b) {
        return Math.abs(this.add(b).norm2() - (this.norm2()+b.norm2())) <= EPS;
    }
    public boolean esPerp_d(double[] b) { return esPerp_d(new AlgebraVectorial(b)); }
    public boolean esParalelo_e(AlgebraVectorial b) {
        Double r = null;
        if (Math.abs(b.x) > EPS) r = this.x / b.x; else if (Math.abs(this.x) > EPS) return false;
        if (Math.abs(b.y) > EPS) {
            double ry = this.y / b.y;
            if (r == null) r = ry; else if (Math.abs(ry-r) > EPS) return false;
        } else if (Math.abs(this.y) > EPS) return false;
        if (Math.abs(b.z) > EPS) {
            double rz = this.z / b.z;
            if (r == null) r = rz; else if (Math.abs(rz-r) > EPS) return false;
        } else if (Math.abs(this.z) > EPS) return false;
        return true;
    }
    public boolean esParalelo_e(double[] b) { return esParalelo_e(new AlgebraVectorial(b)); }
    public boolean esParalelo_f(AlgebraVectorial b) {
        AlgebraVectorial c = this.cross(b);
        return Math.abs(c.x)<=EPS && Math.abs(c.y)<=EPS && Math.abs(c.z)<=EPS;
    }
    public boolean esParalelo_f(double[] b) { return esParalelo_f(new AlgebraVectorial(b)); }
    public AlgebraVectorial proyeccion(AlgebraVectorial b) {
        double denom = b.norm2();
        if (denom <= EPS) throw new IllegalArgumentException("Vector nulo en proyección");
        return b.scale(this.dot(b)/denom);
    }
    public AlgebraVectorial proyeccion(double[] b) { return proyeccion(new AlgebraVectorial(b)); }
    public double componente(AlgebraVectorial b) {
        double nb = b.norm();
        if (nb <= EPS) throw new IllegalArgumentException("Vector nulo en componente");
        return this.dot(b)/nb;
    }
    public double componente(double[] b) { return componente(new AlgebraVectorial(b)); }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
