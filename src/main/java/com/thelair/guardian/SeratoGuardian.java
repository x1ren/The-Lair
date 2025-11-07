package com.thelair.guardian;

public class SeratoGuardian extends Guardian {
    public SeratoGuardian() {
        super("Serato", 3, 850, 140, 400);
        //String name, int level, int maxHP, int logic, int maxWisdom
    }

    public String getIntro() {
        return "NGE 103 – The DSA Sentinel of Sir Serato: 'Your code means nothing without proper logic.'";
    }
}
