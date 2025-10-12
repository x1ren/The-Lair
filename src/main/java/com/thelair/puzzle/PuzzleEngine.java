package main.java.com.thelair.puzzle;

import main.java.com.thelair.guardian.Guardian;
import main.java.com.thelair.player.Player;
import java.util.*;

public class PuzzleEngine {
    private final Map<String, List<Question>> questionBank;
    private final Random random;

    public PuzzleEngine() {
        this.questionBank = new HashMap<>();
        this.random = new Random();
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
        questionBank.put("Dean", deanQuestions);
    }

    public boolean triggerFinisher(Guardian guardian, Player player, Scanner scanner) {
        String guardianName = guardian.getName();
        List<Question> availableQuestions = questionBank.get(guardianName);
        
        if (availableQuestions == null || availableQuestions.isEmpty()) {
            System.out.println("No questions available for " + guardianName);
            return false;
        }

        // Prefer a harder question when the guardian is in finisher range, else random
        availableQuestions.sort(Comparator.comparingInt(Question::getDifficulty).reversed());
        Question question = availableQuestions.get(0);
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
        return hpPercentage <= 0.10; // 10% HP threshold
    }
}


