package main.java.com.thelair.guardian;
import java.util.Random;

/**
 * DeanGuardian
 */
public class DeanGuardian extends Guardian {
    private int phase = 1;
    private int turnsSinceSummon = 0;
    private boolean awakenedAnnounced = false;
    private final Random random = new Random();

    public DeanGuardian() {
        super("Dean", 5, 1200, 120, 25, 450);
    }

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
            return getStrength() + random.nextInt(10);
        } else {
            // her special skills and awaken
            int roll = random.nextInt(100);
            if (roll < 40) {
                System.out.println("\nDean casts - Exam Overload!");
                return (int) (getStrength() * 1.2);
            } else if (roll < 75) {
                System.out.println("\nDean uses - Administrative Pressure!");
                System.out.println("Your Wisdom regeneration is suppressed!");
                return (int) (getStrength() * 1.5);
            } else {
                System.out.println("\nDean unleashes - Comprehensive Exam!");
                System.out.println("Only perfect logic can survive this strike...");
                return (int) (getStrength() * 2.0);
            }
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);

        // Transition to phase 2 when HP <= 25%
        if (phase == 1 && getCurrentHP() <= getMaxHP() * 0.25) {
            phase = 2;
            setMaxHP(1500);
            setCurrentHP(1500);
            setStrength(150);
            setIntelligence(500);
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
