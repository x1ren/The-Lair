package main.java.com.thelair.battle;

public class Minion implements Combatant {
    private final String name;
    private final int maxHP;
    private int currentHP;
    private final int attackDamage;

    public Minion(String name, int maxHP, int attackDamage) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.attackDamage = attackDamage;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getMaxHP() { return maxHP; }

    @Override
    public int getCurrentHP() { return currentHP; }

    @Override
    public boolean isAlive() { return currentHP > 0; }

    @Override
    public void takeDamage(int damage) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;
    }

    @Override
    public int attack() { return attackDamage; }
}


