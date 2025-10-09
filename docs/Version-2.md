# THE LAIR — Version 2 (Final Game Document)

by
**Iben Anoos · Gaille Amolong · Jamuel H. Bacus · Ilde Jan Figueras · Joseph Jimenez**

© 2025
All rights reserved.

---

## Storyline (Backstory)

In a world where magic is written in code and power is measured in logic, there stands the grand citadel of learning known as the **Cebu Institute of Technology University**.

To outsiders, it is only a school. To those within, it is a proving ground for digital pioneers.

A student arrives, ready to master the arcane arts of **Information Technology**. Their path is no ordinary education—it is a **legendary quest** through five great trials. Each trial is defended by guardians of knowledge, instructors whose tests shape only the worthy into true mages of code.

The journey demands not only **logic** and **wisdom**, but resilience, creativity, and mastery over the hidden language of computation.

The first trial awaits. The quest for knowledge begins now.

---

## Game Structure

### Flow of Play

1. **Start Menu**
   - New Game → Pick a hero.
   - Exit Game.

2. **Character Selection**
   - Choose one of five heroes (Iben, Gaille, Jamuel, Ilde, Joseph).
   - Each with unique HP, Logic, Wisdom, and Skills.

3. **Trial Loop**
   - For each Guardian:
     - Short intro story.
     - Minion encounters (based on stage theme).
     - Series of puzzles (3–5) tied to the Guardian’s subject.
     - Final Guardian puzzle/battle.
   - After each trial:
     - Stage clear screen.
     - Stat boosts or skill triggers.

4. **Final Boss: The Dean**
   - Combines all mechanics.
   - Requires strategy, resource management, and luck.

5. **Ending**
   - Win: Graduate as “Master of Code.”
   - Lose: Expelled from the citadel.

---

## Core Mechanics

### Player Stats

- **HP (Health Points)** → Damage taken from mistakes. 0 = failure.
- **Logic** → Affects syntax-based puzzles and code execution checks.
- **Wisdom** → Affects conceptual/strategic puzzles and multi-step planning.

### How Stats Work

Each character has three main stats: **HP, Logic, and Wisdom.** These determine survival, puzzle-solving, and progression.

#### 1. HP (Health Points)
- Purpose: Tracks endurance; mistakes reduce HP.
- Impact: 0 HP = fail (unless a survival skill activates).
- Example: Wrong answer vs Sir Serato’s puzzle → Segmentation Fault deals −2 HP.

#### 2. Logic
- Purpose: Accuracy in syntax and code structure.
- Impact: Higher Logic = better odds in syntax/loop/OOP puzzles.
- Example: “Which loop always executes at least once?” → High Logic improves success.

#### 3. Wisdom
- Purpose: Foresight, strategy, understanding of abstract concepts.
- Impact: Higher Wisdom = advantage in recursion, algorithms, DBMS puzzles.
- Example: “What is the Big-O of binary search?” → High Wisdom improves success.

#### 4. Hybrid (Logic + Wisdom)
- Purpose: Some puzzles need both stats (esp. Dean’s trial).
- Example: “Design a DFA for strings ending in 01.”

### Puzzle Types

- **Logic Puzzle** → Requires Logic check.
- **Wisdom Puzzle** → Requires Wisdom check.
- **Hybrid Puzzle** → Requires both.

### Puzzle Resolution

- Puzzle has difficulty (1–6).
- Compare stat vs difficulty:
  - Equal/higher = success likely.
  - Lower = success possible with a dice roll modifier.
- Wrong answer = −1 or more HP (depending on Guardian).

### Skills

Each character has 3 unique skills, usable once per stage unless stated otherwise.
(See Characters section — skills are final and active in gameplay.)

### Items (Optional for replayability)

- Healing Potion → +2 HP.
- Debugging Scroll → +1 Logic for next puzzle.

---

## Characters (Final Stats & Skills)

