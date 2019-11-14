package klasy;
import zajecia.Function;
import zajecia.Wyniki;

import java.util.ArrayList;
import java.util.List;

public class RegularFalsi  {
    private Function function;
    public RegularFalsi(Function function) {
        this.function = function;
    }
    public Wyniki solver(double a, double b, double relError, int maxIter, double trueValue){
        if (function.function(a) * function.function(b) >= 0) {
            System.out.println("nieprawidłowy przedział");
            return null;
        }
        double c =b-(function.function(b)*(a-b))/(function.function(a)-function.function(b));
        List<Double> epsilonA = new ArrayList<>();
        List<Double> wyniki = new ArrayList<>();
        List<Double> epsilonT = new ArrayList<>();
        wyniki.add(c);
        epsilonA.add(1.);
        epsilonT.add((c - trueValue) / trueValue);
        int i=0;
        while(relError<epsilonA.get(i)||i-1==maxIter){
            c=b-(function.function(b)*(a-b))/(function.function(a)-function.function(b));
            if (function.function(c) == 0.0)
                break;
            else if (function.function(c) * function.function(a) < 0)
                b = c;
            else
                a = c;
        }

        return new Wyniki(epsilonA,epsilonT,c);

    }


}
