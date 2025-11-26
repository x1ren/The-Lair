# THE LAIR

> *In a world where magic is written in code and power is measured in logic*

A text-based RPG adventure set in the halls of **Cebu Institute of Technology University**, where students must prove their mastery through five legendary trials. Battle minions, solve programming puzzles, and face formidable guardian instructors in your quest to become a true Scholar.


---

## Overview

The Lair is a turn-based RPG that combines strategic combat with programming knowledge challenges. Players progress through 5 stages, each representing a course at CIT-U, battling enemies, solving puzzles, and facing guardian bosses who test both combat prowess and programming expertise.

### Core Gameplay
- **Turn-based Combat**: Strategic battles with 5 action types
- **Puzzle System**: 3-5 puzzles per stage + boss finisher puzzles
- **Character Progression**: Level up and upgrade stats between stages
- **Random Events**: Dynamic encounters that shape your journey
- **Skill System**: Unique abilities with synergies and cooldowns

---

## Quick Start

### Requirements
- **Java 17+** (or compatible version)
- Terminal/Command Line

### Installation & Running

```bash
# Compile
javac -d out $(find src/main/java -name "*.java")

# Run
java -cp out com.thelair.Main
```

---

## Game Features

### Core Systems

#### Combat System
- **5 Combat Actions**: Attack, Signature Skills, Defend, Use Items, Inspect Enemy
- **Turn-based Battles**: Strategic decision-making with resource management
- **Status Effects**: Buffs and debuffs with turn-based duration
- **Skill Synergies**: Combine skills for powerful combos

#### Puzzle System
- **Pre-Boss Puzzles**: 3-5 programming questions per stage
- **Boss Finisher Puzzles**: Up to 3 puzzles when boss HP ≤ 40%
- **Topics**: Loops, OOP, Data Structures, Information Systems, and more
- **Perfect Score Bonus**: +50 XP for answering all puzzles correctly

#### Progression System
- **Experience Points**: Gain XP from battles and puzzles
- **Leveling**: Level 2 at 200 XP, then 200 × level for subsequent levels
- **Stat Upgrades**: Choose HP, Logic, or Wisdom after each stage
- **Randomized Growth**: +35-65 HP, +35-60 Logic, +25-100 Wisdom per level

### Character System

**6 Playable Characters** with unique stats and skills:
- **Iben Anoos** - The Codebreaker (High Logic, Glass Cannon)
- **Gaille Amolong** - The Architect (Tank, Defensive)
- **Ilde Jan Figueras** - The Challenger (High HP, Low Logic)
- **Joseph Jimenez** - The Balanced (Versatile, All-Rounder)
- **Jamuel Bacus** - The Tactician (High Wisdom, Strategic)
- **DEBUG HERO** - The Unbeatable (Testing Character)

### Stage Progression

**5 Complete Stages** with increasing difficulty:
1. **NGE 101** - Ma'am Cathy (Loops & Conditionals)
2. **NGE 102** - Sir Khai (Object-Oriented Programming)
3. **NGE 103** - Sir Serato (Debugging & Data Structures)
4. **NGE 104** - Ma'am Tulin (Information Systems)
5. **NGE 105** - The Dean (All Combined - Final Boss)

Each stage includes:
- 5 minion battles with random events
- 3-5 puzzle sequence
- Guardian boss battle with finisher puzzles
- Stat upgrade choice upon completion

### Random Event System

**60% chance** for dynamic encounters:
- **Story Events** (20%): Gain stat bonuses and lore progression
- **Environmental Hazards** (20%): Wisdom costs with potential benefits
- **Random Encounters** (20%): Battle code entities for XP and items

### Inventory & Items

**Consumable Items**:
- **Small Potion**: Restores 100 HP
- **Medium Potion**: Restores 250 HP
- **Small Ether**: Restores 80 Wisdom
- **Revive**: Restores 50% HP (when defeated)
- **Bomb**: Deals 150 true damage to enemy

---

## User Interface

