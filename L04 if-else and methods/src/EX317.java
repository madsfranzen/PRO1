import java.util.Scanner;

public class EX317 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Rock (0) - Paper (1) - Scissor (2) : ");
        int choice = scan.nextInt();
        int npcChoise = (generateNpcChoice());

        System.out.println("You chose: " + translateChoice(choice));
        System.out.println("NPC chose: " + translateChoice(npcChoise));
        System.out.println(gameLogic(choice, npcChoise));
    }

    public static int generateNpcChoice() {
        int choice = (int) (Math.random() * 3);
        return choice;
    }

    public static String gameLogic(int player, int npc) {
        if (player == 0 && npc == 2 ||
                player == 1 && npc == 0 ||
                player == 2 && npc == 1) {
            return "YOU WON!";
        } else if (npc == 0 && player == 2 ||
                npc == 1 && player == 0 ||
                npc == 2 && player == 1) {
            return "YOU LOST...";
        } else return "DRAW! PLAY AGAIN.";
    }

    public static String translateChoice(int choiceNum) {
        if (choiceNum == 0) return "Rock";
        else if (choiceNum == 1) return "Paper";
        else return "Scissor";
    }
}