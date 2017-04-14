package jester;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player2 extends Jester{

	private static Jester instance  = new Player2();
	private Player2() {
		
	}
	
	public static Jester getInstance() {
		return instance;
	}
	
	public void move(int dx) {
		leftX += dx;
		for (int i = 0; i < leftCatchedPlates.size(); i++) {
			leftCatchedPlates.get(i).getCenter().x = leftX;
		}
		for (int i = 0; i < rightCatchedPlates.size(); i++) {
			rightCatchedPlates.get(i).getCenter().x = leftX + width - rightCatchedPlates.get(i).getWidth();
		}
	}
	public void draw(Graphics2D g) {
		try {
			image = ImageIO.read(new File("img" + File.separator + "clown2.png"));
		} catch(IOException e) {
			
		}
		g.drawImage(image, leftX, 460,width,height, null);
		leftCheck();
		rightCheck();
		for (int i = 0; i < leftCatchedPlates.size(); i++) {
			leftCatchedPlates.get(i).draw(g);
		}
		for (int j = 0; j < rightCatchedPlates.size(); j++) {
			rightCatchedPlates.get(j).draw(g);
		}
	}
}
