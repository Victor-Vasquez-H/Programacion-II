package Test;

import java.util.Scanner;
import ecuacion.Ejercicio1;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a, b, c, d, e, f: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        Ejercicio1 eq = new Ejercicio1(a, b, c, d, e, f);

        if (eq.tieneSolucion()) {
            System.out.println("x = " + eq.getX() + ", y = " + eq.getY());
        } else {
            System.out.println("La ecuación no tiene solución");
        }

        sc.close();
    }
}


