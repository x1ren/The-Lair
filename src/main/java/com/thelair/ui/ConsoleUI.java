package main.java.com.thelair.ui;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.battle.Combatant;

public final class ConsoleUI {
    private static final int WIDTH = 70;

    // ANSI colors
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    private ConsoleUI() {}

    private static String repeat(char ch, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) sb.append(ch);
        return sb.toString();
    }

    private static String center(String text, int width) {
        if (text == null) text = "";
        if (text.length() >= width) return text;
        int pad = (width - text.length()) / 2;
        return repeat(' ', pad) + text;
    }

    public static String color(String text, String color) {
        return color + text + RESET;
    }

    public static void divider() {
        System.out.println(repeat('-', WIDTH));
    }

    public static void thickDivider() {
        System.out.println(repeat('=', WIDTH));
    }

    public static void header(String title) {
        thickDivider();
        System.out.println(center(BOLD + title.toUpperCase() + RESET, WIDTH));
        thickDivider();
        System.out.println();
    }

    public static void section(String title) {
        divider();
        System.out.println(center(CYAN + title + RESET, WIDTH));
        divider();
        System.out.println();
    }

    public static void prompt(String text) {
        System.out.print(text + " ");
    }

    public static void menu(String title, String[] options) {
        System.out.println();
        section(title);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("  %d. %s%n", i + 1, options[i]);
        }
    }

    public static void printCharacterOption(int index, String name, String role, int hp, int logic, int wisdom, String description) {
        System.out.printf("%d) %s - %s%n", index, name, role);
        System.out.printf("   HP: %d, Logic: %d, Wisdom: %d%n", hp, logic, wisdom);
        System.out.println(description);
        System.out.println();
    }

    public static void battleHUD(Player player, Combatant opponent) {
        String playerHp = color("" + player.getCurrentHP() + "/" + player.getMaxHP(), GREEN);
        String playerMp = color("" + player.getWisdomStat(), BLUE);
        String enemyHp = color("" + opponent.getCurrentHP() + "/" + opponent.getMaxHP(), RED);
        System.out.printf("%nPlayer HP: %s  |  Wisdom: %s%n", playerHp, playerMp);
        System.out.printf("%s HP: %s%n", opponent.getName(), enemyHp);
    }
}


