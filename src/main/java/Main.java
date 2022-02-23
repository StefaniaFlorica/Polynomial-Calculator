public class Main {
    public static void main(String[] args) {

        Polinom polinom= new Polinom();
        polinom.add(new Monom(3,2));
        polinom.add(new Monom(1,-1));
        polinom.add(new Monom(0,3));
        System.out.println(polinom);
    }
}
