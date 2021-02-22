package models;

public class Hero {

    private String name;
    private int age;
    private String strength;
    private String weakness;

    public Hero(String name, int age, String strength, String weakness) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.weakness = weakness;
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
}
