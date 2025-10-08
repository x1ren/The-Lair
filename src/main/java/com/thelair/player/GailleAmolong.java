package main.java.com.thelair.player;

public class GailleAmolong extends Player {
    public GailleAmolong(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Gaille Amolong", "The Architect", 1, 90, 50, 12, 10, 14);
    }

    @Override
    public String getSignatureSkillName() {
        return "Blueprint Mind";
    }

    @Override
    public int useSignatureSkill() {
        // Slightly higher boost based on intelligence
        return getStrength() + (int)(0.8 * getIntelligence());
    }
}

//long-term growth, high intelligence, decent strength and speed.