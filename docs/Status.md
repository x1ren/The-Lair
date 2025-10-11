
* public class Dean implements Combatant {
    private String name = "The Dean — Overseer of All Knowledge";
    private int hp;
    private int maxHp;
    private int phase;
    private boolean isAwakened;

    public Dean() {
        this.maxHp = 900;
        this.hp = maxHp;
        this.phase = 1;
        this.isAwakened = false;
    }

    @Override
    public String getName() 
    { 
    return name; 
    }

    @Override
    public int getHP() { 
    return hp; 
    }
    

    @Override
    public boolean isAlive() { 
    return hp > 0;
    }

    @Override
    public void takeDamage(int dmg) {
        hp-=dmg;
        if (hp < 0) hp = 0;
        BattleLog.log(name + " took " + dmg + " damage (" + hp + "/" + maxHp + ")");
        checkPhaseTransition();
    }

    @Override
    public void attack(Player player) {
        if (phase == 1) {
            Skill s = new Skill("Exam Review", 40, "Deals medium logic damage");
            BattleLog.log(name + " used " + s.getName() + "!");
            player.takeDamage(40);
        } else {
            Skill s = new Skill("Comprehensive Exam", 70, "High wisdom damage to all players!");
            BattleLog.log(name + " unleashed " + s.getName() + "!");
            player.takeDamage(70);
        }
    }

    private void checkPhaseTransition() {
        if (phase == 1 && hp <= 0 && !isAwakened) {
            awaken();
        }
    }

    private void awaken() {
        BattleLog.log("\nThe Dean Return!);
        this.phase = 2;
        this.isAwakened = true;
        this.maxHp = 1200;
        this.hp = maxHp;
        BattleLog.log(name + " restores to full HP (" + maxHp + ") and gains new skills!");
    }
}

* public class Stage5 {
    private Dean dean;
    private Player player;
    
    public Stage5(Player player) {
        this.player = player;
        this.dean = new Dean();
    }

    public void start() {
        BattleLog.log("\Stage 5");
        BattleLog.log("You face " + dean.getName() + "!");
        BattleLog.separator();

     *   while (player.isAlive() && dean.isAlive()) {
            playerTurn();
            if (!dean.isAlive()) break;
            enemyTurn();
        }

     if (player.isAlive()) {
            BattleLog.log("\nYou defeated The Dean! Congratulations!");
            checkLevelUp();
        } else {
            BattleLog.log("\nYou have failed the final exam. Retry?");
        }
    }

    private void playerTurn() {
        BattleLog.log("\nYour Turn — choose a skill:");
        Skill chosen = player.chooseSkill();  // assume UI or console input
        BattleLog.log("You used " + chosen.getName() + "!");
        dean.takeDamage(chosen.getDamage());
    }

    private void enemyTurn() {
        BattleLog.log("\nEnemy Turn:");
        dean.attack(player);
    }

*Level Up

 private void checkLevelUp() {
        if (player.gainExperience(500)) {
            BattleLog.log("Level up! " + player.getName() + " reached Level " + player.getLevel() + "!");
            BattleLog.log("Stats increased — Logic +5, Wisdom +3.");
        } else {
            BattleLog.log("You earned 500 EXP. Keep going!");
        }
    }
}
