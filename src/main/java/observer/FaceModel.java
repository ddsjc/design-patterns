package observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FaceModel implements Observable {
    private boolean leftEyeOpen = true;
    private boolean rightEyeOpen = true;
    private boolean noseRed = false;
    private boolean mouthOpen = false;
    private boolean leftCheekRed = false;
    private boolean rightCheekRed = false;
    private List<Observer> observers = new ArrayList<>();
    private boolean changed = false;

    public ImageIcon getLeftEyeIcon() {
        return leftEyeOpen ? new ImageIcon(getClass().getClassLoader().getResource("eyeLeftOpen.png")) : new ImageIcon(getClass().getClassLoader().getResource("eyeLeftClose.png"));
    }

    public ImageIcon getRightEyeIcon() {
        return rightEyeOpen ? new ImageIcon(getClass().getClassLoader().getResource("eyeRightOpen.png")) : new ImageIcon(getClass().getClassLoader().getResource("eyeRightClose.png"));
    }

    public ImageIcon getNoseIcon() {
        return noseRed ? new ImageIcon(getClass().getClassLoader().getResource("redNose.png")) : new ImageIcon(getClass().getClassLoader().getResource("usualNose.png"));
    }

    public ImageIcon getMouthIcon() {
        return mouthOpen ? new ImageIcon(getClass().getClassLoader().getResource("smileMouth.png")) : new ImageIcon(getClass().getClassLoader().getResource("closeMouth.png"));
    }

    public ImageIcon getLeftCheekIcon() {
        return leftCheekRed ? new ImageIcon(getClass().getClassLoader().getResource("cheekLeftRed.png")) : new ImageIcon(getClass().getClassLoader().getResource("cheekLeft.png"));
    }

    public ImageIcon getRightCheekIcon() {
        return rightCheekRed ? new ImageIcon(getClass().getClassLoader().getResource("cheekRightRed.png")) : new ImageIcon(getClass().getClassLoader().getResource("cheekRight.png"));
    }

    public void toggleLeftEye() {
        leftEyeOpen = !leftEyeOpen;
        setChanged();
        notifyObservers();
    }

    public void toggleRightEye() {
        rightEyeOpen = !rightEyeOpen;
        setChanged();
        notifyObservers();
    }

    public void toggleNose() {
        noseRed = !noseRed;
        setChanged();
        notifyObservers();
    }

    public void toggleMouth() {
        mouthOpen = !mouthOpen;
        setChanged();
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setChanged() {
        changed = true;
    }
}