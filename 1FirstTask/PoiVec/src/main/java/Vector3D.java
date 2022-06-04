import java.util.Objects;

public class Vector3D {

    private double x;
    private double y;
    private double z;

    public Vector3D(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3D(Point3D a) {
        x = a.getX();
        y = a.getY();
        z = a.getZ();
    }

    public Vector3D(double a, double b, double c) {
        x = a;
        y = b;
        z = c;
    }
    public Vector3D(Vector3D a){
        x = a.getXVec();
        y = a.getYVec();
        z = a.getZVec();
    }

    public Vector3D(Point3D a, Point3D b) {
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();
        z = b.getZ() - a.getZ();

    }

    double lenVec() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    void setXVec(int n) {x = n;}
    void setYVec(int n) {y = n;}
    void setZVec(int n) {z = n;}

    double getXVec() {return x;}
    double getYVec() {return y;}
    double getZVec() {return z;}


    void outVec() {
        System.out.printf("Vector = (%.2f, %.2f, %.2f)",x ,y ,z);
    }

    @Override
    public String toString() {
        return  "(" +
                "x = " + x +
                ", y = " + y +
                ", z = " + z +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Objects.equals(x, vector3D.x) && Objects.equals(y, vector3D.y)
                && Objects.equals(z, vector3D.z);
    }


}