package main.java.com.thelair.guardian;
import java.util.Random;
import main.java.com.thelair.battle.Combatant;

public class Guardian implements Combatant {
    private String name;
    private int level;
    private int maxHP, currentHP;
    //private int strength;
    //private int speed;
    //private int intelligence;
    private int logic;
    private int maxMP, currentMP;


    public Guardian(String name, int level, int maxHP, int logic, int maxMP) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.logic = logic;
        this.maxMP = maxMP;

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
   

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public void setLogic(int logic){
        this.logic = logic;
    }
    public int getLogic(){return logic;}
    public void setMaxMP(int maxMP){
        this.maxMP = maxMP;
    }
    public int getMaxMP(){
        return maxMP;
    }
    public int getExperienceReward() {
        return level * 50;
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
