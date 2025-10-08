## Current Implementation Status (v2 MVP ~40%)

- Stage 1 and Stage 2 implemented with minion waves and boss.
- Basic turn-based combat with `Combatant` interface (abstraction + polymorphism).
- Player subclasses override signature skills (polymorphism).
- Guardians aligned to docs for stats flavor (encapsulation via getters/setters).
- Input handling uses try/catch to avoid crashes on invalid entries.

---

## Next Steps (Task Breakdown)

- Add puzzle system (Logic/Wisdom/Hybrid types, difficulties, outcomes).
- Implement skills’ costs/cooldowns/effects fully for heroes and guardians.
- Implement Stages 3–5: minions, guardians, and Dean’s multi-phase fight.
- Add items (Healing Potion, Debugging Scroll) and simple inventory.
- Add save/load or simple session persistence.
- Balance numbers for damage, HP, and rewards.

Developer TODOs:
- TODO [Ilde Jan]: Implement `Puzzle` engine and resolution checks.
- TODO [Iben]: Implement hero skills with costs/cooldowns and UI prompts.
- TODO [Jamuel]: Build Stage 3 and 4 encounters with minion sheets.
- TODO [Joseph]: Implement Stage 5 (Dean) multi-phase and polish battle logs.

---

## Credits & Notes

- Consolidated from internal docs: storyline script, minion sheets, and guardian skill sheets.
- Sir Khai and The Dean profiles improvised to align with stage narratives.
