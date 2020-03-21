
import java.util.ArrayList;
import java.util.List;

public class Problema {
    public Allapot kezdo() {
        return new Allapot();
    }

    static List<Operator> OPERATOROK = new ArrayList<Operator>();
    static {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int[] poz = {i, j};
                Operator operator = new Operator("F", poz);
                OPERATOROK.add(operator);
                Operator operator1 = new Operator("V", poz);
                OPERATOROK.add(operator1);

            }
        }
    }


    public List<Operator> operatorok() {
        return OPERATOROK;
    }


}