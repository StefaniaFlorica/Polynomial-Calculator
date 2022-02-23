public class Monom {
    private int grad;
    private double coeficient;

    public Monom(int grad, double coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
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
        return (coeficient>0?"+":"")+coeficient+(grad>0?"*x^"+grad:"");
    }
}
