package main.java.com.thelair.game;

import main.java.com.thelair.player.Player;
import main.java.com.thelair.guardian.Guardian;

/**
 * Generic Stage abstraction. Concrete stages define their guardian and prelude text.
 */
public abstract class Stage<T extends Guardian> {
	protected final String stageName;
	protected final T guardian;

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
	public abstract void run(Player player);
}
