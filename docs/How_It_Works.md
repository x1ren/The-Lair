# The Lair - How It Works

## Game Overview

**The Lair** is a text-based RPG that combines turn-based combat with puzzle-solving mechanics. Players progress through 5 stages, each representing a course at Cebu Institute of Technology University, battling minions, solving puzzles, and facing guardian bosses.

---

## Core Gameplay Loop

### 1. Game Start
```
Title Screen (ASCII art from title.txt)
    ↓
Story Narration (optional)
    ↓
Character Selection (6 options)
    ↓
Stage 1 → Stage 2 → Stage 3 → Stage 4 → Stage 5
    ↓
Victory/Defeat
    ↓
Play Again? (Y/N)
```

### 2. Individual Stage Flow

```
Stage Introduction
    ↓
Minion Wave (5 enemies)
    ├─ Random Event (60% chance)
    ├─ Battle with Minion
    └─ Repeat 5 times
    ↓
Puzzle Sequence (3-5 puzzles)
    ├─ Random question selection
    ├─ Answer correctly = continue
    └─ Wrong answer = take damage
    ↓
Boss Battle
    ├─ Random Event (60% chance)
    ├─ Combat with Guardian
    ├─ Boss Puzzles (up to 3 when HP ≤ 40%)
    └─ Victory/Defeat
    ↓
Stage Complete → Stat Upgrade Choice
```

---

## Combat System

### Turn Structure

Each battle turn displays:
```
[NGE101]  ← World indicator (colored, stage-specific)
----------------------------------------------------------------------
                Your Turn! Choose an action:
----------------------------------------------------------------------
  1. Attack
  2. Signature Skill
  3. Defend
  4. Use Item
  5. Inspect Enemy
Enter choice: _
```

### Combat Actions

#### 1. Attack
- **Damage**: Logic + random(0-30)
- **Cost**: None
- **Description**: Basic physical attack using your Logic stat

#### 2. Signature Skill
- **Cost**: Varies by skill (Wisdom)
- **Cooldown**: Varies by skill (turns)
- **Description**: Character-specific powerful abilities
- **Sub-menu**: Select from available skills (if multiple)

#### 3. Defend
- **Effect**: Reduces incoming damage by 50% for one turn
- **Cost**: None
- **Description**: Defensive stance to mitigate damage

#### 4. Use Item
- **Items Available**:
  - **Small Potion**: Restores 100 HP
  - **Medium Potion**: Restores 250 HP
  - **Small Ether**: Restores 80 Wisdom
  - **Revive**: Restores 50% HP (only when defeated)
  - **Bomb**: Deals 150 true damage to enemy
- **Cost**: Consumes item from inventory

#### 5. Inspect Enemy
- **Effect**: Displays enemy stats (HP, Logic, Wisdom)
- **Cost**: None
- **Description**: Gather information about your opponent

### Enemy Turn

After your turn, the enemy attacks:
- **Damage**: Enemy Logic + random variation
- **Special**: Bosses may trigger finisher puzzles when weakened

### Battle End Conditions

- **Victory**: Enemy HP reaches 0
  - Gain experience points
  - May receive items
  - Continue to next encounter

- **Defeat**: Player HP reaches 0
  - Game Over
  - Option to play again

---

## Puzzle System

### Pre-Boss Puzzle Sequence

Before each boss battle, you face 3-5 puzzles:

1. **Question Selection**: Random question from guardian's question bank
2. **Display**: Question with 4 options (A, B, C, D)
3. **Input**: Enter A, B, C, or D
4. **Result**:
   - **Correct**: Continue to next puzzle
   - **Wrong**: Take damage (difficulty × 10 HP), continue if alive
5. **Completion**: Perfect score (all correct) grants +50 bonus XP

### Boss Finisher Puzzles

During boss battles, when boss HP ≤ 40%:
- **Trigger**: Up to 3 finisher puzzles
- **Correct Answer**: Deal extra damage (Logic × 1.5)
- **Wrong Answer**: Boss regenerates 20% HP
- **Strategy**: High risk, high reward mechanic

