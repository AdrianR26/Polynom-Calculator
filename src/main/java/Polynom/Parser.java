package Polynom;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Pattern patern;
    private Matcher matcher;

    private static String variable = "";
    private String firstCharacter   = "+-";
    private String afterPlusOrMinus = "";
    private String afterVariable    = "+-^*";
    private String afterDigit       = "+-*";

    private static final String POLYNOM_PATTERN = "([+-]?[^-+]+)";

    public Parser(){
        patern = Pattern.compile(POLYNOM_PATTERN);
    }

    public boolean validateMonom(String monom){
        //monom = monom.replaceAll("\\s+", "");
        Character previousChar = monom.charAt(0);
        if (firstCharacter.indexOf(previousChar) == -1 && Character.isDigit(previousChar) == false && Character.isLetter(previousChar) == false){
            return false;
        }

        if (Character.isLetter(previousChar) && variable.length() == 0)
            variable += previousChar;

        for (int i = 1; i < monom.length(); i++){
            Character currentChr = monom.charAt(i);

            if (variable.length() == 0 && Character.isLetter(currentChr)){
                variable += currentChr;
                continue;
            }
            else if (previousChar == '+' || previousChar == '-'){
                if(afterPlusOrMinus.indexOf(currentChr) == -1 && Character.isDigit(currentChr) == false && variable.indexOf(currentChr) == -1)
                    return false;
            }
            else if (previousChar == variable.charAt(0) && Character.isDigit(currentChr) == false  && variable.indexOf(currentChr) == -1){
                if (afterVariable.indexOf(currentChr) == -1)
                    return false;
            }
            else if (Character.isDigit(previousChar)){
                if (afterDigit.indexOf(currentChr) == -1 && Character.isDigit(currentChr) == false &&  variable.indexOf(currentChr) == -1)
                    return false;
            }
            previousChar = currentChr;
        }

        return true;
    }

    public Polynom validatePolynom(final String Polynom){
        matcher = patern.matcher(Polynom);

        Polynom result = new Polynom();

        while(matcher.find()){
            String monom = matcher.group();
            if (validateMonom(monom) == false){
                return null;
            }
            else{
                boolean flag = false;
                for(Monom m : result.getPolynom()){
                    if (m.getExponent() == convertStringToMonom(monom).getExponent()){
                        m.setCoefficient(m.getCoefficient() + convertStringToMonom(monom).getCoefficient());
                        flag = true;
                    }
                }

                if (flag == false){
                    result.addMonom(convertStringToMonom(monom));
                }
            }
        }

        Collections.sort(result.getPolynom());
        return result;
    }

    public Monom convertStringToMonom(String s){
        double coefficient = 1.0f;
        int exponent = 0;

        int i = 0;
        float number;
        while (i < s.length()){
            Character c = s.charAt(i);

            if (variable.indexOf(c) >= 0){
                exponent++;
                i++;
            }
            else if (c == '+' || c == '*'){
                i++;
            }
            else if (c == '-'){
                coefficient *= -1;
                i++;
            }
            else if (Character.isDigit(c)){
                number = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i)) ){
                    number = number * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }

                coefficient *= number;
            }
            else if (c == '^'){
                i++;
                int tmp = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    tmp = tmp * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }

                exponent = tmp;
            }
        }

        Monom monom = new Monom(coefficient, exponent);
        return monom;
    }

    public static String getVariable(){
        return variable;
    }

}
