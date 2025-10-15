package main.java.com.thelair.player;

public class JamuelBacus extends Player {
    public JamuelBacus(String name, int level, int maxHP, int maxWisdom) {
        super("Bacus", "The Tactician", 1, 300, 400);
        // Align to Character Stats doc (HP 300, Logic 200, Wisdom 400)
        this.setMaxHP(300);
        this.setCurrentHP(300);
        this.setLogic(200);
        this.setWisdomStat(400);
        this.setMaxWisdom(400);
        this.setCurrentWisdom(400);
        this.setSkills(new Skill[]{
            new Skill("RECURSIVE_INSIGHT", "Recursive Insight", 40, "Reduces next enemy attack by 30%.", 2),
            new Skill("STRATEGIST_GAMBIT", "Strategist’s Gambit", 70, "Next skill deals ×1.75 damage (10% crit).", 4),
            new Skill("PATTERN_RECOGNITION", "Pattern Recognition", 60, "+20% accuracy and +10% crit for 3 turns.", 3)
        });
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