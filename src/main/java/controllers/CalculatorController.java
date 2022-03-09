package controllers;
import models.ExceptieFormat;
import models.Polinom;
import views.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView view;
    private Polinom a;
    private Polinom b;


    public CalculatorController(CalculatorView view1) {
        this.view = view1;
        view.addAdunareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showPoli2();
                try {
                    a = Split.splitPoly(view.getTextFieldPoli1());
                    b = Split.splitPoly(view.getTextFieldPoli2());
                    view.setTextFieldRez(Operatii.aduna(a, b).toString());
                }
                catch (ExceptieFormat exceptieFormat)
                {
                    JOptionPane.showMessageDialog(null,exceptieFormat.getMessage());
                }
                catch(NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null,"Introduceti polinoame valide!");
                }
            }
        });
        view.addScadereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try{view.showPoli2();
                    a=Split.splitPoly(view.getTextFieldPoli1());
                    b=Split.splitPoly(view.getTextFieldPoli2());
                    view.setTextFieldRez(Operatii.scade(a,b).toString());
                }
                catch (ExceptieFormat exceptieFormat)
                {
                    JOptionPane.showMessageDialog(null,exceptieFormat.getMessage());
                }
                catch(NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null,"Introduceti polinoame valide!");
                }

            }

        });
        view.addInmultireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    view.showPoli2();
                    a = Split.splitPoly(view.getTextFieldPoli1());
                    b = Split.splitPoly(view.getTextFieldPoli2());
                    view.setTextFieldRez(Operatii.inmulteste(a, b).toString());
                }
                catch (ExceptieFormat exceptieFormat)
                {
                    JOptionPane.showMessageDialog(null,exceptieFormat.getMessage());
                }
                catch(NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null,"Introduceti polinoame valide!");
                }
            }
        });
        view.addImpartireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                view.showPoli2();
                a=Split.splitPoly(view.getTextFieldPoli1());
                b=Split.splitPoly(view.getTextFieldPoli2());
                view.setTextFieldRez(Operatii.imparte(a,b).toString());
              }
                catch (ExceptieFormat exceptieFormat)
                {
                    JOptionPane.showMessageDialog(null,exceptieFormat.getMessage());
                }
                catch(NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null,"Introduceti polinoame valide!");
                }
            }
        });
        view.addDerivareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    view.hidePoli2();
                    a = Split.splitPoly(view.getTextFieldPoli1());
                    view.setTextFieldRez(Operatii.deriva(a).toString());
                }
                catch (ExceptieFormat exceptieFormat)
                {
                    JOptionPane.showMessageDialog(null,exceptieFormat.getMessage());
                }
                catch(NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null,"Introduceti polinoame valide!");
                }
            }
        });
        view.addIntegrareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    view.hidePoli2();
                    a = Split.splitPoly(view.getTextFieldPoli1());
                    view.setTextFieldRez(Operatii.integreaza(a).toString());
                }
                catch (ExceptieFormat exceptieFormat)
                {
                    JOptionPane.showMessageDialog(null,exceptieFormat.getMessage());
                }
                catch(NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null,"Introduceti polinoame valide!");
                }
            }
        });
        view.addClrListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.clear();
            }
        });

    }
}
