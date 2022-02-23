import java.util.ArrayList;
import java.util.List;

public class Polinom {
    private List<Monom> polinom;

    public Polinom()
    {
        polinom= new ArrayList<Monom>();
    }

    public void add( double coeficient,int grad)
    {

        polinom.add(new Monom(coeficient,grad));
    }

    @Override
    public String toString() {
        String aux="";
        String auxMonom="";
        int k=0;
        for(Monom monom:polinom) {
            if(k!=0)
            {
                aux+=(monom.getCoeficient()>0?"+":"")+monom;
            }
            else{
                aux+=monom;
                k=1;
            }
        }

        return aux;
    }
}
