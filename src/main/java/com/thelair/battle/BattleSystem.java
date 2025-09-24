package main.java.com.thelair.battle;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.Guardian;
import java.util.Scanner;

public class BattleSystem {
    private Player player;
    private Guardian guardian;
    private Scanner scanner;

    public BattleSystem(Player player, Guardian guardian, Scanner scanner) {
        this.player = player;
        this.guardian = guardian;
        this.scanner = scanner;
    }

    private void playerTurn() {
        System.out.println("\nYour Turn! Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Use Skill");
        System.out.println("3. Defend");
        System.out.println("4. Use Item");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                int damage = player.getStrength();
                guardian.takeDamage(damage);
                System.out.println("You attack the " + guardian.getName() + " for " + damage + " damage!");
                break;
            case 2:
                // Skill logic here
                System.out.println("You use a skill!");
                break;
            case 3:
                // Defend logic here
                System.out.println("You defend!");
                break;
            case 4:
                // Item logic here
                System.out.println("You use an item!");
                break;
            default:
                System.out.println("Invalid choice! You lose your turn.");
        }
    }

    private void guardianTurn() {
        int damage = guardian.getStrength();
        player.takeDamage(damage);
        System.out.println("The " + guardian.getName() + " attacks you for " + damage + " damage!");
    }
    
    public void startBattle() {
        System.out.println("A wild " + guardian.getName() + " appears!");
        while(player.isAlive() && guardian.isAlive()) {
            playerTurn();
            if(guardian.isAlive()) {
                guardianTurn();
            }
            System.out.println("\nPlayer HP: " + player.getCurrentHP() + "/" + player.getMaxHP());
            System.out.println(guardian.getName() + " HP: " + guardian.getCurrentHP() + "/" + guardian.getMaxHP());
        }
        if(player.isAlive()) {
            System.out.println("You defeated the " + guardian.getName() + "!");
            player.gainExperience(guardian.getExperienceReward());
        } else {
            System.out.println("You were defeated by the " + guardian.getName() + "...");
        }
    }
}
