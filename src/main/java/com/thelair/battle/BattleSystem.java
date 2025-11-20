package com.thelair.battle;

import com.thelair.player.Player;
import com.thelair.player.Skill;
import com.thelair.guardian.Guardian;
import com.thelair.puzzle.PuzzleEngine;
import com.thelair.ui.ConsoleUI;
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

    private int safeNextInt(int min, int max, String prompt) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Invalid choice! Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a number.");
            }
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
        int choice = safeNextInt(1, 5, "Enter choice:"); 
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
                ConsoleUI.displaySkillsTable(player.getSkills(), player);
                int sIdx = safeNextInt(1, player.getSkills().length, "Choose skill:");
                int sSel = sIdx - 1;
                Skill s = player.getSkills()[sSel];
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
                int damage = 0;
                if ("DBG_EYE".equals(s.getId())) {
                    // Debugger’s Eye: apply enemyDefenseDown for 3 turns
                    if (opponent instanceof Guardian) {
                        ((Guardian) opponent).applyStatusEffect("enemyDefenseDown", 3);
                    }
                    System.out.println("You used " + s.getName() + " and reduced enemy defense!");
                    damage = player.useSignatureSkill();
                } else if ("SYN_SLAYER".equals(s.getId())) {
                    // Syntax Slayer: check for enemyDefenseDown and double damage if present
                    damage = player.useSignatureSkill();
                    if (opponent instanceof Guardian &&
                        ((Guardian) opponent).hasStatusEffect("enemyDefenseDown")) {
                        damage *= 2;
                        System.out.println("Enemy defense is down! Damage doubled!");
                    } else {
                        damage = (int) (damage * 1.5);
                        System.out.println("Syntax Slayer deals 1.5x damage!");
                    }
                } else if ("BLUEPRINT_MIND".equals(s.getId())) {
                    // Blueprint Mind: apply logicBuff for 2 turns
                    player.applyStatusEffect("logicBuff", 2);
                    System.out.println("You used " + s.getName() + " and boosted your Logic for 2 turns!");
                    damage = player.useSignatureSkill();
                } else if ("GOD_MODE".equals(s.getId())) {
                    // Debug hero god mode - instant defeat
                    damage = opponent.getCurrentHP() + 1000; // More than enough to kill anything
                    System.out.println("GOD MODE ACTIVATED! Enemy obliterated!");
                } else if ("INFINITE_WISDOM".equals(s.getId())) {
                    // Debug hero infinite wisdom
                    player.restoreWisdom(player.getMaxWisdom());
                    System.out.println("Infinite Wisdom! All Wisdom restored!");
                    damage = player.useSignatureSkill();
                } else if ("PERFECT_DEFENSE".equals(s.getId())) {
                    // Debug hero perfect defense
                    player.applyStatusEffect("perfectDefense", 1); // Lasts 1 turn
                    System.out.println("Perfect Defense! You are invincible this turn!");
                    // Don't deal damage, but apply defense effect
                    damage = 0;
                } else {
                    // Other skills just deal base damage for now
                    damage = player.useSignatureSkill();
                }
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
                ConsoleUI.displayItemsTable(player.getInventory());
                if (player.getInventory().isEmpty()) {
                    break;
                }
                java.util.List<String> itemKeys = new java.util.ArrayList<>(player.getInventory().keySet());
                int idx = safeNextInt(1, itemKeys.size(), "Choose item number:");
                int sel = idx - 1;
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
                if (opponent instanceof Guardian) {
                    Guardian g = (Guardian) opponent;
                    System.out.println("Logic: " + g.getLogic() +  ", Wisdom: " + g.getMaxWisdom());
                }
                break;
            default:
                System.out.println("Invalid choice! You lose your turn.");
        }
    }

    private void opponentTurn(Combatant opponent) {
        int damage = opponent.attack();

        // Check if debug hero has perfect defense active
        if (player.hasStatusEffect("perfectDefense")) {
            System.out.println("Perfect Defense blocks all damage!");
            damage = 0;
        }

        player.takeDamage(damage);
        if (damage > 0) {
            System.out.println("The " + opponent.getName() + " attacks you for " + damage + " damage!");
        }
    }
    
    public void startBattle(Combatant opponent, Integer experienceReward) {
       
        String battleIntro;
        if (opponent instanceof Guardian) {
            String guardianName = opponent.getName();
            switch(guardianName) {
                case "Ma'am Cathy":
                    battleIntro = "Ma'am Cathy emerges from the flames:\n'This is very easy guys. Dali ra kaau ni ihuman ninyo.'\n'You dare challenge the fundamentals?'";
                    break;
                case "Sir Khai":
                    battleIntro = "Sir Khai stands firm in the Hall of Order:\n'Object-oriented principles will be your downfall!'\n'Order is not restriction — it is understanding.'";
                    break;
                case "Serato":
                    battleIntro = "Serato materializes from swirling code:\n'Your code is messy! Let me teach you proper structure!'\n'Discipline without strength is tyranny.'";
                    break;
                case "Ma'am Tulin":
                    battleIntro = "Ma'am Tulin appears surrounded by data streams:\n'Data is everything! Prove you can manage it!'\n'Information is power. Show me you can wield it.'";
                    break;
                case "Dean":
                    battleIntro = "Dean emerges as the ultimate authority:\n'I am the final test! Show me you've learned everything!'\n'I have watched you grow. Now prove your mastery.'";
                    break;
                default:
                    battleIntro = "A wild " + opponent.getName() + " appears!";
            }
        } else {
            battleIntro = "A wild " + opponent.getName() + " appears!";
        }
        
        ConsoleUI.section(battleIntro);
        
        int bossPuzzleUses = 0;
        int maxBossPuzzles = 3;
        while(player.isAlive() && opponent.isAlive()) {
            playerTurn(opponent);
            
            if(opponent.isAlive()) {
                
                if (opponent instanceof Guardian && 
                    puzzleEngine.shouldTriggerFinisher((Guardian) opponent) && bossPuzzleUses < maxBossPuzzles) {
                    bossPuzzleUses++;
                    System.out.println("\n💡 " + opponent.getName() + " is weakened! Answer to deal extra damage!");
                    System.out.println("Boss puzzle " + bossPuzzleUses + "/" + maxBossPuzzles);
                    boolean finisherSuccess = puzzleEngine.triggerFinisher(
                        (Guardian) opponent, player, scanner);
                    if (finisherSuccess) {
                        int extra = (int)(player.getLogic() * 1.5);
                        opponent.takeDamage(extra);
                        System.out.println("Your answer was correct! Extra damage: " + extra);
                    } else {
                        int regen = Math.min( (int)(opponent.getMaxHP() * 0.20), opponent.getMaxHP() - opponent.getCurrentHP());
                        ((Guardian) opponent).heal(regen);
                        System.out.println(opponent.getName() + " regenerates " + regen + " HP!");
                    }
                } else if (!(opponent instanceof Guardian)) {
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
            
            // tick cooldowns and status effects at end of round
            player.tickCooldowns();
            if (opponent instanceof Guardian) {
                ((Guardian) opponent).tickStatusEffects();
            }
            ConsoleUI.battleHUD(player, opponent);
        }
        
        if(player.isAlive()) {
            String victoryMessage = "";
            if (opponent instanceof Guardian) {
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
            if (opponent instanceof Guardian) {
                defeatMessage = opponent.getName() + " stands victorious: 'Come back when you're ready to learn!'";
            } else {
                defeatMessage = "You were defeated by the " + opponent.getName() + "...";
            }
            System.out.println(defeatMessage);
        }
    }
}
