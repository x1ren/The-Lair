package main.java.com.thelair.guardian;

public class SeratoGuardian extends Guardian {
    public SeratoGuardian() {
        super("Serato", 3, 850, 75, 400);
        //////String name, int level, int maxHP, int logic, int maxMP
    }

    public String getIntro() {
        return "Stage 3 – The Buglord Compiler: 'Your code means nothing without proper logic.'";
    }
}
