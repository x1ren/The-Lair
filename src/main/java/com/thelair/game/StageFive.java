package main.java.com.thelair.game;

import java.util.Scanner;
import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.DeanGuardian;
import main.java.com.thelair.battle.BattleSystem;
import main.java.com.thelair.ui.ConsoleUI;

public class StageFive extends Stage<DeanGuardian> {
    public StageFive() {
        super("Stage 5 – The Dean’s Judgement", new DeanGuardian());
    }

    public void intro() {
        ConsoleUI.section(getGuardian().getIntro());
    }

    public void run(Player player, Scanner scanner) {
        intro();
        // Random event before the final boss
        triggerRandomEvent(player, scanner);
        BattleSystem battle = new BattleSystem(player, scanner);
        battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
    }
}


