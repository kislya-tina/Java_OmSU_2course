
public class Main {

    public static void main(String[] args) {

        Point3D a = new Point3D(7, 5, 4); //конструктор точки 7 5 4
        Point3D b = new Point3D(); //конструктор точки 0 0 0

        System.out.printf("a.x=%.2f a.y=%.2f a.z=%.2f\n", a.getX(), a.getY(), a.getZ()); //getters
        a.setX(5);
        a.setY(24);
        a.setZ(1);
        //setters
        a.out();//вывод точки
        b.setX(5);
        b.setY(24);
        b.setZ(1);
        if(Point3D.isEqual(a, b)) { System.out.println("Точки равны");}

        Vector3D c = new Vector3D(0, 1, 0);// конструктор нулевого вектора в точке 0 1 0
        Vector3D c1 = new Vector3D(a);
        Vector3D d = new Vector3D(1, 2, 3);
        Vector3D d1 = new Vector3D(a, b);
        System.out.println(d.lenVec());//длина вектора
        c.outVec();
        System.out.println();
        Vector3DProcessor.summary(c, d);//сумма векторов
        System.out.println(Vector3DProcessor.summary(c, d));

    }
}