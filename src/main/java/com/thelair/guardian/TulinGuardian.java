package main.java.com.thelair.guardian;

public class TulinGuardian  extends Guardian {
    public TulinGuardian() {
        super("Ma'am Tulin", 4, 950, 50, 400);
        //String name, int level, int maxHP, int logic, int maxWisdom
    }

    public String getIntro() {
        return "Stage 4 – The Keeper of Knowledge: 'Data is power. Prove you can wield it.'";
    }

}
