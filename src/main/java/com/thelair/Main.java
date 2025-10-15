package main.java.com.thelair;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.menu.CharacterSelection;
import main.java.com.thelair.game.GameManager;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Story introduction
		System.out.println("========================================");
		System.out.println("          WELCOME TO THE LAIR");
		System.out.println("========================================");
		System.out.println();
		System.out.println("In a world where magic is written in code and power is measured in logic,");
		System.out.println("there stands the grand citadel of learning known as Cebu Institute of Technology University.");
		System.out.println("To the outside world, it is a school, but to those who walk its halls,");
		System.out.println("it is a proving ground for the next generation of digital pioneers.");
		System.out.println();
		System.out.println("A new student arrives, fresh from high school, ready to master the arcane arts");
		System.out.println("of Information Technology and earn a degree. But this is no ordinary education.");
		System.out.println("The path to graduation is a legendary quest, a series of seven great trials,");
		System.out.println("each overseen by a formidable instructor who guards their knowledge with skill and wisdom.");
		System.out.println();
		System.out.println("To succeed, one must journey through realms of programming, conquer challenges of data,");
		System.out.println("and command the very foundations of technology. The greatest tests lie not in simple exams,");
		System.out.println("but in battles of wit and creativity against the masters themselves.");
		System.out.println();
		System.out.println("The first trial awaits. The quest for knowledge begins now.");
		System.out.println();
		System.out.println("----- ALL HAIL MAROON AND GOLD -----");
		System.out.println();

		Player player = CharacterSelection.chooseCharacter(scanner);

		GameManager manager = new GameManager(scanner);
		manager.run(player);
		scanner.close();
	}
}  