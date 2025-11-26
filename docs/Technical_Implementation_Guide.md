# The Lair - Technical Implementation Guide

## Overview
This document provides detailed technical information about the implementation of The Lair's puzzle system, game mechanics, UI features, and file handling systems.

## Puzzle System Architecture

### Core Classes

#### PuzzleEngine.java
**Purpose**: Manages all puzzle-related functionality
**Key Methods**:
- `runPuzzleSequence(String guardianName, Player player, Scanner scanner)`: Executes 3-5 puzzle sequence
- `triggerFinisher(Guardian guardian, Player player, Scanner scanner)`: Handles boss finisher puzzles
- `triggerThemeQuestion(String themeGuardianName, Scanner scanner)`: Handles minion puzzles
- `shouldTriggerFinisher(Guardian guardian)`: Checks if boss HP ≤ 40%

**Question Bank Structure**:
```java
private final Map<String, List<Question>> questionBank;
// Key: Guardian name, Value: List of questions
```

#### Question.java
**Purpose**: Represents individual puzzle questions
**Properties**:
- `String questionText`: The question itself
- `String[] options`: Four answer choices (A-D)
- `int correctAnswer`: Index of correct answer (0-3)
- `String category`: Question topic/category
- `int difficulty`: Difficulty level (1-5)

### Battle System Integration

#### BattleSystem.java
**Key Modifications**:
- Added `maxBossPuzzles = 3` to allow up to 3 boss finisher puzzles
- Enhanced boss puzzle triggering logic
- Integrated puzzle system with combat flow

**Boss Puzzle Logic**:
```java
if (opponent instanceof Guardian && 
    puzzleEngine.shouldTriggerFinisher((Guardian) opponent) && 
    bossPuzzleUses < maxBossPuzzles) {
    // Trigger finisher puzzle
}
```

### Stage Implementation

#### Stage Classes (StageOne-Five.java)
**New Structure**:
1. **Intro Cutscene**: Guardian introduction
2. **Minion Wave**: 5 minions with random events
3. **Puzzle Sequence**: 3-5 puzzles before boss
4. **Boss Battle**: Guardian fight with finisher puzzles

**Implementation Pattern**:
```java
public void run(Player player, Scanner scanner) {
    intro();
    BattleSystem battle = new BattleSystem(player, scanner);
    PuzzleEngine puzzleEngine = new PuzzleEngine();
    
    // Minion wave
    for (int i = 1; i <= 5 && player.isAlive(); i++) {
        triggerRandomEvent(player, scanner);
        Minion minion = new Minion(/* minion stats */);
        battle.startBattle(minion, xpReward);
    }
    
    if (player.isAlive()) {
        // Puzzle sequence
        triggerRandomEvent(player, scanner);
        ConsoleUI.section("Puzzle challenge message");
        boolean puzzleSuccess = puzzleEngine.runPuzzleSequence(guardianName, player, scanner);
        
        if (puzzleSuccess && player.isAlive()) {
            // Boss battle
            triggerRandomEvent(player, scanner);
            battle.startBattle(getGuardian(), getGuardian().getExperienceReward());
        }
    }
}
```

## Bug Fixes Implemented

### 1. Random Question Selection
**Problem**: Always selected hardest question
**Solution**: Implemented random selection
```java
// Before (always hardest)
availableQuestions.sort(Comparator.comparingInt(Question::getDifficulty).reversed());
Question question = availableQuestions.get(0);

// After (random selection)
Random random = new Random();
Question question = availableQuestions.get(random.nextInt(availableQuestions.size()));
```

### 2. Boss Puzzle Limits
**Problem**: Limited to 2 boss puzzles maximum
**Solution**: Increased to 3 puzzles
```java
// Before
int bossPuzzleUses = 0;
if (/* conditions */ && bossPuzzleUses < 2) {

// After
int bossPuzzleUses = 0;
int maxBossPuzzles = 3;
if (/* conditions */ && bossPuzzleUses < maxBossPuzzles) {
```

### 3. Missing Puzzle Sequences
**Problem**: No 3-5 puzzle sequence per stage
**Solution**: Added `runPuzzleSequence()` method and integrated into all stages

### 4. Game Flow Alignment
**Problem**: Game flow didn't match documentation
**Solution**: Implemented complete stage flow as specified in Version-2.md

## Question Bank Details

