package functionals.functional;

import functionals.functionsOfSingleArgument.IFuncOnSegment;

public class SumFunctional<T extends IFuncOnSegment> implements IFunctional<T>{
    private final double beginOfSegment;
    private final double endOfSegment;
    private final int n;

    public SumFunctional(double beginOfSegment, double endOfSegment, int n) {
        if(beginOfSegment > endOfSegment){
            this.beginOfSegment = endOfSegment;
            this.endOfSegment = beginOfSegment;
        }else {
            this.beginOfSegment = beginOfSegment;
            this.endOfSegment = endOfSegment;
        }
        this.n = n;
    }

    @Override
    public double getValue(T function) {
        double end = function.getEndOfSegment();
        double begin = function.getBeginOfSegment();
        if(n == 0){
            throw new IllegalArgumentException("n is 0");
        }
        if (beginOfSegment < begin ||
                endOfSegment > end) {
            throw new IllegalArgumentException("Segment of function doesn't exist segment");
        }
        return function.getValue(end) + function.getValue(begin) +
                function.getValue((end + begin) / 2.);
    }
}
