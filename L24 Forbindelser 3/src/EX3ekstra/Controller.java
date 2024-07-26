package EX3ekstra;

import java.util.ArrayList;

public abstract class Controller {

    public static NewsFlash createNewsFlash(String header, String content) {
        NewsFlash newsFlash = new NewsFlash(header, content);
        Storage.storeNewsFlash(newsFlash);
        return newsFlash;
    }

    public static ArrayList<NewsFlash> getAllHeadings() {
        return Storage.getAllNewsFlash();
    }

}
