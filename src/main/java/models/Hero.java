package models;

import java.util.ArrayList;

public class Hero {

    private String name;
    private int age;
    private String strength;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, int age, String strength, String weakness) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.weakness = weakness;
        instances.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStrength() {
        return strength;
    }

    public String getWeakness() {
        return weakness;
    }
    public static ArrayList<Hero> getAll(){
        return instances;
    }
}
