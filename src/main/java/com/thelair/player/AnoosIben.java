package main.java.com.thelair.player;

public class AnoosIben extends Player {
    public AnoosIben(String name, int level, int maxHP, int maxMP, int strength, int speed, int intelligence) {
        super("Iben Anoos", "The Codebreaker", 1, 70, 70, 8, 14, 18);
        // Align to Character Stats doc (HP 400, Logic 300, Wisdom 200)
        this.setMaxHP(400);
        this.setCurrentHP(400);
        this.setLogic(300);
        this.setWisdomStat(200);
    }

    @Override
    public String getSignatureSkillName() {
        return "Debugger’s Eye";
    }

    @Override
    public int useSignatureSkill() {
        // High Logic scaling burst
        return getLogic();
    }
}

//high intelligence and speed, low strength, glass cannon.