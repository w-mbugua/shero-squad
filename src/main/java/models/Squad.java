package models;

import java.util.ArrayList;

public class Squad {
    private String title;
    private int size;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String title, int size, String cause) {
        this.title = title;
        this.size = size;
        this.cause = cause;
        instances.add(this);
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

    public static ArrayList<Squad> getAll(){
        return instances;
    }
}
