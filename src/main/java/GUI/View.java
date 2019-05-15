package GUI;

import Polynom.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{

    //----------------------TextFields----------------------//
    private JTextField textFieldP = new JTextField(); // 1st polynom
    private JTextField textFieldQ = new JTextField(); // 2nd polynom
    private JTextField textFieldR = new JTextField(); // result
    //------------------------------------------------------//


    //--------------Butttons--------------//
    private JButton addButton       = new JButton("Add");
    private JButton substractButton = new JButton("Substract");
    private JButton multiplyButton  = new JButton("Multiply");
    private JButton divideButton    = new JButton("Divide");

    private JButton derivatePButton = new JButton("Derivate P");
    private JButton derivateQButton = new JButton("Derivate Q");

    private JButton integratePButton = new JButton("Integrate P");
    private JButton integrateQButton = new JButton("Integrate Q");
    //-----------------------------------//

    public View (){
       JPanel panel = new JPanel();

       JLabel polynomP = new JLabel("P:");
       panel.add(polynomP);
       this.textFieldP.setPreferredSize(new Dimension(470, 20));
       panel.add(this.textFieldP);

       JLabel polynomQ = new JLabel("Q:");
       panel.add(polynomQ);
       this.textFieldQ.setPreferredSize(new Dimension(470, 20));
       panel.add(this.textFieldQ);

       addButton.setPreferredSize(new Dimension(240,30));
       substractButton.setPreferredSize(new Dimension(240,30));
       multiplyButton.setPreferredSize(new Dimension(240,30));
       divideButton.setPreferredSize(new Dimension(240,30));
       derivatePButton.setPreferredSize(new Dimension(240,30));
       derivateQButton.setPreferredSize(new Dimension(240,30));
       integratePButton.setPreferredSize(new Dimension(240,30));
       integrateQButton.setPreferredSize(new Dimension(240,30));

       JPanel buttons = new JPanel();
       buttons.add(addButton);
       buttons.add(substractButton);
       buttons.add(multiplyButton);
       buttons.add(divideButton);

       buttons.add(derivatePButton);
       buttons.add(derivateQButton);

       buttons.add(integratePButton);
       buttons.add(integrateQButton);

       buttons.setLayout(new GridLayout(4,2));
       panel.add(buttons);

       this.textFieldR.setPreferredSize(new Dimension(470, 20));
       JLabel polynomR = new JLabel("R:");
       panel.add(polynomR);
       panel.add(this.textFieldR);

       this.add(panel);

       this.setTitle("Polynom Calculator");
       this.setResizable(false);
       this.setSize(500, 250);
       this.setVisible(true);
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public String getUserInput1(){
        return this.textFieldP.getText();
    }

    public String getUserInput2(){
        return this.textFieldQ.getText();
    }



    public void printResult(Polynom polynom){
        this.textFieldR.setText("");

        boolean flag = false;
        for (Monom m : polynom.getPolynom()){
            if (m.getCoefficient() != 0)
                flag = true;

            this.textFieldR.setText(textFieldR.getText() + String.valueOf(m));
        }

        if (flag == false){
            this.textFieldR.setText("0");
        }
    }

    public void printBadInput(String s){
        this.textFieldR.setText(s);
    }

    public void printDivideResult(Polynom[] p) {
        this.textFieldR.setText("");

        boolean flag = false;
        for (Monom m : p[0].getPolynom()){
            if (m.getCoefficient() != 0)
                flag = true;

            this.textFieldR.setText(textFieldR.getText() + String.valueOf(m));
        }

        if (flag == false){
            this.textFieldR.setText("0");
        }

        this.textFieldR.setText(textFieldR.getText() + " | ");

        flag = false;
        for (Monom m : p[1].getPolynom()){
            if (m.getCoefficient() != 0)
                flag = true;

            this.textFieldR.setText(textFieldR.getText() + String.valueOf(m));
        }

        if (flag == false){
            this.textFieldR.setText(this.textFieldR.getText() + "0");
        }
    }



    public void addSumListener(ActionListener a){
        this.addButton.addActionListener(a);
    }

    public void addSubstractListener(ActionListener a){ this.substractButton.addActionListener(a); }

    public void addMultiplyListener(ActionListener a) { this.multiplyButton.addActionListener(a); }

    public void addDivideListener(ActionListener a) { this.divideButton.addActionListener(a); }



    public void addDerivatePListener(ActionListener a) { this.derivatePButton.addActionListener(a); }

    public void addDerivateQListener(ActionListener a) { this.derivateQButton.addActionListener(a); }



    public void addIntegratePListener(ActionListener a) { this.integratePButton.addActionListener(a); }

    public void addIntegrateQListener(ActionListener a) {this.integrateQButton.addActionListener(a); }

}
