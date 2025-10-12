package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.KhaiGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;
import main.java.com.thelair.ui.ConsoleUI;

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
        // Minion wave: 5 Sorcerers (HP 60, ATK 10)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            Minion sorc = new Minion("Sorcerer #" + i, 60, 10);
            battle.startBattle(sorc, 15);
        }
        if (player.isAlive()) {
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        }
	}
}
