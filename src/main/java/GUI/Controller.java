package GUI;

import Polynom.Parser;
import Polynom.Polynom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private View view;

    public Controller(View view){
        this.view = view;

        view.addSumListener(new sumButtonListener());
        view.addSubstractListener(new substractButtonListener());
        view.addMultiplyListener(new multiplyButtonListener());
        view.addDivideListener(new divideButtonListener());

        view.addDerivatePListener(new derivatePButtonListener());
        view.addDerivateQListener(new derivateQButtonListener());

        view.addIntegratePListener(new integratePButtonListener());
        view.addIntegrateQListener(new integrateQButtonListener());
    }

    class sumButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";

            userInput1 = view.getUserInput1();
            userInput2 = view.getUserInput2();

            userInput1 = userInput1.replaceAll("\\s+", "");
            userInput2 = userInput2.replaceAll("\\s+", "");

            Parser parser = new Parser();

            Polynom p1 = parser.validatePolynom(userInput1);
            Polynom p2 = parser.validatePolynom(userInput2);

            if (p1 != null && p2 != null){
                view.printResult(Polynom.addPolynoms(p1, p2));
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

    class substractButtonListener  implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";

            userInput1 = view.getUserInput1();
            userInput2 = view.getUserInput2();

            userInput1 = userInput1.replaceAll("\\s+", "");
            userInput2 = userInput2.replaceAll("\\s+", "");

            Parser parser = new Parser();

            Polynom p1 = parser.validatePolynom(userInput1);
            Polynom p2 = parser.validatePolynom(userInput2);

            if (p1 != null && p2 != null){
                view.printResult(Polynom.substracPolynoms(p1, p2));
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

    class multiplyButtonListener   implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";

            userInput1 = view.getUserInput1();
            userInput2 = view.getUserInput2();

            userInput1 = userInput1.replaceAll("\\s+", "");
            userInput2 = userInput2.replaceAll("\\s+", "");

            Parser parser = new Parser();

            Polynom p1 = parser.validatePolynom(userInput1);
            Polynom p2 = parser.validatePolynom(userInput2);

            if (p1 != null && p2 != null){
                view.printResult(Polynom.multiplyPolynoms(p1, p2));
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

    class divideButtonListener     implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";

            userInput1 = view.getUserInput1();
            userInput2 = view.getUserInput2();

            userInput1 = userInput1.replaceAll("\\s+", "");
            userInput2 = userInput2.replaceAll("\\s+", "");

            Parser parser = new Parser();

            Polynom p1 = parser.validatePolynom(userInput1);
            Polynom p2 = parser.validatePolynom(userInput2);

            if (p1 != null && p2 != null){
                view.printDivideResult(Polynom.dividePolynoms(p1, p2));
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

    class derivatePButtonListener  implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            userInput = view.getUserInput1();
            userInput = userInput.replaceAll("\\s+", "");

            Parser parser = new Parser();
            Polynom p = parser.validatePolynom(userInput);

            if (p != null){
                view.printResult(p.derivatePolynom());
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

    class derivateQButtonListener  implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            userInput = view.getUserInput2();
            userInput = userInput.replaceAll("\\s+", "");

            Parser parser = new Parser();
            Polynom p = parser.validatePolynom(userInput);

            if (p != null){
                view.printResult(p.derivatePolynom());
            }
            else{
                view.printBadInput("Invalid input!");
            }

        }
    }

    class integratePButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            userInput = view.getUserInput1();
            userInput = userInput.replaceAll("\\s+", "");

            Parser parser = new Parser();
            Polynom p = parser.validatePolynom(userInput);

            if (p != null){
                view.printResult(p.integratePolynom());
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

    class integrateQButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            userInput = view.getUserInput2();
            userInput = userInput.replaceAll("\\s+", "");

            Parser parser = new Parser();
            Polynom p = parser.validatePolynom(userInput);

            if (p != null){
                view.printResult(p.integratePolynom());
            }
            else{
                view.printBadInput("Invalid input!");
            }
        }
    }

}
