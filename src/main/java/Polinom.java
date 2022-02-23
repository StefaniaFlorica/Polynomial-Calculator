import java.util.ArrayList;
import java.util.List;

public class Polinom {
    private List<Monom> polinom;

    public Polinom()
    {
        polinom= new ArrayList<Monom>();
    }

    public void add(Monom m)
    {
        polinom.add(m);
    }

    @Override
    public String toString() {
        String aux="";
        for(Monom monom:polinom)
            aux+=monom;

        return aux;
    }
}
