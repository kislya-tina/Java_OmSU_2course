package quadTrimDepend;

import quadraticTrinominal.QuadraticTrinominal;

public class QuadTrimDepend {
    private QuadraticTrinominal quadraticTrinominal;

    public QuadTrimDepend(double a, double b, double c){
        this.quadraticTrinominal = new QuadraticTrinominal(a, b, c);
    }

    public double higherDecision(){
        if(quadraticTrinominal.decision().length > 2 || quadraticTrinominal.decision().length < 1) {
            throw new IllegalArgumentException("Quadratic trinominal without decisions");
        }
        return quadraticTrinominal.decision()[0];
    }
}