package main.java.com.thelair.battle;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.puzzle.PuzzleEngine;
import main.java.com.thelair.ui.ConsoleUI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleSystem {
    private final Player player;
    private final Scanner scanner;
    private final PuzzleEngine puzzleEngine;

    public BattleSystem(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
        this.puzzleEngine = new PuzzleEngine();
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
        ConsoleUI.menu("Your Turn! Choose an action:", new String[]{
            "Attack",
            "Signature Skill",
            "Defend",
            "Use Item",
            "Inspect Enemy"
        });
        ConsoleUI.prompt("Enter choice:");
        int choice = safeNextInt();
        scanner.nextLine(); 
        switch(choice) {
            case 1: {
                int damage = player.attack();
                opponent.takeDamage(damage);
                System.out.println("You attack the " + opponent.getName() + " for " + damage + " damage!");
                break;
            }
            case 2: {
                // Enforce MP costs and cooldowns (simple defaults by class)
                int cost = Math.max(20, (int)(player.getWisdomStat() * 0.1));
                String key = "SIG:" + player.getClass().getSimpleName();
                int cd = player.getCooldown(key);
                if (cd > 0) {
                    System.out.println("Skill on cooldown for " + cd + " more turn(s).");
                    break;
                }
                if (player.getCurrentMP() < cost) {
                    System.out.println("Not enough MP (need " + cost + ")!");
                    break;
                }
                player.useMP(cost);
                int damage = player.useSignatureSkill();
                opponent.takeDamage(damage);
                System.out.println("You used " + player.getSignatureSkillName() + " and dealt " + damage + " damage!");
                player.setCooldown(key, 3);
                break;
            }
            case 3:
                System.out.println("You brace yourself. Incoming damage reduced this turn.");
                // MVP: no state tracking; in a fuller build, track a defend flag
                break;
            case 4:
                if (player.getInventory().isEmpty()) {
                    System.out.println("Your bag is empty.");
                    break;
                }
                System.out.println("Items:");
                for (int i = 0; i < player.getInventory().size(); i++) {
                    System.out.println("  " + (i+1) + ") " + player.getInventory().get(i));
                }
                ConsoleUI.prompt("Choose item number:");
                int idx = safeNextInt();
                scanner.nextLine();
                int sel = idx - 1;
                if (sel < 0 || sel >= player.getInventory().size()) {
                    System.out.println("Invalid item.");
                    break;
                }
                String item = player.getInventory().get(sel);
                if (player.consumeItem(item)) {
                    if ("POTION_SMALL".equals(item)) {
                        player.heal(100);
                        System.out.println("You used a Small Potion and recovered 100 HP.");
                    } else if ("ETHER_SMALL".equals(item)) {
                        player.restoreMP(80);
                        System.out.println("You used a Small Ether and recovered 80 MP.");
                    } else if ("BOMB".equals(item)) {
                        opponent.takeDamage(150);
                        System.out.println("You threw a Bomb for 150 true damage!");
                    } else {
                        System.out.println("Nothing happened.");
                    }
                }
                break;
            case 5:
                System.out.println("Enemy: " + opponent.getName());
                System.out.println("HP: " + opponent.getCurrentHP() + "/" + opponent.getMaxHP());
                if (opponent instanceof main.java.com.thelair.guardian.Guardian) {
                    main.java.com.thelair.guardian.Guardian g = (main.java.com.thelair.guardian.Guardian) opponent;
                    System.out.println("ATK: " + g.getStrength() + ", SPD: " + g.getSpeed() + ", INT: " + g.getIntelligence());
                }
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
       
        String battleIntro;
        if (opponent instanceof main.java.com.thelair.guardian.Guardian) {
            String guardianName = opponent.getName();
            switch(guardianName) {
                case "Ma'am Cathy":
                    battleIntro = "Ma'am Cathy emerges: 'This is very easy guys. Dali ra kaau ni ihuman ninyo.'";
                    break;
                case "Sir Khai":
                    battleIntro = "Sir Khai stands firm: 'Object-oriented principles will be your downfall!'";
                    break;
                case "Serato":
                    battleIntro = "Serato appears: 'Your code is messy! Let me teach you proper structure!'";
                    break;
                case "Ma'am Tulin":
                    battleIntro = "Ma'am Tulin declares: 'Data is everything! Prove you can manage it!'";
                    break;
                case "Dean":
                    battleIntro = "Dean emerges: 'I am the final test! Show me you've learned everything!'";
                    break;
                default:
                    battleIntro = "A wild " + opponent.getName() + " appears!";
            }
        } else {
            battleIntro = "A wild " + opponent.getName() + " appears!";
        }
        
        ConsoleUI.section(battleIntro);
        
        while(player.isAlive() && opponent.isAlive()) {
            playerTurn(opponent);
            
            if(opponent.isAlive()) {
                
                if (opponent instanceof main.java.com.thelair.guardian.Guardian && 
                    puzzleEngine.shouldTriggerFinisher((main.java.com.thelair.guardian.Guardian) opponent)) {
                    
                    System.out.println("\n💡 " + opponent.getName() + " is weakened! Finish them with your knowledge!");
                    boolean finisherSuccess = puzzleEngine.triggerFinisher(
                        (main.java.com.thelair.guardian.Guardian) opponent, player, scanner);
                    
                    if (finisherSuccess) {
                        opponent.takeDamage(opponent.getCurrentHP()); 
                        break;
                    } else {
                        System.out.println(opponent.getName() + " now has " + opponent.getCurrentHP() + "/" + opponent.getMaxHP() + " HP");
                    }
                }
                
                opponentTurn(opponent);
            }
            
            // tick cooldowns at end of round
            player.tickCooldowns();
            ConsoleUI.battleHUD(player, opponent);
        }
        
        if(player.isAlive()) {
            String victoryMessage = "";
            if (opponent instanceof main.java.com.thelair.guardian.Guardian) {
                String guardianName = opponent.getName();
                switch(guardianName) {
                    case "Cathy":
                        victoryMessage = "Ma'am Cathy fades: 'You... understand the fundamentals well...'";
                        break;
                    case "Khai":
                        victoryMessage = "Sir Khai dissipates: 'Your OOP knowledge... is impressive...'";
                        break;
                    case "Serato":
                        victoryMessage = "Serato crumbles: 'Your code... is clean after all...'";
                        break;
                    case "Tulin":
                        victoryMessage = "Ma'am Tulin vanishes: 'You have mastered the data...'";
                        break;
                    case "Dean":
                        victoryMessage = "Dean dissolves: 'You have proven worthy... the knowledge is yours...'";
                        break;
                    default:
                        victoryMessage = "You defeated the " + opponent.getName() + "!";
                }
            } else {
                victoryMessage = "You defeated the " + opponent.getName() + "!";
            }
            System.out.println(victoryMessage);
            
            if (experienceReward != null && experienceReward > 0) {
                player.gainExperience(experienceReward);
            }
        } else {
            String defeatMessage = "";
            if (opponent instanceof main.java.com.thelair.guardian.Guardian) {
                defeatMessage = opponent.getName() + " stands victorious: 'Come back when you're ready to learn!'";
            } else {
                defeatMessage = "You were defeated by the " + opponent.getName() + "...";
            }
            System.out.println(defeatMessage);
        }
    }
}
