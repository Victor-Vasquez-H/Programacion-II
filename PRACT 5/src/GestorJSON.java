import java.io.*;
import java.util.ArrayList;

public class GestorJSON {
    private static final String ARCHIVO_AUTORES = "datos/autores.json";
    private static final String ARCHIVO_LIBROS = "datos/libros.json";
    private static final String ARCHIVO_ESTUDIANTES = "datos/estudiantes.json";
    private static final String ARCHIVO_PRESTAMOS = "datos/prestamos.json";

    public GestorJSON() {
        crearDirectorio();
    }

    private void crearDirectorio() {
        try {
            new File("datos").mkdirs();
        } catch (Exception e) {
            System.err.println("Error al crear directorio: " + e.getMessage());
        }
    }

    public void guardarAutores(ArrayList<Autor> autores) {
        try {
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < autores.size(); i++) {
                Autor a = autores.get(i);
                json.append("  {\n");
                json.append("    \"nombre\": \"").append(escaparJSON(a.getNombre())).append("\",\n");
                json.append("    \"nacionalidad\": \"").append(escaparJSON(a.getNacionalidad())).append("\"\n");
                json.append("  }");
                if (i < autores.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("]");
            escribirArchivo(ARCHIVO_AUTORES, json.toString());
        } catch (Exception e) {
            System.err.println("Error guardando autores: " + e.getMessage());
        }
    }

    public ArrayList<Autor> cargarAutores() {
        ArrayList<Autor> autores = new ArrayList<>();
        try {
            String contenido = leerArchivo(ARCHIVO_AUTORES);
            ArrayList<String> objetos = extraerObjetos(contenido);
            for (String obj : objetos) {
                String nombre = extraerValor(obj, "nombre");
                String nacionalidad = extraerValor(obj, "nacionalidad");
                if (!nombre.isEmpty() && !nacionalidad.isEmpty()) {
                    autores.add(new Autor(nombre, nacionalidad));
                }
            }
        } catch (Exception e) {
            System.out.println("No se encontraron autores guardados.");
        }
        return autores;
    }

    public void guardarLibros(ArrayList<Libro> libros) {
        try {
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < libros.size(); i++) {
                Libro l = libros.get(i);
                json.append("  {\n");
                json.append("    \"titulo\": \"").append(escaparJSON(l.getTitulo())).append("\",\n");
                json.append("    \"isbn\": \"").append(escaparJSON(l.getIsbn())).append("\",\n");
                json.append("    \"paginas\": [\n");
                ArrayList<String> paginas = l.getPaginasContenido();
                for (int j = 0; j < paginas.size(); j++) {
                    json.append("      \"").append(escaparJSON(paginas.get(j))).append("\"");
                    if (j < paginas.size() - 1) json.append(",");
                    json.append("\n");
                }
                json.append("    ]\n");
                json.append("  }");
                if (i < libros.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("]");
            escribirArchivo(ARCHIVO_LIBROS, json.toString());
        } catch (Exception e) {
            System.err.println("Error guardando libros: " + e.getMessage());
        }
    }

    public ArrayList<Libro> cargarLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            String contenido = leerArchivo(ARCHIVO_LIBROS);
            ArrayList<String> objetos = extraerObjetos(contenido);
            for (String obj : objetos) {
                String titulo = extraerValor(obj, "titulo");
                String isbn = extraerValor(obj, "isbn");
                ArrayList<String> paginas = extraerArray(obj, "paginas");
                if (!titulo.isEmpty() && !isbn.isEmpty() && !paginas.isEmpty()) {
                    libros.add(new Libro(titulo, isbn, paginas));
                }
            }
        } catch (Exception e) {
            System.out.println("No se encontraron libros guardados.");
        }
        return libros;
    }

