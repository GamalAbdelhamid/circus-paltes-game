package level;

import java.awt.Color;

public class Easy extends Level {
	
	public Easy() {
		colors = new Color[3];
		colors[0] = Color.RED;
		colors[1] = Color.BLUE;
		colors[2] = Color.YELLOW;
		dt = 100;
		dx = 10;
		dy = 12;
		width = 30;
		height = 15;
		logger.info("level is easy");
	}

}
