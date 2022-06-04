public class Vector3DProcessor {

    public static Vector3D summary(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.getXVec() + v2.getXVec(), v1.getYVec() + v2.getYVec(), v1.getZVec() + v2.getZVec());

    }

    public static Vector3D different(Vector3D v1, Vector3D v2) {
        return new Vector3D(
                v1.getXVec() - v2.getXVec(),
                v1.getYVec() - v2.getYVec(),
                v1.getZVec() - v2.getZVec()
        );
    }

    public static double scalarMult(Vector3D v1, Vector3D v2) {
        return  v1.getXVec() * v2.getXVec() +
                v1.getYVec() * v2.getYVec() +
                v1.getZVec() * v2.getZVec();
    }

    public static Vector3D vectorMult(Vector3D v1, Vector3D v2) {
        return new Vector3D(
                v1.getZVec() * v2.getZVec() - v1.getZVec() * v2.getYVec(),
                v1.getZVec() * v2.getXVec() - v1.getXVec() * v2.getZVec(),
                v1.getXVec() * v2.getYVec() - v1.getYVec() * v2.getYVec()
        );
    }

    public static boolean isCollinear(Vector3D v1, Vector3D v2) {
        return vectorMult(v1, v2).equals(new Vector3D());
    }
}