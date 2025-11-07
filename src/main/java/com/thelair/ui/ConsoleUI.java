package com.thelair.ui;

import com.thelair.player.Player;
import com.thelair.battle.Combatant;
import com.thelair.player.Skill;

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

    public static String getDivider() {
        return repeat('-', WIDTH) + "\n";
    }

    public static String getThickDivider() {
        return repeat('=', WIDTH) + "\n";
    }

    public static String getBlankLine() {
        return "\n";
    }

    public static String getCenteredText(String text) {
        return center(text, WIDTH) + "\n";
    }

    public static void header(String title) {
        thickDivider();
        System.out.println(center(BOLD + title.toUpperCase() + RESET, WIDTH));
        thickDivider();
        System.out.println();
    }

    public static String getHeader(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeat('=', WIDTH)).append("\n");
        sb.append(center(BOLD + title.toUpperCase() + RESET, WIDTH)).append("\n");
        sb.append(repeat('=', WIDTH)).append("\n");
        return sb.toString();
    }

    public static void section(String title) {
        divider();
        System.out.println(center(CYAN + title + RESET, WIDTH));
        divider();
        System.out.println();
    }

    public static String getSection(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeat('-', WIDTH)).append("\n");
        sb.append(center(CYAN + title + RESET, WIDTH)).append("\n");
        sb.append(repeat('-', WIDTH)).append("\n");
        return sb.toString();
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
        String playerWisdom = color("" + player.getCurrentWisdom() + "/" + player.getMaxWisdom(), BLUE);
        String enemyHp = color("" + opponent.getCurrentHP() + "/" + opponent.getMaxHP(), RED);
        System.out.printf("%nPlayer HP: %s  |  Wisdom: %s%n", playerHp, playerWisdom);
        System.out.printf("%s HP: %s%n", opponent.getName(), enemyHp);
    }

    /**
     * Displays text with a typewriter animation effect (Star Wars style).
     * @param text The text to animate
     * @param delayMs Delay between each character in milliseconds
     */
    public static void animateText(String text, int delayMs) {
        if (text == null) return;

        // Handle multi-line text by splitting on newlines
        String[] lines = text.split("\n");
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                System.out.print(line.charAt(i));
                System.out.flush();

                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println(); // New line at end of each line
        }
    }

    /**
     * Displays multiple lines of text with animation, with paragraph breaks.
     */
    public static void animateStory(String[] lines, int delayMs) {
        for (String line : lines) {
            animateText(line, delayMs);
            try {
                Thread.sleep(delayMs * 2); // Slightly longer pause between lines
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * Displays items in a formatted table.
     * @param inventory Map of item names to quantities
     */
    public static void displayItemsTable(java.util.Map<String, Integer> inventory) {
        if (inventory == null || inventory.isEmpty()) {
            System.out.println("Your bag is empty.");
            return;
        }

        java.util.List<String> itemKeys = new java.util.ArrayList<>(inventory.keySet());
        
        // Format item names for display (replace underscores with spaces, capitalize)
        java.util.List<String> formattedNames = new java.util.ArrayList<>();
        int maxNameLength = 0;
        for (String key : itemKeys) {
            String formatted = formatItemName(key);
            formattedNames.add(formatted);
            if (formatted.length() > maxNameLength) {
                maxNameLength = formatted.length();
            }
        }
        
        // Calculate column widths (ensure they fit within WIDTH)
        int numWidth = 3;  // "#" column
        int nameWidth = Math.max(Math.min(maxNameLength, 35), 20);  // Item name column (20-35 chars)
        int qtyWidth = 8;  // Quantity column
        
        // Print header
        System.out.println();
        System.out.println(color(BOLD + "INVENTORY" + RESET, CYAN));
        
        // Print table top border
        printTableDivider(numWidth, nameWidth, qtyWidth, true);
        
        // Print table header row
        System.out.printf("| %-" + numWidth + "s | %-" + nameWidth + "s | %-" + qtyWidth + "s |%n",
            color(BOLD + "#" + RESET, YELLOW),
            color(BOLD + "Item Name" + RESET, YELLOW),
            color(BOLD + "Quantity" + RESET, YELLOW));
        
        // Print separator between header and data
        printTableDivider(numWidth, nameWidth, qtyWidth, false);
        
        // Print items
        for (int i = 0; i < itemKeys.size(); i++) {
            String itemName = formattedNames.get(i);
            int quantity = inventory.get(itemKeys.get(i));
            System.out.printf("| %-" + numWidth + "d | %-" + nameWidth + "s | %-" + qtyWidth + "d |%n",
                i + 1,
                itemName,
                quantity);
        }
        
        // Print table bottom border
        printTableDivider(numWidth, nameWidth, qtyWidth, true);
        System.out.println();
    }

    /**
     * Prints a divider line for the items table.
     * @param isOuter true for top/bottom borders (+---+), false for separators (+---+)
     */
    private static void printTableDivider(int numWidth, int nameWidth, int qtyWidth, boolean isOuter) {
        char corner = isOuter ? '+' : '+';
        char line = '-';
        char join = '+';
        
        System.out.print(corner);
        System.out.print(repeat(line, numWidth + 2));
        System.out.print(join);
        System.out.print(repeat(line, nameWidth + 2));
        System.out.print(join);
        System.out.print(repeat(line, qtyWidth + 2));
        System.out.println(corner);
    }

    /**
     * Formats item name for display (e.g., "POTION_SMALL" -> "Small Potion")
     */
    private static String formatItemName(String itemKey) {
        if (itemKey == null) return "";
        
        // Replace underscores with spaces
        String formatted = itemKey.replace("_", " ");
        
        // Convert to title case (first letter of each word capitalized)
        String[] words = formatted.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                result.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    result.append(words[i].substring(1));
                }
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }

    /**
     * Displays skills in a formatted table with cooldown information.
     * @param skills Array of skills to display
     * @param player Player object to get cooldown and wisdom information
     */
    public static void displaySkillsTable(Skill[] skills, 
                                          Player player) {
        if (skills == null || skills.length == 0) {
            System.out.println("No skills available.");
            return;
        }

        // Calculate column widths
        int numWidth = 3;  // "#" column
        int nameWidth = 0;
        int costWidth = 6;  // "Cost" column
        int cdWidth = 4;  // "CD" column (for max cooldown)
        int statusWidth = 0;
        
        // Find max lengths
        for (Skill s : skills) {
            if (s.getName().length() > nameWidth) {
                nameWidth = s.getName().length();
            }
        }
        nameWidth = Math.max(Math.min(nameWidth, 30), 15);  // 15-30 chars
        
        // Status column needs to fit "Available" or "CD: X turns"
        statusWidth = 15;
        
        // Print header
        System.out.println();
        System.out.println(color(BOLD + "AVAILABLE SKILLS" + RESET, CYAN));
        
        // Print table top border
        printSkillsTableDivider(numWidth, nameWidth, costWidth, cdWidth, statusWidth, true);
        
        // Print table header row
        System.out.printf("| %-" + numWidth + "s | %-" + nameWidth + "s | %-" + costWidth + "s | %-" + cdWidth + "s | %-" + statusWidth + "s |%n",
            color(BOLD + "#" + RESET, YELLOW),
            color(BOLD + "Skill Name" + RESET, YELLOW),
            color(BOLD + "Cost" + RESET, YELLOW),
            color(BOLD + "CD" + RESET, YELLOW),
            color(BOLD + "Status" + RESET, YELLOW));
        
        // Print separator between header and data
        printSkillsTableDivider(numWidth, nameWidth, costWidth, cdWidth, statusWidth, false);
        
        // Print skills
        for (int i = 0; i < skills.length; i++) {
            Skill s = skills[i];
            int cdLeft = player.getCooldown(s.getId());
            boolean isOnCooldown = cdLeft > 0;
            boolean canAfford = player.getCurrentWisdom() >= s.getMpCost();
            
            // Format status
            String status;
            String statusColor;
            if (isOnCooldown) {
                status = "CD: " + cdLeft + " turn" + (cdLeft != 1 ? "s" : "");
                statusColor = RED;
            } else if (!canAfford) {
                status = "Not enough MP";
                statusColor = YELLOW;
            } else {
                status = "Available";
                statusColor = GREEN;
            }
            
            // Color skill name based on availability
            String skillNameColor = (isOnCooldown || !canAfford) ? "" : "";
            String skillName = skillNameColor + s.getName() + RESET;
            
            System.out.printf("| %-" + numWidth + "d | %-" + nameWidth + "s | %-" + costWidth + "d | %-" + cdWidth + "d | %-" + statusWidth + "s |%n",
                i + 1,
                skillName,
                s.getMpCost(),
                s.getCooldown(),
                color(status, statusColor));
        }
        
        // Print table bottom border
        printSkillsTableDivider(numWidth, nameWidth, costWidth, cdWidth, statusWidth, true);
        
        // Print descriptions below table
        System.out.println();
        System.out.println(color(BOLD + "Skill Descriptions:" + RESET, CYAN));
        for (int i = 0; i < skills.length; i++) {
            Skill s = skills[i];
            System.out.printf("  %d. %s: %s%n", i + 1, s.getName(), s.getDescription());
        }
        System.out.println();
    }

    /**
     * Prints a divider line for the skills table.
     */
    private static void printSkillsTableDivider(int numWidth, int nameWidth, int costWidth, int cdWidth, int statusWidth, boolean isOuter) {
        char corner = '+';
        char line = '-';
        char join = '+';
        
        System.out.print(corner);
        System.out.print(repeat(line, numWidth + 2));
        System.out.print(join);
        System.out.print(repeat(line, nameWidth + 2));
        System.out.print(join);
        System.out.print(repeat(line, costWidth + 2));
        System.out.print(join);
        System.out.print(repeat(line, cdWidth + 2));
        System.out.print(join);
        System.out.print(repeat(line, statusWidth + 2));
        System.out.println(corner);
    }
}


