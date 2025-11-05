
package relaciones;

import java.util.ArrayList;

class Estudiante {
    private String nombre;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<Materia>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void inscribirse(Materia mat){
        materias.add(mat);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", materias=" + materias + '}';
    }
    
    
    
    
}
