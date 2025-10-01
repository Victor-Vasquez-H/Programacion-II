package ejercicio._1;

abstract class Empleado {
    protected String nombre;
    
    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract double CalcularSalarioMensual();
    
    public String toString() {
        return "Nombre: " + nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}