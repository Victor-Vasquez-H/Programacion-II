package ejercicio._1;

import java.util.Scanner;

public class TestEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        
        System.out.println("INGRESO DE EMPLEADOS");

        System.out.println("\n--- EMPLEADOS TIEMPO COMPLETO ---");
        System.out.println("Empleado 1:");
        System.out.print("Nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Salario anual: ");
        double salario1 = scanner.nextDouble();
        scanner.nextLine();
        empleados[0] = new EmpleadoTiempoCompleto(nombre1, salario1);
        
        System.out.println("\nEmpleado 2:");
        System.out.print("Nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Salario anual: ");
        double salario2 = scanner.nextDouble();
        scanner.nextLine();
        empleados[1] = new EmpleadoTiempoCompleto(nombre2, salario2);
        
        System.out.println("\nEmpleado 3:");
        System.out.print("Nombre: ");
        String nombre3 = scanner.nextLine();
        System.out.print("Salario anual: ");
        double salario3 = scanner.nextDouble();
        scanner.nextLine();
        empleados[2] = new EmpleadoTiempoCompleto(nombre3, salario3);

        System.out.println("\n--- EMPLEADOS TIEMPO HORARIO ---");
        System.out.println("Empleado 4:");
        System.out.print("Nombre: ");
        String nombre4 = scanner.nextLine();
        System.out.print("Horas trabajadas: ");
        double horas4 = scanner.nextDouble();
        System.out.print("Tarifa por hora: ");
        double tarifa4 = scanner.nextDouble();
        scanner.nextLine();
        empleados[3] = new EmpleadoTiempoHorario(nombre4, horas4, tarifa4);
        
        System.out.println("\nEmpleado 5:");
        System.out.print("Nombre: ");
        String nombre5 = scanner.nextLine();
        System.out.print("Horas trabajadas: ");
        double horas5 = scanner.nextDouble();
        System.out.print("Tarifa por hora: ");
        double tarifa5 = scanner.nextDouble();
        scanner.nextLine();
        empleados[4] = new EmpleadoTiempoHorario(nombre5, horas5, tarifa5);

        System.out.println("\nINFORMACION DE EMPLEADOS");
        System.out.println("Nombre - Salario Mensual");
        
        System.out.println(empleados[0].getNombre() + " - $" + empleados[0].CalcularSalarioMensual());
        System.out.println(empleados[1].getNombre() + " - $" + empleados[1].CalcularSalarioMensual());
        System.out.println(empleados[2].getNombre() + " - $" + empleados[2].CalcularSalarioMensual());
        System.out.println(empleados[3].getNombre() + " - $" + empleados[3].CalcularSalarioMensual());
        System.out.println(empleados[4].getNombre() + " - $" + empleados[4].CalcularSalarioMensual());
        
        scanner.close();
    }
}
