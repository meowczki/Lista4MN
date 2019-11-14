package klasy;

import zajecia.Function;
import zajecia.Wyniki;

import java.util.ArrayList;
import java.util.List;

public class MetodaStycznych {
    Function function;
    Function dFunction;
    public MetodaStycznych(Function function,Function dFunction) {
        this.function = function;
    }
    public Wyniki solver(double x0, double m, double relError, int maxIter, double trueValue){
        List<Double> epsilonA = new ArrayList<>();
        List<Double> wyniki = new ArrayList<>();
        List<Double> epsilonT = new ArrayList<>();
        wyniki.add(x0);
        epsilonA.add(1.);
        epsilonT.add((x0 - trueValue) / trueValue);
        int i=0;
        while(relError<epsilonA.get(i)||i-1==maxIter){

            wyniki.add(wyniki.get(i)-(function.function(wyniki.get(i))-dFunction.function(wyniki.get(i))));
            epsilonA.add((wyniki.get(i + 1) - wyniki.get(i)) / wyniki.get(i + 1));
            epsilonT.add((wyniki.get(i+1) - trueValue) / trueValue);
            i++;
        }

        return new Wyniki(epsilonA,epsilonT,x0);

    }
}
