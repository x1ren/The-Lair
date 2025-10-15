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

		ConsoleUI.animateText(storyText, 50);

		Player player = CharacterSelection.chooseCharacter(scanner);

		GameManager manager = new GameManager(scanner);
		manager.run(player);
		scanner.close();
	}
}  