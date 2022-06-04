package functionals.functional;

import functionals.functionsOfSingleArgument.IFuncOnSegment;

public class IntegralFunctional<T extends IFuncOnSegment> implements IFunctional<T>{
    private final double integralBeginOfSegment;
    private final double integralEndOfSegment;
    private final int n;

    public IntegralFunctional(double integralBeginOfSegment, double integralEndOfSegment, int n) {
        if(integralBeginOfSegment > integralEndOfSegment){
            this.integralBeginOfSegment = integralEndOfSegment;
            this.integralEndOfSegment = integralBeginOfSegment;
        }else {
            this.integralBeginOfSegment = integralBeginOfSegment;
            this.integralEndOfSegment = integralEndOfSegment;
        }
        this.n = n;
    }
    @Override
    public double getValue(T function) {
        if(n == 0){
            throw new IllegalArgumentException("n is 0");
        }
        if (integralBeginOfSegment < function.getBeginOfSegment() ||
                integralEndOfSegment > function.getEndOfSegment()) {
            throw new IllegalArgumentException("Segment of function doesn't exist segment of integral");
        }
        double result = 0;
        double d = (integralEndOfSegment - integralBeginOfSegment) / n;
        for (int i = 0; i < n; i++) {
            result += function.getValue(integralBeginOfSegment + d * (i + 0.5));
        }
        result *= d;
        return result;
    }
}
