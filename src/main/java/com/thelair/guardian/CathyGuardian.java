package com.thelair.guardian;

public class CathyGuardian extends Guardian {
	public CathyGuardian() {
        super("Ma'am Cathy", 1, 500, 100, 200);
		//String name, int level, int maxHP, int logic, int maxWisdom
	}

	public String getIntro() {
        return "Stage 1 – The Keeper of First Flames: 'This is very easy guys. Dali ra kaau ni ihuman ninyo.'";
	}
}
