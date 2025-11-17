import java.util.*;


class Cabina {
	
	private int nroCabina;
	private ArrayList<Persona> PersonasAbordo = new ArrayList<>();

	Cabina(int nroCabina) {
		this.nroCabina = nroCabina;
	}

	public int getNroCabina() { return nroCabina; }

	public void agregarPersona(Persona p) {
		PersonasAbordo.add(p);
	}

	public boolean esPreferencial(Persona p) {
		int edad = p.getEdad();
		return edad < 25 || edad > 60;
	}

	public double calcularTarifa(Persona p, boolean preferencial) {
		if (preferencial && esPreferencial(p)) return 1.5;
		return 3.0;
	}

	public ArrayList<Persona> getPersonasAbordo() {
		return PersonasAbordo;
	}

	public void vaciar() {
		PersonasAbordo.clear();
	}
}