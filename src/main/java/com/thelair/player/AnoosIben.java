package main.java.com.thelair.player;

public class AnoosIben extends Player {
    public AnoosIben(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Iben Anoos", "The Codebreaker", 1, 70, 70, 8, 14, 18);
    }

    @Override
    public String getSignatureSkillName() {
        return "Debugger’s Eye";
    }

    @Override
    public int useSignatureSkill() {
        // High INT scaling burst
        return getStrength() + getIntelligence();
    }
}

//high intelligence and speed, low strength, glass cannon.