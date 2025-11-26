package com.thelair.player;
import java.util.Random; 
public class AnoosIben extends Player {
    public AnoosIben(String name, int level, int maxHP, int maxWisdom) {
        super("Iben Anoos", "The Codebreaker", 1, 700, 200);

        this.setMaxHP(700);
        this.setCurrentHP(700);
        int min = 200;
        int max = 300; 
        int value = new Random().nextInt(max - min) + min;
        this.setLogic(value);
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