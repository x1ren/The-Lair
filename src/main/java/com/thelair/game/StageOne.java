package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.CathyGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;

public class StageOne extends Stage<CathyGuardian> {
	public StageOne() {
		super("Stage 1 – The Hall of Flame", new CathyGuardian());
	}

	public void intro() {
		System.out.println(getGuardian().getIntro());
	}

	public void run(Player player) {
		intro();
		Scanner scanner = new Scanner(System.in);
        BattleSystem battle = new BattleSystem(player, scanner);
        // Minion wave: 5 Goblins (HP 40, ATK 5)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            Minion goblin = new Minion("Goblin #" + i, 40, 5);
            battle.startBattle(goblin, 10);
        }
        if (player.isAlive()) {
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        }
	}
}
