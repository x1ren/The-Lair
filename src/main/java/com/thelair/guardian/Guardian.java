package main.java.com.thelair.guardian;

public class Guardian {
    private String name;
    private int level;
    private int maxHP, currentHP;
    private int strength;
    private int speed;
    private int intelligence;

    public Guardian(String name, int level, int maxHP, int strength, int speed, int intelligence) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.strength = strength;
        this.speed = speed;
        this.intelligence = intelligence;
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void takeDamage(int damage) {
        currentHP -= damage;
        if(currentHP < 0) currentHP = 0;
    }

    public void heal(int amount) {
        currentHP += amount;
        if(currentHP > maxHP) currentHP = maxHP;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentHP() { return currentHP; }
    public int getStrength() { return strength; }
    public int getSpeed() { return speed; }
    public int getIntelligence() { return intelligence; }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
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

    public int getExperienceReward() {
        return level * 50;
    }
}
