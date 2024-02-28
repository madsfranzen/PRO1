package OPG1;

public class CarApp {

    public static void main(String[] args) {
//        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
//        System.out.println("Test: " + myCar.toString());
//        System.out.println();
//
//        String brand = myCar.brand;
//        System.out.println("Brand " + brand);
//        System.out.println("My car: " + myCar.brand + ", " + myCar.color);
//
//        myCar.km = 65000;
//        System.out.println("Km nu: " + myCar.km);

        // -------------------------------------------------

        Car newCar = new Car("Opel", "Black", "DX 54189", 0);

        newCar.km = 42000;

        System.out.println("New Car");
        System.out.println("******************");
        System.out.println("* Brand: " + newCar.brand);
        System.out.println("* " + newCar.regNo);
        System.out.println("* Color: " + newCar.color);
        System.out.println("* " + newCar.km + " km");
        System.out.println("******************");

    }
}