### Iben Anoos — The Codebreaker
- HP: 400 | Logic: 300 | Wisdom: 200
- Skills:
  - Debugger’s Eye — cost 40 Wisdom; reveal hint/remove wrong option; -25% enemy defense for 3 turns; cd 3
  - Syntax Slayer — cost 30 Wisdom; damage = Logic × 1.5 (×2 if eye active); cd 2
  - Loop Mastery — cost 60 Wisdom; repeats last skill free; retry last puzzle; cd 4

### Gaille Amolong — The Architect
- HP: 500 | Logic: 200 | Wisdom: 300
- Skills:
  - Second Chance (Passive) — revive once per stage with 30% HP; +1 extra attempt
  - Blueprint Mind — cost 50 Wisdom; +30% Logic for 2 turns; cd 3
  - Vision Realized — cost 70 Wisdom; +20% defense, regen 10% HP for 3 turns; cd 5

### Jamuel Bacus — The Tactician
- HP: 300 | Logic: 200 | Wisdom: 400
- Skills:
  - Recursive Insight — cost 40 Wisdom; -30% next enemy attack; preview next question; cd 2
  - Strategist’s Gambit — cost 70 Wisdom; next skill ×1.75; removes 2 wrong options with risk; cd 4
  - Pattern Recognition — cost 60 Wisdom; +20% accuracy, +10% crit for 3 turns; trace preview; cd 3

### Ilde Jan Figueras — The Challenger
- HP: 600 | Logic: 100 | Wisdom: 200
- Skills:
  - Iron Will (Passive) — at HP < 50%, -10% damage taken; +10s in timed puzzles
  - Overclocked Resolve — cost 80 Wisdom (scales); double Logic for 2 turns; skip one question; cd 3
  - Berserker Coder — cost 120 Wisdom (scales) + 150 HP; Logic × 3, 10% recoil; auto-answer then disable skills next puzzle; cd 4

### Joseph Jimenez — The Balanced
- HP: 400 | Logic: 200 | Wisdom: 200
- Skills:
  - Jack of All Codes — cost 40 Wisdom; AOE, Logic × 1.2; 50/50 hint; cd 3
  - Adaptive Learner — cost 50 Wisdom; reuse last skill with +20% efficiency; hint after one wrong; cd 4
  - Steady Hand (Passive) — 15% resist debuffs; prevent one wrong penalty

---

## Villains (Guardians of Trials)

### Ma’am Cathy — Keeper of First Flames (Loops & Conditionals)
- HP: 500 | Logic: 300 | Wisdom: 200
- Trial: Syntax-focused. Deceptively simple but punishing.
- Signature Skills:
  - Syntax Curse — cost 40 W; damage Logic × 1.2; next player skill +10 W; cd 2
  - Deceptive Simplicity — cost 50 W; -20% player damage for 2 turns; misleading hints; cd 3
  - Loop Trap — cost 60 W; damage over 2 turns Logic × 1.5; repeated puzzle on fail; cd 4

### Sir Khai — Warden of Objects (OOP)
- HP: 600 | Logic: 400 | Wisdom: 300
- Trial: Classes, inheritance, polymorphism, encapsulation.
- Signature Skills:
  - Encapsulation Barrier — cost 50 W; -40% incoming damage for 3 turns; requires method access; cd 3
  - Inheritance Strike — cost 60 W; copies player’s last ability and strengthens it; cd 4
  - Polymorphic Mirage — cost 75 W; spawns illusions; pick the true instance; cd 5
  - Access Modifier Judgment — cost 65 W; changes effect based on visibility state; cd 3
  - Abstract Punishment — cost 120 W; disables concrete effects 2 turns until implemented; cd 6
  - Flavor: “Strength without discipline is chaos. Wield structure, or be broken by it.”

### Sir Serato — Guardian of Data (Debugging & DSA)

