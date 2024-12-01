package template;

import javax.swing.*;
import java.awt.*;

class Ball extends Figure {
    private int size;

    private Color color;

    public Ball(int startX, int startY, JPanel panel) {
        super(startX, startY, panel);
        size = 20;
        this.color = new Color(249,7,109);
    }

    @Override
    protected void move() {
        x -= xSpeed;
        y -= ySpeed;

        if (x <= 4 || x >= panel.getWidth() - size - 4 ) {
            xSpeed *= -1;
        }
        if (y <= 4 || y >= panel.getHeight() - size - 4 ) {
            ySpeed *= -1;
        }

    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}