### Ma'am Cathy (Stage 1) - Loops & Conditionals
- **Difficulty**: 1
- **Questions**: 5
- **Topics**: for loops, while loops, if-else statements, do-while loops
- **Examples**:
  - "What does this loop do: 'for(int i=0; i<5; i++)'?"
  - "Which loop is guaranteed to execute at least once?"

### Sir Khai (Stage 2) - Object-Oriented Programming
- **Difficulty**: 2
- **Questions**: 5
- **Topics**: Encapsulation, Inheritance, Polymorphism, Abstract classes, Access modifiers
- **Examples**:
  - "What is the main principle of encapsulation?"
  - "Which OOP concept allows a class to inherit properties from another class?"

### Serato (Stage 3) - Debugging & Data Structures
- **Difficulty**: 3
- **Questions**: 5
- **Topics**: Binary search, Stacks, Sorting algorithms, NullPointerException
- **Examples**:
  - "What is the time complexity of binary search?"
  - "Which data structure uses LIFO (Last-In-First-Out) principle?"

### Ma'am Tulin (Stage 4) - Information Systems
- **Difficulty**: 4
- **Questions**: 5
- **Topics**: Database normalization, SQL, Primary keys, ACID properties
- **Examples**:
  - "What is the purpose of database normalization?"
  - "Which SQL clause is used to filter results?"

### Dean (Stage 5) - All Combined
- **Difficulty**: 5
- **Questions**: 5
- **Topics**: Design patterns, Exception handling, REST APIs, Java collections
- **Examples**:
  - "Which design pattern ensures only one instance of a class exists?"
  - "What is the purpose of the 'finally' block in exception handling?"

## Performance Considerations

### Memory Management
- Question bank loaded once at startup
- Random selection without sorting for better performance
- Efficient status effect tracking with HashMap

### Input Validation
- Robust input handling with try-catch blocks
- Input retry mechanism for invalid answers
- Graceful error handling for edge cases

## Testing Strategy

### Unit Testing Areas
1. **PuzzleEngine**: Question selection, answer validation, damage calculation
2. **BattleSystem**: Boss puzzle triggering, combat integration
3. **Stage Classes**: Flow control, puzzle sequence integration
4. **Question Bank**: Question validity, difficulty distribution

### Integration Testing
1. **Complete Stage Flow**: Minions → Puzzles → Boss
2. **Boss Puzzle Triggers**: HP-based activation
3. **Random Event Integration**: Event triggering during puzzle sequences
4. **Character Progression**: XP gain from puzzles and battles

## Future Enhancements

### Potential Improvements
1. **Dynamic Difficulty**: Adjust puzzle difficulty based on player performance
2. **Hint System**: Provide hints for struggling players
3. **Achievement System**: Track puzzle mastery and perfect scores
4. **Custom Questions**: Allow educators to add custom questions
5. **Multiplayer**: Puzzle competitions between players
6. **Analytics**: Track player performance and question difficulty

### Code Quality Improvements
1. **Configuration Files**: Move question banks to external files
2. **Factory Pattern**: Create question factories for different types
3. **Strategy Pattern**: Implement different puzzle resolution strategies
4. **Observer Pattern**: Notify UI components of puzzle events

## Deployment Notes

### Compilation
```bash
javac -d out $(find src/main/java -name "*.java")
```

### Execution
```bash
java -cp out main.java.com.thelair.Main
```

### Dependencies
- Java 17+ (or compatible)
- No external libraries required
- Standard Java collections and utilities only

## UI System Implementation

### Title Logo System

#### ConsoleUI.getTitleFromFile()
**Purpose**: Loads ASCII art title logo from external file

**Implementation**:
```java
public static String getTitleFromFile() {
    // Try resource path first (for JAR deployment)
    InputStream inputStream = ConsoleUI.class.getResourceAsStream("/com/thelair/files/title.txt");
    
    // Fallback to file system paths (for development)
    if (inputStream == null) {
        String[] possiblePaths = {
            "src/main/java/com/thelair/files/title.txt",
            "out/com/thelair/files/title.txt",
            "com/thelair/files/title.txt"
        };
        // Try each path until file found
    }
    
    // Read file content line by line
    // Return content or fallback header
}
```

**File Location**: `src/main/java/com/thelair/files/title.txt`

**Features**:
- Multiple path fallback system
- UTF-8 encoding support
- Graceful error handling with fallback
- Works in both development and JAR deployment

### World Indicator System

#### Stage.getWorldIndicator()
**Purpose**: Extracts stage code (e.g., "NGE101") from stage name

