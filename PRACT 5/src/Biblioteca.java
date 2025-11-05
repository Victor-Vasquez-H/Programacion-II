import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;    
    private ArrayList<Autor> autores;   
    private ArrayList<Prestamo> prestamos;
    private Horario horario;            

    public Biblioteca(String nombre, String dias, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario = new Horario(dias, horaApertura, horaCierre);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void prestarLibro(Estudiante estudiante, Libro libro) {
        Prestamo p = new Prestamo(estudiante, libro);
        prestamos.add(p);
        System.out.println("→ Libro '" + libro.getTitulo() + "' prestado a " + estudiante.getNombre());
    }

    public void mostrarEstado() {
        System.out.println("\n=== Estado de la Biblioteca " + nombre + " ===");
        horario.mostrarHorario();

        System.out.println("\nLibros disponibles:");
        for (Libro l : libros) System.out.println("- " + l.getTitulo());

        System.out.println("\nAutores registrados:");
        for (Autor a : autores) a.mostrarInfo();

        System.out.println("\nPréstamos activos:");
        for (Prestamo p : prestamos) p.mostrarInfo();
    }

    public void cerrarBiblioteca() {
        System.out.println("\nLa biblioteca '" + nombre + "' está cerrando...");
        prestamos.clear();
        System.out.println("Todos los préstamos han sido finalizados.");
    }
}
