    package main.java.com.thelair.player;

import main.java.com.thelair.battle.Combatant;
import java.util.Random;


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
    protected int maxWisdom, currentWisdom;
    protected java.util.Map<String, Integer> statusEffects = new java.util.HashMap<>();
    protected int logic;
    protected int wisdom;
    protected Skill[] skills;
    protected java.util.Map<String, Integer> skillCooldowns = new java.util.HashMap<>();
    protected java.util.Map<String, Integer> inventory = new java.util.HashMap<>();
    protected int experience = 0;
    protected int experienceToNextLevel = 100;

    public Player(String name, String characterClass, int level, int maxHP, int maxWisdom) {
        this.name = name;
        this.characterClass = characterClass;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxWisdom = maxWisdom;
        this.currentWisdom = maxWisdom;
        this.level = level;
        this.experience = 0;
        this.experienceToNextLevel = 100; // First level up at 100 XP
    }

    public void restoreStats(){

        currentHP = maxHP;
        currentWisdom = maxWisdom;
        System.out.println(name + " is now resting in the library to restore HP and Wisdom");
        System.out.println("After 2 minutes....");
        System.out.printf("Current HP: %d\n", currentHP);
        System.out.printf("Current Wisdom: %d\n", currentWisdom);
        System.out.println(name + "is now fully rested!");

    }

    public boolean isAlive() {
        return currentHP > 0;
    }


    public void heal(int amount) {
        currentHP += amount;
        if(currentHP > maxHP) currentHP = maxHP;
    }

    public void useWisdom(int amount) {
        currentWisdom -= amount;
        if(currentWisdom < 0) currentWisdom = 0;
    }

    public void restoreWisdom(int amount) {
        currentWisdom += amount;
        if(currentWisdom > maxWisdom) currentWisdom = maxWisdom;
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
        checkLevelUp();
    }

    private void levelUp() {
        Random random = new Random();
        level++;
        int maxHpToAdd = 35 + random.nextInt(30);
        int logicToAdd = 35 + random.nextInt(25);
        int wisdomToAdd = 25 + random.nextInt(75);
        maxHP += maxHpToAdd; // More HP per level
        currentHP = maxHP;
        // Logic/Wisdom are the only scaling stats in this simplified model
        logic += logicToAdd; // More logic per level
        wisdom += wisdomToAdd; // More wisdom per level
        experienceToNextLevel = level * 50; 
        System.out.println(name + " leveled up to level " + level + "!");
        System.out.println("HP increased by " + maxHpToAdd + ",  Logic increased by " + logicToAdd + ", Wisdom increased by " + wisdomToAdd + "!");
    }

    public String getName() { return name; }
    public String getCharacterClass() { return characterClass; }
    public int getLevel() { return level; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxWisdom() { return maxWisdom; }
    public int getCurrentWisdom() { return currentWisdom;}
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
    public void setMaxWisdom(int maxWisdom) { this.maxWisdom = maxWisdom; }
    public void setCurrentWisdom(int currentWisdom) { this.currentWisdom = currentWisdom; }

    public void displayStats() {
        System.out.printf("%s (%s) - HP: %d/%d | Wisdom: %d/%d | Logic: %d%n",
        name, characterClass, currentHP, maxHP, currentWisdom, maxWisdom, logic);
    }

    // Combatant implementation
    @Override
    public int attack() {
        int effectiveLogic = getEffectiveLogic();
        int min = effectiveLogic;
        int max = effectiveLogic + 30;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Polymorphic signature skill. Subclasses may override.
    public String getSignatureSkillName() {
        return "Basic Strike";
    }

    public int useSignatureSkill() {
        // Default: modest bonus based on effective logic (with buffs), no cost
        return (int)(0.5 * getEffectiveLogic());
    }

    // New stat accessors
    public int getLogic() { return logic; }
    public int getWisdomStat() { return wisdom; }
    public void setLogic(int logic) { this.logic = logic; }
    public void setWisdomStat(int wisdom) { this.wisdom = wisdom; }
    public void increaseLogic(int amount) { this.logic += amount; }
    public void increaseWisdomStat(int amount) { this.wisdom += amount; }
    public void increaseMaxHP(int amount) { this.maxHP += amount; this.currentHP = Math.min(this.currentHP + amount, this.maxHP); }

    public Skill[] getSkills() { return skills; }
    public void setSkills(Skill[] skills) { this.skills = skills; }

    // Inventory helpers
    public java.util.Map<String, Integer> getInventory() { 
        return inventory; 
    }
    public void addItem(String itemId) { 
        inventory.put(itemId, inventory.getOrDefault(itemId, 0) + 1); 
        System.out.println(name + " found " + itemId + " and added it to their inventory.");
    }
    public void addItem(String itemId, int count) { 
        inventory.put(itemId, inventory.getOrDefault(itemId, 0) + count); 
        System.out.println(name + " found " + count + " " + itemId + " and added it to their inventory.");
    }
    public boolean consumeItem(String itemId) {
        Integer c = inventory.get(itemId);
        if (c == null || c <= 0) return false;
        if (c == 1) inventory.remove(itemId); else inventory.put(itemId, c - 1);
        return true;
    }

    // Cooldowns helpers
    public int getCooldown(String key) { return skillCooldowns.getOrDefault(key, 0); }
    public void setCooldown(String key, int turns) { skillCooldowns.put(key, turns); }
    public void tickCooldowns() {
        java.util.Map<String, Integer> next = new java.util.HashMap<>();
        for (java.util.Map.Entry<String, Integer> e : skillCooldowns.entrySet()) {
            int v = Math.max(0, e.getValue() - 1);
            if (v > 0) next.put(e.getKey(), v);
        }
        skillCooldowns = next;
        tickStatusEffects();
    }

    public void tickStatusEffects() {
        java.util.Map<String, Integer> next = new java.util.HashMap<>();
        for (java.util.Map.Entry<String, Integer> e : statusEffects.entrySet()) {
            int v = Math.max(0, e.getValue() - 1);
            if (v > 0) next.put(e.getKey(), v);
        }
        statusEffects = next;
    }

    public void applyStatusEffect(String effect, int duration) {
        statusEffects.put(effect, duration);
    }

    public boolean hasStatusEffect(String effect) {
        return statusEffects.containsKey(effect) && statusEffects.get(effect) > 0;
    }

    public int getStatusEffectDuration(String effect) {
        return statusEffects.getOrDefault(effect, 0);
    }

    public int getEffectiveLogic() {
        int baseLogic = logic;
        if (hasStatusEffect("logicBuff")) {
            baseLogic = (int) (baseLogic * 1.3); // 30% boost
        }
        return baseLogic;
    }

    @Override
    public void takeDamage(int damage) {
        // Iron Will passive: 10% damage reduction when HP < 50%
        if (currentHP < maxHP / 2) {
            damage = (int) (damage * 0.9);
        }
        currentHP -= damage;
        if(currentHP < 0) currentHP = 0;
    }
}
