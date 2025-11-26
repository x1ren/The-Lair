package com.thelair.battle;

// combatant determines the actions of the combatant in the battle.. eg if it's a player or a guardian or a minion
public interface Combatant {
    String getName();
    int getMaxHP();
    int getCurrentHP();
    boolean isAlive();
    void takeDamage(int damage);
    int attack();
}


