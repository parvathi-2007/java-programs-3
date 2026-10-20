package mod3;
import java.util.Scanner;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

public class program1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the number of values: ");
            int n = sc.nextInt();

            if (n <= 0) {
                throw new InvalidNumberException(
                    "N must be positive."
                );
            }

            double sum = 0;

            for (int i = 1; i <= n; i++) {
                System.out.print("Enter number " + i + ": ");
                double num = sc.nextDouble();

                if (num <= 0) {
                    throw new InvalidNumberException(
                        "Zero or negative numbers are not allowed."
                    );
                }

                sum = sum + num;
            }

            double average = sum / n;

            System.out.println("Sum = " + sum);
            System.out.println("Average = " + average);

        } catch (InvalidNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
