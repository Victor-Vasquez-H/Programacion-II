package ejercicio_2;
 import java.util.Random;

public class TestFiguras {
    public static void main(String[] args) {
        Random random = new Random();
        Figura[] figuras = new Figura[5];
        
        System.out.println("GENERANDO FIGURAS ALEATORIAS");

        figuras[0] = crearFiguraAleatoria(random, 1);
        figuras[1] = crearFiguraAleatoria(random, 2);
        figuras[2] = crearFiguraAleatoria(random, 3);
        figuras[3] = crearFiguraAleatoria(random, 4);
        figuras[4] = crearFiguraAleatoria(random, 5);
        
        System.out.println("\nINFORMACION DE FIGURAS");

        System.out.println("Figura 1:");
        mostrarInfoFigura(figuras[0]);
        
        System.out.println("Figura 2:");
        mostrarInfoFigura(figuras[1]);
        
        System.out.println("Figura 3:");
        mostrarInfoFigura(figuras[2]);
        
        System.out.println("Figura 4:");
        mostrarInfoFigura(figuras[3]);
        
        System.out.println("Figura 5:");
        mostrarInfoFigura(figuras[4]);
    }
    
    private static Figura crearFiguraAleatoria(Random random, int numero) {
        int tipo = random.nextInt(2) + 1; 
        
        if (tipo == 1) {
            double lado = 1 + random.nextDouble() * 9;
            System.out.println("Cuadrado " + numero + " - Lado: " + lado);
            return new Cuadrado(lado);
        } else {
            double radio = 1 + random.nextDouble() * 9;
            System.out.println("Circulo " + numero + " - Radio: " + radio);
            return new Circulo(radio);
        }
    }
    
    private static void mostrarInfoFigura(Figura figura) {
        System.out.println("Area: " + figura.area());
        System.out.println("Perimetro: " + figura.perimetro());
        
        if (figura instanceof Coloreado) {
            Coloreado coloreado = (Coloreado) figura;
            System.out.println("Como colorear: " + coloreado.comoColorear());
        }
        System.out.println();
    }
}        
       