package klasy;

import zajecia.Function;
import zajecia.Wyniki;

import java.util.ArrayList;
import java.util.List;

public class MetodaSiecznych {
    Function function;
    public MetodaSiecznych(Function function) {
        this.function = function;
    }
    public Wyniki solver(double x0, double x1, double relError, int maxIter, double trueValue){
        List<Double> epsilonA = new ArrayList<>();
        List<Double> wyniki = new ArrayList<>();
        List<Double> epsilonT = new ArrayList<>();
        wyniki.add(x0);
        wyniki.add(x1);
        epsilonA.add(1.);
        epsilonA.add((x1-x0)/x1);
        epsilonT.add((x0 - trueValue) / trueValue);
        epsilonT.add((x1 - trueValue) / trueValue);
        int i=1;
        while(relError<epsilonA.get(i)||i-1==maxIter){
            wyniki.add(wyniki.get(i)-(function.function(wyniki.get(i))*(wyniki.get(i-1)-wyniki.get(i)))/(function.function(i-1)-function.function(i)));
            epsilonA.add((wyniki.get(i + 1) - wyniki.get(i)) / wyniki.get(i + 1));
            epsilonT.add((wyniki.get(i+1) - trueValue) / trueValue);
            i++;
        }

        return new Wyniki(epsilonA,epsilonT,x0);

    }
}
