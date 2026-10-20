package mod3;


import java.util.Scanner;

class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(String message) {
        super(message);
    }
}

class Student {

    private int score;

    public void setScore(int score) {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException(
                "Score must be between 0 and 100."
            );
        }

        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

public class program3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        System.out.print("Enter student score: ");
        int score = sc.nextInt();

        try {
            student.setScore(score);
            System.out.println("Valid score: " + student.getScore());

        } catch (InvalidScoreException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
