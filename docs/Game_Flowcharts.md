# The Lair - Game Flowcharts

## Main Game Flow

```
┌─────────────────┐
│   Start Game    │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Character       │
│ Selection       │
│ (6 Options)     │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│   Stage 1       │
│ Ma'am Cathy     │
│ (Loops & Cond.) │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│   Stage 2       │
│   Sir Khai      │
│     (OOP)       │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│   Stage 3       │
│    Serato       │
│ (Debug & DSA)   │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│   Stage 4       │
│ Ma'am Tulin     │
│ (Info Systems)  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│   Stage 5       │
│     Dean        │
│ (All Combined)  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Victory/Defeat  │
└─────────────────┘
```

## Individual Stage Flow

```
┌─────────────────┐
│  Stage Start    │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Intro Cutscene  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│  Minion Wave    │
│   (5 enemies)   │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Random Event?   │
│   (60% chance)  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Battle Minion   │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ More Minions?   │
└─────────┬───────┘
          │ Yes
          ▼
┌─────────────────┐
│ Repeat 5 times  │
└─────────┬───────┘
          │ No
          ▼
┌─────────────────┐
│ Puzzle Sequence │
│   (3-5 puzzles) │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Random Event?   │
│   (60% chance)  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│  Boss Battle    │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Stage Complete  │
└─────────────────┘
```

## Puzzle System Flow

```
┌─────────────────┐
│ Puzzle Sequence │
│    Start        │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Generate Random │
│ Puzzle Count    │
│    (3-5)        │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ For Each Puzzle │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Select Random   │
│ Question from   │
│ Guardian Bank   │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Display Question│
│ with 4 Options  │
│     (A-D)       │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Get Player      │
│    Input        │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Check Answer    │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│Correct? │ │ Wrong?  │
│Continue │ │ Take    │
│to next  │ │ Damage  │
│puzzle   │ │ (diff×10│
└─────────┘ │   HP)   │
            └─────────┘
    │           │
    └─────┬─────┘
          │
          ▼
┌─────────────────┐
│ Player Still    │
│    Alive?       │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│  Yes    │ │   No    │
│Continue │ │ Game    │
│         │ │  Over   │
└─────────┘ └─────────┘
```

## Boss Finisher Puzzle Flow

```
┌─────────────────┐
│   Boss HP ≤     │
│     40%?        │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│  Yes    │ │   No    │
│         │ │ Normal  │
│         │ │ Attack  │
└─────────┘ └─────────┘
    │
    ▼
┌─────────────────┐
│ Boss Puzzle     │
│ Uses < 3?       │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│  Yes    │ │   No    │
│Trigger  │ │ Normal  │
│Puzzle   │ │ Attack  │
└─────────┘ └─────────┘
    │
    ▼
┌─────────────────┐
│ Select Random   │
│ Question        │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Player Answers  │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│Correct? │ │ Wrong?  │
│Deal     │ │ Boss    │
│Extra    │ │ Heals   │
│Damage   │ │ 20% HP  │
│(Logic×1.5│ │         │
└─────────┘ └─────────┘
    │           │
    └─────┬─────┘
          │
          ▼
┌─────────────────┐
│ Increment       │
│ Puzzle Counter  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Continue        │
│ Battle          │
└─────────────────┘
```

## Question Bank Structure

```
┌─────────────────────────────────────────────────────────────┐
│                    Question Bank                            │
├─────────────────────────────────────────────────────────────┤
│ Ma'am Cathy (Stage 1) - Loops & Conditionals               │
│ ├─ 5 questions, Difficulty: 1                              │
│ ├─ Topics: for loops, while loops, if-else, do-while       │
│ └─ Examples: "Which loop always executes at least once?"   │
├─────────────────────────────────────────────────────────────┤
│ Sir Khai (Stage 2) - Object-Oriented Programming           │
│ ├─ 5 questions, Difficulty: 2                              │
│ ├─ Topics: Encapsulation, Inheritance, Polymorphism        │
│ └─ Examples: "What is the main principle of encapsulation?"│
├─────────────────────────────────────────────────────────────┤
│ Serato (Stage 3) - Debugging & Data Structures             │
│ ├─ 5 questions, Difficulty: 3                              │
│ ├─ Topics: Binary search, Stacks, Sorting, NullPointer     │
│ └─ Examples: "What is the time complexity of binary search?"│
├─────────────────────────────────────────────────────────────┤
│ Ma'am Tulin (Stage 4) - Information Systems                │
│ ├─ 5 questions, Difficulty: 4                              │
│ ├─ Topics: Database normalization, SQL, Primary keys       │
│ └─ Examples: "What is the purpose of database normalization?"│
├─────────────────────────────────────────────────────────────┤
│ Dean (Stage 5) - All Combined                              │
│ ├─ 5 questions, Difficulty: 5                              │
│ ├─ Topics: Design patterns, Exception handling, REST APIs  │
│ └─ Examples: "Which design pattern ensures only one instance?"│
└─────────────────────────────────────────────────────────────┘
```

## Combat System Integration

```
┌─────────────────┐
│ Battle Start    │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Battle Intro    │
│ Animation       │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ While (player   │
│ alive AND       │
│ opponent alive) │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│   Player Turn   │
│ Choose Action:  │
│ ├─ Attack       │
│ ├─ Skill        │
│ ├─ Defend       │
│ ├─ Item         │
│ └─ Inspect      │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│  Opponent Turn  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Boss Puzzle     │
│ Trigger Check   │
│ (HP ≤ 40%?)     │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│  Yes    │ │   No    │
│Run      │ │ Normal  │
│Finisher │ │ Attack  │
│Puzzle   │ │         │
└─────────┘ └─────────┘
    │           │
    └─────┬─────┘
          │
          ▼
┌─────────────────┐
│ Update Status   │
│ Effects &       │
│ Cooldowns       │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Battle          │
│ Resolution      │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│Victory: │ │Defeat:  │
│Gain XP  │ │Game     │
│& Items  │ │Over     │
└─────────┘ └─────────┘
```

## Random Event System

```
┌─────────────────┐
│ Random Event    │
│ (60% chance     │
│ per encounter)  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Event Type      │
│ Roll (1-100)    │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│1-20:    │ │21-40:   │
│Story    │ │Environ- │
│Event    │ │mental   │
│         │ │Hazard   │
└─────────┘ └─────────┘
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│Stat     │ │Wisdom   │
│Bonus    │ │Cost     │
│Lore     │ │Challenge│
│Progress │ │Overcome │
└─────────┘ └─────────┘
    │           │
    └─────┬─────┘
          │
          ▼
┌─────────────────┐
│41-60: Random    │
│Encounter        │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│XP Reward        │
│Item Drop        │
└─────────────────┘
```

## Character Progression

```
┌─────────────────┐
│ Experience      │
│ Sources         │
└─────────┬───────┘
          │
    ┌─────┴─────┐
    │           │
    ▼           ▼
┌─────────┐ ┌─────────┐
│Minions: │ │Bosses:  │
│15-30 XP │ │75+ XP   │
│(varies  │ │(level×75│
│by stage)│ │)        │
└─────────┘ └─────────┘
    │           │
    └─────┬─────┘
          │
          ▼
┌─────────────────┐
│Random           │
│Encounters: 15 XP│
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│Perfect Puzzle   │
│Score: +50       │
│Bonus XP         │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│ Leveling        │
│ Requirements    │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐
│Level 2: 200 XP  │
│Level 3: 400 XP  │
│Level 4: 600 XP  │
│Each level:      │
│+25 HP           │
│+15 Logic        │
│+10 Wisdom       │
└─────────────────┘
```
