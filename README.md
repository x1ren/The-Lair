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
<pre><code>java -cp out main.java.com.thelair.Main
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

<p>Stages 1–5 are wired. Add new stages by creating a `Guardian` and `Stage` and wiring in `GameManager`.</p>

<h3>New Features</h3>
<ul>
<li><b>Upgrade Choice</b>: After each stage, choose +HP, +Logic, or +Wisdom. Ranges scale per docs.</li>
<li><b>Skills Enforced</b>: Signature Skill now checks MP and has cooldown.</li>
<li><b>Inventory & Items</b>: Start with Small Potion (+100 HP), Small Ether (+80 MP), Bomb (150 dmg). Use in battle.</li>
<li><b>Inspect Enemy</b>: View boss/minion stats mid-battle.</li>
<li><b>ANSI Colors</b>: Colored headers and HUD for readability.</li>
<li><b>Stage 5</b>: Dean’s Judgement with puzzle finisher gating.</li>
</ul>

<h3>Developer TODOs</h3>
<ul>
<li><b>Ilde Jan</b>: Build `Puzzle` engine (types, difficulty, stat checks, outcomes).</li>
<li><b>Iben</b>: Implement hero skill costs/cooldowns and prompts in `BattleSystem`.</li>
<li><b>Jamuel</b>: Add Stage 3–4 minions/guardians and intros per docs.</li>
<li><b>Joseph</b>: Implement Dean’s multi-phase flow and polish battle logs/UI.</li>
</ul>
