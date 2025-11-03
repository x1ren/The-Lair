<h1>THE LAIR</h1>
<h5>Welcome to the Lair Game</h5>

In a world where magic is written in code and power is measured in logic, there stands the grand citadel of learning known as the Cebu Institute of Technology University. To the outside world, it is a school, but to those who walk its halls, it is a proving ground for the next generation of digital pioneers.

A new student arrives, fresh from high school, ready to master the arcane arts of Information Technology and earn a degree. But this is no ordinary education. The path to graduation is a legendary quest, a series of seven great trials, each overseen by a formidable instructor who guards their knowledge with skill and wisdom.

To succeed, one must journey through realms of programming, conquer challenges of data, and command the very foundations of technology. The greatest tests lie not in simple exams, but in battles of wit and creativity against the masters themselves.

The first trial awaits. The quest for knowledge begins now.

<h6> -----ALL HAIL MAROON AND GOLD-----</h6>

<hr/>

<h3>How to Run</h3>

<p><b>Requirements:</b> Java 17+ (or compatible), a terminal/shell.</p>

<ol>
<li><b>Compile</b>
<pre><code>javac -d out $(find src/main/java -name "*.java")
</code></pre>
</li>
<li><b>Run</b>
<pre><code>java -cp out com.thelair.Main
</code></pre>
</li>
</ol>

<p>
This MVP uses OOP pillars:
<ul>
<li><b>Abstraction</b>: `Stage<T extends Guardian>` and `Combatant` interface unify battles.</li>
<li><b>Inheritance</b>: `CathyGuardian` and `KhaiGuardian` extend `Guardian`; heroes extend `Player`.</li>
<li><b>Polymorphism</b>: `Player` subclasses override signature skills; `BattleSystem` accepts any `Combatant`.</li>
<li><b>Encapsulation</b>: `Player`/`Guardian` fields are private with getters/setters.</li>
</ul>
</p>

<p>Stages 1–5 are fully implemented with balanced combat, random events, puzzles, and story progression. Each stage features:
- **5 minions** with increasing difficulty
- **3-5 puzzle sequence** before boss battle 
- **Boss battles** with animated dialogues and up to 3 finisher puzzles
- **Random events** (60% chance): story moments, environmental hazards, or random encounters
- **Experience rewards** that scale with stage difficulty (15-30 XP per minion, 75+ XP per boss)
- **Level progression** with meaningful stat increases (+25 HP, +15 Logic, +10 Wisdom per level)</p>

<h3>New Features</h3>
<ul>
<li><b>Balanced Combat</b>: All character and guardian stats properly balanced for fair progression</li>
<li><b>Balanced Experience System</b>: Proper progression requiring 200 XP for level 2, scaling to 200×level XP for subsequent levels</li>
<li><b>Advanced Skill System</b>: Status effects, synergies, and cooldown management</li>
<li><b>Random Events</b>: 60% chance for story moments, environmental hazards, or random encounters during stages</li>
<li><b>Inventory & Items</b>: Stackable consumables with strategic usage in battle</li>
<li><b>Animated Boss Dialogues</b>: Epic, multi-line introductions for all guardians</li>
<li><b>Dean Ultimate Form</b>: Multi-phase final boss with powers from all guardians</li>
<li><b>Debug Hero</b>: Testing character (option 6) for storyline review</li>
</ul>

<h3>Implementation Status</h3>
<p><b>FULLY IMPLEMENTED</b> - All planned features have been successfully implemented:</p>
<ul>
<li><b>Puzzle Engine</b>: Complete question bank with 5+ questions per guardian, random selection, 3-5 puzzle sequences per stage, and boss finisher puzzles</li>
<li><b>Skill System</b>: Multi-skill selection with costs, cooldowns, synergies, and status effects</li>
<li><b>Stage Content</b>: All 5 stages with minions, bosses, random events, and balanced progression</li>
<li><b>Dean Multi-Phase</b>: Complex final boss with guardian power channeling and transformation mechanics</li>
<li><b>UI Polish</b>: Animated intros, colored displays, and comprehensive battle feedback</li>
</ul>

<h3>Advanced Features Added</h3>
<ul>
<li><b>Random Event System</b>: 60% chance for dynamic story moments, environmental challenges, and procedural encounters</li>
<li><b>Status Effect Engine</b>: Turn-based buffs/debuffs with synergies (defense debuff enables damage multipliers)</li>
<li><b>Experience Scaling</b>: Meaningful progression with +25 HP, +15 Logic, +10 Wisdom per level</li>
<li><b>Inventory Management</b>: Stackable items with strategic combat applications</li>
<li><b>Debug Testing Tools</b>: Special character for complete storyline review and balance testing</li>
</ul>
