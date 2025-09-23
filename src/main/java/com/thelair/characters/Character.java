package main.java.com.thelair.characters;

/** 
 * HP (Health Points): represents the amount of damage a character can take before dying or being knocked out.
 * MP (Magic Points):  represents the amount of magical power a character has. Higher the power, the more spells can be cast.
 * Strength: represents the character’s physical strength. Determines amount of damage attacks inflict.
 * Speed: represents how fast the character moves. Determines frequency of attacks and chance to dodge incoming attacks.
 * Intelligence: represents how clever the character is. Determines power of spells and ability to resist magic attacks.
 */

public class Character {
    private String name; 
    private String characterClass;
    private int level;
    private int maxHP; 
    private int maxMP;
    private int strength;
    private int speed;
    private int intelligence; 

    //private int currentHP;
    //private int currentMP;

    public Character(String name, String characterClass, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        this.name = name;
        this.characterClass = characterClass;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.strength = strength;
        this.speed = speed;
        this.intelligence = intelligence;
    }

    public String getName() { return name; }
    public String getCharacterClass() { return characterClass; }
    public int getLevel() { return level; }
    public int getMaxHP() { return maxHP; }
    public int getMaxMP() { return maxMP; }
    public int getStrength() { return strength; }
    public int getSpeed() { return speed; }
    public int getIntelligence() { return intelligence; }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    } 

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void displayStats() {
        System.out.println("Character: " + name);
        System.out.println("Class: " + characterClass);
        System.out.println("Level: " + level);
        System.out.println("HP: " + maxHP);
        System.out.println("MP: " + maxMP);
        System.out.println("Strength: " + strength);
        System.out.println("Speed: " + speed);
        System.out.println("Intelligence: " + intelligence);
    }
}
