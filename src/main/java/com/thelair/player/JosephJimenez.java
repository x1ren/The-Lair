package main.java.com.thelair.player;

public class JosephJimenez extends Player {
    public JosephJimenez(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Jimenez", "The Balanced", 1, 85, 45, 11, 11, 11);
        // Align to Character Stats doc (HP 400, Logic 200, Wisdom 200)
        this.setMaxHP(400);
        this.setCurrentHP(400);
        this.setLogic(200);
        this.setWisdomStat(200);
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