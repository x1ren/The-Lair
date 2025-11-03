package com.thelair.puzzle;

import com.thelair.guardian.Guardian;
import com.thelair.player.Player;
import java.util.*;
import java.util.Random;

public class PuzzleEngine {
    private final Map<String, List<Question>> questionBank;

    public PuzzleEngine() {
        this.questionBank = new HashMap<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Stage 1: Cathy - Basics (Loops, Conditionals) - Difficulty 1
        List<Question> cathyQuestions = new ArrayList<>();
        cathyQuestions.add(new Question(
            "What does this loop do: 'for(int i=0; i<5; i++)'?",
            new String[]{
                "Runs 5 times",
                "Runs 6 times",
                "Runs 4 times",
                "Runs infinitely"
            },
            0, "Loops", 1
        ));
        cathyQuestions.add(new Question(
            "In an if-else statement, when is the else block executed?",
            new String[]{
                "When if condition is true",
                "When if condition is false",
                "Always after if block",
                "Never"
            },
            1, "Conditionals", 1
        ));
        cathyQuestions.add(new Question(
            "Which loop is guaranteed to execute at least once?",
            new String[]{
                "for loop",
                "while loop",
                "do-while loop",
                "if statement"
            },
            2, "Loops", 1
        ));
        cathyQuestions.add(new Question(
            "What happens if a while loop condition is never false?",
            new String[]{
                "It runs once",
                "It causes a compilation error",
                "It creates an infinite loop",
                "It skips the loop body"
            },
            2, "Loops", 1
        ));
        cathyQuestions.add(new Question(
            "Which of these is NOT a valid loop structure in Java?",
            new String[]{
                "for loop",
                "while loop",
                "do-while loop",
                "repeat-until loop"
            },
            3, "Loops", 1
        ));
        questionBank.put("Ma'am Cathy", cathyQuestions);

        // Stage 2: Khai - OOP - Difficulty 2
        List<Question> khaiQuestions = new ArrayList<>();
        khaiQuestions.add(new Question(
            "What is the main principle of encapsulation?",
            new String[]{
                "Hiding implementation details",
                "Creating multiple objects", 
                "Reusing code", 
                "Making everything public"
            },
            0, "OOP Principles", 2
        ));
        khaiQuestions.add(new Question(
            "Which OOP concept allows a class to inherit properties from another class?",
            new String[]{
                "Polymorphism", 
                "Encapsulation", 
                "Inheritance", 
                "Abstraction"
            },
            2, "OOP Concepts", 2
        ));
        khaiQuestions.add(new Question(
            "What is an abstract class?",
            new String[]{
                "A class that can't be instantiated",
                "A class with only static methods",
                "A class that must be final",
                "A class with no methods"
            },
            0, "OOP Concepts", 2
        ));
        khaiQuestions.add(new Question(
            "What does 'polymorphism' allow in OOP?",
            new String[]{
                "One interface, multiple implementations",
                "Multiple inheritance",
                "Code duplication",
                "Static method overriding"
            },
            0, "OOP Concepts", 2
        ));
        khaiQuestions.add(new Question(
            "Which access modifier makes a method visible only within its own package?",
            new String[]{
                "public",
                "private",
                "protected",
                "default (package-private)"
            },
            3, "OOP Access", 2
        ));
        questionBank.put("Sir Khai", khaiQuestions);

        // Stage 3: Serato - Debugging and DSA - Difficulty 3
        List<Question> seratoQuestions = new ArrayList<>();
        seratoQuestions.add(new Question(
            "What is the time complexity of binary search?",
            new String[]{
                "O(1)", 
                "O(n)", 
                "O(log n)", 
                "O(n²)"
            },
            2, "Algorithms", 3
        ));
        seratoQuestions.add(new Question(
            "Which data structure uses LIFO (Last-In-First-Out) principle?",
            new String[]{
                "Queue", 
                "Stack", 
                "Linked List", 
                "Tree"
            },
            1, "Data Structures", 3
        ));
        seratoQuestions.add(new Question(
            "What does a NullPointerException indicate?",
            new String[]{
                "Division by zero",
                "Trying to use a null object",
                "Array index out of bounds",
                "Infinite loop"
            },
            1, "Debugging", 3
        ));
        seratoQuestions.add(new Question(
            "What is the worst-case time complexity of quicksort?",
            new String[]{
                "O(n)",
                "O(n log n)",
                "O(n²)",
                "O(2^n)"
            },
            2, "Algorithms", 3
        ));
        seratoQuestions.add(new Question(
            "Which sorting algorithm is generally considered the fastest for large datasets?",
            new String[]{
                "Bubble sort",
                "Insertion sort",
                "Merge sort",
                "Selection sort"
            },
            2, "Algorithms", 3
        ));
        questionBank.put("Serato", seratoQuestions);

        // Stage 4: Tulin - Information Management - Difficulty 4
        List<Question> tulinQuestions = new ArrayList<>();
        tulinQuestions.add(new Question(
            "What is the purpose of database normalization?",
            new String[]{
                "To reduce data redundancy",
                "To increase storage space",
                "To make queries slower",
                "To duplicate data"
            },
            0, "Databases", 4
        ));
        tulinQuestions.add(new Question(
            "Which SQL clause is used to filter results?",
            new String[]{
                "SELECT", 
                "FROM", 
                "WHERE", 
                "JOIN"
            },
            2, "SQL", 4
        ));
        tulinQuestions.add(new Question(
            "What is a primary key in a database?",
            new String[]{
                "A key that can be null",
                "A unique identifier for each record",
                "A foreign key from another table",
                "Any column in a table"
            },
            1, "Databases", 4
        ));
        tulinQuestions.add(new Question(
            "What does ACID stand for in database transactions?",
            new String[]{
                "Atomicity, Consistency, Isolation, Durability",
                "Access, Control, Identity, Data",
                "Automated, Centralized, Integrated, Distributed",
                "Application, Client, Interface, Database"
            },
            0, "Databases", 4
        ));
        tulinQuestions.add(new Question(
            "Which SQL command is used to modify existing data?",
            new String[]{
                "SELECT",
                "INSERT",
                "UPDATE",
                "DELETE"
            },
            2, "SQL", 4
        ));
        questionBank.put("Ma'am Tulin", tulinQuestions);

        // Stage 5: Dean - All Combined - Difficulty 5
        List<Question> deanQuestions = new ArrayList<>();
        deanQuestions.add(new Question(
            "Which design pattern ensures only one instance of a class exists?",
            new String[]{
                "Factory Pattern", 
                "Singleton Pattern", 
                "Observer Pattern", 
                "Adapter Pattern"
            },
            1, "Design Patterns", 5
        ));
        deanQuestions.add(new Question(
            "What is the purpose of the 'finally' block in exception handling?",
            new String[]{
                "To handle exceptions",
                "To catch specific exceptions",
                "To execute code regardless of exceptions",
                "To throw new exceptions"
            },
            2, "Exception Handling", 5
        ));
        deanQuestions.add(new Question(
            "In REST APIs, what does HTTP status code 201 indicate?",
            new String[]{
                "Success",
                "Created",
                "Not Found",
                "Server Error"
            },
            1, "Web Development", 5
        ));
        deanQuestions.add(new Question(
            "What is the main advantage of using interfaces in Java?",
            new String[]{
                "They allow multiple inheritance",
                "They provide default method implementations",
                "They enable polymorphism",
                "All of the above"
            },
            3, "OOP Advanced", 5
        ));
        deanQuestions.add(new Question(
            "Which collection type in Java maintains insertion order and allows duplicates?",
            new String[]{
                "Set",
                "Map",
                "List",
                "Queue"
            },
            2, "Java Collections", 5
        ));
        questionBank.put("Dean", deanQuestions);
    }

