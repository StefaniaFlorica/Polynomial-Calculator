package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void add( Monom monom)
    {
        polinom.add(monom);
    }
    public void stergeIndex(int index)
    {
        polinom.remove(index);
    }

    public void setPosition(int index,double coeficient, int grad)
    {
        polinom.get(index).setCoeficient(coeficient);
        polinom.get(index).setGrad(grad);
    }

    public List<Monom> getPolinom() {
        return polinom;
    }

    public void afisare()
    {
        for(Monom monom: polinom)
        {
            System.out.println(monom.getCoeficient()+"*x^"+ monom.getGrad());
        }
    }

    @Override
    public String toString() {
        String aux="";
        String auxMonom="";
        int k=0;
        if(polinom.size()==0)
            return "0";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom polinom1 = (Polinom) o;
        if(polinom.size()!=polinom1.getPolinom().size()) return false;
        for(Monom monom:polinom)
            if(!polinom1.getPolinom().contains(monom))
                return false;
        return true;
    }



    public static void copiazaPolinom(Polinom sursa, Polinom destinatie)
    {
        for(Monom monom:sursa.getPolinom())
        {
            destinatie.getPolinom().add(monom);
        }
    }
}
