package OPG4ex91;

public class RectangleApp {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        System.out.println("RECTANGLE 1:");
        System.out.println("Perimeter is: " + rectangle1.getPerimeter());
        System.out.println("Area is:      " + rectangle1.getArea());

        System.out.println("\n RECTANGLE 2:");
        System.out.println("Perimeter is: " + rectangle2.getPerimeter());
        System.out.println("Area is:      " + rectangle2.getArea());
    }
}
