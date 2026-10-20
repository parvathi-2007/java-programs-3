package mod4;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class program1 extends JFrame
        implements ActionListener {

    JTextField guessField;
    JLabel feedbackLabel, numberLabel;
    JButton guessButton, newGameButton;

    int randomNumber;

    program1() {
        setTitle("Number Guessing Game");
        setSize(420, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        numberLabel = new JLabel();
        feedbackLabel = new JLabel(
            "Guess a number between 1 and 100."
        );

        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        newGameButton = new JButton("New Game");

        add(new JLabel("Your guess:"));
        add(guessField);
        add(guessButton);
        add(newGameButton);
        add(feedbackLabel);
        add(numberLabel);

        guessButton.addActionListener(this);
        newGameButton.addActionListener(this);

        generateNumber();

        setVisible(true);
    }

    void generateNumber() {
        randomNumber = new Random().nextInt(100) + 1;

        numberLabel.setText(
            "Random number: " + randomNumber
        );
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == guessButton) {
            try {
                int guess = Integer.parseInt(
                    guessField.getText().trim()
                );

                if (guess < 1 || guess > 100) {
                    feedbackLabel.setText(
                        "Enter a number from 1 to 100."
                    );
                } else if (guess < randomNumber) {
                    feedbackLabel.setText("Too low! Try again.");
                } else if (guess > randomNumber) {
                    feedbackLabel.setText("Too high! Try again.");
                } else {
                    feedbackLabel.setText("Correct! You won!");
                }

            } catch (NumberFormatException ex) {
                feedbackLabel.setText(
                    "Please enter a valid whole number."
                );
            }
        }

        if (e.getSource() == newGameButton) {
            generateNumber();
            guessField.setText("");
            feedbackLabel.setText(
                "Guess a number between 1 and 100."
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new program1()
        );
    }
}
