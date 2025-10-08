package main.java.com.thelair.player;

public class JosephJimenez extends Player {
    public JosephJimenez(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Jimenez", "The Balanced", 1, 85, 45, 11, 11, 11);
    }

    @Override
    public String getSignatureSkillName() {
        return "Jack of All Codes";
    }

    @Override
    public int useSignatureSkill() {
        // Balanced scaling
        return getStrength() + (int)(0.4 * getIntelligence()) + (int)(0.2 * getSpeed());
    }
}

//balanced, jack of all trades, master of none.