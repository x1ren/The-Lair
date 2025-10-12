package main.java.com.thelair.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import main.java.com.thelair.player.Player;

public class GameManager {
	private final List<Stage<?>> stages = new ArrayList<>();

	public GameManager() {
		stages.add(new StageOne());
		stages.add(new StageTwo());
		stages.add(new StageThree());
		stages.add(new StageFour());
	}

	public void run(Player player) {
		for (Stage<?> stage : stages) {
			stage.run(player);
			if (!player.isAlive()) {
				System.out.println("You were defeated. Game Over.");
				return;
			}
			// Simple post-stage upgrade per Character Stats doc
			applyRandomUpgrade(player, stages.indexOf(stage) + 1);
		}
		System.out.println("Stages 1 and 2 complete! (MVP)");
	}

	private void applyRandomUpgrade(Player player, int stageNumber) {
		int min, max;
		switch (stageNumber) {
			case 1: min = 50; max = 70; break;
			case 2: min = 60; max = 80; break;
			case 3: min = 65; max = 85; break;
			case 4: min = 70; max = 90; break;
			case 5: min = 90; max = 100; break;
			default: min = 50; max = 70;
		}
		Random rng = new Random();
		int roll = rng.nextInt((max - min) + 1) + min;
		int category = rng.nextInt(3); // 0 HP, 1 Logic, 2 Wisdom
		switch (category) {
			case 0:
				player.increaseMaxHP(roll);
				System.out.println("Upgrade: +" + roll + " HP");
				break;
			case 1:
				player.increaseLogic(roll);
				System.out.println("Upgrade: +" + roll + " Logic");
				break;
			default:
				player.increaseWisdomStat(roll);
				System.out.println("Upgrade: +" + roll + " Wisdom");
		}
		player.displayStats();
	}
}
