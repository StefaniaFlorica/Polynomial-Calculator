package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldPoli1;
    private JTextField textFieldPoli2;
    private JTextField textFieldRez;
    private JButton btnAdunare;
    private JButton btnScadere;
    private JButton btnInmultire;
    private JButton btnDerivare;
    private JButton btnIntegrare;
    private JButton btnImpartire;
    private JLabel lblPoli2;
    private JButton btnClr;

    public CalculatorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 570);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(252, 241, 221));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(252, 241, 221));
        panel.setBounds(0, 10, 476, 550);
        contentPane.add(panel);
        panel.setLayout(null);

        textFieldPoli1 = new JTextField();
        textFieldPoli1.setBackground(new Color(255, 255, 255));
        textFieldPoli1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldPoli1.setBounds(148, 50, 300, 40);
        panel.add(textFieldPoli1);
        textFieldPoli1.setColumns(10);

        textFieldPoli2 = new JTextField();
        textFieldPoli2.setBackground(new Color(255, 255, 255));
        textFieldPoli2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldPoli2.setColumns(10);
        textFieldPoli2.setBounds(148, 110, 300, 40);
        panel.add(textFieldPoli2);

        JLabel lblPoli1 = new JLabel("Polinom 1");
        lblPoli1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPoli1.setForeground(new Color(145, 158, 186));
        lblPoli1.setToolTipText("");
        lblPoli1.setBounds(21, 48, 100, 40);
        panel.add(lblPoli1);

        lblPoli2 = new JLabel("Polinom2");
        lblPoli2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPoli2.setForeground(new Color(145, 158, 186));
        lblPoli2.setBounds(21, 108, 100, 40);
        panel.add(lblPoli2);

        btnAdunare = new JButton("+");
        btnAdunare.setBackground(new Color(151, 229, 215));
        btnAdunare.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdunare.setBounds(10, 288, 187, 50);
        panel.add(btnAdunare);

        btnScadere = new JButton("-");
        btnScadere.setBackground(new Color(210, 235, 216));
        btnScadere.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnScadere.setBounds(261, 288, 187, 50);
        panel.add(btnScadere);

        btnInmultire = new JButton("*");
        btnInmultire.setBackground(new Color(255, 212, 184));
        btnInmultire.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnInmultire.setBounds(10, 380, 187, 50);
        panel.add(btnInmultire);

        btnDerivare = new JButton("'");
        btnDerivare.setBackground(new Color(189, 184, 219));
        btnDerivare.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDerivare.setBounds(10, 469, 187, 50);
        panel.add(btnDerivare);

        btnIntegrare = new JButton("∫");
        btnIntegrare.setBackground(new Color(198, 209, 226));
        btnIntegrare.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnIntegrare.setBounds(261, 469, 187, 50);
        panel.add(btnIntegrare);

        btnImpartire = new JButton("/");
        btnImpartire.setBackground(new Color(255, 204, 153));
        btnImpartire.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnImpartire.setBounds(261, 380, 187, 50);
        panel.add(btnImpartire);

        textFieldRez = new JTextField();
        textFieldRez.setFont(new Font("Tahoma", Font.BOLD, 14));
        textFieldRez.setBackground(Color.WHITE);
        textFieldRez.setColumns(10);
        textFieldRez.setEditable(false);
        textFieldRez.setBounds(148, 170, 300, 40);
        panel.add(textFieldRez);

        JLabel lblRezultat = new JLabel("Rezultat");
        lblRezultat.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblRezultat.setForeground(new Color(145, 158, 186));
        lblRezultat.setBounds(21, 170, 100, 40);
        panel.add(lblRezultat);

        JLabel lblCalculator = new JLabel("Calculator");
        lblCalculator.setForeground(new Color(145, 158, 186));
        lblCalculator.setToolTipText("");
        lblCalculator.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCalculator.setBounds(190, 10, 100, 40);
        panel.add(lblCalculator);


        btnClr = new JButton("C");
        btnClr.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClr.setBackground(new Color(254, 183, 179));
        btnClr.setBounds(207, 288, 44, 231);
        panel.add(btnClr);

        JLabel lblInfo = new JLabel("*Pentru derivare si integrare, introduceti polinomul in prima caseta.");
        lblInfo.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblInfo.setForeground(new Color(145, 158, 186));
        lblInfo.setBounds(21, 233, 427, 37);
        panel.add(lblInfo);
        this.setVisible(true);

    }

    public String getTextFieldPoli1() {
        return textFieldPoli1.getText();
    }

    public String getTextFieldPoli2() {
        return textFieldPoli2.getText();
    }

    public void setTextFieldRez(String rezultat) {
        this.textFieldRez.setText(rezultat);
    }

    public void addClrListener(ActionListener actionListener)
    {
        btnClr.addActionListener(actionListener);
    }

    public void addAdunareListener(ActionListener actionListener)
    {
        btnAdunare.addActionListener(actionListener);
    }
    public void addScadereListener(ActionListener actionListener)
    {
        btnScadere.addActionListener(actionListener);
    }
    public void addInmultireListener(ActionListener actionListener)
    {
        btnInmultire.addActionListener(actionListener);
    }
    public void addImpartireListener(ActionListener actionListener)
    {
        btnImpartire.addActionListener(actionListener);
    }
    public void addDerivareListener(ActionListener actionListener)
    {
        btnDerivare.addActionListener(actionListener);
    }
    public void addIntegrareListener(ActionListener actionListener)
    {
        btnIntegrare.addActionListener(actionListener);
    }
    public void hidePoli2()
    {

        textFieldPoli2.setEditable(false);
        textFieldPoli2.setText("");

    }
    public void showPoli2()
    {
        textFieldPoli2.setEditable(true);
    }
    public void clear()
    {
        textFieldPoli1.setVisible(true);
        textFieldPoli2.setVisible(true);
        textFieldRez.setVisible(true);
        lblPoli2.setVisible(true);
        textFieldPoli1.setText("");
        textFieldPoli2.setText("");
        textFieldPoli2.setEditable(true);
        textFieldRez.setText("");
    }

}
