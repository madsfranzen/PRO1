package OPG3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println(player.getName() + ", " + player.getAge() + ", " + player.getScore());
        }
    }

    public double calcAverage() {
        double allPlayersScore = 0;
        for (Player player : players) {
            allPlayersScore += player.getScore();
        }
        return allPlayersScore / players.size();
    }

    public int calcTotalScore() {
        int totalScore = 0;
        for (Player player : players) {
            totalScore += player.getScore();
        }
        return totalScore;
    }

    public int maxScore() {
        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }
        return maxScore;
    }

    public int calcOldPlayerScore(int age) {
        int oldScore = 0;
        for (Player player : players) {
            if (player.getAge() > age) {
                oldScore += player.getScore();
            }
        }
        return oldScore;
    }

    public ArrayList<String> bestPlayerNames() {
        int maxScore = maxScore();
        ArrayList<String> list = new ArrayList<>();
        for (Player player : players) {
            if (player.getScore() == maxScore) {
                list.add(player.getName());
            }
        }
        return list;
    }


    public String toString() {
        return "Team(" + name + ")";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
