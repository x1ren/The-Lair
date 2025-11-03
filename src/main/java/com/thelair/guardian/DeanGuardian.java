package com.thelair.guardian;
import java.util.Random;

/**
 * DeanGuardian
 */
public class DeanGuardian extends Guardian {
    private int phase = 1;
    int turnsSinceSummon = 0;
    private boolean awakenedAnnounced = false;
    private boolean cathySummoned = false;
    private boolean khaiSummoned = false;
    private boolean seratoSummoned = false;
    private boolean tulinSummoned = false;
    private final Random random = new Random();

    public DeanGuardian() {
        super("Dean", 5, 1200, 170, 450);
        //String name, int level, int maxHP, int logic, int maxWisdom
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
            // Phase 1: Dean channels powers from all guardians
            int roll = random.nextInt(100);
            turnsSinceSummon++;

            if (roll < 25 && !cathySummoned) {
                // Cathy's Loop Trap - repeating damage
                System.out.println("\nDean channels Ma'am Cathy's power!");
                System.out.println("Loop Trap activated - damage repeats next turn!");
                cathySummoned = true;
                return getLogic() + 20;
            } else if (roll < 50 && !khaiSummoned) {
                // Khai's Polymorphic Mirage - summons illusions
                System.out.println("\nDean channels Sir Khai's power!");
                System.out.println("Polymorphic Mirage - creates confusing duplicates!");
                khaiSummoned = true;
                return getLogic() + 15;
            } else if (roll < 75 && !seratoSummoned) {
                // Serato's Algorithm Strike - high damage
                System.out.println("\nDean channels Serato's power!");
                System.out.println("Algorithm Strike - optimized for maximum efficiency!");
                seratoSummoned = true;
                return (int) (getLogic() * 1.8);
            } else if (roll < 100 && !tulinSummoned) {
                // Tulin's Data Sort - debuff
                System.out.println("\nDean channels Ma'am Tulin's power!");
                System.out.println("Data Sort - reorganizes your thoughts against you!");
                tulinSummoned = true;
                return getLogic() + 10;
            } else {
                // Normal attack
                return getLogic() + random.nextInt(20);
            }
        } else {
            // Phase 2: Ultimate power combining all guardians
            int roll = random.nextInt(100);
            if (roll < 30) {
                System.out.println("\nDean unleashes - Ultimate Synthesis!");
                System.out.println("Combining all guardian powers into one devastating attack!");
                return (int) (getLogic() * 2.0);
            } else if (roll < 60) {
                System.out.println("\nDean activates - Faculty Council!");
                System.out.println("All instructors lend their strength - overwhelming power!");
                return (int) (getLogic() * 1.8);
            } else if (roll < 80) {
                System.out.println("\nDean performs - Final Examination!");
                System.out.println("The ultimate test of knowledge and wisdom!");
                return (int) (getLogic() * 1.6);
            } else {
                System.out.println("\nDean executes - Academic Judgment!");
                System.out.println("The final verdict on your programming abilities!");
                return (int) (getLogic() * 1.9);
            }
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);

        // Transition to phase 2 when HP <= 30% and all guardians have been "summoned"
        if (phase == 1 && getCurrentHP() <= getMaxHP() * 0.30 && cathySummoned && khaiSummoned && seratoSummoned && tulinSummoned) {
            phase = 2;

            // Increase stats dramatically for phase 2
            setCurrentHP(getMaxHP()); // Full heal
            setLogic(180); // Massive power increase

            if (!awakenedAnnounced) {
                System.out.println("\n" + "=".repeat(80));
                System.out.println("THE DEAN AWAKENS!");
                System.out.println("=".repeat(80));
                System.out.println("\"You have faced my guardians... now face their master!\"");
                System.out.println("\"I am the culmination of all knowledge!\"");
                System.out.println("\"Prepare for the FINAL EXAMINATION!\"");
                System.out.println("=".repeat(80));
                awakenedAnnounced = true;
            }
        }
    }

    public int getPhase() {
        return phase;
    }
}
