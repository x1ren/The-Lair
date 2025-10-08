package main.java.com.thelair.player;

public class IldeJanFigueras extends Player {
    public IldeJanFigueras(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Ilde", "The Challenger", 1, 120, 25, 18, 9, 7);
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