package mod4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program4 extends JFrame implements ActionListener {

    JTextField numberField;
    JLabel resultLabel;
    JButton checkButton, clearButton;

    program4() {
        setTitle("Prime Number Checker");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter an integer:"));

        numberField = new JTextField(10);
        add(numberField);

        checkButton = new JButton("Check");
        clearButton = new JButton("Clear");

        add(checkButton);
        add(clearButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        checkButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkButton) {
            try {
                int number = Integer.parseInt(
                    numberField.getText().trim()
                );

                if (number < 2) {
                    resultLabel.setText(
                        number + " is not a prime number."
                    );
                    return;
                }

                boolean isPrime = true;

                for (int i = 2; i <= number / i; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    resultLabel.setText(
                        number + " is a prime number."
                    );
                } else {
                    resultLabel.setText(
                        number + " is not a prime number."
                    );
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText(
                    "Please enter a valid integer."
                );
            }
        }

        if (e.getSource() == clearButton) {
            numberField.setText("");
            resultLabel.setText("Result: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new program4());
    }
}
