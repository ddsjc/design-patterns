package facade;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoadPanel extends JPanel {
    private Car car;
    private TrafficLight trafficLight;
    private ImageIcon background;

    public RoadPanel() {
        setLayout(null); // Используем null layout для позиционирования компонентов вручную
        background = new ImageIcon("src/main/java/facade/resources/fon.jpg");
        
        car = new Car(10, 250, 3);
        trafficLight = new TrafficLight(285, 119, 285, 159, 285, 195, 2600); // Интервал переключения цветов: 2.6 секунды

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.move();
                if (car.getX() >= trafficLight.getxRed() - 170 && car.getX() <= trafficLight.getxRed() + 30) {
                    if (trafficLight.getColor() == Color.RED) {
                        car = new Car(car.getX(), 250, 0);
                    } else if (trafficLight.getColor() == Color.GREEN) {
                        car = new Car(car.getX(), 250, 13);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.paintIcon(this, g, 0, 0); // Рисуем фон
        car.draw(g);
        trafficLight.draw(g);
    }
}

