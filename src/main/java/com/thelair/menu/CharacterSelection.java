package main.java.com.thelair.menu;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.player.AnoosIben;
import main.java.com.thelair.player.GailleAmolong;
import main.java.com.thelair.player.IldeJanFigueras;
import main.java.com.thelair.player.JosephJimenez;
import main.java.com.thelair.player.JamuelBacus;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterSelection {
    public static Player chooseCharacter(Scanner scanner) {
        Player player;

        System.out.println("Choose your character:");
        System.out.println("1) Iben Anoos - The Codebreaker");
        System.out.println("   HP: 400, Logic: 300, Wisdom: 200");
        System.out.println("A quiet thinker who sees through syntax like glass.");
        System.out.println("2) Gaille Amolong - The Architect");
        System.out.println("   HP: 500, Logic: 200, Wisdom: 300");
        System.out.println("A visionary builder who blends creativity with discipline.");
        System.out.println("3) Ilde Jan Figueras - The Challenger");
        System.out.println("   HP: 600, Logic: 100, Wisdom: 200");
        System.out.println("Bold and relentless, charging headfirst into code with sheer determination.");
        System.out.println("4) Joseph Jimenez - The Balanced");
        System.out.println("   HP: 400, Logic: 200, Wisdom: 200");
        System.out.println("A steady learner with no glaring weaknesses, but no flashy strengths.");
        System.out.println("5) Jamuel Bacus - The Tactician");
        System.out.println("   HP: 300, Logic: 200, Wisdom: 400");
        System.out.println("A strategist who plays the long game.");

        int choice;
        while (true){
            try {
                System.out.print("Enter the Player's Number of your choice: ");
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
        return player;
    }
}