import java.util.Scanner;

public class AppMadsF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indtast personens navn");
        String name = scan.nextLine();
        System.out.println("Indtast personens vægt i kg:");
        int weight = scan.nextInt();
        System.out.println("Indtast personens højde i m");
        double height = scan.nextDouble();

        Double bmi = weight / (height * 2);
        String bmiInterpretation = null;

        if (bmi < 18.5) {
            bmiInterpretation = "Undervægt";
        } else if (bmi >= 18.5 && bmi <= 25) {
            bmiInterpretation = "Normal vægt";
        } else if (bmi > 25 && bmi <= 30) {
            bmiInterpretation = "Overvægt";
        } else if (bmi > 30) {
            bmiInterpretation = "Fedme";
        } else bmiInterpretation = "Error";

        System.out.println("Beregnet BMI: " + bmi);
        System.out.print(name + ", BMI siger: " + bmiInterpretation);
    }
}
