public class Vector3DArray {
    private final Vector3D[] arr;

    public Vector3DArray(int n) {
        if (n <= 0) throw new IllegalArgumentException("arr.length error");
        this.arr = new Vector3D[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Vector3D();
        }
    }

    public void set(Vector3D v, int ind) {
        if (ind < 0 || ind >= arr.length) throw new IllegalArgumentException("Index error");
        if (v == null) throw new IllegalArgumentException("Method set isn't get null");
        arr[ind] = new Vector3D(v);
    }


    public double maxVectorLength() {
        double res = -1;
        double temp = 0;

        for (Vector3D vector3D : arr) {
            temp = vector3D.lenVec();
            if (temp > res) res = temp;
        }
        return res;
    }

    public int contains(Vector3D v) {
        if (v == null) throw new IllegalArgumentException("Method contains isn't get null");
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i].equals(v)) return i;
        }
        return -1;
    }

    public int length() {
        return this.arr.length;
    }

    public Point3D[] pointSwap(Point3D point) {
        if (point == null) throw new IllegalArgumentException("Method pointSwap isn't get null");
        Point3D[] data = new Point3D[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            data[i] = new Point3D(
                    point.getX() + arr[i].getXVec(),
                    point.getY() + arr[i].getYVec(),
                    point.getZ() + arr[i].getZVec()
            );
        }
        return data;
    }

    public Vector3D sumAllVectors() {
        Vector3D res = arr[0];
        for (int i = 1; i < this.arr.length; i++) {
            res = Vector3DProcessor.summary(res, arr[i]);
        }
        return res;
    }

    public Vector3D lineCombination(double[] koefs) {
        if (koefs.length != arr.length) throw new IllegalArgumentException("Coefficient's count incorrect ");
        double x = 0;
        double y = 0;
        double z = 0;
        for (int i = 0; i < koefs.length; i++) {
            x += arr[i].getXVec() * koefs[i];
            y += arr[i].getYVec() * koefs[i];
            z += arr[i].getZVec() * koefs[i];
        }
        return new Vector3D(x, y, z);
    }

    public Vector3D getElement(int index) {
        return this.arr[index];
    }
}