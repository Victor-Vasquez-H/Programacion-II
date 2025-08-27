package ecuacion;

public class Ejercicio2 {
    private double a, b, c;

    public Ejercicio2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }

    public double getRaiz1() {
        if (getDiscriminante() >= 0) {
            return (-b + Math.sqrt(getDiscriminante())) / (2 * a);
        }
        return 0;
    }

    public double getRaiz2() {
        if (getDiscriminante() >= 0) {
            return (-b - Math.sqrt(getDiscriminante())) / (2 * a);
        }
        return 0;
    }
}
