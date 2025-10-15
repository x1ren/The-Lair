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
                // Show multi-skill menu
                if (player.getSkills() == null || player.getSkills().length == 0) {
                    System.out.println("No skills available.");
                    break;
                }
                System.out.println("Skills:");
                for (int i = 0; i < player.getSkills().length; i++) {
                    main.java.com.thelair.player.Skill s = player.getSkills()[i];
                    int cdLeft = player.getCooldown(s.getId());
                    System.out.printf("  %d) %s (Cost %d MP, CD %d) %s%n", i+1, s.getName(), s.getMpCost(), s.getCooldown(), cdLeft>0?"[CD "+cdLeft+"]":"");
                    System.out.println("     - " + s.getDescription());
                }
                ConsoleUI.prompt("Choose skill:");
                int sIdx = safeNextInt();
                scanner.nextLine();
                int sSel = sIdx - 1;
                if (sSel < 0 || sSel >= player.getSkills().length) {
                    System.out.println("Invalid skill.");
                    break;
                }
                main.java.com.thelair.player.Skill s = player.getSkills()[sSel];
                int cdLeft = player.getCooldown(s.getId());
                if (cdLeft > 0) {
                    System.out.println("Skill on cooldown for " + cdLeft + " more turn(s).");
                    break;
                }
                if (player.getCurrentWisdom() < s.getMpCost()) {
                    System.out.println("Not enough Wisdom (need " + s.getMpCost() + ")!");
                    break;
                }
                player.useWisdom(s.getMpCost());
                // Apply skill-specific effects
                if ("DBG_EYE".equals(s.getId())) {
                    // Debugger’s Eye: apply enemyDefenseDown for 3 turns
                    if (opponent instanceof main.java.com.thelair.guardian.Guardian) {
                        ((main.java.com.thelair.guardian.Guardian) opponent).applyStatusEffect("enemyDefenseDown", 3);
                    }
                    System.out.println("You used " + s.getName() + " and reduced enemy defense!");
                } else if ("BLUEPRINT_MIND".equals(s.getId())) {
                    // Blueprint Mind: apply logicBuff for 2 turns
                    player.applyStatusEffect("logicBuff", 2);
                    System.out.println("You used " + s.getName() + " and boosted your Logic for 2 turns!");
                }
                // Other skills just deal base damage for now
                int damage = player.useSignatureSkill();
                opponent.takeDamage(damage);
                System.out.println("You used " + s.getName() + " and dealt " + damage + " damage!");
                if (s.getCooldown() > 0) player.setCooldown(s.getId(), s.getCooldown());
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
                java.util.List<String> itemKeys = new java.util.ArrayList<>(player.getInventory().keySet());
                for (int i = 0; i < itemKeys.size(); i++) {
                    String key = itemKeys.get(i);
                    System.out.println("  " + (i+1) + ") " + key + " x" + player.getInventory().get(key));
                }
                ConsoleUI.prompt("Choose item number:");
                int idx = safeNextInt();
                scanner.nextLine();
                int sel = idx - 1;
                if (sel < 0 || sel >= itemKeys.size()) {
                    System.out.println("Invalid item.");
                    break;
                }
                String item = itemKeys.get(sel);
                if (player.consumeItem(item)) {
                    if ("POTION_SMALL".equals(item)) {
                        player.heal(100);
                        System.out.println("You used a Small Potion and recovered 100 HP.");
                    } else if ("POTION_MED".equals(item)) {
                        player.heal(250);
                        System.out.println("You used a Medium Potion and recovered 250 HP.");
                    } else if ("ETHER_SMALL".equals(item)) {
                        player.restoreWisdom(80);
                        System.out.println("You used a Small Ether and recovered 80 Wisdom.");
                    } else if ("REVIVE".equals(item)) {
                        if (!player.isAlive()) {
                            player.heal(player.getMaxHP()/2);
                            System.out.println("You used a Revive! Restored to 50% HP.");
                        } else {
                            System.out.println("Revive can only be used when down.");
                        }
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
                    System.out.println("Logic: " + g.getLogic() +  ", Wisdom: " + g.getMaxWisdom());
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
        
        int bossPuzzleUses = 0;
        while(player.isAlive() && opponent.isAlive()) {
            playerTurn(opponent);
            
            if(opponent.isAlive()) {
                
                if (opponent instanceof main.java.com.thelair.guardian.Guardian && 
                    puzzleEngine.shouldTriggerFinisher((main.java.com.thelair.guardian.Guardian) opponent) && bossPuzzleUses < 2) {
                    bossPuzzleUses++;
                    System.out.println("\n💡 " + opponent.getName() + " is weakened! Answer to deal extra damage!");
                    boolean finisherSuccess = puzzleEngine.triggerFinisher(
                        (main.java.com.thelair.guardian.Guardian) opponent, player, scanner);
                    if (finisherSuccess) {
                        int extra = (int)(player.getLogic() * 1.5);
                        opponent.takeDamage(extra);
                        System.out.println("Your answer was correct! Extra damage: " + extra);
                    } else {
                        int regen = Math.min( (int)(opponent.getMaxHP() * 0.20), opponent.getMaxHP() - opponent.getCurrentHP());
                        ((main.java.com.thelair.guardian.Guardian) opponent).heal(regen);
                        System.out.println(opponent.getName() + " regenerates " + regen + " HP!");
                    }
                } else if (!(opponent instanceof main.java.com.thelair.guardian.Guardian)) {
                    // Minion chance to ask a theme question; reward random item on success
                    if (new java.util.Random().nextInt(100) < 30) { // 30% chance
                        System.out.println("A quick puzzle appears!");
                        // Map puzzle theme based on current guardian in the stage: default Cathy
                        String theme = "Ma'am Cathy";
                        // we cannot access the stage here; approximate based on opponent name wave
                        if (opponent.getName().contains("Sorcerer")) theme = "Sir Khai";
                        if (opponent.getName().contains("Thieves")) theme = "Serato";
                        if (opponent.getName().contains("Dire Wolves")) theme = "Ma'am Tulin";
                        boolean ok = puzzleEngine.triggerThemeQuestion(theme, scanner);
                        if (ok) {
                            String[] pool = new String[]{"POTION_SMALL","POTION_SMALL","ETHER_SMALL","BOMB"};
                            String reward = pool[new java.util.Random().nextInt(pool.length)];
                            player.addItem(reward);
                            System.out.println("You solved it! Found an item: " + reward);
                        } else {
                            System.out.println("Incorrect. No reward.");
                        }
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
