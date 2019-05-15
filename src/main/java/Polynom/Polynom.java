package Polynom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynom{

    private List<Monom> monoms;

    public Polynom() {
        this.monoms = new ArrayList<Monom>();
    }

    public List<Monom> getPolynom() {
        return this.monoms;
    }

    public void addMonom(Monom m) {
        this.monoms.add(m);
    }

    public static Polynom addPolynoms(Polynom p1, Polynom p2) {
        Polynom result = new Polynom();
        Collections.sort(p1.getPolynom());
        Collections.sort(p2.getPolynom());

        for (Monom m1 : p1.getPolynom()) {
            result.addMonom(new Monom(m1.getCoefficient(), m1.getExponent()));
        }

        boolean flag;
        for (Monom m2 : p2.getPolynom()) {
            flag = false;
            for (Monom r : result.getPolynom()) {
                if (m2.getExponent() == r.getExponent()) {
                    r.addMonoms(m2);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                result.addMonom(new Monom(m2.getCoefficient(), m2.getExponent()));
            }
        }

        Collections.sort(result.getPolynom());
        return result;
    }

    public static Polynom substracPolynoms(Polynom p1, Polynom p2) {
        Collections.sort(p1.getPolynom());
        Collections.sort(p2.getPolynom());

        for (Monom m2 : p2.getPolynom()){
            m2.setCoefficient(m2.getCoefficient() * (-1));
        }

        Polynom result = Polynom.addPolynoms(p1, p2);

        for (Monom m2 : p2.getPolynom()){
            m2.setCoefficient(m2.getCoefficient() * (-1));
        }

        Collections.sort(result.getPolynom());
        return result;
    }

    public static Polynom multiplyPolynoms(Polynom p1, Polynom p2){
        Polynom result = new Polynom();
        Collections.sort(p1.getPolynom());
        Collections.sort(p2.getPolynom());

        boolean flag;
        for (Monom m1 : p1.getPolynom()){
            for (Monom m2 : p2.getPolynom()){
                Monom aux = Monom.multiplyMonoms(m1, m2);
                flag = false;
                for (Monom r : result.getPolynom()){
                    if (aux.getExponent() == r.getExponent()){
                        r.addMonoms(aux);
                        flag = true;
                        break;
                    }
                }

                if (flag == false){
                    result.addMonom(new Monom(aux.getCoefficient(), aux.getExponent()));
                }
                aux = null;
            }
        }

        Collections.sort(result.getPolynom());
        return result;
    }

    public static Polynom[] dividePolynoms(Polynom p1, Polynom p2){
        Polynom quotient = new Polynom();
        Polynom reminder = new Polynom();
        Collections.sort(p1.getPolynom());
        Collections.sort(p2.getPolynom());
        // p1 / p2 -> grd(p1) <= grd(p2)

        while (p1.getPolynom().get(0).getExponent() <= p2.getPolynom().get(0).getExponent()){
            quotient.addMonom(Monom.divideMonoms(p2.getPolynom().get(0), p1.getPolynom().get(0)));


            Monom tmp_m = new Monom(quotient.getPolynom().get(quotient.getPolynom().size() - 1).getCoefficient(),
                                        quotient.getPolynom().get(quotient.getPolynom().size() - 1).getExponent());

            Polynom tmp_p = new Polynom();
            tmp_p.addMonom(tmp_m);

            Polynom aux = Polynom.multiplyPolynoms(p1, tmp_p);

            p2 = Polynom.substracPolynoms(p2, aux);
            p2.getPolynom().remove(0);

            if (p2.getPolynom().size() == 0){
                break;
            }
        }

        for (Monom m2 : p2.getPolynom()){
            reminder.addMonom(m2);
        }

        Polynom[] polynoms = new Polynom[2];
        polynoms[0] = quotient;
        polynoms[1] = reminder;

        return polynoms;
    }

    public Polynom derivatePolynom(){
        for(Monom m : this.getPolynom()){
            m.derivateMonom();
        }

        Collections.sort(this.getPolynom());

        return this;
    }

    public Polynom integratePolynom(){
        for(Monom m : this.getPolynom()){
            m.integrateMonom();
        }

        Collections.sort(this.getPolynom());
        return this;
    }

    public String toString(){
        String toReturn = "";

        boolean flag = false;
        for (Monom m : this.getPolynom()){
            if (m.getCoefficient() != 0)
                flag = true;

            //System.out.print(m);
        }

        return toReturn;
    }

}

