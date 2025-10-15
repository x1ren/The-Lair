package main.java.com.thelair.guardian;

public class SeratoGuardian extends Guardian {
    public SeratoGuardian() {
        super("Serato", 3, 850, 140, 400);
        //String name, int level, int maxHP, int logic, int maxWisdom
    }

    public String getIntro() {
        return "Stage 3 – The Buglord Compiler: 'Your code means nothing without proper logic.'";
    }
}
