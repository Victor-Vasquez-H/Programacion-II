 import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;    
    private ArrayList<Autor> autores;   
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Estudiante> estudiantes;
    private Horario horario;
    private GestorJSON gestor;

    public Biblioteca(String nombre, String dias, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.horario = new Horario(dias, horaApertura, horaCierre);
        this.gestor = new GestorJSON();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
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

        System.out.println("\nEstudiantes registrados:");
        for (Estudiante e : estudiantes) e.mostrarInfo();

        System.out.println("\nPréstamos activos:");
        for (Prestamo p : prestamos) p.mostrarInfo();
    }

    public void guardarDatos() {
        gestor.guardarAutores(autores);
        gestor.guardarLibros(libros);
        gestor.guardarEstudiantes(estudiantes);
        gestor.guardarPrestamos(prestamos);
        System.out.println("✓ Datos guardados correctamente en archivos JSON");
    }

    public void cargarDatos() {
        autores = gestor.cargarAutores();
        libros = gestor.cargarLibros();
        estudiantes = gestor.cargarEstudiantes();
        prestamos = gestor.cargarPrestamos(estudiantes, libros);
        System.out.println("✓ Datos cargados correctamente desde archivos JSON");
    }

    public void cerrarBiblioteca() {
        guardarDatos();
        System.out.println("\nLa biblioteca '" + nombre + "' está cerrando...");
        System.out.println("Todos los datos han sido guardados.");
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public String getNombre() {
        return nombre;
    }
}
