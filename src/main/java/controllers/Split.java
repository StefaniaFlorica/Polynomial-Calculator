package controllers;

import models.ExceptieFormat;
import models.Polinom;

import javax.swing.*;
import java.util.*;

public final class Split {
    private Split() {}
    public static String modifyPoly(String poly) throws ExceptieFormat {
        if(poly.compareTo("")==0)
            throw new ExceptieFormat("Introduceti polinoame!");
        char[] polyChar = poly.toCharArray();
        String aux="";
        int k=0;
        if(poly.compareTo("")==0 || poly.compareTo("0")==0) {
            aux+="0x^0";
            return aux;
        }
        if(poly.length()<2) {
            if(poly.compareTo("x")==0) aux+="1x";
            if(Character.isDigit(poly.charAt(0))) {
                aux+=poly.charAt(0);
                aux+="x^0";
            }
        }
        else {
            for (int i = 0; i < polyChar.length - 1; i++) {
                if (i == 0 && polyChar[i] == 'x') aux += '1';
                if (polyChar[i] != '*' && polyChar[i]!=' ') aux += polyChar[i];
                if (polyChar[i + 1] == 'x' && (polyChar[i] == '+' || polyChar[i] == '-')) aux += '1';
                //if(i>0 && Character.isDigit(polyChar[i]) && (polyChar[i+1]=='+' || polyChar[i+1]=='-') && !aux.contains("^")) aux+="x^0";
                if (polyChar[i] == 'x' && polyChar[i + 1] != '^') aux += "^1";
            }
        aux+=polyChar[polyChar.length-1];
        }
        if(aux.charAt(aux.length()-1)=='x') aux+="^1";
        if(Character.isDigit(aux.charAt(aux.length()-1)) && aux.charAt(aux.length()-2)!='^') aux+="x^0";
        System.out.println("Dupa modificare:\n"+aux);
        return aux;
    }
    public static Polinom splitPoly(String poly1) throws NumberFormatException, ExceptieFormat{
       //String poly="";
       poly1=poly1.replaceAll("\\s+","");
       poly1=poly1.replace("*","");
       String poly = modifyPoly(poly1);
       List<String> numbers= Arrays.asList(poly.replace("^", "").split("((?=\\+)|(?=\\-)|x)"));
       Polinom polinom= new Polinom();

       System.out.println(numbers);
       boolean sortate=true;
       int lastCoeff=-1;
       for (int i=0;i<numbers.size();i+=2) {
           int currentCoeff=Integer.parseInt(numbers.get(i+1));
           if(lastCoeff!=-1)
           {
               if(lastCoeff<currentCoeff)
               sortate=false;
           }
           polinom.add(Double.parseDouble(numbers.get(i)),currentCoeff);
           lastCoeff=currentCoeff;
       }

       if(sortate==false)
           Collections.sort(polinom.getPolinom());

       //if(!poly.equals(modifyPoly(polinom.toString())))
        //   throw new ExceptieFormat("Polinom invalid!");
        System.out.println("polinom final: "+polinom);
       return polinom;

    }
}
