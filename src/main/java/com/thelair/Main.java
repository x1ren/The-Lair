package main.java.com.thelair;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.player.AnoosIben;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.guardian.Guardian;
import main.java.com.thelair.menu.CharacterSelection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = CharacterSelection.chooseCharacter(scanner);

        Guardian guardian = new Guardian("Goblin", 1, 50, 10, 8, 0);
        BattleSystem battleSystem = new BattleSystem(player, guardian, scanner);
        battleSystem.startBattle();
        scanner.close();
    }
}  