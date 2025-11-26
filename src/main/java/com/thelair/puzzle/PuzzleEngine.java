package com.thelair.puzzle;

import com.thelair.guardian.Guardian;
import com.thelair.player.Player;
import java.util.*;

public class PuzzleEngine {
    private final Map<String, List<Question>> questionBank;

    // Tracks each guardian's current question index
    private final Map<String, Integer> questionIndexTracker;

    public PuzzleEngine() {
        this.questionBank = new HashMap<>();
        this.questionIndexTracker = new HashMap<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Stage 1: Cathy
        List<Question> cathyQuestions = new ArrayList<>();
        cathyQuestions.add(new Question(
            "What does this loop do: 'for(int i=0; i<5; i++)'?",
            new String[]{"Runs 5 times","Runs 6 times","Runs 4 times","Runs infinitely"},
            0, "Loops", 1
        ));
        cathyQuestions.add(new Question(
            "In an if-else statement, when is the else block executed?",
            new String[]{"When if condition is true","When if condition is false","Always after if block","Never"},
            1, "Conditionals", 1
        ));
        cathyQuestions.add(new Question(
            "Which loop is guaranteed to execute at least once?",
            new String[]{"for loop","while loop","do-while loop","if statement"},
            2, "Loops", 1
        ));
        cathyQuestions.add(new Question(
            "What happens if a while loop condition is never false?",
            new String[]{"It runs once","It causes a compilation error","It creates an infinite loop","It skips the loop body"},
            2, "Loops", 1
        ));
        cathyQuestions.add(new Question(
            "Which of these is NOT a valid loop structure in Java?",
            new String[]{"for loop","while loop","do-while loop","repeat-until loop"},
            3, "Loops", 1
        ));
        questionBank.put("Ma'am Cathy", cathyQuestions);

        // Stage 2: Khai
        List<Question> khaiQuestions = new ArrayList<>();
        khaiQuestions.add(new Question(
            "What is the main principle of encapsulation?",
            new String[]{"Hiding implementation details","Creating multiple objects","Reusing code","Making everything public"},
            0, "OOP Principles", 2
        ));
        khaiQuestions.add(new Question(
            "Which OOP concept allows a class to inherit properties from another class?",
            new String[]{"Polymorphism","Encapsulation","Inheritance","Abstraction"},
            2, "OOP Concepts", 2
        ));
        khaiQuestions.add(new Question(
            "What is an abstract class?",
            new String[]{"A class that can't be instantiated","A class with only static methods","A class that must be final","A class with no methods"},
            0, "OOP Concepts", 2
        ));
        khaiQuestions.add(new Question(
            "What does 'polymorphism' allow in OOP?",
            new String[]{"One interface, multiple implementations","Multiple inheritance","Code duplication","Static method overriding"},
            0, "OOP Concepts", 2
        ));
        khaiQuestions.add(new Question(
            "Which access modifier makes a method visible only within its own package?",
            new String[]{"public","private","protected","default (package-private)"},
            3, "OOP Access", 2
        ));
        questionBank.put("Sir Khai", khaiQuestions);

        // Stage 3: Serato
        List<Question> seratoQuestions = new ArrayList<>();
        seratoQuestions.add(new Question(
            "What is the time complexity of binary search?",
            new String[]{"O(1)","O(n)","O(log n)","O(n²)"},
            2, "Algorithms", 3
        ));
        seratoQuestions.add(new Question(
            "Which data structure uses LIFO?",
            new String[]{"Queue","Stack","Linked List","Tree"},
            1, "Data Structures", 3
        ));
        seratoQuestions.add(new Question(
            "What does a NullPointerException indicate?",
            new String[]{"Division by zero","Trying to use a null object","Array index out of bounds","Infinite loop"},
            1, "Debugging", 3
        ));
        seratoQuestions.add(new Question(
            "What is the worst-case time complexity of quicksort?",
            new String[]{"O(n)","O(n log n)","O(n²)","O(2^n)"},
            2, "Algorithms", 3
        ));
        seratoQuestions.add(new Question(
            "Which sorting algorithm is fastest for large datasets?",
            new String[]{"Bubble sort","Insertion sort","Merge sort","Selection sort"},
            2, "Algorithms", 3
        ));
        questionBank.put("Serato", seratoQuestions);

        // Stage 4: Tulin
        List<Question> tulinQuestions = new ArrayList<>();
        tulinQuestions.add(new Question(
            "What is the purpose of database normalization?",
            new String[]{"To reduce data redundancy","To increase storage space","To make queries slower","To duplicate data"},
            0, "Databases", 4
        ));
        tulinQuestions.add(new Question(
            "Which SQL clause is used to filter results?",
            new String[]{"SELECT","FROM","WHERE","JOIN"},
            2, "SQL", 4
        ));
        tulinQuestions.add(new Question(
            "What is a primary key?",
            new String[]{"A key that can be null","A unique identifier","A foreign key","Any column"},
            1, "Databases", 4
        ));
        tulinQuestions.add(new Question(
            "What does ACID stand for?",
            new String[]{"Atomicity, Consistency, Isolation, Durability","Access, Control, Identity, Data","Automated, Centralized, Integrated, Distributed","Application, Client, Interface, Database"},
            0, "Databases", 4
        ));
        tulinQuestions.add(new Question(
            "Which SQL command modifies existing data?",
            new String[]{"SELECT","INSERT","UPDATE","DELETE"},
            2, "SQL", 4
        ));
        questionBank.put("Ma'am Tulin", tulinQuestions);

        // Stage 5: Dean
        List<Question> deanQuestions = new ArrayList<>();
        deanQuestions.add(new Question(
            "Which design pattern ensures only one instance exists?",
            new String[]{"Factory","Singleton","Observer","Adapter"},
            1, "Design Patterns", 5
        ));
        deanQuestions.add(new Question(
            "What is the purpose of the finally block?",
            new String[]{"To handle exceptions","To catch exceptions","To execute regardless of exceptions","To throw exceptions"},
            2, "Exception Handling", 5
        ));
        deanQuestions.add(new Question(
            "HTTP 201 means?",
            new String[]{"Success","Created","Not Found","Server Error"},
            1, "Web Development", 5
        ));
        deanQuestions.add(new Question(
            "Main advantage of interfaces?",
            new String[]{"Multiple inheritance","Default methods","Enable polymorphism","All of the above"},
            3, "OOP", 5
        ));
        deanQuestions.add(new Question(
            "Which collection maintains order & allows duplicates?",
            new String[]{"Set","Map","List","Queue"},
            2, "Collections", 5
        ));
        questionBank.put("Dean", deanQuestions);
    }

  
    //  //sequential
    private Question getNextSequentialQuestion(String guardianName) {
        List<Question> questions = questionBank.get(guardianName);
        int index = questionIndexTracker.getOrDefault(guardianName, 0);

        if (index >= questions.size()) index = 0;

        Question q = questions.get(index);

        questionIndexTracker.put(guardianName, index + 1);
        return q;
    }


