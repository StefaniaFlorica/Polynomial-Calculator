package models;

import controllers.Operatii;
import controllers.Split;
import junit.framework.TestCase;

public class OperatiiTest extends TestCase {

    public void testAduna() throws ExceptieFormat {
        Polinom a= Split.splitPoly("-x^2+3x-5");
        Polinom b= Split.splitPoly("-x^3+7x^2+6.5x");
        Polinom rezultat= Operatii.aduna(a,b);
        Polinom corect= Split.splitPoly("-x^3+6x^2+9.5x-5");
        assertEquals(corect, rezultat);
    }

    public void testScade() throws ExceptieFormat {
        Polinom a= Split.splitPoly("-x^2+3x-5");
        Polinom b= Split.splitPoly("-x^3+7x^2+6.5x");
        Polinom rezultat= Operatii.scade(a,b);
        Polinom corect= Split.splitPoly("x^3-8x^2-3.5x-5");
        assertEquals(corect, rezultat);
    }

    public void testInmulteste() throws ExceptieFormat {
        Polinom a= Split.splitPoly("-x^2+3x-5");
        Polinom b= Split.splitPoly("-x^3+7x^2+6.5x");
        Polinom rezultat= Operatii.inmulteste(a,b);
        Polinom corect= Split.splitPoly("x^5-10x^4+19.5x^3-15.5x^2-32.5x");
        assertEquals(corect, rezultat);
    }

    public void testImparte() throws ExceptieFormat {
        Polinom a= Split.splitPoly("-x^2+3x-5");
        Polinom b= Split.splitPoly("-x^3+7x^2+6.5x");
        Tupla<Polinom,Polinom> rezultat= Operatii.imparte(b,a);
        Tupla<Polinom,Polinom> corect= new Tupla<>(Split.splitPoly("x-4"),Split.splitPoly("23.5x-20"));
        assertEquals(corect, rezultat);
    }

    public void testDeriva() throws ExceptieFormat {
        Polinom a= Split.splitPoly("x^5-10x^4+19.5x^3-15.5x^2-32.5x");
        Polinom rezultat= Operatii.deriva(a);
        Polinom corect= Split.splitPoly("5*x^4-40*x^3+58.5*x^2-31*x-32.5");
        assertEquals(corect, rezultat);
    }

    public void testIntegreaza() throws ExceptieFormat {
        Polinom a= Split.splitPoly("x^5-10x^4+19.5x^3-15.5x^2-32.5x");
        Polinom rezultat= Operatii.integreaza(a);
        Polinom corect= Split.splitPoly("0.2*x^6-2.5*x^5+6.5*x^4-7.75*x^3-32.5*x^2");
        assertEquals(corect, rezultat);
    }
}