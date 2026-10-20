package mod4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program5 extends JFrame implements ActionListener {

    JTextField numberField, previousField, nextField;
    JLabel numberLabel, previousLabel, nextLabel;
    JButton calculateButton;

    program5() {
        setTitle("Previous and Next Number");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        numberLabel = new JLabel("Enter a number:");
        numberField = new JTextField(10);

        previousLabel = new JLabel("Previous number:");
        previousField = new JTextField(10);
        previousField.setEditable(false);

        nextLabel = new JLabel("Next number:");
        nextField = new JTextField(10);
        nextField.setEditable(false);

        calculateButton = new JButton("Calculate");

        add(numberLabel);
        add(numberField);

        add(previousLabel);
        add(previousField);

        add(nextLabel);
        add(nextField);

        add(calculateButton);

        calculateButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            long number = Long.parseLong(
                numberField.getText().trim()
            );

            previousField.setText(String.valueOf(number - 1));
            nextField.setText(String.valueOf(number + 1));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid whole number."
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new program5());
    }
}

