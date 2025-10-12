package main.java.com.thelair.guardian;
import main.java.com.thelair.battle.Combatant;
import java.util.Random;

/**
 * DeanGuardian
 */
public class DeanGuardian extends Guardian implements Combatant {
    private int phase = 1;
    private int turnsSinceSummon = 0;
    private boolean awakenedAnnounced = false;
    private final Random random = new Random();

    public DeanGuardian() {
        super("Dean", 4, 1000, 70, 25, 50);
    }

    @Override
    public String getIntro() {
        if (phase == 1) {
            return "Stage 4 – The Hall of Balance: 'Strength with discipline is power.'";
        } else {
            return "Stage 5 – The Dean’s Judgement: 'All your lessons lead here. Show me if you truly deserve to pass.'";
        }
    }

    @Override
    public int attack() {
        if (phase == 1) {
            if (turnsSinceSummon % 2 == 0) {
                System.out.println("\nDean summons an another villains to test your logic!");
                System.out.println("Each instructor empowers her resolve...");
            }
            turnsSinceSummon++;
            return getAttackPower() + random.nextInt(10);
        } else {
            // her special skills and awaken
            int roll = random.nextInt(100);
            if (roll < 40) {
                System.out.println("\nDean casts - Exam Overload!");
                return (int) (getAttackPower() * 1.2);
            } else if (roll < 75) {
                System.out.println("\nDean uses - Administrative Pressure!");
                System.out.println("Your Wisdom regeneration is suppressed!");
                return (int) (getAttackPower() * 1.5);
            } else {
                System.out.println("\nDean unleashes - Comprehensive Exam!");
                System.out.println("Only perfect logic can survive this strike...");
                return (int) (getAttackPower() * 2.0);
            }
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);

        // When deans hp currently below 25%, go bakc to phase2
        if (phase == 1 && getCurrentHP() <= getMaxHP() * 0.25) {
            phase = 2;
            setMaxHP(1200);
            setCurrentHP(1200);
            setAttackPower(150);
            setWisdom(450);
            if (!awakenedAnnounced) {
                System.out.println("\nDean awakens!");
                System.out.println("“You have defeated my mentors... but can you withstand the source of all exams?”");
                awakenedAnnounced = true;
            }
        }
    }

    public int getPhase() {
        return phase;
    }
}
