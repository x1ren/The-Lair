package main.java.com.thelair;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.menu.CharacterSelection;
import main.java.com.thelair.game.GameManager;
import main.java.com.thelair.ui.ConsoleUI;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Story introduction with Star Wars-style animation
		ConsoleUI.animateText("========================================", 50);
		ConsoleUI.animateText("          WELCOME TO THE LAIR", 50);
		ConsoleUI.animateText("========================================", 50);
		ConsoleUI.animateText("", 100);

		String[] storyLines = {
			"In a world where magic is written in code and power is measured in logic,",
			"there stands the grand citadel of learning known as Cebu Institute of Technology University.",
			"To the outside world, it is a school, but to those who walk its halls,",
			"it is a proving ground for the next generation of digital pioneers.",
			"",
			"A new student arrives, fresh from high school, ready to master the arcane arts",
			"of Information Technology and earn a degree. But this is no ordinary education.",
			"The path to graduation is a legendary quest, a series of seven great trials,",
			"each overseen by a formidable instructor who guards their knowledge with skill and wisdom.",
			"",
			"To succeed, one must journey through realms of programming, conquer challenges of data,",
			"and command the very foundations of technology. The greatest tests lie not in simple exams,",
			"but in battles of wit and creativity against the masters themselves.",
			"",
			"The first trial awaits. The quest for knowledge begins now.",
			"",
			"----- ALL HAIL MAROON AND GOLD -----"
		};

		ConsoleUI.animateStory(storyLines, 50);

		Player player = CharacterSelection.chooseCharacter(scanner);

		GameManager manager = new GameManager(scanner);
		manager.run(player);
		scanner.close();
	}
}  