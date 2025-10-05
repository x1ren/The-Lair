<h1>THE LAIR</h1>
<h5>Welcome to the Lair Game</h5>

In a world where magic is written in code and power is measured in logic, there stands the grand citadel of learning known as the Cebu Institute of Technology University. To the outside world, it is a school, but to those who walk its halls, it is a proving ground for the next generation of digital pioneers.

A new student arrives, fresh from high school, ready to master the arcane arts of Information Technology and earn a degree. But this is no ordinary education. The path to graduation is a legendary quest, a series of seven great trials, each overseen by a formidable instructor who guards their knowledge with skill and wisdom.

To succeed, one must journey through realms of programming, conquer challenges of data, and command the very foundations of technology. The greatest tests lie not in simple exams, but in battles of wit and creativity against the masters themselves.

The first trial awaits. The quest for knowledge begins now.

<h6> -----ALL HAIL MAROON AND GOLD-----</h6>

<hr/>

<h3>MVP (Stages 1–2) – How to Run</h3>

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
<li><b>Abstraction</b>: `Stage<T extends Guardian>` defines the stage contract.</li>
<li><b>Inheritance</b>: `CathyGuardian` and `KhaiGuardian` extend `Guardian`.</li>
<li><b>Polymorphism</b>: `GameManager` iterates a `List&lt;Stage&lt;?&gt;&gt;` and calls `run`.</li>
<li><b>Encapsulation</b>: `Player`/`Guardian` fields are private with getters/setters.</li>
</ul>
</p>

<p>Future devs can add Stage 3+ by creating new `Guardian` subclasses and `Stage` implementations, then wiring them in `GameManager`.</p>
