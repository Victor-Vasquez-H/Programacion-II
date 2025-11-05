
package relaciones;

import java.util.ArrayList;

public class Materia {
    
    private String nombre; 
    private String sigla;
    private ArrayList<Estudiante> estudiantes;

    public Materia(String nombre, String sigla){
        this.nombre = nombre;
        this.sigla = sigla;
        this.estudiantes = new ArrayList <Estudiante>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getSigla() {
        return sigla;
    }
    
    public void agrega(Estudiante est){
        estudiantes.add(est);
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", sigla=" + sigla + ", estudiantes=" + estudiantes + '}';
    }
    
    
    
}
