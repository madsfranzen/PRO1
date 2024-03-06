package OPG6ex1013;

public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D() {
        x = 0;
        y = 0;
        width = 1;
        width = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(MyRectangle2D r) {
        double x1 = r.getX();
        double y1 = r.getY();
        double x2 = r.getX() + r.getWidth();
        double y2 = r.getY() + r.getHeight();
        if (containsPoint(x1, y1) && !containsPoint(x2, y2)) {
            return true;
        } else if (!containsPoint(x1, y1) && containsPoint(x2, y2)) {
            return true;
        }
        return false;
    }

    public boolean contains(MyRectangle2D r) {
        double x1 = r.getX();
        double y1 = r.getY();
        double x2 = r.getX() + r.getWidth();
        double y2 = r.getY() + r.getHeight();
        if (containsPoint(x1, y1) && containsPoint(x2, y2)) {
            return true;
        } else return false;
    }

    public boolean containsPoint(double x, double y) {
        if ((x <= width + this.x && x >= this.x) && (y <= height + this.y && y >= this.y)) {
            return true;
        } else return false;
    }

    //region ## GETTER & SETTER ##
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    //endregion
}


