package View;
import java.awt.Button;

import javax.swing.JFrame;


public class Game {
	public Game() {
		
	}
	private static long startTime, endTime, time;
	public static void main(String[] args) {
		PlayFrame play = new PlayFrame();
		play.start.setVisible(true);
		startTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		while (time < 5 * 1000) {
			endTime = System.currentTimeMillis();
			time = endTime - startTime;
		}
		play.start.mainMenue.setVisible(true);
		play.start.choose.setFrame(play);
		while (!play.isVisible()){
			System.out.print("");
		}
		play.a.run();
	}

}