    public boolean triggerFinisher(Guardian guardian, Player player, Scanner scanner) {
        String guardianName = guardian.getName();
        List<Question> availableQuestions = questionBank.get(guardianName);
        
        if (availableQuestions == null || availableQuestions.isEmpty()) {
            System.out.println("No questions available for " + guardianName);
            return false;
        }

        // Random question selection for variety
        Random random = new Random();
        Question question = availableQuestions.get(random.nextInt(availableQuestions.size()));
        question.displayQuestion();

        String input = scanner.nextLine().trim().toUpperCase();
        int playerAnswer = -1;
        
        switch(input) {
            case "A": playerAnswer = 0; break;
            case "B": playerAnswer = 1; break;
            case "C": playerAnswer = 2; break;
            case "D": playerAnswer = 3; break;
            default: 
                System.out.println("Invalid input! Please enter A, B, C, or D.");
                return false;
        }

        if (question.isCorrect(playerAnswer)) {
            System.out.println("\n✓ " + guardianName + " collapses: 'Impossible... you truly understand...'");
            return true;
        } else {
            int healAmount = (int)(guardian.getMaxHP() * 0.25);
            guardian.heal(healAmount);
            System.out.println("\n✗ " + guardianName + " laughs: 'Fool! You know nothing! I regain my strength!'");
            System.out.println(guardianName + " regenerates " + healAmount + " HP!");
            return false;
        }
    }

