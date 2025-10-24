package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.ui.ConsoleUI;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.SeratoGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;
import main.java.com.thelair.puzzle.PuzzleEngine;

public class StageThree extends Stage<SeratoGuardian> {
	public StageThree() {
		super("Stage 3 – The Buglord Compiler", new SeratoGuardian());
	}

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner);
        PuzzleEngine puzzleEngine = new PuzzleEngine();
        
        // Minion wave: 5 Thieves (HP 50, ATK 8)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            // 30% chance for random event before each minion
            triggerRandomEvent(player, scanner);
            Minion thieves = new Minion("Thieves #" + i, 50, 8);
            battle.startBattle(thieves, 45);
        }
        
        if (player.isAlive()) {
            // Random event before puzzle sequence
            triggerRandomEvent(player, scanner);
            
            // Main puzzle sequence (3-5 puzzles as per documentation)
            ConsoleUI.section("Before facing Serato, you must prove your knowledge of Debugging and Data Structures!");
            boolean puzzleSuccess = puzzleEngine.runPuzzleSequence("Serato", player, scanner);
            
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
