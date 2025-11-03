package com.thelair;

import com.thelair.player.Player;
import com.thelair.menu.CharacterSelection;
import com.thelair.game.GameManager;
import com.thelair.ui.ConsoleUI;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean playAgain;

		do {
			// Story introduction with Star Wars-style animation
			ConsoleUI.animateText(ConsoleUI.getHeader("WELCOME TO THE LAIR"), 10);
			ConsoleUI.animateText(ConsoleUI.getBlankLine(), 40);

			String storyText = "In a world where magic is written in code and power is measured in logic,\n" +
				"there stands the grand citadel of learning known as Cebu Institute of Technology University.\n" +
				"To the outside world, it is a school, but to those who walk its halls,\n" +
				"it is a proving ground for the next generation of digital pioneers.\n\n" +
				"A new student arrives, fresh from high school, ready to master the arcane arts\n" +
				"of Information Technology and earn a degree. But this is no ordinary education.\n" +
				"The path to graduation is a legendary quest, a series of seven great trials,\n" +
				"each overseen by a formidable instructor who guards their knowledge with skill and wisdom.\n\n" +
				"To succeed, one must journey through realms of programming, conquer challenges of data,\n" +
				"and command the very foundations of technology. The greatest tests lie not in simple exams,\n" +
				"but in battles of wit and creativity against the masters themselves.\n\n" +
				"The first trial awaits. The quest for knowledge begins now.\n\n";

			// Skip narration option
			ConsoleUI.menu("Game Start", new String[]{
				"Watch full narration",
				"Skip narration"
			});
			ConsoleUI.prompt("Enter choice:");
			int narrationChoice;
			try {
				narrationChoice = Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				narrationChoice = 1;
			}

			if (narrationChoice == 1) {
				ConsoleUI.animateText(storyText, 50);
			} else {
				System.out.println("Narration skipped.");
			}

			Player player = CharacterSelection.chooseCharacter(scanner);

			GameManager manager = new GameManager(scanner);
			manager.run(player);

			// Play again prompt
			System.out.println();
			ConsoleUI.menu("Game Over", new String[]{
				"Play Again",
				"Exit"
			});
			ConsoleUI.prompt("Enter choice:");
			int playAgainChoice;
			try {
				playAgainChoice = Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				playAgainChoice = 2;
			}
			playAgain = (playAgainChoice == 1);
		} while (playAgain);

		scanner.close();
	}
}  