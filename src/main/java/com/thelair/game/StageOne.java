package com.thelair.game;

import java.util.Scanner;
import com.thelair.player.Player;
import com.thelair.guardian.CathyGuardian;
import com.thelair.battle.BattleSystem;
import com.thelair.battle.Minion;
import com.thelair.ui.ConsoleUI;
import com.thelair.puzzle.PuzzleEngine;

public class StageOne extends Stage<CathyGuardian> {
	public StageOne() {
		super("NGE 101 – The Hall of Ma'am Cathy", new CathyGuardian());
	}

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner, getWorldIndicator());
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
