package models;

import java.util.ArrayList;

public class Squad {
    private String title;
    private int size;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;

    public Squad(String title, int size, String cause) {
        this.title = title;
        this.size = size;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();
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
    public int getId(){
        return id;
    }
    public static ArrayList<Squad> getAll(){
        return instances;
    }
    public static void clearAll(){
        instances.clear();
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
}
