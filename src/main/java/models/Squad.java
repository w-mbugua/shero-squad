package models;

public class Squad {
    private String title;
    private int size;
    private String cause;

    public Squad(String title, int size, String cause) {
        this.title = title;
        this.size = size;
        this.cause = cause;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public String getCause() {
        return cause;
    }
}
