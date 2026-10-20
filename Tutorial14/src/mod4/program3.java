package mod4;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program3 extends JFrame implements ActionListener {

    JTextField feetField, inchesField;
    JLabel resultLabel;
    JButton convertButton, clearButton;

    program3() {
        setTitle("Feet and Inches to Centimeters");
        setSize(400, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter feet:"));
        feetField = new JTextField(8);
        add(feetField);

        add(new JLabel("Enter inches:"));
        inchesField = new JTextField(8);
        add(inchesField);

        convertButton = new JButton("Convert");
        clearButton = new JButton("Clear");
        add(convertButton);
        add(clearButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        convertButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == convertButton) {
            try {
                double feet = Double.parseDouble(
                    feetField.getText().trim()
                );
                double inches = Double.parseDouble(
                    inchesField.getText().trim()
                );

                if (feet < 0 || inches < 0) {
                    resultLabel.setText(
                        "Lengths cannot be negative."
                    );
                    return;
                }

                double totalInches = feet * 12 + inches;
                double centimeters = totalInches * 2.54;

                resultLabel.setText(
                    String.format("Result: %.2f cm", centimeters)
                );

            } catch (NumberFormatException ex) {
                resultLabel.setText(
                    "Please enter valid numbers."
                );
            }
        }

        if (e.getSource() == clearButton) {
            feetField.setText("");
            inchesField.setText("");
            resultLabel.setText("Result: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new program3());
    }
}
