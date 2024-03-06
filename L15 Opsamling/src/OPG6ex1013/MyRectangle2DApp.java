package OPG6ex1013;

public class MyRectangle2DApp {

    public static void main(String[] args) {
        MyRectangle2D rectangle1 = new MyRectangle2D(1, 1, 3, 3);
        MyRectangle2D rectangle2 = new MyRectangle2D(1, 1, 4, 4);

        System.out.println(rectangle1.containsPoint(3, 3));


        System.out.println(rectangle1.contains(rectangle2));


        System.out.println(rectangle1.overlaps(rectangle2));
    }


}
