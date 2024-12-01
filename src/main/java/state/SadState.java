package state;

import javax.swing.*;

public class SadState implements HumanState{
    @Override
    public void handleState(JLabel humanLabel) {
        humanLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("session.jpg")));
    }
}
