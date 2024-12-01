package state;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanMoodApp extends JFrame {
    private JLabel humanLabel;
    private JButton semesterButton;
    private JButton vacationButton;
    private JButton sessionButton;
    private HumanState currentState;
    public HumanMoodApp() {
        setTitle("Human Mood App");
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        humanLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("main.jpg")));
        semesterButton = new JButton("Семестр");
        vacationButton = new JButton("Каникулы");
        sessionButton = new JButton("Сессия");

        semesterButton.setBackground(Color.BLACK);
        semesterButton.setForeground(Color.WHITE);
        vacationButton.setBackground(Color.BLACK);
        vacationButton.setForeground(Color.WHITE);
        sessionButton.setBackground(Color.BLACK);
        sessionButton.setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        add(humanLabel, BorderLayout.LINE_START);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(semesterButton);
        buttonPanel.add(vacationButton);
        buttonPanel.add(sessionButton);
        add(buttonPanel, BorderLayout.SOUTH);

        semesterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentState = new SleepingState();
                currentState.handleState(humanLabel);
            }
        });

        vacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentState = new HappyState();
                currentState.handleState(humanLabel);
            }
        });

        sessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentState = new SadState();
                currentState.handleState(humanLabel);
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HumanMoodApp app = new HumanMoodApp();
                app.setVisible(true);
            }
        });
    }
}
