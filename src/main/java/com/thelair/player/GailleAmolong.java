package main.java.com.thelair.player;

public class GailleAmolong extends Player {
    public GailleAmolong(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Gaille Amolong", "The Architect", 1, 90, 50, 12, 10, 14);
        // Align to Character Stats doc (HP 500, Logic 200, Wisdom 300)
        this.setMaxHP(500);
        this.setCurrentHP(500);
        this.setLogic(200);
        this.setWisdomStat(300);
    }

    @Override
    public String getSignatureSkillName() {
        return "Blueprint Mind";
    }

    @Override
    public int useSignatureSkill() {
        // Slightly higher boost based on logic
        return (int)(0.8 * getLogic());
    }
}

//long-term growth, high intelligence, decent strength and speed.