package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.KhaiGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;
import main.java.com.thelair.ui.ConsoleUI;
import main.java.com.thelair.puzzle.PuzzleEngine;

public class StageTwo extends Stage<KhaiGuardian> {
	public StageTwo() {
		super("Stage 2 – The Hall of Order", new KhaiGuardian());
	}

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner);
        PuzzleEngine puzzleEngine = new PuzzleEngine();
        
        // Minion wave: 5 Sorcerers (HP 60, ATK 10)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            // 30% chance for random event before each minion
            triggerRandomEvent(player, scanner);
            Minion sorc = new Minion("Sorcerer #" + i, 60, 10);
            battle.startBattle(sorc, 35);
        }
        
        if (player.isAlive()) {
            // Random event before puzzle sequence
            triggerRandomEvent(player, scanner);
            
            // Main puzzle sequence (3-5 puzzles as per documentation)
            ConsoleUI.section("Before facing Sir Khai, you must prove your knowledge of Object-Oriented Programming!");
            boolean puzzleSuccess = puzzleEngine.runPuzzleSequence("Sir Khai", player, scanner);
            
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
