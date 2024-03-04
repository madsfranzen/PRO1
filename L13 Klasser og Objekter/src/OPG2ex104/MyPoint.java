package OPG2ex104;

public class MyPoint {
    private double x = 0;
    private double y = 0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(double pointA, double pointB) {
        double distance = pointA - pointB;
        return distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}


