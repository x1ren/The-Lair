Class Stage 5 ----- Implementaions

    static class Player {
        String name;
        int hp, logic, wisdom, level, exp;

        public Player(String name) {
            this.name = name;
            this.hp = 600;
            this.logic = 300;
            this.wisdom = 260;
            this.level = 5;
            this.exp = 0;
        }

        public void gainExp(int amount) {
            exp += amount;
            checkLevelUp();
        }

        public void checkLevelUp() {
            int requiredExp = level * 100;
            if (exp >= requiredExp) {
                exp -= requiredExp;
                level++;
                hp += 50;
                logic += 20;
                wisdom += 15;
                BattleLog.message(name + " leveled up to Level " + level + "!");
                BattleLog.message("Stats boosted! HP+" + 50 + " Logic+" + 20 + " Wisdom+" + 15);
            }
        }
    }

    // Simple Dean representation
    static class Dean {
        int hp;
        int logic;
        int wisdom;
        int phase; // 1 = normal, 2 = awakened
        boolean awakened;

        public Dean() {
            this.phase = 1;
            this.hp = 800;
            this.logic = 400;
            this.wisdom = 300;
            this.awakened = false;
        }

        public void takeDamage(int dmg) {
            hp -= dmg;
            BattleLog.message("Dean took " + dmg + " damage. [HP: " + Math.max(hp, 0) + "]");
            if (phase == 1 && hp <= 0 && !awakened) {
                awaken();
            } else if (phase == 2 && hp <= 0) {
                BattleLog.message("You have defeated Ma’am Dean!");
            }
        }

        private void awaken() {
            phase = 2;
            awakened = true;
            hp = 1200;
            logic = 500;
            wisdom = 450;
            BattleLog.separator();
            BattleLog.message("Ma’am Dean awakens into her True Form!");
            BattleLog.message(""Prepare for my wrath?”");
            BattleLog.separator();
        }

        public void performSkill(Player p) {
            if (phase == 1) {
                BattleLog.message("Dean summons villain to test your endurance!");
                int dmg = 50;
                p.hp -= dmg;
                BattleLog.message("Villain deals " + dmg + " damage!");
            } else {
                int choice = new Random().nextInt(3);
                switch (choice) {
                    case 0: examOverload(p);break;
                    case 1: administrativePressure(p);breal;
                    case 2: comprehensiveExam(p)break;
                }
            }
        }

        private void examOverload(Player p) {
            int dmg = (int)(logic * 1.2 / 10);
            BattleLog.message("Dean casts *Exam Overload!*");
            BattleLog.message("Linked puzzles appear! You solve them partially...");
            p.hp -= dmg;
            BattleLog.message("You take " + dmg + " damage.");
        }

        private void administrativePressure(Player p) {
            BattleLog.message("Dean casts *Administrative Pressure!*");
            BattleLog.message("Your focus weakens. Wisdom regeneration reduced!");
            p.hp -= 40;
            BattleLog.message("You take 40 mental strain damage!");
        }

        private void comprehensiveExam(Player p) {
            BattleLog.message("Dean uses her Ultimate — *Comprehensive Exam!*");
            boolean solved = new Random().nextBoolean();
            if (solved) {
                BattleLog.message("You solved the 3 puzzle\exam! Attack reflected!");
                int reflect = logic / 2;
                takeDamage(reflect);
            } else {
                int dmg = logic * 2 / 10;
                p.hp -= dmg;
                BattleLog.message("Failed to complete the chain! You take " + dmg + " damage!");
            }
        }
    }

    //BATTLE LOG
    static class BattleLog {
        public static void message(String msg) {
            System.out.println("[🧾] " + msg);
            try { Thread.sleep(400); 
            } catch (InterruptedException ignored) {
            
            }
        }

        public static void separator() {
            System.out.println("\n********************************\n");
        }
    }

    // Simulation
    public static void main(String[] args) {
        Player player = new Player("Alden");
        Dean dean = new Dean();

        BattleLog.separator();
        BattleLog.message("Final Stage — The Dean’s Judgement begins!");
        BattleLog.message("Ma’am Dean: “All your lessons lead here. Show me if you truly deserve to pass.”");
        BattleLog.separator();

        while (player.hp > 0 && (dean.phase != 2 || dean.hp > 0)) {
            BattleLog.message(player.name + " attacks!");
            dean.takeDamage(120);

            if (dean.phase == 2 && dean.hp <= 0) 
            break;
            if (player.hp <= 0) {
                BattleLog.message(player.name + " failed to answer the exam.");
                break;
            }

            dean.performSkill(player);
            if (player.hp <= 0) {
                BattleLog.message(player.name + " could not answer the exam!");
                break;
            }
        }

        if (player.hp > 0 && dean.hp <= 0) {
            BattleLog.separator();
            BattleLog.message("Victory! Congratulations on your next chapter(not sure pa)!");
            player.gainExp(200);
        }

        BattleLog.separator();
        BattleLog.message("End of Stage 5 Simulation.");
    }
}