**Implementation**:
```java
protected String getWorldIndicator() {
    // Extract pattern like "NGE 101" from stage name
    // Stage names: "NGE 101 – The Hall of Ma'am Cathy"
    String[] parts = stageName.split("–|\\-");
    if (parts.length > 0) {
        String codePart = parts[0].trim();
        return codePart.replaceAll("\\s+", ""); // "NGE101"
    }
    return "NGE101"; // Default fallback
}
```

#### BattleSystem Integration
**Display**: Every battle turn shows `[NGE101]` in bold cyan
```java
System.out.println(ConsoleUI.color("[" + worldIndicator + "]", ConsoleUI.CYAN + ConsoleUI.BOLD));
```

**Features**:
- Automatic extraction from stage name
- ANSI color formatting (bold cyan)
- Context-aware display
- Stage-specific codes (NGE101-NGE105)

### Input Validation System

#### Comprehensive Error Handling

**Main.java**:
```java
while (true) {
    try {
        ConsoleUI.prompt("Enter choice:");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice >= 1 && choice <= max) {
            break; // Valid input
        } else {
            System.out.println("Invalid choice! Please enter 1 or 2.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a number (1 or 2).");
    }
}
```

**BattleSystem.safeNextInt()**:
```java
private int safeNextInt(int min, int max, String prompt) {
    while (true) {
        try {
            ConsoleUI.prompt(prompt);
            int value = scanner.nextInt();
            scanner.nextLine();
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Invalid choice! Please enter a number between " + min + " and " + max + ".");
            }
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            System.out.println("Invalid input! Please enter a number.");
        }
    }
}
```

**Features**:
- All prompts inside try blocks
- Range validation for menu choices
- Clear error messages
- Automatic retry loops
- Prevents invalid input crashes

### ANSI Color System

#### ConsoleUI Color Constants
```java
public static final String RESET = "\u001B[0m";
public static final String BOLD = "\u001B[1m";
public static final String RED = "\u001B[31m";
public static final String GREEN = "\u001B[32m";
public static final String YELLOW = "\u001B[33m";
public static final String BLUE = "\u001B[34m";
public static final String CYAN = "\u001B[36m";
```

#### Usage Examples
- **World Indicators**: Bold cyan `[NGE101]`
- **Battle HUD**: Green (HP), Blue (Wisdom), Red (Enemy HP)
- **Menu Sections**: Cyan headers
- **Emphasis**: Yellow for important text

## File System Architecture

### File Structure
```
src/main/java/com/thelair/
├── files/
│   └── title.txt          # ASCII art title logo
├── battle/
│   ├── BattleSystem.java # Combat and world indicator
│   └── ...
├── game/
│   ├── Stage.java        # World indicator extraction
│   └── ...
└── ui/
    └── ConsoleUI.java    # File loading and display
```

### Resource Loading Strategy

1. **Primary**: Try resource path (`/com/thelair/files/title.txt`)
   - Works when packaged as JAR
   - Standard Java resource loading

2. **Fallback 1**: Development path (`src/main/java/com/thelair/files/title.txt`)
   - For running from project root
   - Direct file system access

3. **Fallback 2**: Compiled path (`out/com/thelair/files/title.txt`)
   - For running from compiled output
   - Post-compilation file access

4. **Final Fallback**: Default header
   - If all paths fail, use text-based header
   - Ensures game always starts

## Maintenance Guidelines

### Adding New Questions
1. Add question to appropriate guardian's question bank in `PuzzleEngine.java`
2. Ensure proper difficulty level assignment
3. Test question validity and answer correctness
4. Update documentation if adding new categories

### Modifying Game Flow
1. Update stage classes to maintain consistency
2. Ensure puzzle sequences are properly integrated
3. Test all stages for proper flow
4. Update documentation and flowcharts

### Updating Title Logo
1. Edit `src/main/java/com/thelair/files/title.txt`
2. Ensure UTF-8 encoding
3. Test file loading in both development and compiled modes
4. Verify fallback behavior if file missing

### Adding New Stages
1. Create new `StageX.java` extending `Stage<Guardian>`
2. Implement `getWorldIndicator()` automatically extracts code
3. Pass world indicator to `BattleSystem` constructor
4. Update `GameManager` to include new stage

### Performance Monitoring
1. Monitor question selection performance
2. Track memory usage with large question banks
3. Ensure input validation doesn't cause delays
4. Test with various player skill levels
5. Monitor file I/O performance for title loading
