package level;

import java.awt.Color;

public class Hard extends Level {
	public Hard() {
		//Defining the colors 
		colors = new Color[5];
		colors[0] = Color.RED;
		colors[1] = Color.BLUE;
		colors[2] = Color.YELLOW;
		colors[4] = Color.GREEN;
		colors[3] = Color.BLACK;
		dt = 50;
		dx = 10;
		dy = 12;
		width = 20;
		height = 10;
		logger.info("level is hard");
		
	}

}
