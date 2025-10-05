package main.java.com.thelair;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.menu.CharacterSelection;
import main.java.com.thelair.game.GameManager;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player = CharacterSelection.chooseCharacter(scanner);

		GameManager manager = new GameManager();
		manager.run(player);
		scanner.close();
	}
}  