package main.java.com.thelair.player;

public class JamuelBacus extends Player {
    public JamuelBacus(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Bacus", "The Tactician", 1, 65, 65, 10, 12, 17);
        // Align to Character Stats doc (HP 300, Logic 200, Wisdom 400)
        this.setMaxHP(300);
        this.setCurrentHP(300);
        this.setLogic(200);
        this.setWisdomStat(400);
    }

    @Override
    public String getSignatureSkillName() {
        return "Strategist’s Gambit";
    }

    @Override
    public int useSignatureSkill() {
        // Moderate boost using logic
        return (int)(0.6 * getLogic());
    }
}

//weak but fast and intelligent, high skill cap.