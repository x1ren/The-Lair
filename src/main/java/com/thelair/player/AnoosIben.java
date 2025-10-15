package main.java.com.thelair.player;

public class AnoosIben extends Player {
    public AnoosIben(String name, int level, int maxHP, int maxWisdom) {
        super("Iben Anoos", "The Codebreaker", 1, 400, 200);
        // Align to Character Stats doc (HP 400, Logic 300, Wisdom 200)
        this.setMaxHP(400);
        this.setCurrentHP(400);
        this.setLogic(300);
        this.setWisdomStat(200);
        this.setMaxWisdom(200);
        this.setCurrentWisdom(200);
        this.setSkills(new Skill[]{
            new Skill("DBG_EYE", "Debugger’s Eye", 40, "Reduce enemy defense by 25% for 3 turns; reveals hidden abilities.", 3),
            new Skill("SYN_SLAYER", "Syntax Slayer", 60, "Deal Logic ×1.5 damage (×2 if enemy weakened).", 2),
            new Skill("LOOP_MASTERY", "Loop Mastery", 80, "Repeat last skill for free.", 4)
        });
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