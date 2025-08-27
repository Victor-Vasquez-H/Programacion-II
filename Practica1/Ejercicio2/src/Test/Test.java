package test;

import java.util.Scanner;
import ecuacion.Ejercicio2;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        Ejercicio2 eq = new Ejercicio2(a, b, c);

        double discriminante = eq.getDiscriminante();

        if (discriminante > 0) {
            System.out.println("La ecuación tiene dos raíces " + eq.getRaiz1() + " y " + eq.getRaiz2());
        } else if (discriminante == 0) {
            System.out.println("La ecuación tiene una raíz " + eq.getRaiz1());
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }

        sc.close();
    }
}

