package template;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private java.util.List<Ball> balls;
    private java.util.List<Star> stars;
    private java.util.List<Square> squares;
    private java.util.List<SquareGradient> squaresGradient;
    private Image backgroundImage;

    private long lastShadowTime = 0;
    private static final long SHADOW_INTERVAL = 1000;


    public DrawingPanel() {
        balls = new java.util.ArrayList<>();
        stars = new java.util.ArrayList<>();
        squares = new java.util.ArrayList<>();
        squaresGradient = new java.util.ArrayList<>();
        backgroundImage = new ImageIcon("src/main/java/facade/resources/foneTemplates.jpg").getImage();
    }
    public void addBall() {
        Ball ball = new Ball(350, 350, this);
        balls.add(ball);
        Thread ballThread = new Thread(() -> {
            while (balls.contains(ball)) {
                ball.move();
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ballThread.start();
    }

    public void addStar(){
        Star star = new Star(40,40, this);
        stars.add(star);
        Thread starThread = new Thread(() -> {
            while (stars.contains(star)){
                star.move();
                repaint();
                try {
                    Thread.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        starThread.start();
    }

    public void addSquare(){
        Square square = new Square(360,40, this);
        squares.add(square);
        Thread squareThread = new Thread(() -> {
            while (squares.contains(square)){
                square.move();
                repaint();
                try {
                    Thread.sleep(13);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        squareThread.start();
    }

    public void addSquareGradient(){
        SquareGradient squareGradient = new SquareGradient(350,350, this);
        squaresGradient.add(squareGradient);
        Thread squareGradientThread = new Thread(() -> {
            while (squaresGradient.contains(squareGradient)){
                squareGradient.move();
                repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        squareGradientThread.start();
    }
    public void addShadow(int x, int y, Color color){
        SquareGradient squareGradient = new SquareGradient(x, y, this);
        squareGradient.setColor(color);
        squaresGradient.add(squareGradient);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        for (Ball ball : balls) {
            ball.draw(g);
        }
        for(Star star : stars){
            star.draw(g);
        }
        for (Square square: squares){
            square.draw(g);
        }
        for (SquareGradient squareGradient: squaresGradient){
            squareGradient.draw(g);
        }
    }
}
