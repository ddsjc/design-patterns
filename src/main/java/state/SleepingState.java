package state;

import javax.swing.*;

public class SleepingState implements HumanState{
    @Override
    public void handleState(JLabel humanLabel) {
        humanLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("semestr.jpg")));
    }
}
