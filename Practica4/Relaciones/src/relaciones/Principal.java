package relaciones;

public class Principal {
    public static void main(String[] args) {
        Estudiante alvaro = new Estudiante("Alvaro");
        Estudiante juan = new Estudiante("Juan");
        Estudiante fabio = new Estudiante("Fabio");
        
        Materia inf121 = new Materia("Programacion II", " INF121");
        Materia inf133 = new Materia("Programacion WEB III", " INF133");
        Materia inf123 = new Materia("Electronica GRAL", " INF123");
        
        alvaro.inscribirse(inf121);
        alvaro.inscribirse(inf123);
        
        juan.inscribirse(inf121);
        juan.inscribirse(inf123);
        juan.inscribirse(inf133);
        
        fabio.inscribirse(inf121);
        fabio.inscribirse(inf133);
        
        inf121.agrega(juan);
        inf121.agrega(alvaro);
        inf121.agrega(fabio);
        
        inf133.agrega(juan);
        inf133.agrega(fabio);
        
        inf123.agrega(juan);
        inf123.agrega(alvaro);
        
        System.out.println(alvaro);
    }
    
    
}
