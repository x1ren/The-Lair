package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.CathyGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;
import main.java.com.thelair.ui.ConsoleUI;
import main.java.com.thelair.puzzle.PuzzleEngine;

public class StageOne extends Stage<CathyGuardian> {
	public StageOne() {
		super("Stage 1 – The Hall of Flame", new CathyGuardian());
	}

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner);
        PuzzleEngine puzzleEngine = new PuzzleEngine();
        
        // Minion wave: 5 Goblins (HP 40, ATK 5) - easier for testing
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            // 30% chance for random event before each minion
            triggerRandomEvent(player, scanner);
            Minion goblin = new Minion("Goblin #" + i, 40, 5);
            battle.startBattle(goblin, 15);
        }
        
        if (player.isAlive()) {
            // Random event before puzzle sequence
            triggerRandomEvent(player, scanner);
            
            // Main puzzle sequence (3-5 puzzles as per documentation)
            ConsoleUI.section("Before facing Ma'am Cathy, you must prove your knowledge of the fundamentals!");
            boolean puzzleSuccess = puzzleEngine.runPuzzleSequence("Ma'am Cathy", player, scanner);
            
            if (puzzleSuccess && player.isAlive()) {
                // Random event before boss
                triggerRandomEvent(player, scanner);
                battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
            } else {
                System.out.println("You have been defeated by the trials of knowledge!");
            }
        }
	}
}
