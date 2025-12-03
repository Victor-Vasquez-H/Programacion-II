import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String isbn;
    private ArrayList<Pagina> paginas; 

    public Libro(String titulo, String isbn, ArrayList<String> contenidosPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();

        int num = 1;
        for (String contenido : contenidosPaginas) {
            this.paginas.add(new Pagina(num++, contenido));
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public ArrayList<String> getPaginasContenido() {
        ArrayList<String> contenidos = new ArrayList<>();
        for (Pagina p : paginas) {
            contenidos.add(p.getContenido());
        }
        return contenidos;
    }

    public void leer() {
        System.out.println("\nLeyendo libro: " + titulo);
        for (Pagina p : paginas) {
            p.mostrarPagina();
        }
    }
}