### Puzzle Topics by Stage

- **Stage 1 (Ma'am Cathy)**: Loops & Conditionals
- **Stage 2 (Sir Khai)**: Object-Oriented Programming
- **Stage 3 (Sir Serato)**: Debugging & Data Structures
- **Stage 4 (Ma'am Tulin)**: Information Systems
- **Stage 5 (The Dean)**: All Combined Topics

---

## Random Event System

### Trigger Chance
- **60% chance** before each minion encounter
- **60% chance** before puzzle sequence
- **60% chance** before boss battle

### Event Types

#### Story Events (20% of random events)
- **Effect**: Gain stat bonuses (+10 Logic or +10 Wisdom)
- **Examples**:
  - Overhearing instructors discuss algorithms
  - Finding ancient data crystals
  - Encountering spectral former students
- **Reward**: Permanent stat increase

#### Environmental Hazards (20% of random events)
- **Effect**: Lose Wisdom (10-30 points)
- **Risk**: If insufficient Wisdom, take 50 HP damage instead
- **Benefit**: 30% chance to gain +5 Logic after overcoming
- **Examples**:
  - Code compilation errors
  - Logic traps
  - Memory leaks
  - Infinite loop hazards

#### Random Encounters (20% of random events)
- **Effect**: Battle with code entity
- **Enemies**: Syntax Error, Null Pointer, Memory Leak, Infinite Loop, Stack Overflow
- **Reward**: 15 XP upon victory
- **Special**: 30% chance for minion to ask theme question (reward: random item)

---

## Progression System

### Experience Points (XP)

**Sources:**
- Minions: 15-55 XP (varies by stage)
- Bosses: 60-300 XP (level × 60)
- Random Encounters: 15 XP
- Perfect Puzzle Score: +50 bonus XP

**Level Requirements:**
- Level 2: 200 XP
- Level 3: 400 XP (200 × 2)
- Level 4: 600 XP (200 × 3)
- Level 5: 800 XP (200 × 4)
- And so on...

### Leveling Up

When you level up:
- **HP**: +35 to +65 (randomized)
- **Logic**: +35 to +60 (randomized)
- **Wisdom**: +25 to +100 (randomized)
- **Current HP**: Fully restored
- **Experience to Next**: Reset to 200 × new level

### Stage Completion Rewards

After each stage, choose one stat to upgrade:
- **Stage 1**: +50 to +70 points
- **Stage 2**: +60 to +80 points
- **Stage 3**: +65 to +85 points
- **Stage 4**: +70 to +90 points
- **Stage 5**: +90 to +100 points

**Strategy**: Choose based on your character's needs and playstyle.

---

## Skill System

### Skill Mechanics

**Components:**
- **Wisdom Cost**: Required Wisdom to use
- **Cooldown**: Turns before skill can be used again
- **Effects**: Vary by skill (damage, buffs, debuffs, utility)

### Skill Synergies

Some skills work together:
- **Debugger's Eye** (Iben Anoos) → **Syntax Slayer**: Doubles damage
- **Blueprint Mind** (Gaille Amolong) → All attacks: +30% Logic for 2 turns

### Status Effects

**Player Buffs:**
- **logicBuff**: Increases Logic for X turns
- **perfectDefense**: Blocks all damage for 1 turn (Debug Hero)

**Enemy Debuffs:**
- **enemyDefenseDown**: Reduces enemy defense for X turns

**Duration**: Status effects tick down each turn

---

## Inventory System

### Items

**Consumables:**
- **POTION_SMALL**: Restores 100 HP
- **POTION_MED**: Restores 250 HP
- **ETHER_SMALL**: Restores 80 Wisdom
- **REVIVE**: Restores 50% HP (only when defeated)
- **BOMB**: Deals 150 true damage to enemy

**Stacking**: Items stack in inventory (quantity shown)

**Acquisition**:
- Starting items (1 of each: Small Potion, Small Ether, Bomb)
- Random encounter rewards
- Minion puzzle rewards (30% chance)

### Item Usage

1. Select "Use Item" in battle
2. View inventory table
3. Choose item number
4. Item effect applies immediately
5. Item quantity decreases by 1

---

## User Interface Features

### Title Screen
- **Source**: `src/main/java/com/thelair/files/title.txt`
- **Display**: ASCII art logo loaded via file handling
- **Fallback**: Default header if file not found

### World Indicator
- **Format**: `[NGE101]`, `[NGE102]`, etc.
- **Color**: Bold cyan (ANSI codes)
- **Display**: Every battle turn
- **Purpose**: Shows current stage context

### Input Validation
- **All Inputs**: Validated with try-catch blocks
- **Error Messages**: "Invalid choice! Please try again."
- **Range Checking**: Ensures valid menu options
- **Retry Loop**: Prompts again until valid input

### Menu System
- **Format**: Numbered options with dividers
- **Colors**: Cyan for sections, Yellow for emphasis
- **Layout**: Centered, organized display

### Battle HUD
```
Player HP: 400/400  |  Wisdom: 200/200
Enemy HP: 500/500
```
- **Colors**: Green (HP), Blue (Wisdom), Red (Enemy HP)
- **Updates**: After each turn

---

## Technical Features

### File Handling
- **Title Logo**: Loaded from external file
- **Multiple Paths**: Tries resource path, then file system paths
- **Error Handling**: Graceful fallback if file not found

### Error Handling
- **Input Validation**: All user inputs wrapped in try-catch
- **Range Checking**: Validates menu choice ranges
- **Error Messages**: Clear, helpful feedback
- **Retry Logic**: Loops until valid input received

### ANSI Colors
- **Colors Available**: RED, GREEN, YELLOW, BLUE, CYAN
- **Formatting**: BOLD, RESET
- **Usage**: World indicators, battle HUD, menu sections

### Animation
- **Typewriter Effect**: Star Wars-style character-by-character display
- **Speed Control**: Configurable delay per character
- **Usage**: Story narration, boss dialogues

---

## Strategy Tips

### Combat Strategy
1. **Manage Wisdom**: Don't spam skills; save for critical moments
2. **Use Items Wisely**: Save potions for boss battles
3. **Defend When Low**: Use Defend action to reduce incoming damage
4. **Skill Synergies**: Learn which skills work together
5. **Inspect Enemies**: Gather information before committing to strategy

### Puzzle Strategy
1. **Read Carefully**: Questions test real programming knowledge
2. **Manage HP**: Wrong answers cost HP; be prepared
3. **Perfect Scores**: Aim for +50 bonus XP
4. **Boss Puzzles**: High risk, high reward—choose wisely

### Progression Strategy
1. **Stat Upgrades**: Choose based on character needs
2. **Level Timing**: Plan level-ups for HP restoration
3. **Item Management**: Don't hoard items; use when needed
4. **Random Events**: Embrace them; they often provide benefits

### Character-Specific Tips

**Iben Anoos**: Use Debugger's Eye before Syntax Slayer for maximum damage

**Gaille Amolong**: Use Second Chance passive strategically; don't waste it early

**Ilde Jan Figueras**: Manage HP carefully; Iron Will activates at 50% HP

**Joseph Jimenez**: Use Adaptive Learner to recover from mistakes

**Jamuel Bacus**: Use Recursive Insight to preview challenges before committing

---

## Game Flow Summary

1. **Start** → Choose character → Enter Stage 1
2. **Each Stage**:
   - Fight 5 minions (with random events)
   - Solve 3-5 puzzles
   - Battle guardian boss
   - Choose stat upgrade
3. **Repeat** for Stages 2-5
4. **Final Boss**: The Dean (ultimate challenge)
5. **Victory** → Become a Scholar

---

*Master the mechanics, understand the systems, and triumph in The Lair!*

