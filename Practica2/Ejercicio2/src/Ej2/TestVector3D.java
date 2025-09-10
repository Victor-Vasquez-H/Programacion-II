package EJ2;
public class TestVector3D {
    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, -1, 2);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("a+b = " + a.sumar(b));
        System.out.println("2a = " + a.multiplicar(2));
        System.out.println("|a| = " + a.longitud());
        System.out.println("â = " + a.normalizado());
        System.out.println("a·b = " + a.productoEscalar(b));
        System.out.println("a×b = " + a.productoVectorial(b));
        System.out.println("Proy_b(a) = " + a.proyeccion(b));
        System.out.println("Comp_b(a) = " + a.componente(b));
    }
}