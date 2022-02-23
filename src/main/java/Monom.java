public class Monom {
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
        if(coeficient==-1 || coeficient==1)
        {
            coef="-";
            k=1;

        }
        else
        {
            coef=String.valueOf(coeficient).replaceAll("()\\.0+$|(\\..+?)0+$", "$2");

        }
        return coef+(grad>0?(((coef.compareTo("-")==0)?"":"*")+((grad==1)?"x":"x^"+grad)):"");
    }
}
