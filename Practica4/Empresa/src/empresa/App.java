/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresa;
public class App {
    public static void main(String[] args) throws Exception {

        Empresa empresa = new Empresa("Tech Solutions");
        empresa.contratarEmpleado(new Empleado("alan", "gerente", "cochabamba", "bella vista", 4));
        empresa.contratarEmpleado(new Empleado("juan", "desarrollador", "La Paz", "calle 3", 10));
        empresa.listar_empleados();
    }
}