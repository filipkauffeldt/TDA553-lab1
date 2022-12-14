package Lab1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class TimerListener{
    private List<IUpdateable> updateableList;
    private static int delay = 50;
    private Timer timer;
    public TimerListener(List<IUpdateable> updateableList) {
        this.updateableList = updateableList;
        timer = new Timer(delay, new TimerListenerDoesAction());
    }

    public void start() {
        timer.start();
    }
    private class TimerListenerDoesAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IUpdateable updateable : updateableList) {
                updateable.update();
            }
        }
    }
}
