package EX3ekstra;

public class NewsFlash {
    private String header;
    private String content;
    private int version = 1;

    public NewsFlash(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return header + " - V." + version;
    }
}
