package models;

import models.Monom;
import models.Polinom;
import models.Tupla;

import java.util.ListIterator;

public final class Operatii {

    public static Polinom aduna(Polinom a, Polinom b)
    {

        Polinom q= new Polinom();

        ListIterator<Monom> iteratorA= a.getPolinom().listIterator();
        ListIterator<Monom> iteratorB= b.getPolinom().listIterator();

        while(iteratorA.hasNext() && iteratorB.hasNext())
        {
            Monom currentA=iteratorA.next();
            Monom currentB=iteratorB.next();

            if(currentA.getGrad()> currentB.getGrad())
            {
                q.add(currentA);
                iteratorB.previous();
            }
            else if(currentB.getGrad()> currentA.getGrad())
            {
                q.add(currentB);
                iteratorA.previous();
            }
            else
            {
                if(currentA.getCoeficient()+ currentB.getCoeficient()!=0)
                    q.add(currentA.getCoeficient()+ currentB.getCoeficient(), currentA.getGrad());
            }

        }
        while(iteratorA.hasNext())
        {
            q.add(iteratorA.next());
        }

        while(iteratorB.hasNext())
        {
            q.add(iteratorB.next());
        }

        return q;
    }

    public static Polinom scade(Polinom a, Polinom b)
    {

        Polinom q= new Polinom();

        ListIterator<Monom> iteratorA= a.getPolinom().listIterator();
        ListIterator<Monom> iteratorB= b.getPolinom().listIterator();

        while(iteratorA.hasNext() && iteratorB.hasNext())
        {
            Monom currentA=iteratorA.next();
            Monom currentB=iteratorB.next();

            if(currentA.getGrad()> currentB.getGrad())
            {
                q.add(currentA);
                iteratorB.previous();
            }
            else if(currentB.getGrad()> currentA.getGrad())
            {

                q.add(-currentB.getCoeficient(), currentB.getGrad());
                iteratorA.previous();
            }
            else
            {
                if(currentA.getCoeficient()- currentB.getCoeficient()!=0)
                    q.add(currentA.getCoeficient()- currentB.getCoeficient(), currentA.getGrad());
            }

        }
        while(iteratorA.hasNext())
        {
            q.add(iteratorA.next());
        }

        while(iteratorB.hasNext())
        {
            Monom currentB=iteratorB.next();
            q.add(-currentB.getCoeficient(), currentB.getGrad());
        }

        return q;
    }
    public static Polinom inmulteste(Polinom a, Polinom b)
    {

        Polinom q= new Polinom();
        for(Monom x: a.getPolinom())
        {
            for(Monom y: b.getPolinom())
            {
                q.add(x.getCoeficient()*y.getCoeficient(),x.getGrad()+y.getGrad());
            }
        }

        ListIterator<Monom> iterator1=q.getPolinom().listIterator();
        int index2=0;
        int index1=0;
        while(iterator1.hasNext())
        {

            Monom current1=iterator1.next();
            index2=iterator1.nextIndex();
            index1=index2-1;
            ListIterator<Monom> iterator2=q.getPolinom().listIterator(index2);
            while(iterator2.hasNext())
            {
                Monom current2=iterator2.next();
                index2=iterator2.previousIndex();
                if(current1.getGrad()==current2.getGrad())
                {
                    q.setPosition(index1, current1.getCoeficient()+ current2.getCoeficient(), current1.getGrad());
                    q.stergeIndex(index2);
                    iterator1=q.getPolinom().listIterator(index1);
                    iterator2=q.getPolinom().listIterator(index2);
                }
            }
        }
        return q;
    }
    public static Monom imparteMonoame(Monom a, Monom b)
    {
        return new Monom(a.getCoeficient()/b.getCoeficient(),a.getGrad()-b.getGrad());
    }
    public static Tupla<Polinom,Polinom> imparte(Polinom a, Polinom b)
    {
        Polinom q=new Polinom();
        Polinom r=new Polinom();
        Polinom.copiazaPolinom(a,r);
        int i=0;

        while(r.getPolinom().size()!=0 && r.getPolinom().get(0).getGrad()>=b.getPolinom().get(0).getGrad())
        {
            q.add(imparteMonoame(r.getPolinom().get(0),b.getPolinom().get(0)));
            Polinom polinomAux=new Polinom();
            polinomAux.add(q.getPolinom().get(i));
            i++;
            Polinom polinomInmultire=inmulteste(polinomAux,b);
            r=scade(r,polinomInmultire);

        }
        return new Tupla<Polinom,Polinom>(q,r);
    }
    public static Polinom deriva(Polinom poly)
    {
        Polinom q= new Polinom();

        for(Monom monom:poly.getPolinom())
        {
            if(monom.getGrad()!=0)
                q.add(monom.getCoeficient()*monom.getGrad(), monom.getGrad()-1);
        }
        return q;
    }
    public static Polinom integreaza(Polinom poly)
    {
        Polinom q= new Polinom();
        for(Monom monom:poly.getPolinom())
        {
            if(monom.getGrad()==0)
                q.add(monom.getCoeficient(), 1);
            else
                q.add(monom.getCoeficient()/((double)monom.getGrad()+1), monom.getGrad()+1);
        }
        return q;
    }

}
