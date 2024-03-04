package OPG1ex98;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;

    private int speed = SLOW;
    private boolean power = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int speed, boolean power, double radius, String color) {
        this.speed = speed;
        this.power = power;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String str = "The fan";
        if (power) {
            return str + " is on. Speed is " + getSpeed() + ". Color is " + getColor() + ". Radius is " + getRadius() + ".";
        } else return str + " is off. Color is " + getColor() + ". Radius is " + getRadius() + ".";
    }
}
