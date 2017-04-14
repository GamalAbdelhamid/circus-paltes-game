package View;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class timer {
static int interval;
static Timer timer;
static StartFrame startFrame;
static PlayFrame playFrame;
 static boolean pause = false;
public boolean isPause() {
	return pause;
}

public void setPause(boolean pause) {
	this.pause = pause;
}

public timer(PlayFrame frame1 , StartFrame frame2) {
	this.playFrame = frame1;
	this.startFrame = frame2;
}

public void time(final JLabel label) {
    String secs = "150";
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = Integer.parseInt(secs);
    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
        	String s = ""+setInterval();
            label.setText(s);

        }
    }, delay, period);
}

private static final int setInterval() {
	while(pause) {
		System.out.print("");
	}
    if (interval == 1){
    	playFrame.setVisible(false);
    	startFrame.setVisible(true);
    	startFrame.mainMenue.setVisible(false);
    	startFrame.choose.panel.setVisible(false);
    	startFrame.gameover.setVisible(true);
        timer.cancel();
    }
    return --interval;
}
}