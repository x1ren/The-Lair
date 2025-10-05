package main.java.com.thelair.game;

import java.util.ArrayList;
import java.util.List;
import main.java.com.thelair.player.Player;

public class GameManager {
	private final List<Stage<?>> stages = new ArrayList<>();

	public GameManager() {
		stages.add(new StageOne());
		stages.add(new StageTwo());
	}

	public void run(Player player) {
		for (Stage<?> stage : stages) {
			stage.run(player);
			if (!player.isAlive()) {
				System.out.println("You were defeated. Game Over.");
				return;
			}
		}
		System.out.println("Stages 1 and 2 complete! (MVP)");
	}
}
