package com.thelair.player;
import java.util.Random; 
public class IldeJanFigueras extends Player {
    public IldeJanFigueras(String name, int level, int maxHP, int maxWisdom) {
        super("Ilde", "The Challenger", 1, 800, 200);
        // Align to Character Stats doc (HP 600, Logic 100, Wisdom 200)
        this.setMaxHP(800);
        this.setCurrentHP(800);
        int min = 100;
        int max = 200; 
        int value = new Random().nextInt(max - min) + min;
        this.setLogic(value);
        this.setWisdomStat(200);
        this.setMaxWisdom(200);
        this.setCurrentWisdom(200);
        this.setSkills(new Skill[]{
            new Skill("PASSIVE_IRON_WILL", "Iron Will (Passive)", 0, "When HP < 50%, damage taken reduced by 10%.", 0),
            new Skill("OVERCLOCKED_RESOLVE", "Overclocked Resolve", 80, "Double Logic for 2 turns.", 3),
            new Skill("BERSERKER_CODER", "Berserker Coder", 120, "Logic ×3 damage; 10% recoil.", 4)
        });
    }

    @Override
    public String getSignatureSkillName() {
        return "Iron Will";
    }

    @Override
    public int useSignatureSkill() {
        // Heavy logic-based simple strike in simplified model
        return getLogic() + 5;
    }
}

//tanky, high strength, low intelligence and speed.