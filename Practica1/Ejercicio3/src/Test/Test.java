package test;

import java.util.Scanner;
import ecuacion.Ejercicio3;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numeros = new double[10];
        System.out.println("Ingrese 10 números: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextDouble();
        }

        Ejercicio3 est = new Ejercicio3(numeros);

        System.out.println("El promedio es " + est.promedio());
        System.out.println("La desviación estándar es " + est.desviacion());

        sc.close();
    }
}
