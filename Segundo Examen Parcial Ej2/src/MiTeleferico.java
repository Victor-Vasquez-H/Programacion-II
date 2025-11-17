import java.util.*;


public class MiTeleferico {
	private ArrayList<Linea> lineas = new ArrayList<>();
	private float cantidadIngresos;

	public MiTeleferico() {
		this.cantidadIngresos = 0f;
	}

	public void agregarLinea(Linea l) {
		lineas.add(l);
	}


	public void agregarPersonasFila(Persona p, String linea) {
		for (Linea l : lineas) {
			if (l.getColor().equals(linea)) {
				l.agregarPersona(p);
				return;
			}
		}
	}

	
	public void agregarCabina(String linea) {
		for (Linea l : lineas) {
			if (l.getColor().equals(linea)) {
				int nro = l.getCantidadCabinas() + 1;
				l.agregarCabina(nro);
				return;
			}
		}
	}

	public ArrayList<Linea> getLineas() { return lineas; }
	public float getIngresos() { return ingresos; }
	public void agregarIngresos(float monto) { ingresos += monto; }
}