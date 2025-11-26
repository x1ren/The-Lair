# The Lair - Quick Reference Guide

## Quick Start

### Compile and Run
```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.thelair.Main
```

### Game Flow
1. Title Screen → Character Selection → Stage 1-5 → Victory

---

## Character Quick Stats

| Character | HP | Logic | Wisdom | Playstyle |
|-----------|----|----|--------|-----------|
| Iben Anoos | 400 | 200-300 | 200 | High damage, glass cannon |
| Gaille Amolong | 500 | 200 | 300 | Tank, defensive |
| Ilde Jan Figueras | 600 | 100 | 200 | High HP, low Logic |
| Joseph Jimenez | 400 | 200 | 200 | Balanced, versatile |
| Jamuel Bacus | 300 | 200 | 400 | Strategist, high Wisdom |
| DEBUG HERO | 9999 | 9999 | 9999 | Testing only |

---

## Stage Overview

| Stage | Code | Guardian | HP | Theme |
|-------|------|----------|-----|-------|
| 1 | NGE101 | Ma'am Cathy | 500 | Loops & Conditionals |
| 2 | NGE102 | Sir Khai | 900 | Object-Oriented Programming |
| 3 | NGE103 | Sir Serato | 850 | Debugging & DSA |
| 4 | NGE104 | Ma'am Tulin | 950 | Information Systems |
| 5 | NGE105 | The Dean | 1200 | All Combined |

---

## Combat Actions

1. **Attack** - Basic attack (Logic + 0-30 damage)
2. **Signature Skill** - Character-specific abilities (costs Wisdom)
3. **Defend** - Reduce incoming damage by 50%
4. **Use Item** - Consume inventory items
5. **Inspect Enemy** - View enemy stats

---

## Items

- **Small Potion**: +100 HP
- **Medium Potion**: +250 HP
- **Small Ether**: +80 Wisdom
- **Revive**: +50% HP (when defeated)
- **Bomb**: 150 true damage to enemy

---

## Experience & Leveling

- **Level 2**: 200 XP
- **Level 3+**: 200 × level XP
- **Level Bonus**: +35-65 HP, +35-60 Logic, +25-100 Wisdom

### XP Sources
- Minions: 15-55 XP
- Bosses: 60-300 XP
- Random Encounters: 15 XP
- Perfect Puzzle Score: +50 bonus

---

## Puzzle System

### Pre-Boss Puzzles
- **Count**: 3-5 puzzles per stage
- **Wrong Answer**: Take damage (difficulty × 10 HP)
- **Perfect Score**: +50 bonus XP

### Boss Finisher Puzzles
- **Trigger**: Boss HP ≤ 40%
- **Max Uses**: 3 per battle
- **Correct**: Deal Logic × 1.5 extra damage
- **Wrong**: Boss regenerates 20% HP

---

## Random Events (60% chance)

### Story Events (20%)
- Gain +10 Logic or +10 Wisdom

### Environmental Hazards (20%)
- Lose 10-30 Wisdom
- 30% chance for +5 Logic bonus

### Random Encounters (20%)
- Battle code entities
- Reward: 15 XP
- 30% chance for item reward

---

## Stage Rewards

After each stage, choose one stat upgrade:
- **Stage 1**: +50 to +70
- **Stage 2**: +60 to +80
- **Stage 3**: +65 to +85
- **Stage 4**: +70 to +90
- **Stage 5**: +90 to +100

---

## Key Features

✅ **Title Logo**: ASCII art from `title.txt`  
✅ **World Indicators**: `[NGE101]` in bold cyan  
✅ **Input Validation**: All inputs validated with error messages  
✅ **Random Events**: 60% chance for dynamic encounters  
✅ **Puzzle System**: 3-5 puzzles per stage + boss finishers  
✅ **Skill Synergies**: Skills work together for combos  
✅ **Status Effects**: Turn-based buffs/debuffs  
✅ **Inventory**: Stackable consumable items  

---

## Tips

1. **Manage Wisdom**: Don't spam skills
2. **Save Items**: Use potions for boss battles
3. **Learn Synergies**: Some skills combo together
4. **Read Puzzles**: They test real programming knowledge
5. **Perfect Scores**: Aim for +50 bonus XP
6. **Boss Puzzles**: High risk, high reward

---

## Documentation Files

- **README.md**: Main project overview
- **Complete_Storyline.md**: Full narrative
- **Character_Guide.md**: Detailed character info
- **How_It_Works.md**: Gameplay mechanics
- **Technical_Implementation_Guide.md**: Code details
- **Game_Flow_Documentation.md**: Flow and structure
- **Status.md**: Implementation status

---

*For detailed information, see the full documentation files in the `docs/` directory.*

