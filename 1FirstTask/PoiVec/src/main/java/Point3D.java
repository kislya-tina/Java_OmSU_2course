import java.util.Objects;

public class Point3D {

    private double x;
    private double y;
    private double z;

    public Point3D(double a, double b, double c) {
        x = a;
        y = b;
        z = c;
    }

    public Point3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    void setX(double n){x = n;}
    void setY(double n){y = n;}
    void setZ(double n){z = n;}

    double getX(){return x;}
    double getY(){return y;}
    double getZ(){return z;}

    void out() {
        System.out.println("("+x + ", " + y + ", " + z + ")  ");
    }

    public static  boolean isEqual(Point3D a, Point3D b){
        int count=0;
        if(Math.abs(a.getX()-b.getX())<1e-9){count++;}//Double.compare(a.getX(),b.getX()) == 0
        if(Math.abs(a.getY()-b.getY())<1e-9){count++;}
        if(Math.abs(a.getZ()-b.getZ())<1e-9){count++;}

        if(count==3){return true;} else return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Objects.equals(x, point3D.x) && Objects.equals(y, point3D.y)
                && Objects.equals(z, point3D.z);
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                ", z=" + z;
    }

}