package template;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonPanel extends JPanel{
    public ButtonPanel(DrawingPanel drawingPanel) {

        JButton startButton = new JButton("Пуск");
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.DARK_GRAY);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int choice = random.nextInt(3); // Случайный выбор между 0, 1 и 2

                switch (choice) {
                    case 0:
                        drawingPanel.addBall();
                        break;
                    case 1:
                        drawingPanel.addStar();
                        break;
                    case 2:
                        drawingPanel.addSquare();
                        break;
                    default:
                        break;
                }
            }
        });
        add(startButton);

        JButton addButtonSquareShadow = new JButton("*");
        addButtonSquareShadow.setBackground(Color.WHITE);
        addButtonSquareShadow.setForeground(Color.DARK_GRAY);
        addButtonSquareShadow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.addSquareGradient();
            }
        });
        add(addButtonSquareShadow);

        JButton addButton = new JButton("Шарик");
        addButton.setBackground(Color.WHITE);
        addButton.setForeground(Color.DARK_GRAY);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.addBall();
            }
        });
        add(addButton);

        JButton addButtonStar = new JButton("Звездочка");
        addButtonStar.setBackground(Color.WHITE);
        addButtonStar.setForeground(Color.DARK_GRAY);
        addButtonStar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.addStar();
            }
        });
        add(addButtonStar);

        JButton addButtonSquare = new JButton("Квадратик");
        addButtonSquare.setBackground(Color.WHITE);
        addButtonSquare.setForeground(Color.DARK_GRAY);
        addButtonSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.addSquare();
            }
        });
        add(addButtonSquare);

        JButton exitButton = new JButton("Выход");
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.DARK_GRAY);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}
