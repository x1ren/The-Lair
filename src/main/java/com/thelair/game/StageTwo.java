package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.KhaiGuardian;
import main.java.com.thelair.battle.BattleSystem;

public class StageTwo extends Stage<KhaiGuardian> {
	public StageTwo() {
		super("Stage 2 – The Hall of Order", new KhaiGuardian());
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
