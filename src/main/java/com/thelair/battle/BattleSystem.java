package main.java.com.thelair.battle;

import main.java.com.thelair.player.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleSystem {
    private final Player player;
    private final Scanner scanner;

    public BattleSystem(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    private int safeNextInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            System.out.println("Invalid input. Defaulting to 1 (Attack).");
            return 1;
        }
    }

    private void playerTurn(Combatant opponent) {
        System.out.println("\nYour Turn! Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Signature Skill");
        System.out.println("3. Defend");
        System.out.println("4. Use Item");
        System.out.print("Enter choice: ");
        int choice = safeNextInt();
        switch(choice) {
            case 1: {
                int damage = player.attack();
                opponent.takeDamage(damage);
                System.out.println("You attack the " + opponent.getName() + " for " + damage + " damage!");
                break;
            }
            case 2: {
                int damage = player.useSignatureSkill();
                opponent.takeDamage(damage);
                System.out.println("You used " + player.getSignatureSkillName() + " and dealt " + damage + " damage!");
                break;
            }
            case 3:
                System.out.println("You brace yourself. Incoming damage reduced this turn.");
                // MVP: no state tracking; in a fuller build, track a defend flag
                break;
            case 4:
                System.out.println("You rummage for an item, but your bag is empty (MVP).");
                break;
            default:
                System.out.println("Invalid choice! You lose your turn.");
        }
    }

    private void opponentTurn(Combatant opponent) {
        int damage = opponent.attack();
        player.takeDamage(damage);
        System.out.println("The " + opponent.getName() + " attacks you for " + damage + " damage!");
    }
    
    public void startBattle(Combatant opponent, Integer experienceReward) {
        System.out.println("A wild " + opponent.getName() + " appears!");
        // TODO [Iben]: Wire hero skills with real costs/cooldowns; prompt choices
        // TODO [Ilde Jan]: Integrate Puzzle checks affecting damage and outcomes
        while(player.isAlive() && opponent.isAlive()) {
            playerTurn(opponent);
            if(opponent.isAlive()) {
                opponentTurn(opponent);
            }
            System.out.println("\nPlayer HP: " + player.getCurrentHP() + "/" + player.getMaxHP());
            System.out.println(opponent.getName() + " HP: " + opponent.getCurrentHP() + "/" + opponent.getMaxHP());
        }
        if(player.isAlive()) {
            System.out.println("You defeated the " + opponent.getName() + "!");
            if (experienceReward != null && experienceReward > 0) {
                player.gainExperience(experienceReward);
            }
        } else {
            System.out.println("You were defeated by the " + opponent.getName() + "...");
        }
    }
}
