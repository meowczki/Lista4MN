package klasy;

import zajecia.Function;
import zajecia.Wyniki;

import java.util.ArrayList;
import java.util.List;

public class Bisection {
    private Function function;
    public Bisection(Function function){
        this.function=function;
    }
    public Wyniki bisection(double a, double b, double blad, int maxIt) {
        if (function.function(a) * function.function(b) >= 0) {
            System.out.println("nieprawidłowy przedział");
            return null;
        }
        double c =c = (a + b) / 2;
        double trueValue = 0.56714329;
        List<Double> epsilonA = new ArrayList<>();
        List<Double> wyniki = new ArrayList<>();
        List<Double> epsilonT = new ArrayList<>();
        wyniki.add(c);
        epsilonA.add(1.);
        epsilonT.add((c - trueValue) / trueValue);
        int i = 0;
        while (blad <epsilonA.get(i) || i-1 == maxIt) {
            c = (a + b) / 2;
            if (function.function(c) == 0.0)
                break;
            else if (function.function(c) * function.function(a) < 0)
                b = c;
            else {
                a = c;
            }
            wyniki.add(c);
            epsilonA.add((wyniki.get(i + 1) - wyniki.get(i)) / wyniki.get(i + 1));
            epsilonT.add((wyniki.get(i+1) - trueValue) / trueValue);
            i++;
        }
        return new Wyniki(epsilonA,epsilonT,c);
    }

}