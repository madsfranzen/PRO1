package EX3ekstra;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<NewsFlash> allNewsFlash = new ArrayList<>();

    public static void storeNewsFlash(NewsFlash newsFlash) {
        allNewsFlash.add(newsFlash);
    }

    public static ArrayList<NewsFlash> getAllNewsFlash() {
        return new ArrayList<>(allNewsFlash);
    }
}
