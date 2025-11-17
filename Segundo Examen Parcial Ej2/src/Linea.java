import java.util.*;


public class Linea {
	private String color;
	private ArrayList<Persona> filaPersonas = new ArrayList<>();
	private ArrayList<Cabina> cabinas = new ArrayList<>();
	private int cantidadCabinas = 0;

	public Linea(String color) {
		this.color = color;
	}

	public String getColor() { return color; }

	public void agregarPersona(Persona p) {
		filaPersonas.add(p);
	}

	public void agregarCabina(int nroCab) {
		Cabina c = new Cabina(this, nroCab); 
		cabinas.add(c);
		cantidadCabinas = cabinas.size();
	}

	public ArrayList<Persona> getFilaPersonas() { return filaPersonas; }
	public ArrayList<Cabina> getCabinas() { return cabinas; }
	public int getCantidadCabinas() { return cantidadCabinas; }


	public boolean embarcarSiguienteEnCabina(int nroCab) {
		if (filaPersonas.isEmpty()) return false;
		for (Cabina c : cabinas) {
			if (c.getNroCabina() == nroCab) {
				c.subirPersona(filaPersonas.remove(0));
				return true;
			}
		}
		return false;
	}
}