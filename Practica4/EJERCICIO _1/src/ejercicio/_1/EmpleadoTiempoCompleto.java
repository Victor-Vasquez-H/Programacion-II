package ejercicio._1;

class EmpleadoTiempoCompleto extends Empleado {
    private double salario_anual;
    
    public EmpleadoTiempoCompleto(String nombre, double salario_anual) {
        super(nombre);
        this.salario_anual = salario_anual;
    }
    
    @Override
    public double CalcularSalarioMensual() {
        return salario_anual / 12;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Salario Anual: $" + salario_anual + 
               ", Tipo: Tiempo Completo";
    }
    
    public double getSalarioAnual() {
        return salario_anual;
    }
    
    public void setSalarioAnual(double salario_anual) {
        this.salario_anual = salario_anual;
    }
}

