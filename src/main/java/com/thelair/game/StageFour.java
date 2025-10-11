package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.TulinGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;

public class StageFour extends Stage<TulinGuardian> {
	public StageFour() {
		super("Stage 4 – The Dean’s Judgement", new TulinGuardian());
	}

	public void intro() {
		System.out.println(getGuardian().getIntro());
	}

	public void run(Player player) {
		intro();
		Scanner scanner = new Scanner(System.in);
        BattleSystem battle = new BattleSystem(player, scanner);
        // Minion wave: 5 Dire Wolves (HP 80, ATK 12)
        for (int i = 1; i <= 5 && player.isAlive(); i++) {
            Minion direWolves = new Minion("Dire Wolves #" + i, 80, 12);
            battle.startBattle(direWolves, 25);
        }
        if (player.isAlive()) {
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        }
	}
}
