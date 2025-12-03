import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazBiblioteca extends JFrame {
    private Biblioteca biblioteca;
    private JTextArea txtArea;

    public InterfazBiblioteca() {
        setTitle("Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        biblioteca = new Biblioteca("UMSA Central", "Lunes a Viernes", "08:00", "18:00");
        biblioteca.cargarDatos();

        crearInterfaz();
        mostrarDatos();

        setVisible(true);
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel panelBotones = new JPanel(new GridLayout(3, 3, 5, 5));
        
        JButton btn1 = new JButton("Agregar Autor");
        btn1.addActionListener(e -> agregarAutor());
        panelBotones.add(btn1);
        
        JButton btn2 = new JButton("Agregar Libro");
        btn2.addActionListener(e -> agregarLibro());
        panelBotones.add(btn2);
        
        JButton btn3 = new JButton("Agregar Estudiante");
        btn3.addActionListener(e -> agregarEstudiante());
        panelBotones.add(btn3);
        
        JButton btn4 = new JButton("Realizar Prestamo");
        btn4.addActionListener(e -> realizarPrestamo());
        panelBotones.add(btn4);
        
        JButton btn5 = new JButton("Ver Datos");
        btn5.addActionListener(e -> mostrarDatos());
        panelBotones.add(btn5);
        
        JButton btn6 = new JButton("Guardar");
        btn6.addActionListener(e -> guardarDatos());
        panelBotones.add(btn6);
        
        JButton btn7 = new JButton("Cargar");
        btn7.addActionListener(e -> cargarDatos());
        panelBotones.add(btn7);
        
        JButton btn8 = new JButton("Limpiar");
        btn8.addActionListener(e -> limpiarPantalla());
        panelBotones.add(btn8);
        
        JButton btn9 = new JButton("Salir");
        btn9.addActionListener(e -> salir());
        panelBotones.add(btn9);
        
        // Panel de texto
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        
        panelPrincipal.add(panelBotones, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        
        add(panelPrincipal);
    }

    private void agregarAutor() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del autor:");
        if (nombre == null || nombre.isEmpty()) return;
        
        String nacionalidad = JOptionPane.showInputDialog(this, "Nacionalidad:");
        if (nacionalidad == null || nacionalidad.isEmpty()) return;
        
        biblioteca.agregarAutor(new Autor(nombre, nacionalidad));
        mostrarDatos();
        JOptionPane.showMessageDialog(this, "Autor agregado");
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog(this, "Titulo del libro:");
        if (titulo == null || titulo.isEmpty()) return;
        
        String isbn = JOptionPane.showInputDialog(this, "ISBN:");
        if (isbn == null || isbn.isEmpty()) return;
        
        ArrayList<String> paginas = new ArrayList<>();
        paginas.add("Pagina de contenido");
        
        biblioteca.agregarLibro(new Libro(titulo, isbn, paginas));
        mostrarDatos();
        JOptionPane.showMessageDialog(this, "Libro agregado");
    }

    private void agregarEstudiante() {
        String codigo = JOptionPane.showInputDialog(this, "Codigo del estudiante:");
        if (codigo == null || codigo.isEmpty()) return;
        
        String nombre = JOptionPane.showInputDialog(this, "Nombre del estudiante:");
        if (nombre == null || nombre.isEmpty()) return;
        
        biblioteca.agregarEstudiante(new Estudiante(codigo, nombre));
        mostrarDatos();
        JOptionPane.showMessageDialog(this, "Estudiante agregado");
    }

    private void realizarPrestamo() {
        if (biblioteca.getEstudiantes().isEmpty() || biblioteca.getLibros().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe haber estudiantes y libros registrados");
            return;
        }
        
        String[] estudiantes = new String[biblioteca.getEstudiantes().size()];
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = biblioteca.getEstudiantes().get(i).getNombre();
        }
        
        String estSeleccionado = (String) JOptionPane.showInputDialog(this, 
            "Selecciona un estudiante:", 
            "Estudiantes", 
            JOptionPane.PLAIN_MESSAGE, 
            null, 
            estudiantes, 
            estudiantes[0]);
        
        if (estSeleccionado == null) return;
        
        String[] libros = new String[biblioteca.getLibros().size()];
        for (int i = 0; i < libros.length; i++) {
            libros[i] = biblioteca.getLibros().get(i).getTitulo();
        }
        
        String libroSeleccionado = (String) JOptionPane.showInputDialog(this, 
            "Selecciona un libro:", 
            "Libros", 
            JOptionPane.PLAIN_MESSAGE, 
            null, 
            libros, 
            libros[0]);
        
        if (libroSeleccionado == null) return;
        
        Estudiante est = null;
        for (Estudiante e : biblioteca.getEstudiantes()) {
            if (e.getNombre().equals(estSeleccionado)) {
                est = e;
                break;
            }
        }
        
        Libro libro = null;
        for (Libro l : biblioteca.getLibros()) {
            if (l.getTitulo().equals(libroSeleccionado)) {
                libro = l;
                break;
            }
        }
        
        if (est != null && libro != null) {
            biblioteca.prestarLibro(est, libro);
            mostrarDatos();
            JOptionPane.showMessageDialog(this, "Prestamo realizado");
        }
    }

    private void mostrarDatos() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("=== AUTORES ===\n");
        if (biblioteca.getAutores().isEmpty()) {
            sb.append("Sin autores\n");
        } else {
            for (Autor a : biblioteca.getAutores()) {
                sb.append(a.getNombre()).append(" (").append(a.getNacionalidad()).append(")\n");
            }
        }
        
        sb.append("\n=== LIBROS ===\n");
        if (biblioteca.getLibros().isEmpty()) {
            sb.append("Sin libros\n");
        } else {
            for (Libro l : biblioteca.getLibros()) {
                sb.append(l.getTitulo()).append(" [").append(l.getIsbn()).append("]\n");
            }
        }
        
        sb.append("\n=== ESTUDIANTES ===\n");
        if (biblioteca.getEstudiantes().isEmpty()) {
            sb.append("Sin estudiantes\n");
        } else {
            for (Estudiante e : biblioteca.getEstudiantes()) {
                sb.append(e.getNombre()).append(" [").append(e.getCodigo()).append("]\n");
            }
        }
        
        sb.append("\n=== PRESTAMOS ===\n");
        if (biblioteca.getPrestamos().isEmpty()) {
            sb.append("Sin prestamos\n");
        } else {
            for (Prestamo p : biblioteca.getPrestamos()) {
                sb.append(p.getEstudiante().getNombre()).append(" -> ")
                  .append(p.getLibro().getTitulo()).append("\n");
            }
        }
        
        txtArea.setText(sb.toString());
    }

    private void limpiarPantalla() {
        txtArea.setText("");
    }

    private void guardarDatos() {
        biblioteca.guardarDatos();
        JOptionPane.showMessageDialog(this, "Datos guardados");
    }

    private void cargarDatos() {
        biblioteca.cargarDatos();
        mostrarDatos();
        JOptionPane.showMessageDialog(this, "Datos cargados");
    }

    private void salir() {
        biblioteca.cerrarBiblioteca();
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazBiblioteca());
    }
}
