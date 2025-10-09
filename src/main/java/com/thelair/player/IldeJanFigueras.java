package main.java.com.thelair.player;

public class IldeJanFigueras extends Player {
    public IldeJanFigueras(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Ilde", "The Challenger", 1, 120, 25, 18, 9, 7);
        // Align to Character Stats doc (HP 600, Logic 100, Wisdom 200)
        this.setMaxHP(600);
        this.setCurrentHP(600);
        this.setLogic(100);
        this.setWisdomStat(200);
    }

    @Override
    public String getSignatureSkillName() {
        return "Iron Will";
    }

    @Override
    public int useSignatureSkill() {
        // Heavy STR-based strike
        return getStrength() + 5;
    }
}

//tanky, high strength, low intelligence and speed.