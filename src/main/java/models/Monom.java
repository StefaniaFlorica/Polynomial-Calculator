package models;

import java.util.Objects;

public class Monom implements  Comparable<Monom>{
    private double coeficient;
    private int grad;

    public Monom(double coeficient, int grad) {
        this.coeficient = coeficient;
        this.grad = grad;

    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public String toString() {
        String coef="";
        int k=0;
        if(coeficient==0) return "";
        if(coeficient==-1 && grad!=0) return "-x"+((grad==1)?"":("^"+grad));
        if(coeficient==1 && grad!=0) return "x"+((grad==1)?"":("^"+grad));
        else {
            coef=String.valueOf(coeficient);
            coef=coef.replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");

        }
        return (grad==0)?coef:(coef+(grad>0?(((coef.compareTo("-")==0)?"":"*")+((grad==1)?"x":"x^"+grad)):""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom monom = (Monom) o;
        return Double.compare(monom.coeficient, coeficient) == 0 && grad == monom.grad;
    }


    @Override
    public int compareTo(Monom o) {
        return o.getGrad()-grad;
    }

}
