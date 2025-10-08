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
        System.out.println("   HP: 70, MP: 70, STR: 8, SPD: 14, INT: 18");
        System.out.println("A quiet thinker who sees through syntax like glass.");
        System.out.println("2) Gaille Amolong - The Architect");
        System.out.println("   HP: 90, MP: 50, STR: 12, SPD: 10, INT: 14");
        System.out.println("A visionary builder who blends creativity with discipline.");
        System.out.println("3) Ilde Jan Figueras - The Challenger");
        System.out.println("   HP: 120, MP: 25, STR: 18, SPD: 9, INT: 7");
        System.out.println("Bold and relentless, charging headfirst into code with sheer determination.");
        System.out.println("4) Joseph Jimenez - The Balanced");
        System.out.println("   HP: 85, MP: 45, STR: 11, SPD: 11, INT: 11");
        System.out.println("A steady learner with no glaring weaknesses, but no flashy strengths.");
        System.out.println("5) Jamuel Bacus - The Tactician");
        System.out.println("   HP: 65, MP: 65, STR: 10, SPD: 12, INT: 17");
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
                player = new AnoosIben("Iben Anoos", 1, 70, 70, 8, 14, 18);
                break;
            case 2:
                player = new GailleAmolong("Gaille Amolong", 1, 90, 50, 12, 10, 14);
                break;
            case 3:
                player = new IldeJanFigueras("Ilde Jan Figueras", 1, 120, 25, 18, 9, 7);
                break;
            case 4:
                player = new JosephJimenez("Joseph Jimenez", 1, 85, 45, 11, 11, 11);
                break;
            case 5:
                player = new JamuelBacus("Jamuel Bacus", 1, 65, 65, 10, 12, 17);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Iben Anoos.");
                player = new AnoosIben("Iben Anoos", 1, 70, 70, 8, 14, 18);
        }
        System.out.println("You have chosen " + player.getName() + " - " + player.getCharacterClass() + "!");
        return player;
    }
}