### Visual Features
- **ASCII Art Title**: Dynamic logo loaded from `title.txt` file
- **World Indicators**: Stage codes `[NGE101]` displayed in bold cyan every turn
- **ANSI Colors**: Color-coded battle HUD and menu sections
- **Animated Text**: Star Wars-style typewriter effect for narration
- **Formatted Menus**: Clean, organized displays with proper spacing

### Input System
- **Comprehensive Validation**: All inputs validated with try-catch blocks
- **Error Recovery**: Clear error messages with automatic retry loops
- **Range Checking**: Ensures valid menu options
- **User-Friendly**: Helpful prompts and feedback

---

## Technical Architecture

### Object-Oriented Design

This project demonstrates all four OOP pillars:

- **Abstraction**: `Stage<T extends Guardian>` and `Combatant` interface unify battles
- **Inheritance**: Guardian classes extend `Guardian`; Player classes extend `Player`
- **Polymorphism**: `BattleSystem` accepts any `Combatant`; Players override signature skills
- **Encapsulation**: Private fields with getters/setters throughout

### Key Components

- **BattleSystem**: Manages combat flow, boss puzzles, and experience distribution
- **PuzzleEngine**: Handles question banks, puzzle sequences, and answer validation
- **Stage Classes**: Control stage-specific flow and random events
- **ConsoleUI**: Provides formatting, colors, animations, and file loading
- **Player/Guardian Classes**: Define character stats, skills, and abilities

### File System

- **Title Logo**: Loaded from `src/main/java/com/thelair/files/title.txt`
- **Multiple Fallbacks**: Resource path, file system paths, and default header
- **Error Handling**: Graceful degradation if files are missing

---

## Documentation

Comprehensive documentation available in the `docs/` directory:

- **[Complete Storyline](docs/Complete_Storyline.md)**: Full narrative for all stages
- **[Character Guide](docs/Character_Guide.md)**: Detailed character stats and strategies
- **[How It Works](docs/How_It_Works.md)**: Complete gameplay mechanics guide
- **[Technical Implementation](docs/Technical_Implementation_Guide.md)**: Code architecture and details
- **[Quick Reference](docs/Quick_Reference.md)**: At-a-glance information
- **[Game Flow Documentation](docs/Game_Flow_Documentation.md)**: Flowcharts and structure

---

## Recent Updates

### Latest Features
- **File-Based Title System**: Dynamic ASCII art logo loading
- **World Indicator Display**: Stage codes with ANSI colors
- **Robust Input Validation**: Comprehensive error handling
- **Enhanced UI**: Colored displays and formatted menus
- **Complete Puzzle System**: 3-5 puzzles per stage + boss finishers
- **Random Event System**: Dynamic story moments and encounters
- **Status Effect Engine**: Turn-based buffs/debuffs with synergies

---

## Game Status

**FULLY IMPLEMENTED** - All planned features are complete and tested:

- 5 complete stages with balanced progression
- 6 playable characters with unique abilities
- Complete puzzle system with 25+ questions
- Random event system with 3 event types
- Inventory and item management
- Experience and leveling system
- Skill system with synergies
- Status effects and cooldowns
- Multi-phase boss battles
- File handling and UI polish

---

## Educational Value

The Lair serves as both entertainment and educational tool:

- **Programming Concepts**: Questions test real Java and programming knowledge
- **Problem Solving**: Puzzles require understanding of core concepts
- **Strategic Thinking**: Combat requires resource management and planning
- **OOP Demonstration**: Codebase showcases proper OOP principles

---

## License & Credits

Developed as an Object-Oriented Programming project demonstrating:
- Clean code architecture
- Proper design patterns
- Comprehensive documentation
- User-friendly interfaces

**Institution**: Cebu Institute of Technology University  

---

## Tips for Players

1. **Manage Resources**: Balance Wisdom usage and item consumption
2. **Learn Synergies**: Some skills work better together
3. **Read Carefully**: Puzzles test real programming knowledge
4. **Plan Upgrades**: Choose stat upgrades based on your character
5. **Use Items Strategically**: Save powerful items for boss battles
6. **Embrace Random Events**: They often provide valuable benefits

---

*Begin your journey through The Lair and prove yourself worthy of becoming a Scholar!*
