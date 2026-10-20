package mod4;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program1 extends JFrame implements ActionListener {

    JTextField limitField;
    DefaultListModel<Long> listModel;
    JList<Long> fibonacciList;
    JButton generateButton, clearButton;

    program1() {
        setTitle("Fibonacci Series");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter limit:"));
        limitField = new JTextField(10);
        add(limitField);

        generateButton = new JButton("Generate");
        clearButton = new JButton("Clear");

        add(generateButton);
        add(clearButton);

        listModel = new DefaultListModel<>();
        fibonacciList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(fibonacciList);
        scrollPane.setPreferredSize(new Dimension(280, 220));
        add(scrollPane);

        generateButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == generateButton) {
            listModel.clear();

            try {
                long limit = Long.parseLong(limitField.getText().trim());

                if (limit < 0) {
                    JOptionPane.showMessageDialog(
                        this, "Enter a non-negative limit."
                    );
                    return;
                }

                long first = 0;
                long second = 1;

                while (first <= limit) {
                    listModel.addElement(first);

                    if (Long.MAX_VALUE - first < second) {
                        break;
                    }

                    long next = first + second;
                    first = second;
                    second = next;
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this, "Please enter a valid whole number."
                );
            }
        }

        if (e.getSource() == clearButton) {
            limitField.setText("");
            listModel.clear();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new program1());
    }
}
