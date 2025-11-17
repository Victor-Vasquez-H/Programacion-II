import java.util.*;


public class Persona {
	private String nombre;
	private int edad;
	private double peso;

	public Persona(String nombre, int edad, double peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public String getNombre() { return nombre; }
	public int getEdad() { return edad; }
	public double getPeso() { return peso; }
}