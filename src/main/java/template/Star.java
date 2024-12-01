package template;

import java.awt.*;

public class Star extends Figure{
    private int size;
    private int[] xPoints;
    private int[] yPoints;

    public Star(int x, int y, DrawingPanel panel) {
        super(x, y, panel);
        this.size = 20;
        this.xPoints = new int[10];
        this.yPoints = new int[10];
        calculateStarPoints();
    }

    @Override
    protected void move() {
        x += xSpeed;
        y += ySpeed;

        if (x <= 20 || x >= panel.getWidth() - size) {
            xSpeed *= -1;
        }
        if (y <= 20 || y >= panel.getHeight() - size) {
            ySpeed *= -1;
        }


        for (int i = 0; i < 10; i++) {
            double radius = (i % 2 == 0) ? size : size / 2;
            double angle = Math.PI / 2 + i * Math.PI / 5;
            double x = this.x + radius * Math.cos(angle);
            double y = this.y + radius * Math.sin(angle);
            xPoints[i] = (int) x;
            yPoints[i] = (int) y;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillPolygon(xPoints, yPoints, 10);
    }

    // Метод для вычисления координат вершин звезды
    private void calculateStarPoints() {
        for (int i = 0; i < 10; i++) {
            double radius = (i % 2 == 0) ? size : size / 2;
            double angle = Math.PI / 2 + i * Math.PI / 5;
            double x = this.x + radius * Math.cos(angle);
            double y = this.y + radius * Math.sin(angle);
            xPoints[i] = (int) x;
            yPoints[i] = (int) y;
        }
    }
}
