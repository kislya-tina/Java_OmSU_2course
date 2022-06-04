package quadraticTrinominal;

public class QuadraticTrinominal {
    private double a;
    private double b;
    private double c;

    public QuadraticTrinominal(double a, double b, double c){
        if(Double.compare(a, 0) == 0){
            throw new IllegalArgumentException("Not quadratic trinominal");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] decision(){
        if(Double.compare(a, b) == 0 && Double.compare(b, c) == 0){
            throw new IllegalArgumentException("Infinity roots");
        }
        double descr = b*b - 4*a*c;
        if(descr < 0){
            throw new IllegalArgumentException("Equation without roots");
        }
        double x1 = (-b + Math.sqrt(descr))/(2*a);
        double x2 = (-b - Math.sqrt(descr))/(2*a);
        if(x2 > x1){
            return new double[]{x2, x1};
        }
        if(Double.compare(x1, x2) == 0){
            return new double[]{x1};
        }
        return new double[]{x1, x2};
    }
}
