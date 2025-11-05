import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante; 
    private Libro libro; 

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(7);
        this.estudiante = estudiante;
        this.libro = libro;
    }

    public void mostrarInfo() {
        System.out.println("Préstamo: " + estudiante.getNombre() + " → " + libro.getTitulo());
        System.out.println("Fecha préstamo: " + fechaPrestamo + ", Devolución: " + fechaDevolucion);
    }
}
