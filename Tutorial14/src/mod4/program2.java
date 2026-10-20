package mod4;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program2 extends JFrame implements ActionListener {

    JTextField numberField;
    JLabel resultLabel;
    JButton calculateButton, clearButton;

    program2() {
        setTitle("Factorial Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter a non-negative integer:"));

        numberField = new JTextField(10);
        add(numberField);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        add(calculateButton);
        add(clearButton);

        resultLabel = new JLabel("Factorial: ");
        add(resultLabel);

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {
            try {
                int number = Integer.parseInt(
                    numberField.getText().trim()
                );

                if (number < 0 || number > 20) {
                    resultLabel.setText(
                        "Enter a number from 0 to 20."
                    );
                    return;
                }

                long factorial = 1;

                for (int i = 1; i <= number; i++) {
                    factorial = factorial * i;
                }

                resultLabel.setText("Factorial: " + factorial);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Enter a valid whole number.");
            }
        }

        if (e.getSource() == clearButton) {
            numberField.setText("");
            resultLabel.setText("Factorial: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new program2());
    }
}

