package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.ui.ConsoleUI;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.SeratoGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;

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
        // Minion wave: 5 Thieves (HP 50, ATK 8)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            Minion thieves = new Minion("Thieves #" + i, 50, 8);
            battle.startBattle(thieves, 20);
        }
        if (player.isAlive()) {
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        }
	}
}
