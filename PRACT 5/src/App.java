import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        
        Biblioteca biblio = new Biblioteca("Central UMSA", "Lunes a Viernes", "08:00", "18:00");
        
        Autor a1 = new Autor("Gabriel García Márquez", "Colombia");
        Autor a2 = new Autor("Isabel Allende", "Chile");
        biblio.agregarAutor(a1);
        biblio.agregarAutor(a2);

        ArrayList<String> paginas1 = new ArrayList<>();
        paginas1.add("Era un día caluroso en Macondo...");
        paginas1.add("El coronel no tenía quien le escribiera...");
        Libro libro1 = new Libro("Cien Años de Soledad", "ISBN001", paginas1);

        ArrayList<String> paginas2 = new ArrayList<>();
        paginas2.add("La casa de los espíritus se alzaba sobre la colina...");
        paginas2.add("Clara había nacido con el don de la clarividencia...");
        Libro libro2 = new Libro("La Casa de los Espíritus", "ISBN002", paginas2);

        biblio.agregarLibro(libro1);
        biblio.agregarLibro(libro2);

        Estudiante est1 = new Estudiante("2023001", "María Pérez");

        biblio.prestarLibro(est1, libro1);

        biblio.mostrarEstado();

        libro1.leer();

        biblio.cerrarBiblioteca();
    }
}

