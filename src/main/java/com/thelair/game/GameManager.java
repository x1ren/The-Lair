package com.thelair.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.thelair.player.Player;
import com.thelair.ui.ConsoleUI;

public class GameManager {
    private final List<Stage<?>> stages = new ArrayList<>();
    private final Scanner scanner;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
        stages.add(new StageOne());
        stages.add(new StageTwo());
        stages.add(new StageThree());
        stages.add(new StageFour());
        stages.add(new StageFive());
    }

    public void run(Player player) {
		for (Stage<?> stage : stages) {
            stage.run(player, scanner);
			if (!player.isAlive()) {
				System.out.println("You were defeated. Game Over.");
				return;
			}
            int stageNumber = stages.indexOf(stage) + 1;

			// Stage transition narrative
			if (stageNumber < stages.size()) {
				System.out.println();
				System.out.println("As you emerge victorious from " + stage.getStageName() + ",");
				System.out.println("you feel the weight of knowledge growing within you.");
				System.out.println("The next chamber beckons, holding even greater challenges...");
				System.out.println();
			}

            applyChosenUpgrade(player, stageNumber);
		}
        ConsoleUI.header("Stages 1–5 complete! GG");
		System.out.println("You have proven your mastery of the arcane arts of Information Technology!");
		System.out.println("The faculty recognizes your dedication and grants you your degree.");
		System.out.println("Congratulations, graduate! Your journey in The Lair is complete.");
	}

    private void applyChosenUpgrade(Player player, int stageNumber) {
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
        ConsoleUI.menu("Choose your upgrade (Stage " + stageNumber + ")", new String[]{
            "+HP",
            "+Logic",
            "+Wisdom"
        });
        ConsoleUI.prompt("Enter choice:");
        int category;
        try {
            category = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (Exception e) {
            category = 0;
        }
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
