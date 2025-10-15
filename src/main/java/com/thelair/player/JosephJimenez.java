package main.java.com.thelair.player;

public class JosephJimenez extends Player {
    public JosephJimenez(String name, int level, int maxHP, int maxWisdom) {
        super("Jimenez", "The Balanced", 1, 400, 200);
        // Align to Character Stats doc (HP 400, Logic 200, Wisdom 200)
        this.setMaxHP(400);
        this.setCurrentHP(400);
        this.setLogic(200);
        this.setWisdomStat(200);
        this.setMaxWisdom(200);
        this.setCurrentWisdom(200);
        this.setSkills(new Skill[]{
            new Skill("JACK_OF_ALL_CODES", "Jack of All Codes", 40, "Deals Logic ×1.2 damage to all enemies.", 3),
            new Skill("ADAPTIVE_LEARNER", "Adaptive Learner", 50, "Reuse last skill with +20% efficiency.", 4),
            new Skill("STEADY_HAND", "Steady Hand (Passive)", 0, "15% chance to resist debuffs.", 0)
        });
    }

    @Override
    public String getSignatureSkillName() {
        return "Jack of All Codes";
    }

    @Override
    public int useSignatureSkill() {
        // Balanced scaling on logic only in simplified model
        return (int)(0.5 * getLogic());
    }
}

//balanced, jack of all trades, master of none.