- HP: 700 | Logic: 500 | Wisdom: 350
- Trial: Debugging nightmares; stacks, queues, recursion traps.
- Signature Skills:
  - Recursive Reaper — cost 50 W; damage over 3 turns; identify base case; cd 4
  - Stack Overflow — cost 60 W; forces strict order of operations next turn; cd 3
  - Heap Corruption — cost 80 W; DOT until “heap cleaned”; cd 5
  - Binary Search Slash — cost 40 W; precision strike; crit if HP in midpoint; cd 2
  - Graph Trap — cost 120 W; maze of choices; cd 6

### Ma’am Tulin — The Mistress of Knowledge (Information Systems)
- HP: 950 | Logic: 500 | Wisdom: 400
- Trial: Information systems, data integrity, organization.
- Signature Skills:
  - Data Sort — cost 40 W; 250 dmg; sorting/SQL fill-in; cd 2
  - Record Query — cost 50 W; 300 dmg; output tracing; cd 3
  - System Backup — cost 80 W; 400 dmg + heal 100; multiple choice; cd 5

### The Dean — Arbiter of Mastery (Final Boss)
- HP: 1200 | Logic: 500 | Wisdom: 450 (Awakened phase)
- Trial: Hybrid mechanics across all domains + automata/AI concepts.
- Signature Skills:
  - Exam Overload — cost 70 W; AOE Logic × 1.2; dual linked puzzles; cd 3
  - Administrative Pressure — cost 80 W; -Wisdom regen for 2 turns; cd 4
  - Comprehensive Exam — cost 100 W; Logic × 2.0, 3-part chain; reflect on solve; cd 6
  - Passive: Authority of Knowledge — +10% defense, +30 W/turn, hidden clause in puzzles

---

## Minion Encounters (Per Stage)

- Stage 1 — Goblin Horde: 5× Goblins (HP 40, ATK 5). Swarm may summon +1.
- Stage 2 — Sorcerer Circle: 5× Sorcerers (HP 60, ATK 10). Firebolt 20 dmg.
- Stage 3 — Thieves’ Ambush: 5× Thieves (HP 50, ATK 8). Backstab opener.
- Stage 4 — Dire Wolf Pack: 5× Wolves (HP 80, ATK 12). Howl self-buff.
- Stage 5 — Orc Warband: 4× Orc Brutes (HP 120, ATK 15). Smash can stun.

---

## Scene Beats (Cinematic Flow)

- Stage 1 — The Hall of Flame (Ma’am Cathy): fiery torches, trial by basics.
- Stage 2 — The Hall of Order (Sir Khai): marble symmetry, discipline of OOP.
- Stage 3 — The Buglord Compiler (Sir Serato): shifting pathways, flow mastery.
- Stage 4 — The Chamber of Structures (Ma’am Tulin): library of living data.
- Stage 5 — The Dean’s Judgement (The Dean): steel and stone, harmony test.

Each stage opens with minions, escalates through puzzles, and concludes with a boss epilogue that hints at the next trial.

---

## Java Implementation (Blueprint)
- Stat Upgrades per Stage (post-clear):
  - Stage 1: Random(50, 70)
  - Stage 2: Random(60, 80)
  - Stage 3: Random(65, 85)
  - Stage 4: Random(70, 90)
  - Stage 5: Random(90, 100)

### Key Classes
- `GameManager` — manages flow.
- `Player` — abstract base class, extended by heroes (inheritance + abstraction).
- `Guardian` — base class for villains (inheritance), implements `Combatant` (interface).
- `Combatant` — interface for anything that can fight (players, guardians, minions).
- `Minion` — simple `Combatant` used for stage waves.
- `BattleSystem` — runs simple turn-based battles, uses try/catch for input safety.

### Loop Skeleton
```java
while (!gameOver) {
    showIntro();
    Character hero = chooseCharacter();
    for (Guardian g : guardians) {
        playTrial(hero, g);
        if (hero.getHp() <= 0) gameOver = true;
    }
    if (!gameOver) endGame(true);
    else endGame(false);
}
```

---

## Win / Lose Conditions

- **Victory** → Defeat the Dean. Credits + Graduation ending.
- **Defeat** → HP = 0 with no survival skill left. Expelled ending.