    //finisher  //sequential
    public boolean triggerFinisher(Guardian guardian, Player player, Scanner scanner) {
        String guardianName = guardian.getName();
        List<Question> availableQuestions = questionBank.get(guardianName);
        
        if (availableQuestions == null || availableQuestions.isEmpty()) {
            System.out.println("No questions available for " + guardianName);
            return false;
        }

        Question question = getNextSequentialQuestion(guardianName);
        question.displayQuestion();

        String input = scanner.nextLine().trim().toUpperCase();
        int playerAnswer = switch(input) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            default -> {
                System.out.println("Invalid input!");
                yield -1;
            }
        };
        if (playerAnswer == -1) return false;

        if (question.isCorrect(playerAnswer)) {
            System.out.println("\n✓ " + guardianName + " collapses!");
            return true;
        } else {
            int healAmount = (int)(guardian.getMaxHP() * 0.25);
            guardian.heal(healAmount);
            System.out.println("\n✗ Wrong! " + guardianName + " regenerates " + healAmount + " HP!");
            return false;
        }
    }

    public boolean shouldTriggerFinisher(Guardian guardian) {
        return (double) guardian.getCurrentHP() / guardian.getMaxHP() <= 0.40;
    }

  
    //-theme question  //sequential
    public boolean triggerThemeQuestion(String themeGuardianName, Scanner scanner) {
        List<Question> availableQuestions = questionBank.get(themeGuardianName);
        if (availableQuestions == null || availableQuestions.isEmpty()) {
            System.out.println("No questions available for theme: " + themeGuardianName);
            return false;
        }

        Question question = getNextSequentialQuestion(themeGuardianName);
        question.displayQuestion();

        String input = scanner.nextLine().trim().toUpperCase();
        int playerAnswer = switch(input) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            default -> {
                System.out.println("Invalid input!");
                yield -1;
            }
        };
        if (playerAnswer == -1) return false;

        return question.isCorrect(playerAnswer);
    }

   
    //sequential
    public boolean runPuzzleSequence(String guardianName, Player player, Scanner scanner) {
    List<Question> availableQuestions = questionBank.get(guardianName);
    if (availableQuestions == null || availableQuestions.isEmpty()) {
        System.out.println("No questions available for " + guardianName);
        return false;
    }

    Random random = new Random();
    int puzzleCount = random.nextInt(3) + 3; // still 3–5 puzzles
    int correctAnswers = 0;

    System.out.println("\n" + guardianName + " challenges you with " + puzzleCount + " puzzles!\n");

    for (int i = 1; i <= puzzleCount; i++) {
        System.out.println("--- Puzzle " + i + "/" + puzzleCount + " ---");

        Question question = getNextSequentialQuestion(guardianName);
        question.displayQuestion();

        String input = scanner.nextLine().trim().toUpperCase();
        int playerAnswer = switch (input) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            default -> {
                System.out.println("Invalid input! Try again.");
                yield -1;
            }
        };

        if (playerAnswer == -1) {
            i--; 
            continue;
        }

        if (question.isCorrect(playerAnswer)) {
            System.out.println("✓ Correct!");
            correctAnswers++;

            int reward = random.nextInt(3);
            switch (reward) {
                case 0 -> player.addItem("POTION_SMALL");
                case 1 -> player.addItem("ETHER_SMALL");
                case 2 -> player.addItem("BOMB");
            }
        } else {
            System.out.println("✗ Incorrect! Answer: " + question.getOptions()[question.getCorrectAnswer()]);
            int damage = question.getDifficulty() * 10;
            player.takeDamage(damage);
            System.out.println("You took " + damage + " damage!");

            if (!player.isAlive()) {
                System.out.println("You died to the puzzles!");
                return false;
            }
        }

        System.out.println();
    }

    System.out.println("Puzzle complete! Score: " + correctAnswers + "/" + puzzleCount);

    if (correctAnswers == puzzleCount) {
        System.out.println("Perfect score! +50 XP!");
        player.gainExperience(50);
    }

    return true;
}

}
