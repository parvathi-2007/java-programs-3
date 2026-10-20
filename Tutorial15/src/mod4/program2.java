package mod4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program2 extends JFrame
        implements ActionListener {

    JTextField countField;
    JButton upButton, downButton, resetButton;

    int count = 0;

    program2() {
        setTitle("Counter Application");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        countField = new JTextField("0", 10);
        countField.setEditable(false);

        upButton = new JButton("Count Up");
        downButton = new JButton("Count Down");
        resetButton = new JButton("Reset");

        add(new JLabel("Count:"));
        add(countField);
        add(upButton);
        add(downButton);
        add(resetButton);

        upButton.addActionListener(this);
        downButton.addActionListener(this);
        resetButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == upButton) {
            count++;
        } else if (e.getSource() == downButton) {
            count--;
        } else if (e.getSource() == resetButton) {
            count = 0;
        }

        countField.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new program2()
        );
    }
}
