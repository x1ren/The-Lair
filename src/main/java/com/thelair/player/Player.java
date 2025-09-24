    package main.java.com.thelair.player;

/** 
 * HP (Health Points): represents the amount of damage a character can take before dying or being knocked out.
 * MP (Magic Points):  represents the amount of magical power a character has. Higher the power, the more spells can be cast.
 * Strength: represents the character’s physical strength. Determines amount of damage attacks inflict.
 * Speed: represents how fast the character moves. Determines frequency of attacks and chance to dodge incoming attacks.
 * Intelligence: represents how clever the character is. Determines power of spells and ability to resist magic attacks.
 */

public abstract class Player {
    protected String name; 
    protected String nickname;
    protected String characterClass;
    protected int level;
    protected int maxHP, currentHP;
    protected int maxMP, currentMP;
    protected int strength;
    protected int speed;    
    protected int intelligence;
    protected Skill[] skills;
    protected int experience = 0;
    protected int experienceToNextLevel = 100;

    public Player(String name, String characterClass, int level, 
    int maxHP, int maxMP, int strength, int speed, int intelligence) {
        this.name = name;
        this.characterClass = characterClass;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMP = maxMP;
        this.currentMP = maxMP;
        this.strength = strength;
        this.speed = speed;
        this.intelligence = intelligence;
        this.level = level;
        this.experience = 0;
        this.experienceToNextLevel = level * 100;
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

    public void useMP(int amount) {
        currentMP -= amount;
        if(currentMP < 0) currentMP = 0;
    }

    public void restoreMP(int amount) {
        currentMP += amount;
        if(currentMP > maxMP) currentMP = maxMP;
    }
    
    public void checkLevelUp() {
        while(experience >= experienceToNextLevel) {
            experience -= experienceToNextLevel;
            levelUp();
        }
    }

    public void gainExperience(int exp) {
        experience += exp;
        System.out.println(name + " gained " + exp + " experience points.");
    }

    private void levelUp() {
        level++;
        maxHP += 10;
        currentHP = maxHP;
        maxMP += 5;
        currentMP = maxMP;
        strength += 2;
        speed += 2;
        intelligence += 2;
        experienceToNextLevel += level * 100; // Example scaling
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public String getName() { return name; }
    public String getCharacterClass() { return characterClass; }
    public int getLevel() { return level; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxMP() { return maxMP; }
    public int getCurrentMP() { return currentMP;}
    public int getStrength() { return strength; }
    public int getSpeed() { return speed; }
    public int getIntelligence() { return intelligence; }
    
    public void setLevel(int level) {
        this.level = level;
    }

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

    public void displayStats() {
        System.out.printf("%s (%s) - HP: %d/%d | MP: %d/%d%n", 
        name, characterClass, currentHP, maxHP, currentMP, maxMP);
    }
}
