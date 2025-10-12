package main.java.com.thelair.player;

public class Skill {
    private String id;
    private String name;
    private int mpCost;
    private String description;
    private int cooldown;


    public Skill(String id, String name, int mpCost, String description, int cooldown) {
        this.id = id;
        this.name = name;
        this.mpCost = mpCost;
        this.description = description;
        this.cooldown = cooldown;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getMpCost() { return mpCost; }
    public String getDescription() { return description; }
    public int getCooldown() { return cooldown; }
}
