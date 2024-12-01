package observer;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Face App");
        FaceModel model = new FaceModel();
        FaceView view = new FaceView(model);
        model.addObserver(view);
        frame.add(view);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}