package main.java.com.thelair.stage;

import main.java.com.thelair.guardian.DeanGuardian;
import main.java.com.thelair.player.Player;

public class Stage5 {

    public void startStage(Player player) {
        DeanGuardian dean = new DeanGuardian();

        System.out.println("\n====================================================");
        System.out.println("STAGE 5 — THE DEAN’S WRATH EXAMINATION");
        System.out.println("====================================================");
        System.out.println(dean.getIntro());
        System.out.println("Prepare yourself. This test will measure everything you’ve learned.");
        System.out.println("====================================================\n");
        while (player.isAlive() && dean.isAlive()) {

            int playerAttack = player.attack();
            int deanAttack = dean.attack();

            dean.takeDamage(playerAttack);
            player.takeDamage(deanAttack);

            displayBattleLog(player, dean, playerAttack, deanAttack);
            if (!dean.isAlive()) {
                System.out.println("\nYou have triumphed over the Dean’s final exam!");
                System.out.println("Your code, logic, and willpower have passed the ultimate test!");
                break;
            }

            if (!player.isAlive()) {
                System.out.println("\nThe Dean’s lessons overwhelm you...");
                System.out.println("Perhaps you were not yet ready for the final judgment.");
                break;
            }
        }
    }

    private void displayBattleLog(Player player, DeanGuardian dean, int playerAttack, int deanAttack) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("You dealt " + playerAttack + " damage!");
        System.out.println("Dean dealt " + deanAttack + " damage!");
        System.out.println("\nCurrent Status:");
        System.out.println("You: " + player.getCurrentHP() + "/" + player.getMaxHP());
        System.out.println("Dean: " + dean.getCurrentHP() + "/" + dean.getMaxHP());
      
        if (dean.getPhase() == 1 && dean.getCurrentHP() <= dean.getMaxHP() * 0.25) {
            System.out.println("\n⚠️ The Dean’s calm demeanor shatters...");
            System.out.println("You feel an immense power rising — something is changing!");
        }

        if (dean.getPhase() == 2) {
            System.out.println("\nThe Dean’s Judgement has begun!");
            if (dean.getCurrentHP() <= dean.getMaxHP() * 0.30) {
                System.out.println("Her energy flickers, yet her determination only grows stronger!");
            }
        }

        System.out.println("------------------------------------------------------\n");
    }
}
