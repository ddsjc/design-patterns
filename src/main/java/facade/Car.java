package facade;
import javax.swing.*;
import java.awt.*;

public class Car {
    private int x;
    private int y;
    private int speed;
    private ImageIcon carIcon;

    public Car(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        carIcon = new ImageIcon("src/main/java/facade/resources/car_icon.png");
    }

    public void move() {
        x += speed;
    }

    public void draw(Graphics g) {
        carIcon.paintIcon(null, g, x, y); // Рисуем иконку машинки
    }

    public int getX() {
        return x;
    }
}
