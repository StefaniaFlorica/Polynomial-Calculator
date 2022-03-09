import controllers.CalculatorController;
import views.CalculatorView;

public class Main {

    public static void main(String[] args) {
/*
        try {
        String poliA="x^2-2*x+1";
        String poliB="7.5*x -1";
        System.out.println(poliA);
        System.out.println(poliB);


            Polinom a = Split.splitPoly(poliA);
            Polinom b = Split.splitPoly(poliB);

            System.out.println("ADUNARE: "+ Operatii.aduna(a,b));
            System.out.println("SCADERE: "+Operatii.scade(a,b));
            System.out.println("INMULTIRE: "+Operatii.inmulteste(a,b));
            System.out.println("IMPARTIRE: "+Operatii.imparte(a,b));
            System.out.println("DERIVARE: "+Operatii.deriva(b));
            System.out.println("INTEGRARE: "+Operatii.integreaza(a));

        }
        catch(ExceptieFormat e)
        {
            System.out.println(e.getMessage());
        }
*/

        CalculatorView calculatorView= new CalculatorView();
        CalculatorController calculatorController= new CalculatorController(calculatorView);

    }
}
