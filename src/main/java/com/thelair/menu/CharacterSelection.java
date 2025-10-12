package main.java.com.thelair.menu;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.player.AnoosIben;
import main.java.com.thelair.player.GailleAmolong;
import main.java.com.thelair.player.IldeJanFigueras;
import main.java.com.thelair.player.JosephJimenez;
import main.java.com.thelair.player.JamuelBacus;
import main.java.com.thelair.ui.ConsoleUI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterSelection {
    public static Player chooseCharacter(Scanner scanner) {
        Player player;

        ConsoleUI.header("Choose your character");
        ConsoleUI.printCharacterOption(1, "Iben Anoos", "The Codebreaker", 400, 60, 200,
                "A quiet thinker who sees through syntax like glass.");
        ConsoleUI.printCharacterOption(2, "Gaille Amolong", "The Architect", 500, 50, 300,
                "A visionary builder who blends creativity with discipline.");
        ConsoleUI.printCharacterOption(3, "Ilde Jan Figueras", "The Challenger", 600, 40, 200,
                "Bold and relentless, charging headfirst into code with sheer determination.");
        ConsoleUI.printCharacterOption(4, "Joseph Jimenez", "The Balanced", 400, 50, 200,
                "A steady learner with no glaring weaknesses, but no flashy strengths.");
        ConsoleUI.printCharacterOption(5, "Jamuel Bacus", "The Tactician", 300, 50, 400,
                "A strategist who plays the long game.");

        int choice;
        while (true){
            try {
                ConsoleUI.prompt("Enter the Player's Number of your choice:");
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Invalid input! Please try again.");
                
            }
        }
        scanner.nextLine();
        
        switch(choice) {
            case 1:
                player = new AnoosIben("Iben Anoos", 1, 0, 0, 0, 0, 0);
                break;
            case 2:
                player = new GailleAmolong("Gaille Amolong", 1, 0, 0, 0, 0, 0);
                break;
            case 3:
                player = new IldeJanFigueras("Ilde Jan Figueras", 1, 0, 0, 0, 0, 0);
                break;
            case 4:
                player = new JosephJimenez("Joseph Jimenez", 1, 0, 0, 0, 0, 0);
                break;
            case 5:
                player = new JamuelBacus("Jamuel Bacus", 1, 0, 0, 0, 0, 0);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Iben Anoos.");
                player = new AnoosIben("Iben Anoos", 1, 0, 0, 0, 0, 0);
        }
        System.out.println("You have chosen " + player.getName() + " - " + player.getCharacterClass() + "!");
        // Seed starter items
        player.addItem("POTION_SMALL");
        player.addItem("ETHER_SMALL");
        player.addItem("BOMB");
        System.out.println();
        return player;
    }
}