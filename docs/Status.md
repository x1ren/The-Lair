<h5>Stage 5</h5>


public class Stage5 {
    private Dean dean;
    private Player player;
    public Stage5(Player player) {
        this.player = player;
        this.dean = new Dean();
    }
    public void start() {
        BattleLog.log("\n=== STAGE 5: FINAL EXAM — THE DEAN ===");
        BattleLog.log("You face " + dean.getName() + "!");
        BattleLog.separator();
        while (player.isAlive() && dean.isAlive()) {
            playerTurn();
            if (!dean.isAlive()) break;
            enemyTurn();
        }
        if (player.isAlive()) {
            BattleLog.log("\n🎓 You defeated The Dean! Graduation achieved!");
            checkLevelUp();
        } else {
            BattleLog.log("\n💀 You have failed the final exam. Retry?");
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
}
