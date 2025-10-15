package main.java.com.thelair.player;

public class DebugHero extends Player {
    public DebugHero(String name, int level, int maxHP, int maxWisdom) {
        super("DEBUG HERO", "The Unbeatable", 1, 9999, 9999);
        // Set up an unbeatable character for testing
        this.setMaxHP(9999);
        this.setCurrentHP(9999);
        this.setLogic(9999);
        this.setWisdomStat(9999);
        this.setMaxWisdom(9999);
        this.setCurrentWisdom(9999);
        this.setSkills(new Skill[]{
            new Skill("GOD_MODE", "God Mode", 0, "Instantly defeats any enemy.", 0),
            new Skill("INFINITE_WISDOM", "Infinite Wisdom", 0, "Restores all Wisdom.", 0),
            new Skill("PERFECT_DEFENSE", "Perfect Defense", 0, "Blocks all damage.", 0)
        });
    }

    @Override
    public String getSignatureSkillName() {
        return "God Mode";
    }

    @Override
    public int useSignatureSkill() {
        return 999999; // Massive damage
    }

    @Override
    public void takeDamage(int damage) {
        // Debug hero takes no damage
        System.out.println("Debug Hero is invincible!");
    }

    @Override
    public int attack() {
        return 999999; // Massive damage
    }
}
