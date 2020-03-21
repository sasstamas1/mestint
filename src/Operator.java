import java.util.Arrays;
import java.util.Objects;

public class Operator {
    String irany;
    int[] poz = new int[2];

    public Operator(String irany, int[] poz) {
        this.irany = irany;
        this.poz = poz;
    }

    public Allapot use(Allapot state) {
        Allapot uj = new Allapot();
        int[][] a = state.getA();
        int[][] b = uj.getA();

        for (int i  = 0; i < 8; i++)
            System.arraycopy(a[i], 0, b[i], 0, 8);

        if(irany.equals("V")){
            b[poz[0]][poz[1]] = 1;
            b[poz[0]][poz[1]+1] = 1;
            b[poz[0]][poz[1]+2] = 1;
        }
        if(irany.equals("F")){
            b[poz[0]][poz[1]] = 1;
            b[poz[0]+1][poz[1]] = 1;
            b[poz[0]+2][poz[1]] = 1;
        }

        uj.setA(b);

        return uj;
    }

    public boolean alkalmazhato(Allapot allapot) {
        int[][] A = allapot.getA();
        switch (this.irany) {
            case "V":
                if((this.poz[1]+2<=7 && this.poz[1]+1<=6) && (A[this.poz[0]][this.poz[1]]==0) &&
                        (A[this.poz[0]][this.poz[1]+1]==0) && (A[this.poz[0]][this.poz[1]+2]==0)){
                    return true;
                }
                else
                    return false;
            case "F":
                if((this.poz[0]+2<=7 && this.poz[0]+1<=6) && (A[this.poz[0]][this.poz[1]]==0 &&
                        A[this.poz[0]+1][this.poz[1]]==0 && A[this.poz[0]+2][this.poz[1]]==0))
                    return true;
                else
                    return false;
            default:
                    return false;
        }
    }


    public String getIrany() {
        return irany;
    }

    public void setIrany(String irany) {
        this.irany = irany;
    }

    public int[] getPoz() {
        return poz;
    }

    public void setPoz(int[] poz) {
        this.poz = poz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator that = (Operator) o;
        return Objects.equals(irany, that.irany) &&
                Arrays.equals(poz, that.poz);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(irany);
        result = 31 * result + Arrays.hashCode(poz);
        return result;
    }

    @Override
    public String toString() {
        return "Operatorok{" +
                "irany='" + irany + '\'' +
                ", poz=" + Arrays.toString(poz) +
                '}';
    }
}