    public void guardarEstudiantes(ArrayList<Estudiante> estudiantes) {
        try {
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante e = estudiantes.get(i);
                json.append("  {\n");
                json.append("    \"codigo\": \"").append(escaparJSON(e.getCodigo())).append("\",\n");
                json.append("    \"nombre\": \"").append(escaparJSON(e.getNombre())).append("\"\n");
                json.append("  }");
                if (i < estudiantes.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("]");
            escribirArchivo(ARCHIVO_ESTUDIANTES, json.toString());
        } catch (Exception e) {
            System.err.println("Error guardando estudiantes: " + e.getMessage());
        }
    }

    public ArrayList<Estudiante> cargarEstudiantes() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            String contenido = leerArchivo(ARCHIVO_ESTUDIANTES);
            ArrayList<String> objetos = extraerObjetos(contenido);
            for (String obj : objetos) {
                String codigo = extraerValor(obj, "codigo");
                String nombre = extraerValor(obj, "nombre");
                if (!codigo.isEmpty() && !nombre.isEmpty()) {
                    estudiantes.add(new Estudiante(codigo, nombre));
                }
            }
        } catch (Exception e) {
            System.out.println("No se encontraron estudiantes guardados.");
        }
        return estudiantes;
    }

    public void guardarPrestamos(ArrayList<Prestamo> prestamos) {
        try {
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < prestamos.size(); i++) {
                Prestamo p = prestamos.get(i);
                json.append("  {\n");
                json.append("    \"estudiante_codigo\": \"").append(escaparJSON(p.getEstudiante().getCodigo())).append("\",\n");
                json.append("    \"estudiante_nombre\": \"").append(escaparJSON(p.getEstudiante().getNombre())).append("\",\n");
                json.append("    \"libro_titulo\": \"").append(escaparJSON(p.getLibro().getTitulo())).append("\",\n");
                json.append("    \"libro_isbn\": \"").append(escaparJSON(p.getLibro().getIsbn())).append("\",\n");
                json.append("    \"fecha\": \"").append(p.getFecha().toString()).append("\"\n");
                json.append("  }");
                if (i < prestamos.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("]");
            escribirArchivo(ARCHIVO_PRESTAMOS, json.toString());
        } catch (Exception e) {
            System.err.println("Error guardando préstamos: " + e.getMessage());
        }
    }

    public ArrayList<Prestamo> cargarPrestamos(ArrayList<Estudiante> estudiantes, ArrayList<Libro> libros) {
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        try {
            String contenido = leerArchivo(ARCHIVO_PRESTAMOS);
            ArrayList<String> objetos = extraerObjetos(contenido);
            for (String obj : objetos) {
                String codigoEst = extraerValor(obj, "estudiante_codigo");
                String tituloLibro = extraerValor(obj, "libro_titulo");
                
                Estudiante est = buscarEstudiante(estudiantes, codigoEst);
                Libro libro = buscarLibro(libros, tituloLibro);
                
                if (est != null && libro != null) {
                    Prestamo p = new Prestamo(est, libro);
                    prestamos.add(p);
                }
            }
        } catch (Exception e) {
            System.out.println("No se encontraron préstamos guardados.");
        }
        return prestamos;
    }

    private void escribirArchivo(String ruta, String contenido) throws IOException {
        FileWriter fw = new FileWriter(ruta);
        fw.write(contenido);
        fw.close();
    }

    private String leerArchivo(String ruta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        StringBuilder sb = new StringBuilder();
        String linea;
        while ((linea = br.readLine()) != null) {
            sb.append(linea);
        }
        br.close();
        return sb.toString();
    }

    private String escaparJSON(String texto) {
        return texto.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }

    private ArrayList<String> extraerObjetos(String json) {
        ArrayList<String> objetos = new ArrayList<>();
        int inicio = -1;
        int contador = 0;
        
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') {
                if (contador == 0) inicio = i;
                contador++;
            } else if (c == '}') {
                contador--;
                if (contador == 0 && inicio != -1) {
                    objetos.add(json.substring(inicio, i + 1));
                    inicio = -1;
                }
            }
        }
        return objetos;
    }

    private String extraerValor(String objeto, String clave) {
        String patron = "\"" + clave + "\"\\s*:\\s*\"([^\"]*)\"";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(patron);
        java.util.regex.Matcher m = p.matcher(objeto);
        if (m.find()) {
            return desescaparJSON(m.group(1));
        }
        return "";
    }

    private ArrayList<String> extraerArray(String objeto, String clave) {
        ArrayList<String> valores = new ArrayList<>();
        String patron = "\"" + clave + "\"\\s*:\\s*\\[([^\\]]*)\\]";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(patron);
        java.util.regex.Matcher m = p.matcher(objeto);
        if (m.find()) {
            String contenido = m.group(1);
            String[] elementos = contenido.split(",");
            for (String elem : elementos) {
                elem = elem.trim().replace("\"", "").trim();
                if (!elem.isEmpty()) {
                    valores.add(desescaparJSON(elem));
                }
            }
        }
        return valores;
    }

    private String desescaparJSON(String texto) {
        return texto.replace("\\\"", "\"")
                   .replace("\\n", "\n")
                   .replace("\\r", "\r")
                   .replace("\\t", "\t")
                   .replace("\\\\", "\\");
    }

    private Estudiante buscarEstudiante(ArrayList<Estudiante> estudiantes, String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    private Libro buscarLibro(ArrayList<Libro> libros, String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equals(titulo)) {
                return l;
            }
        }
        return null;
    }
}

