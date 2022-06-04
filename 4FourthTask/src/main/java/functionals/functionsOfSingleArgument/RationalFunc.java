package functionals.functionsOfSingleArgument;

public class RationalFunc implements IFuncOnSegment{

    private final double koefA;
    private final double koefB;
    private final double koefC;
    private final double koefD;
    private final double beginOfSegment;
    private final double endOfSegment;

    public RationalFunc(double koefA, double koefB, double koefC, double koefD, double beginOfSegment, double endOfSegment){
        this.koefA = koefA;
        this.koefB = koefB;
        this.koefC = koefC;
        this.koefD = koefD;
        if(beginOfSegment > endOfSegment){
            this.beginOfSegment = endOfSegment;
            this.endOfSegment = beginOfSegment;
        }else {
            this.beginOfSegment = beginOfSegment;
            this.endOfSegment = endOfSegment;
        }
    }

    @Override
    public double getValue(double x) {
        if(x < beginOfSegment || x > endOfSegment){
            throw new IllegalArgumentException("x not in segment");
        }
        return (koefA * x + koefB)/(koefC * x + koefD);
    }

    @Override
    public double getBeginOfSegment() {
        return beginOfSegment;
    }

    @Override
    public double getEndOfSegment() {
        return endOfSegment;
    }
}
