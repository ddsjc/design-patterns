package template;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Figure {
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    protected JPanel panel;

    public Figure(int startX, int startY, JPanel panel) {
        x = startX;
        y = startY;
        xSpeed = 2;
        ySpeed = 2;
        this.panel = panel;
    }

    protected abstract void move();
    protected abstract void draw(Graphics g);
}
