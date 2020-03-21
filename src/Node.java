import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    Allapot allapot;
    Node szulo;
    Operator eloallito;
    List<Operator> nemProbalt = new ArrayList<Operator>();

    public Node(Allapot allapot, Node szulo, Operator eloallito, Problema p) {
        this.allapot = allapot;
        this.szulo = szulo;
        this.eloallito = eloallito;
        for (Operator o : p.operatorok())
            if (o.alkalmazhato(allapot))
                this.nemProbalt.add(o);
    }

    public Allapot getAllapot() {
        return allapot;
    }

    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }

    public Node getSzulo() {
        return szulo;
    }

    public void setSzulo(Node szulo) {
        this.szulo = szulo;
    }

    public Operator getEloallito() {
        return eloallito;
    }

    public void setEloallito(Operator eloallito) {
        this.eloallito = eloallito;
    }

    public List<Operator> getNemProbalt() {
        return nemProbalt;
    }

    public void setNemProbalt(List<Operator> nemProbalt) {
        this.nemProbalt = nemProbalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(allapot, node.allapot) &&
                Objects.equals(szulo, node.szulo) &&
                Objects.equals(eloallito, node.eloallito) &&
                Objects.equals(nemProbalt, node.nemProbalt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allapot, szulo, eloallito, nemProbalt);
    }

    @Override
    public String toString() {
        return "Node{" +
                "allapot=" + allapot +
                ", szulo=" + szulo +
                ", eloallito=" + eloallito +
                ", nemProbalt=" + nemProbalt +
                '}';
    }
}