package level;

import java.awt.Color;

public class Medium extends Level {
	
	public Medium () {
		colors = new Color[4];
		colors[0] = Color.RED;
		colors[1] = Color.BLUE;
		colors[2] = Color.YELLOW;
		colors[3] = Color.black;
		
		dt = 100;
		dx = 10;
		dy = 12;
		width = 30;
		height = 15;
		logger.info("level is medium");
	}

}
