package main.java.com.thelair.player;

public class GailleAmolong extends Player {
    public GailleAmolong(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Gaille Amolong", "The Architect", 1, 90, 50, 12, 10, 14);
        // Align to Character Stats doc (HP 500, Logic 200, Wisdom 300)
        this.setMaxHP(500);
        this.setCurrentHP(500);
        this.setLogic(50);
        this.setWisdomStat(300);
        this.setMaxMP(300);
        this.setCurrentMP(300);
        this.setSkills(new Skill[]{
            new Skill("PASSIVE_SECOND_CHANCE", "Second Chance (Passive)", 0, "Revive once per stage with 30% HP.", 0),
            new Skill("BLUEPRINT_MIND", "Blueprint Mind", 50, "+30% Logic for 2 turns.", 3),
            new Skill("VISION_REALIZED", "Vision Realized", 70, "+20% defense and regen 10% HP for 3 turns.", 5)
        });
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