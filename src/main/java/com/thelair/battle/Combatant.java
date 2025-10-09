package main.java.com.thelair.battle;

/**
 * Simple interface to unify anything that can participate in battle.
 * Demonstrates abstraction and polymorphism across Players, Guardians, and Minions.
 */
public interface Combatant {
    String getName();
    int getMaxHP();
    int getCurrentHP();
    boolean isAlive();
    void takeDamage(int damage);
    int attack();
}


