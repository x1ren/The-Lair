package main.java.com.thelair.puzzle;

public class Question {
    private final String question;
    private final String[] options;
    private final int correctAnswer; 
    private final String topic;
    private final int difficulty;

    public Question(String question, String[] options, int correctAnswer, String topic, int difficulty) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.topic = topic;
        this.difficulty = difficulty;
    }

    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public int getCorrectAnswer() { return correctAnswer; }
    public String getTopic() { return topic; }
    public int getDifficulty() { return difficulty; }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }

    public void displayQuestion() {
    System.out.println("\n=== FINAL CHALLENGE ===");
    System.out.println("Topic: " + topic);
    
    String bossMessage = "";
    switch(topic) {
        case "Loops":
        case "Conditionals":
            bossMessage = "Cathy gasps: 'Prove you understand the fundamentals! Answer this:'";
            break;
        case "OOP Principles":
        case "OOP Concepts":
            bossMessage = "Khai struggles: 'Show me you grasp true object-oriented design! Tell me:'";
            break;
        case "Algorithms":
        case "Data Structures":
        case "Debugging":
            bossMessage = "Serato wheezes: 'Your code means nothing without proper structure! Answer:'";
            break;
        case "Databases":
        case "SQL":
            bossMessage = "Tulin whispers: 'Data is power... prove you can wield it! Tell me:'";
            break;
        default:
            bossMessage = "Dean collapses: 'All my knowledge... condensed to one final question:'";
    }
    
    System.out.println(bossMessage);
    System.out.println(question);
    System.out.println("A) " + options[0]);
    System.out.println("B) " + options[1]);
    System.out.println("C) " + options[2]);
    System.out.println("D) " + options[3]);
    System.out.print("Your answer (A/B/C/D): ");
}
}


