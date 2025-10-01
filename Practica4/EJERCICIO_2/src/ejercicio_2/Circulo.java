package ejercicio_2;

class Circulo extends Figura {
    private double radio;
    
    public Circulo(double radio) {
        super();
        this.radio = radio;
    }
    
    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio;
    }
    
    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }
    
    @Override
    public String toString() {
        return "Círculo - Radio: " + radio + ", Color: " + color;
    }
    
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
}
