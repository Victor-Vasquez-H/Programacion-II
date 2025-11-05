/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;
import java.util.ArrayList;
import java.util.List;


public class Empresa {
    private String nombre;
    private List<Empleado> empleados;
    
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void contratarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }   
    public void listar_empleados() {
        System.out.println("Empleados de la empresa " + nombre + ":");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}
