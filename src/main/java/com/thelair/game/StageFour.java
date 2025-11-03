package com.thelair.game;

import java.util.Scanner;
import com.thelair.ui.ConsoleUI;
import com.thelair.player.Player;
import com.thelair.guardian.TulinGuardian;
import com.thelair.battle.BattleSystem;
import com.thelair.battle.Minion;
import com.thelair.puzzle.PuzzleEngine;

public class StageFour extends Stage<TulinGuardian> {
	public StageFour() {
        super("Stage 4 – The Keeper of Knowledge", new TulinGuardian());
	}

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner);
        PuzzleEngine puzzleEngine = new PuzzleEngine();
        
        // Minion wave: 5 Dire Wolves (HP 80, ATK 12)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            // 30% chance for random event before each minion
            triggerRandomEvent(player, scanner);
            Minion direWolves = new Minion("Dire Wolves #" + i, 80, 12);
            battle.startBattle(direWolves, 55);
        }
        
        if (player.isAlive()) {
            // Random event before puzzle sequence
            triggerRandomEvent(player, scanner);
            
            // Main puzzle sequence (3-5 puzzles as per documentation)
            ConsoleUI.section("Before facing Ma'am Tulin, you must prove your knowledge of Information Systems!");
            boolean puzzleSuccess = puzzleEngine.runPuzzleSequence("Ma'am Tulin", player, scanner);
            
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
