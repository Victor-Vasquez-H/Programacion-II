public class Horario {
    private String dias;
    private String horaApertura;
    private String horaCierre;

    public Horario(String dias, String horaApertura, String horaCierre) {
        this.dias = dias;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public void mostrarHorario() {
        System.out.println("Horario: " + dias + " de " + horaApertura + " a " + horaCierre);
    }
}
