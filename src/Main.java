import java.util.*;
import java.util.Random;

public class Main {

    static int[][] kezdo = {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

    public static void main(String[] args) {
        Problema p = new Problema();
        List<Operator> m = new BackTrack().solve(p,kezdo);
        if ( m != null ) {
            Allapot a = p.kezdo();
            for (Operator o : m) {
                a = o.use(a);
                System.out.println("Operátor: " +o);
                System.out.println(a);
            }
            System.out.println("-----------------------------");
            System.out.println("|            Cél            |");
            System.out.println("-----------------------------");
            System.out.println(a);
        }
    }
}
