package storage;

import model.Badge;
import model.Hold;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Hold> alleHold = new ArrayList<>();
    private static final ArrayList<Badge> alleBadges = new ArrayList<>();

    public static void tilføjHold(Hold hold) {
        alleHold.add(hold);
    }

    public static void tilføjBadge(Badge badge) {
        alleBadges.add(badge);
    }

    public static ArrayList<Hold> getAlleHold() {
        return new ArrayList<Hold>(alleHold);
    }

    public static ArrayList<Badge> getAlleBadges() {
        return new ArrayList<Badge>(alleBadges);
    }

}
