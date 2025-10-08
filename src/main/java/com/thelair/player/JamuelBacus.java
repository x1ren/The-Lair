package main.java.com.thelair.player;

public class JamuelBacus extends Player {
    public JamuelBacus(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Bacus", "The Tactician", 1, 65, 65, 10, 12, 17);
    }

    @Override
    public String getSignatureSkillName() {
        return "Strategist’s Gambit";
    }

    @Override
    public int useSignatureSkill() {
        // Moderate boost with small extra for speed
        return getStrength() + (int)(0.6 * getIntelligence()) + (int)(0.2 * getSpeed());
    }
}

//weak but fast and intelligent, high skill cap.