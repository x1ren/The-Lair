package main.java.com.thelair.guardian;

public class KhaiGuardian extends Guardian {
	public KhaiGuardian() {
        super("Sir Khai", 2, 800, 70, 400);
		////String name, int level, int maxHP, int logic, int maxMP
	}

	public String getIntro() {
		return "Stage 2 – The Object-Oriented Sentinel: 'Order is understanding. Code without structure is chaos.'";
	}
}
