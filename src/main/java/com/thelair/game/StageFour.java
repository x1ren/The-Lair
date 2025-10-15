package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.ui.ConsoleUI;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.TulinGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;

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
        // Minion wave: 5 Dire Wolves (HP 80, ATK 12)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            // 30% chance for random event before each minion
            triggerRandomEvent(player, scanner);
            Minion direWolves = new Minion("Dire Wolves #" + i, 80, 12);
            battle.startBattle(direWolves, 55);
        }
        if (player.isAlive()) {
            // Random event before boss
            triggerRandomEvent(player, scanner);
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        }
	}
}
