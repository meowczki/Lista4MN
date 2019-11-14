package zajecia;

public class Main {
    public static void main(String[] args) {
        double trueValue = 0.56714329;
        Solver solver=new Solver((x)->Math.exp(-1*x)-x,trueValue);
        Wyniki w1=solver.bisection(-3,2,0.001,50);
        Wyniki w2=solver.fixedPoint(2,0.001,50);
        Wyniki w3=solver.metodaStycznych(1,0.001,50,(x)->-1*Math.exp(-1*x)-1);
        Wyniki w4=solver.metodaSiecznych(-2,2,0.001,50);
        Wyniki w5=solver.regularFalsi(-3,2,0.001,50);
       for(Double d:w5.getEpsilonT()){
           System.out.println(d);
       }

    }
}
