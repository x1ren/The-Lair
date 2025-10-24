# The Lair - Game Flow Documentation

## Overview
This document describes the complete game flow and puzzle system implementation in The Lair, including flowcharts and detailed mechanics.

## Game Flow Structure

### 1. Main Game Loop
```
Start Game
    ↓
Character Selection (6 options)
    ↓
Stage 1: Ma'am Cathy (Loops & Conditionals)
    ↓
Stage 2: Sir Khai (OOP)
    ↓
Stage 3: Serato (Debugging & DSA)
    ↓
Stage 4: Ma'am Tulin (Information Systems)
    ↓
Stage 5: Dean (All Combined)
    ↓
Victory/Defeat
```

### 2. Individual Stage Flow
```
Stage Start
    ↓
Intro Cutscene
    ↓
Minion Wave (5 enemies)
    ├─ Random Event (60% chance)
    ├─ Battle with Minion
    └─ Repeat 5 times
    ↓
Puzzle Sequence (3-5 puzzles)
    ├─ Random puzzle selection
    ├─ Answer correctly = continue
    └─ Wrong answer = take damage
    ↓
Boss Battle
    ├─ Random Event (60% chance)
    ├─ Combat with Guardian
    ├─ Boss Puzzles (up to 3 when HP ≤ 40%)
    └─ Victory/Defeat
    ↓
Stage Complete
```

## Puzzle System Implementation

### 3. Puzzle Engine Flowchart
```
PuzzleEngine.runPuzzleSequence()
    ↓
Generate random puzzle count (3-5)
    ↓
For each puzzle:
    ├─ Select random question from guardian's bank
    ├─ Display question with 4 options (A-D)
    ├─ Get player input
    ├─ Check answer
    │   ├─ Correct: Continue to next puzzle
    │   └─ Wrong: Take damage (difficulty × 10 HP)
    └─ Check if player still alive
    ↓
Calculate final score
    ├─ Perfect score: +50 bonus XP
    └─ Return success/failure
```

### 4. Boss Finisher Puzzle Flow
```
Boss HP ≤ 40%?
    ↓ (Yes)
Boss puzzle uses < 3?
    ↓ (Yes)
Trigger finisher puzzle
    ├─ Select random question
    ├─ Player answers
    ├─ Correct: Deal extra damage (Logic × 1.5)
    └─ Wrong: Boss heals 20% HP
    ↓
Increment puzzle counter
    ↓
Continue battle
```

## Question Bank Structure

### 5. Guardian Question Distribution
```
Ma'am Cathy (Stage 1)
├─ 5 questions about Loops & Conditionals
├─ Difficulty: 1
└─ Topics: for loops, while loops, if-else, do-while

Sir Khai (Stage 2)
├─ 5 questions about OOP
├─ Difficulty: 2
└─ Topics: Encapsulation, Inheritance, Polymorphism, Abstract classes

Serato (Stage 3)
├─ 5 questions about Debugging & DSA
├─ Difficulty: 3
└─ Topics: Binary search, Stacks, Sorting algorithms, NullPointerException

Ma'am Tulin (Stage 4)
├─ 5 questions about Information Systems
├─ Difficulty: 4
└─ Topics: Database normalization, SQL, Primary keys, ACID properties

Dean (Stage 5)
├─ 5 questions about All Combined
├─ Difficulty: 5
└─ Topics: Design patterns, Exception handling, REST APIs, Java collections
```

## Combat System Integration

### 6. Battle System with Puzzles
```
BattleSystem.startBattle()
    ↓
Battle intro animation
    ↓
While (player alive AND opponent alive):
    ├─ Player turn
    │   ├─ Choose action (Attack/Skill/Defend/Item/Inspect)
    │   └─ Execute action
    ├─ Opponent turn
    │   ├─ Check for boss puzzle trigger
    │   ├─ If triggered: Run finisher puzzle
    │   └─ If not: Normal attack
    └─ Update status effects and cooldowns
    ↓
Battle resolution
    ├─ Victory: Gain XP and items
    └─ Defeat: Game over
```

## Random Event System

### 7. Random Event Triggers
```
Random Event (60% chance per encounter)
    ├─ Story Event (20% of events)
    │   ├─ Stat bonus
    │   └─ Lore progression
    ├─ Environmental Hazard (20% of events)
    │   ├─ Wisdom cost
    │   └─ Challenge overcome
    └─ Random Encounter (20% of events)
        ├─ XP reward
        └─ Item drop
```

## Character Progression

### 8. Experience and Leveling
```
Experience System
    ├─ Minions: 15-30 XP (varies by stage)
    ├─ Bosses: 75+ XP (level × 75)
    ├─ Random encounters: 15 XP
    └─ Perfect puzzle score: +50 bonus XP

Leveling Requirements
    ├─ Level 2: 200 XP
    ├─ Level 3: 400 XP (200 × 2)
    ├─ Level 4: 600 XP (200 × 3)
    └─ Each level: +25 HP, +15 Logic, +10 Wisdom
```

## Technical Implementation Details

### 9. Key Classes and Responsibilities
```
PuzzleEngine
├─ Question bank management
├─ Random question selection
├─ Puzzle sequence execution
└─ Answer validation

BattleSystem
├─ Combat flow management
├─ Boss puzzle triggering
├─ Status effect handling
└─ Experience distribution

Stage Classes (StageOne-Five)
├─ Stage-specific flow
├─ Minion wave management
├─ Puzzle sequence integration
└─ Random event triggering

Guardian Classes
├─ Boss-specific stats and skills
├─ HP-based puzzle triggers
└─ Combat behavior
```

## Bug Fixes Implemented

### 10. Recent Improvements
```
Puzzle Generation Fixes
├─ Fixed: Always selecting hardest question
├─ Now: Random question selection for variety
└─ Result: More balanced and unpredictable gameplay

Boss Puzzle System
├─ Fixed: Limited to 2 puzzles max
├─ Now: Up to 3 puzzles when HP ≤ 40%
└─ Result: More strategic boss encounters

Stage Flow Implementation
├─ Added: 3-5 puzzle sequence per stage
├─ Added: Proper integration with combat
└─ Result: Matches documentation requirements

Game State Alignment
├─ Fixed: Missing puzzle sequences
├─ Now: Complete stage flow as documented
└─ Result: Proper game progression
```

## Testing and Validation

### 11. Verification Checklist
- [x] All stages have 3-5 puzzle sequences
- [x] Boss puzzles trigger at 40% HP
- [x] Random question selection works
- [x] Puzzle damage scales with difficulty
- [x] Perfect puzzle scores give bonus XP
- [x] Game flow matches documentation
- [x] All stages compile and run correctly
- [x] Character progression works properly

## Future Enhancements

### 12. Potential Improvements
- Dynamic difficulty scaling based on player performance
- Additional question banks for replayability
- Puzzle hints system for struggling players
- Achievement system for puzzle mastery
- Multiplayer puzzle competitions
- Custom question editor for educators
