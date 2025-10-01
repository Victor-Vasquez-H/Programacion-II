package ejercicio_2;

class Cuadrado extends Figura implements Coloreado {
    private double lado;
    
    public Cuadrado(double lado) {
        super();
        this.lado = lado;
    }
    
    public Cuadrado(double lado, String color) {
        super(color);
        this.lado = lado;
    }
    
    @Override
    public double area() {
        return lado * lado;
    }
    
    @Override
    public double perimetro() {
        return 4 * lado;
    }
    
    @Override
    public String comoColorear() {
        return "Colorear los cuatro lados";
    }
    
    @Override
    public String toString() {
        return "Cuadrado - Lado: " + lado + ", Color: " + color;
    }
    
    public double getLado() {
        return lado;
    }
    
    public void setLado(double lado) {
        this.lado = lado;
    }
}