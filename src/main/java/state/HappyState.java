package state;

import javax.swing.*;

public class HappyState implements HumanState{
    @Override
    public void handleState(JLabel humanLabel) {
        humanLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("holidays.jpg")));
    }
}