    public boolean shouldTriggerFinisher(Guardian guardian) {
        double hpPercentage = (double) guardian.getCurrentHP() / guardian.getMaxHP();
        return hpPercentage <= 0.40; // 40% HP threshold per docs
    }

    // Ask a question based on a theme (guardian name) without needing a real Guardian.
    public boolean triggerThemeQuestion(String themeGuardianName, Scanner scanner) {
        List<Question> availableQuestions = questionBank.get(themeGuardianName);
        if (availableQuestions == null || availableQuestions.isEmpty()) {
            System.out.println("No questions available for theme: " + themeGuardianName);
            return false;
        }
        // Random question selection for variety
        Random random = new Random();
        Question question = availableQuestions.get(random.nextInt(availableQuestions.size()));
        question.displayQuestion();

        String input = scanner.nextLine().trim().toUpperCase();
        int playerAnswer;
        switch(input) {
            case "A": playerAnswer = 0; break;
            case "B": playerAnswer = 1; break;
            case "C": playerAnswer = 2; break;
            case "D": playerAnswer = 3; break;
            default: 
                System.out.println("Invalid input! Please enter A, B, C, or D.");
                return false;
        }
        return question.isCorrect(playerAnswer);
    }

    // Run the main puzzle sequence for a stage (3-5 puzzles as per documentation)
    public boolean runPuzzleSequence(String guardianName, Player player, Scanner scanner) {
        List<Question> availableQuestions = questionBank.get(guardianName);
        if (availableQuestions == null || availableQuestions.isEmpty()) {
            System.out.println("No questions available for " + guardianName);
            return false;
        }

        Random random = new Random();
        int puzzleCount = random.nextInt(3) + 3; // 3-5 puzzles
        int correctAnswers = 0;
        
        System.out.println("\n " + guardianName + " challenges you with " + puzzleCount + " puzzles!");
        System.out.println("Answer correctly to proceed to the final battle...\n");

        for (int i = 1; i <= puzzleCount; i++) {
            System.out.println("--- Puzzle " + i + "/" + puzzleCount + " ---");
            
            // Select random question
            Question question = availableQuestions.get(random.nextInt(availableQuestions.size()));
            question.displayQuestion();

            String input = scanner.nextLine().trim().toUpperCase();
            int playerAnswer = -1;
            
            switch(input) {
                case "A": playerAnswer = 0; break;
                case "B": playerAnswer = 1; break;
                case "C": playerAnswer = 2; break;
                case "D": playerAnswer = 3; break;
                default: 
                    System.out.println("Invalid input! Please enter A, B, C, or D.");
                    i--; // Retry this puzzle
                    continue;
            }

            if (question.isCorrect(playerAnswer)) {
                System.out.println("✓ Correct! Well done!");
                correctAnswers++;
            } else {
                System.out.println("✗ Incorrect. The answer was: " + question.getOptions()[question.getCorrectAnswer()]);
                // Take damage based on difficulty
                int damage = question.getDifficulty() * 10;
                player.takeDamage(damage);
                System.out.println("You take " + damage + " damage from the wrong answer!");
                
                if (!player.isAlive()) {
                    System.out.println("You have been defeated by the puzzles!");
                    return false;
                }
            }
            System.out.println();
        }

        System.out.println("Puzzle sequence complete! You answered " + correctAnswers + "/" + puzzleCount + " correctly.");
        
        // Bonus for perfect score
        if (correctAnswers == puzzleCount) {
            System.out.println("Perfect score! You gain 50 bonus experience!");
            player.gainExperience(50);
        }
        
        return true; // Player survived the puzzle sequence
    }
}


