package EJ1;
public class TestAlgebraVectorial {
    public static void main(String[] args) {
        AlgebraVectorial a = new AlgebraVectorial(1, 0, 0);
        AlgebraVectorial b = new AlgebraVectorial(0, 2, 0);
        AlgebraVectorial c = new AlgebraVectorial(3, 0, 0);

        System.out.println("Perp (a·b=0): " + a.esPerp_c(b));
        System.out.println("|a+b|=|a-b|? " + a.esPerp_a(b));
        System.out.println("|a+b|^2=|a|^2+|b|^2? " + a.esPerp_d(b));
        System.out.println("|a-b|=|b-a|? " + a.esPerp_b(b));

        System.out.println("a paralelo c (escalar): " + a.esParalelo_e(c));
        System.out.println("a paralelo c (cruz): " + a.esParalelo_f(c));

        System.out.println("Proy_a(b) = " + b.proyeccion(a));
        System.out.println("Comp_a(b) = " + b.componente(a));
    }
}
