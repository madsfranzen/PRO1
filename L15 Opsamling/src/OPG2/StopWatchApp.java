package OPG2;

import java.util.Scanner;

public class StopWatchApp {
    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();

        Scanner scan = new Scanner(System.in);
        System.out.println("Start watch by pressing Enter (enter)");
        String input = scan.nextLine();
        stopWatch.start();
        System.out.println("Stop watch by pressing Enter (enter)");
        input = scan.nextLine();
        stopWatch.stop();
        System.out.println("Elapsed Time: " + stopWatch.elapsedTime() + " seconds.");
    }
}
