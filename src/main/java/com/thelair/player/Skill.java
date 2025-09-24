package main.java.com.thelair.player;

public class Skill {
    private String name;
    private int mpCost;
    private String description;
    private int power;
    // private String type;
    // private String effect;
    // private int effectChance;
    // private int levelRequirement;
    // private String target;
    // private String element;
    // private String statusEffect;
    // private int statusEffectChance;
    // private int cooldown;
    // private int currentCooldown;

    public Skill(String name, int mpCost, String description, int power) {
        this.name = name;
        this.mpCost = mpCost;
        this.description = description;
        this.power = power;
        // this.type = type;
        // this.effect = effect;
        // this.effectChance = effectChance;
        // this.levelRequirement = levelRequirement;
        // this.target = target;
        // this.element = element;
        // this.statusEffect = statusEffect;
        // this.statusEffectChance = statusEffectChance;
        // this.cooldown = cooldown;
        // this.currentCooldown = 0;
    }

    public String getName() { return name; }
    public int getMpCost() { return mpCost; }
    public String getDescription() { return description; }
    public int getPower() { return power; }
}
