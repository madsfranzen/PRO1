import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        Player player1 = new Player("John", 180, 100, 6);
        Player player2 = new Player("Gurli", 170, 70, 5);
        Player player3 = new Player("Ho", 165, 55, 4);
        Player player4 = new Player("Lee", 160, 60, 3);
        Player player5 = new Player("Fuk", 175, 90, 2);
        Player player6 = new Player("Jim", 210, 150, 1);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);

        System.out.println(linearSearch(players, 5));
        System.out.println(findPlayerBinary(players, 1));
    }

    public static Player linearSearch(ArrayList players, int numOfGoals) {
        int i = 0;
        boolean found = false;
        Player player = null;
        while (!found && i < players.size()) {
            Player playerSearch = (Player) players.get(i);
            if (playerSearch.getScoredGoals() == numOfGoals) {
                found = true;
                player = playerSearch;
            } else i++;
        }
        return player;
    }

    /* Write a binary search method that returns a player with a given number of scored goals found in a sorted ArrayList of players
    (sorted in descending order according to scored goals) given as parameter. Return null, if no such player is found. */
    public static Player findPlayerBinary(ArrayList<Player> players, int score) {
        Player player = null;
        int left = 0;
        int right = players.size() - 1;
        while (player == null && left <= right) {
            int middle = (left + right) / 2;
            Player p = players.get(middle);
            if (p.getScoredGoals() == score) {
                player = p;
            } else if (p.getScoredGoals() < score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return player;
    }
}
