    package main.java.com.thelair.player;

import main.java.com.thelair.battle.Combatant;

/** 
 * HP (Health Points): represents the amount of damage a character can take before dying or being knocked out.
 * MP (Magic Points):  represents the amount of magical power a character has. Higher the power, the more spells can be cast.
 * Strength: represents the character’s physical strength. Determines amount of damage attacks inflict.
 * Speed: represents how fast the character moves. Determines frequency of attacks and chance to dodge incoming attacks.
 * Intelligence: represents how clever the character is. Determines power of spells and ability to resist magic attacks.
 */

public abstract class Player implements Combatant {
    protected String name; 
    protected String nickname;
    protected String characterClass;
    protected int level;
    protected int maxHP, currentHP;
    protected int maxMP, currentMP;
    protected int logic;
    protected int wisdom;
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
        // TODO [Joseph]: Consider scaling EXP and calling checkLevelUp() at milestones
    }

    private void levelUp() {
        level++;
        maxHP += 10;
        currentHP = maxHP;
        // Logic/Wisdom are the only scaling stats in this simplified model
        logic += 2;
        wisdom += 2;
        experienceToNextLevel += level * 100; // current scaling method
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public String getName() { return name; }
    public String getCharacterClass() { return characterClass; }
    public int getLevel() { return level; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxMP() { return maxMP; }
    public int getCurrentMP() { return currentMP;}
    // strength/speed/intelligence removed
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    // setters for strength/speed/intelligence removed

    public void displayStats() {
        System.out.printf("%s (%s) - HP: %d/%d | Logic: %d | Wisdom: %d%n", 
        name, characterClass, currentHP, maxHP, logic, wisdom);
    }

    // Combatant implementation
    @Override
    public int attack() {
        return logic;
    }

    // Polymorphic signature skill. Subclasses may override.
    public String getSignatureSkillName() {
        return "Basic Strike";
    }

    public int useSignatureSkill() {
        // Default: modest bonus based on logic
        return (int)(0.5 * logic);
    }

    // New stat accessors
    public int getLogic() { return logic; }
    public int getWisdomStat() { return wisdom; }
    public void setLogic(int logic) { this.logic = logic; }
    public void setWisdomStat(int wisdom) { this.wisdom = wisdom; }
    public void increaseLogic(int amount) { this.logic += amount; }
    public void increaseWisdomStat(int amount) { this.wisdom += amount; }
    public void increaseMaxHP(int amount) { this.maxHP += amount; this.currentHP = Math.min(this.currentHP + amount, this.maxHP); }
}
