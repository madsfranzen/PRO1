package OPG3;

public class OPG3 {
    public static void main(String[] args) {

        Team hobbits = new Team("Hobbits");
        Player bilbo = new Player("Bilbo", 111);
        Player frodo = new Player("Frodo", 54);
        hobbits.addPlayer(bilbo);
        bilbo.setScore(12);
        hobbits.addPlayer(frodo);
        frodo.setScore(0);

        Team elves = new Team("Elves");
        Player legolas = new Player("Legolas", 2000);
        Player elrond = new Player("Elrond", 4269);
        elves.addPlayer(legolas);
        legolas.setScore(5);
        elves.addPlayer(elrond);
        elrond.setScore(5);

        hobbits.printPlayers();
        System.out.println(hobbits.calcAverage());
        System.out.println(hobbits.calcTotalScore());
        elves.printPlayers();
        System.out.println(elves.calcAverage());
        System.out.println(elves.calcTotalScore());
        System.out.println(elves.calcOldPlayerScore(4000));
        System.out.println(elves.bestPlayerNames());
    }
}
