import java.util.ArrayList;

public class PruebaInterfaz {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca biblio = new Biblioteca("UMSA Central", "Lunes a Viernes", "08:00", "18:00");
        
        // Cargar datos guardados previos
        biblio.cargarDatos();
        
        System.out.println("=== PRUEBA DEL SISTEMA ===\n");
        
        // Agregar autores si no existen suficientes
        if (biblio.getAutores().size() < 3) {
            System.out.println("→ Agregando autores de ejemplo...");
            biblio.agregarAutor(new Autor("Gabriel García Márquez", "Colombia"));
            biblio.agregarAutor(new Autor("Isabel Allende", "Chile"));
            biblio.agregarAutor(new Autor("Jorge Luis Borges", "Argentina"));
        }
        
        // Agregar libros si no existen suficientes
        if (biblio.getLibros().size() < 3) {
            System.out.println("→ Agregando libros de ejemplo...");
            
            ArrayList<String> paginas1 = new ArrayList<>();
            paginas1.add("Era un día caluroso en Macondo...");
            paginas1.add("El coronel no tenía quien le escribiera...");
            biblio.agregarLibro(new Libro("Cien Años de Soledad", "ISBN001", paginas1));
            
            ArrayList<String> paginas2 = new ArrayList<>();
            paginas2.add("La casa de los espíritus se alzaba sobre la colina...");
            paginas2.add("Clara había nacido con el don de la clarividencia...");
            biblio.agregarLibro(new Libro("La Casa de los Espíritus", "ISBN002", paginas2));
            
            ArrayList<String> paginas3 = new ArrayList<>();
            paginas3.add("Nadie sino una voz se oyó...");
            biblio.agregarLibro(new Libro("Ficciones", "ISBN003", paginas3));
        }
        
        // Agregar estudiantes si no existen suficientes
        if (biblio.getEstudiantes().size() < 3) {
            System.out.println("→ Agregando estudiantes de ejemplo...");
            biblio.agregarEstudiante(new Estudiante("2023001", "María Pérez"));
            biblio.agregarEstudiante(new Estudiante("2023002", "Carlos López"));
            biblio.agregarEstudiante(new Estudiante("2023003", "Ana García"));
        }
        
        // Realizar algunos préstamos solo si hay suficientes datos
        if (biblio.getPrestamos().isEmpty() && 
            biblio.getEstudiantes().size() >= 2 && 
            biblio.getLibros().size() >= 2) {
            System.out.println("→ Realizando préstamos de ejemplo...");
            biblio.prestarLibro(biblio.getEstudiantes().get(0), biblio.getLibros().get(0));
            biblio.prestarLibro(biblio.getEstudiantes().get(1), biblio.getLibros().get(1));
        }
        
        // Mostrar estado
        biblio.mostrarEstado();
        
        // Guardar todos los datos en JSON
        System.out.println("\n→ Guardando datos en archivos JSON...");
        biblio.guardarDatos();
        
        System.out.println("\n✓ Prueba completada. Los datos están guardados en la carpeta 'datos/'");
        System.out.println("✓ Ahora ejecuta la interfaz gráfica: java -cp bin InterfazBiblioteca");
    }
}
