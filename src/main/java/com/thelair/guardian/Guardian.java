package com.thelair.guardian;
import java.util.*; 
import com.thelair.battle.Combatant;

public class Guardian implements Combatant {
    private String name;
    private int level;
    private int maxHP, currentHP;
    //private int strength;
    //private int speed;
    //private int intelligence;
    private int logic;
    private int maxWisdom, currentWisdom;
    protected Map<String, Integer> statusEffects = new HashMap<>();


    public Guardian(String name, int level, int maxHP, int logic, int maxWisdom) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.logic = logic;
        this.maxWisdom = maxWisdom;
        this.currentWisdom = maxWisdom;

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
    public int getLogic(){return logic;}
    public int getMaxWisdom(){return maxWisdom;}
    public int getCurrentWisdom(){return currentWisdom;}


    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public void setLogic(int logic){
        this.logic = logic;
    }
    public void setMaxWisdom(int maxWisdom){
        this.maxWisdom = maxWisdom;
    }
    public void setCurrentWisdom(int currentWisdom){
        this.currentWisdom = currentWisdom;
    }
    public int getExperienceReward() {
        return level * 60; // Increased from 50 to 65 for better balance
    }

    // Status effect helpers
    public void applyStatusEffect(String effect, int duration) {
        statusEffects.put(effect, duration);
    }

    public boolean hasStatusEffect(String effect) {
        return statusEffects.containsKey(effect) && statusEffects.get(effect) > 0;
    }

    public int getStatusEffectDuration(String effect) {
        return statusEffects.getOrDefault(effect, 0);
    }

    public void tickStatusEffects() {
        Map<String, Integer> next = new HashMap<>();
        for (java.util.Map.Entry<String, Integer> e : statusEffects.entrySet()) {
            int v = Math.max(0, e.getValue() - 1);
            if (v > 0) next.put(e.getKey(), v);
        }
        statusEffects = next;
    }

    // Combatant implementation
    @Override
    public int attack() {
        Random random = new Random(); 

        int min = logic;
        int max = logic+30;
        return random.nextInt(max - min + 1) + min;
    }
}
