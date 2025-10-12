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
            "Use Item"
        });
        ConsoleUI.prompt("Enter choice:");
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
       
        String battleIntro = "";
        if (opponent instanceof main.java.com.thelair.guardian.Guardian) {
            String guardianName = opponent.getName();
            switch(guardianName) {
                case "Cathy":
                    battleIntro = "Ma'am Cathy emerges: 'You dare challenge me? Let's see if you know the basics!'";
                    break;
                case "Khai":
                    battleIntro = "Sir Khai stands firm: 'Object-oriented principles will be your downfall!'";
                    break;
                case "Serato":
                    battleIntro = "Serato appears: 'Your code is messy! Let me teach you proper structure!'";
                    break;
                case "Tulin":
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
