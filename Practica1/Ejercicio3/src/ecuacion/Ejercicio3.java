package ecuacion;

public class Ejercicio3 {
    private double[] datos;

    public Ejercicio3(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double suma = 0;
        for (double v : datos) {
            suma += v;
        }
        return suma / datos.length;
    }

    public double desviacion() {
        double prom = promedio();
        double suma = 0;
        for (double v : datos) {
            suma += Math.pow(v - prom, 2);
        }
        return Math.sqrt(suma / (datos.length - 1));
    }
}
