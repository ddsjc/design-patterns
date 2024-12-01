package observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FaceView extends JPanel implements Observer {
    private FaceModel model;

    public FaceView(FaceModel model) {
        this.model = model;
        this.model.addObserver(this);
        this.setPreferredSize(new Dimension(600, 600));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getY() < 350 && e.getY() > 300 && e.getX() < 270 && e.getX() > 150){
                    model.toggleLeftEye();
                } else if (e.getY() < 350 &&  e.getY() > 300 && e.getX() > 330 && e.getX() < 450){
                    model.toggleRightEye();
                } else if (e.getY() > 350 && e.getY() < 380 && e.getX() > 290 && e.getX() < 320) {
                    model.toggleNose();
                } else if (e.getY() > 390 && e.getY() < 450 && e.getX() > 213 && e.getX() < 387) {
                    model.toggleMouth();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(new ImageIcon(getClass().getClassLoader().getResource("fone.png")).getImage(), 0, 0, null);

        g2d.drawImage(model.getLeftEyeIcon().getImage(),140, 250, null);
        g2d.drawImage(model.getRightEyeIcon().getImage(), 340, 245, null);

        g2d.drawImage(model.getNoseIcon().getImage(), 290, 350, null);

        g2d.drawImage(model.getMouthIcon().getImage(), 220, 370, null);

        g2d.drawImage(model.getLeftCheekIcon().getImage(), 150, 350, null);
        g2d.drawImage(model.getRightCheekIcon().getImage(), 385, 350, null);
    }

    @Override
    public void update() {
        repaint();
    }
}