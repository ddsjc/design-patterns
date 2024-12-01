package template;

import java.awt.*;

public class Square extends Figure{
    private int size;

    private Color color;
    public Square(int x, int y, DrawingPanel panel) {
        super(x, y, panel);
        this.size = 35;
        this.color = new Color(72,180,255);
    }

    @Override
    protected void move() {
        x -= xSpeed;
        y += ySpeed;

        if (x <= 4 || x >= panel.getWidth() - size - 4) {
            ySpeed = (int) (Math.random() * 4 - 2);
            xSpeed *= -1;
        }
        if (y <= 4 || y >= panel.getHeight() - size - 4) {
            xSpeed = (int) (Math.random() * 4 - 2);
            ySpeed *= -1;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}
