/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;
public class Empleado {
    private String nombre;
    private String puesto;
    private Direccion direccion;

    public Empleado(String nombre, String puesto, String cDir, String dDir, int nDir) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.direccion = new Direccion(cDir, dDir, nDir);
    }
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + ", puesto='" + puesto + ", direccion=" + direccion +
                '}';
    }
    
   
    
    
}

