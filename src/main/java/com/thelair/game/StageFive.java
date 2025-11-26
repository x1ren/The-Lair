package com.thelair.game;

import java.util.Scanner;
import com.thelair.player.Player;
import com.thelair.guardian.DeanGuardian;
import com.thelair.battle.BattleSystem;
import com.thelair.ui.ConsoleUI;
import com.thelair.puzzle.PuzzleEngine;

public class StageFive extends Stage<DeanGuardian> {
    public StageFive() {
        super("CCS FACULTY – The Dean's Office", new DeanGuardian());
    }

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        BattleSystem battle = new BattleSystem(player, scanner, getWorldIndicator());
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


