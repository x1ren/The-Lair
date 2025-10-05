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
- HP: 70 | MP: 70 | STR: 8 | SPD: 14 | INT: 18
- Skills: Debugger’s Eye, Syntax Slayer, Loop Mastery.

### Gaille Amolong — The Architect
- HP: 90 | MP: 50 | STR: 12 | SPD: 10 | INT: 14
- Skills: Second Chance, Blueprint Mind, Vision Realized.

### Jamuel Bacus — The Tactician
- HP: 65 | MP: 65 | STR: 10 | SPD: 12 | INT: 17
- Skills: Recursive Insight, Strategist’s Gambit, Pattern Recognition.

### Ilde Jan Figueras — The Challenger
- HP: 120 | MP: 25 | STR: 18 | SPD: 9 | INT: 7
- Skills: Iron Will, Overclocked Resolve, Berserker Coder.

### Joseph Jimenez — The Balanced
- HP: 85 | MP: 45 | STR: 11 | SPD: 11 | INT: 11
- Skills: Jack of All Codes, Adaptive Learner, Steady Hand.

---

## Villains (Guardians of Trials)

### Ma’am Cathy — Keeper of First Flames (Loops & Conditionals)
- HP: 500 | Logic: 300 | Wisdom: 200
- Trial: Syntax-focused. Deceptively simple but punishing.
- Signature Skills: Syntax Curse, Deceptive Simplicity, Loop Trap.

### Sir Khai — Warden of Objects (OOP)
- HP: 600 | Logic: 400 | Wisdom: 300
- Trial: Classes, inheritance, polymorphism, encapsulation.
- Signature Skills:
  - Null Reference — disables one player skill for 1–2 turns; forces careful planning.
  - Constructor Overload — rapid follow-up attack if player misuses types/params.
  - Polymorph Edge — damage bonus if player misclassifies inheritance.
- Flavor: “Strength without discipline is chaos. Wield structure, or be broken by it.”

### Sir Serato — Guardian of Data (Debugging & DSA)
- HP: 700 | Logic: 450 | Wisdom: 300
- Trial: Debugging nightmares; stacks, queues, recursion traps.
- Signature Skills: Segfault Strike, Garbage Overflow, Infinite Loop.

### Ma’am Tulin — Mistress of Networks (Data Structures & Systems)
- HP: 950 | Logic: 500 | Wisdom: 400
- Trial: Stacks, queues, graphs, and system-like layered checks.
- Signature Skills: Stack Smash, Queue Rush, Graph Snare.

### The Dean — Arbiter of Mastery (Final Boss)
- HP: 1000+ | Logic: 600 | Wisdom: 600
- Trial: Hybrid mechanics across all domains + automata/AI concepts.
- Signature Skills:
  - Turing’s Judgement — hybrid check that locks skills if failed.
  - Summon Instructor — calls weakened echoes of all prior bosses.
  - Comprehensive Exam — multi-step puzzle where hints are delayed.
- Flavor: “Pieces are not enough. Only mastery unites them.”

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

### Key Classes
- `Game` — manages flow.
- `PlayerCharacter` — base class, extended by heroes.
- `Guardian` — base class for villains.
- `Puzzle` — question, type, difficulty, answer, effects.
- `BattleSystem` — runs puzzles, applies damage, skills, status.

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

---

## Credits & Notes

- Consolidated from internal docs: storyline script, minion sheets, and guardian skill sheets.
- Sir Khai and The Dean profiles improvised to align with stage narratives.
