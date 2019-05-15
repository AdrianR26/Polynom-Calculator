package Polynom;

public class Monom implements Comparable<Monom>{

    private int exponent;
    private double coefficient;

    public Monom(double coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Monom(){
        this.coefficient = 0.0f;
        this.exponent = 0;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void addMonoms(Monom m){
        this.setCoefficient(this.getCoefficient() + m.getCoefficient());
    }

    public static Monom multiplyMonoms(Monom m1, Monom m2){
        Monom result = new Monom();

        result.setExponent(m1.getExponent() + m2.getExponent());
        result.setCoefficient(m1.getCoefficient() * m2.getCoefficient());

        return result;
    }

    public static Monom divideMonoms(Monom m1, Monom m2){
        Monom result = new Monom();

        result.setCoefficient(m1.getCoefficient() / m2.getCoefficient());
        result.setExponent(m1.getExponent() - m2.getExponent());

        return result;
    }

    public void derivateMonom(){
        this.setCoefficient(this.getCoefficient() * this.getExponent());
        this.setExponent(this.getExponent() - 1);
    }

    public void integrateMonom(){
        this.setExponent(this.getExponent() + 1);
        this.setCoefficient(this.getCoefficient() / this.getExponent());
    }

    public int compareTo(Monom o) {
        if (this.getExponent() < o.getExponent()){
            return 1;
        }
        else if (this.getExponent() > o.getExponent()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public String toString(){
        String toReturn = "";

        if (this.getExponent() != 0){
            if (this.getCoefficient() < 0){
                if (this.getCoefficient() == -1){
                    toReturn += "-" + Parser.getVariable() + "^" + this.getExponent();
                }
                else{
                    toReturn += this.getCoefficient() + Parser.getVariable() + "^" + this.getExponent();
                }
            }
            else if (this.getCoefficient() > 0){
                if (this.getCoefficient() == 1){
                    toReturn += "+" + Parser.getVariable() + "^" + this.getExponent();
                }
                else{
                    toReturn += "+" + this.getCoefficient() + Parser.getVariable() + "^" + this.getExponent();
                }
            }
        }
        else{
            if (this.getCoefficient() > 0){
                toReturn += "+" + this.getCoefficient();
            }
            else if (this.getCoefficient() < 0){
                toReturn += this.getCoefficient();
            }
        }

        return toReturn;
    }

}
