package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.DeanGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.ui.ConsoleUI;
import main.java.com.thelair.puzzle.PuzzleEngine;

public class StageFive extends Stage<DeanGuardian> {
    public StageFive() {
        super("Stage 5 – The Dean’s Judgement", new DeanGuardian());
    }

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner);
        PuzzleEngine puzzleEngine = new PuzzleEngine();
        
        // Random event before puzzle sequence
        triggerRandomEvent(player, scanner);
        
        // Main puzzle sequence (3-5 puzzles as per documentation) - Dean combines all knowledge
        ConsoleUI.section("Before facing the Dean, you must prove your mastery of ALL subjects!");
        boolean puzzleSuccess = puzzleEngine.runPuzzleSequence("Dean", player, scanner);
        
        if (puzzleSuccess && player.isAlive()) {
            // Random event before the final boss
            triggerRandomEvent(player, scanner);
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        } else {
            System.out.println("You have been defeated by the ultimate trials of knowledge!");
        }
    }
}


