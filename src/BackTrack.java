import java.util.LinkedList;
import java.util.List;

public class BackTrack {
    public List<Operator> megoldas(Node terminalis) {
        LinkedList<Operator> megoldas = new LinkedList<Operator>();
        for (Node cs = terminalis; cs.szulo != null; cs = cs.szulo)
            megoldas.addFirst(cs.eloallito);
        return megoldas;
    }



    public List<Operator> solve(Problema p,int[][] kezdo) {
        List<Operator> megoldas = null;
        Allapot startState = new Allapot(kezdo);
        Node aktualis = new Node(startState, null, null,p);

        if ( aktualis.allapot.cel() ) {
            return megoldas(aktualis);
        }

        while (true) {
            if (!aktualis.nemProbalt.isEmpty() ) {
                Operator o = aktualis.nemProbalt.remove(0);
                Allapot uj = o.use(aktualis.allapot);
                boolean voltMar = false;
                for (Node cs =  aktualis; cs != null; cs = cs.szulo)
                    if ( cs.allapot == uj) {
                        voltMar = true;
                        break;
                    }
                if ( !voltMar ) {
                    aktualis = new Node(uj, aktualis, o, p);
                    if ( aktualis.allapot.cel() ) {
                        megoldas = megoldas(aktualis);
                        return megoldas;
                    }
                }
            } else {
                if ( aktualis.szulo != null )
                    aktualis = aktualis.szulo;
            }
        }

    }
}
