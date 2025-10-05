package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.CathyGuardian;
import main.java.com.thelair.battle.BattleSystem;

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
		BattleSystem battle = new BattleSystem(player, getGuardian(), scanner);
		battle.startBattle();
	}
}
