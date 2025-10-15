package main.java.com.thelair.game;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.Guardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.battle.Minion;
import main.java.com.thelair.ui.ConsoleUI;
import java.util.Scanner;
import java.util.Random;

/**
 * Generic Stage abstraction. Concrete stages define their guardian and prelude text.
 */
public abstract class Stage<T extends Guardian> {
	protected final String stageName;
	protected final T guardian;
	protected final Random random = new Random();

    protected Stage(String stageName, T guardian) {
        this.stageName = stageName;
        this.guardian = guardian;
    }


	public String getStageName() {
		return stageName;
	}

	public T getGuardian() {
		return guardian;
	}

	/**
	 * Hook for intro narration/cutscene.
	 */
	public abstract void intro();

	/**
	 * Run the core encounter for this stage (minions + boss simplified for MVP).
	 */
    public abstract void run(Player player, Scanner scanner);

    /**
     * Generate random events during stage progression.
     */
    protected void triggerRandomEvent(Player player, Scanner scanner) {
        int eventRoll = random.nextInt(100);

        if (eventRoll < 20) { // 20% chance for random event
            triggerStoryEvent(player, scanner);
        } else if (eventRoll < 40) { // 20% chance for environmental hazard
            triggerEnvironmentalHazard(player);
        } else if (eventRoll < 60) { // 20% chance for random encounter
            triggerRandomEncounter(player, scanner);
        }
        // 40% chance for nothing special
    }

    /**
     * Trigger a story-related random event.
     */
    private void triggerStoryEvent(Player player, Scanner scanner) {
        String[] storyEvents = {
            "As you traverse the halls, you overhear instructors discussing a 'corrupted algorithm' that threatens the entire system. You gain insight into the guardians' weaknesses!",
            "A holographic message appears: 'Student, your determination has been noted. The trials adapt to your growing power.' The next enemy seems... different.",
            "You find an ancient data crystal containing fragments of forgotten code. Studying it reveals a hidden truth about the Institute's founding.",
            "Suddenly, the environment shifts! The walls seem to whisper secrets of students who came before you. You feel inspired to push harder.",
            "A spectral figure appears briefly - a former student who says 'The true test is not just knowledge, but wisdom in its application.' You feel enlightened."
        };

        String event = storyEvents[random.nextInt(storyEvents.length)];
        ConsoleUI.section("Random Story Event");
        ConsoleUI.animateText(event, 30);

        // Small benefit for story events
        if (random.nextBoolean()) {
            player.increaseLogic(10);
            System.out.println("Your Logic increased by 10!");
        } else {
            player.increaseWisdomStat(10);
            System.out.println("Your Wisdom increased by 10!");
        }
    }

    /**
     * Trigger an environmental hazard.
     */
    private void triggerEnvironmentalHazard(Player player) {
        String[] hazards = {
            "Sudden code compilation errors fill the air! You take minor damage from debugging stress.",
            "A logic trap activates! You must quickly solve a mini-puzzle or lose some Wisdom.",
            "The environment becomes unstable - floating code fragments cause confusion!",
            "Memory leaks appear as obstacles! You expend extra Wisdom to navigate safely.",
            "An infinite loop hazard slows your progress, costing precious time and Wisdom."
        };

        String hazard = hazards[random.nextInt(hazards.length)];
        ConsoleUI.section("Environmental Hazard");
        ConsoleUI.animateText(hazard, 30);

        // Environmental hazards cost Wisdom but might provide benefits
        int wisdomCost = 10 + random.nextInt(20);
        if (player.getCurrentWisdom() >= wisdomCost) {
            player.useWisdom(wisdomCost);
            System.out.println("Lost " + wisdomCost + " Wisdom navigating the hazard.");

            // 30% chance for a beneficial outcome
            if (random.nextInt(100) < 30) {
                player.increaseLogic(5);
                System.out.println("But you learned something valuable! Logic +5");
            }
        } else {
            System.out.println("Insufficient Wisdom! You take damage instead.");
            player.takeDamage(50);
        }
    }

    /**
     * Trigger a random encounter.
     */
    private void triggerRandomEncounter(Player player, Scanner scanner) {
        String[] encounters = {
            "A wild 'Syntax Error' manifests as a swirling vortex of broken code!",
            "You encounter a 'Null Pointer' entity - a dangerous void that drains life force!",
            "A 'Memory Leak' creature appears, slowly consuming your available resources!",
            "An 'Infinite Loop' demon circles you, forcing you to break free or lose Wisdom!",
            "A 'Stack Overflow' spirit emerges, threatening to overwhelm your mental capacity!"
        };

        String encounter = encounters[random.nextInt(encounters.length)];
        ConsoleUI.section("Random Encounter");
        ConsoleUI.animateText(encounter, 30);

        // Create a random minion-like enemy
        String[] enemyNames = {"Syntax Error", "Null Pointer", "Memory Leak", "Infinite Loop", "Stack Overflow"};
        String enemyName = enemyNames[random.nextInt(enemyNames.length)];
        int enemyHP = 30 + random.nextInt(40); // 30-70 HP
        int enemyAttack = 5 + random.nextInt(15); // 5-20 attack

        Minion randomEnemy = new Minion(enemyName, enemyHP, enemyAttack);
        BattleSystem battle = new BattleSystem(player, scanner);
        battle.startBattle(randomEnemy, 15); // 15 XP reward
    }
}
