package jester;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import plate.Plate;

public abstract class Jester {
	protected int leftX = 250;
	protected int width = 90;
	protected int height = 200;
	protected ArrayList<Plate> leftCatchedPlates = new ArrayList<Plate>();
	protected ArrayList<Plate> rightCatchedPlates = new ArrayList<Plate>();
	protected BufferedImage image;
	protected int score = 0;
	public String getScore() {
		return String.valueOf(score);
	}

	protected int leftCatchedPlatesHeight = 460;
	protected int rightCatchedPlatesHeight = 460;
	protected int flag = 0;

	public int getLeftX() {
		return leftX;
	}

	public static Jester getInstance() {
		return null;
	}

	public int getWidth() {
		return width;
	}

	public void move(int newX) {
		leftX = newX;
		for (int i = 0; i < leftCatchedPlates.size(); i++) {
			leftCatchedPlates.get(i).getCenter().x = newX;
		}
		for (int i = 0; i < rightCatchedPlates.size(); i++) {
			rightCatchedPlates.get(i).getCenter().x = newX + width - rightCatchedPlates.get(i).getWidth();
		}
	}

	public void draw(Graphics2D g) {
		try {
			image = ImageIO.read(new File("img" + File.separator + "clown.png"));
		} catch (IOException e) {

		}
		g.drawImage(image, leftX, 460, width, height, null);
		leftCheck();
		rightCheck();
		for (int i = 0; i < leftCatchedPlates.size(); i++) {
			leftCatchedPlates.get(i).draw(g);
		}
		for (int j = 0; j < rightCatchedPlates.size(); j++) {
			rightCatchedPlates.get(j).draw(g);
		}
	}

	public boolean catchCheck(Plate plate) {
		if (((plate.getCenter().y <= leftCatchedPlatesHeight) && (plate.getCenter().y > leftCatchedPlatesHeight - 10))
				|| ((plate.getCenter().y <= rightCatchedPlatesHeight)
						&& (plate.getCenter().y > rightCatchedPlatesHeight - 10))) {
			if ((plate.getCenter().x >= leftX - 5) && (plate.getCenter().x < leftX + plate.getWidth() + 10)) {
				flag = 0;
				return true;
			} else if ((plate.getCenter().x >= leftX + width - plate.getWidth() - 10)
					&& (plate.getCenter().x < width + leftX + plate.getWidth())) {
				flag = 1;
				return true;
			}
		}
		return false;
	}

	protected void leftCheck() {
		if (leftCatchedPlates.size() >= 3) {
			Plate plate1 = leftCatchedPlates.get(leftCatchedPlates.size() - 1);
			Plate plate2 = leftCatchedPlates.get(leftCatchedPlates.size() - 2);
			Plate plate3 = leftCatchedPlates.get(leftCatchedPlates.size() - 3);
			if ((plate1.getColor().equals(plate2.getColor())) && (plate3.getColor().equals(plate1.getColor()))) {
				leftCatchedPlates.remove(plate1);
				leftCatchedPlates.remove(plate2);
				leftCatchedPlates.remove(plate3);
				leftCatchedPlatesHeight += (plate1.getHeight() * 3);
				score++;
			}
		}
	}

	protected void rightCheck() {
		if (rightCatchedPlates.size() >= 3) {
			Plate plate1 = rightCatchedPlates.get(rightCatchedPlates.size() - 1);
			Plate plate2 = rightCatchedPlates.get(rightCatchedPlates.size() - 2);
			Plate plate3 = rightCatchedPlates.get(rightCatchedPlates.size() - 3);
			if ((plate1.getColor().equals(plate2.getColor())) && (plate3.getColor().equals(plate1.getColor()))) {
				rightCatchedPlates.remove(plate1);
				rightCatchedPlates.remove(plate2);
				rightCatchedPlates.remove(plate3);
				rightCatchedPlatesHeight += (plate1.getHeight() * 3);
				score++;
			}
		}
	}

	public void catchPlate(Plate plate) {
		if (flag == 0) {
			leftCatchedPlatesHeight -= plate.getHeight();
			plate.setCenter((int) leftX, leftCatchedPlatesHeight);
			leftCatchedPlates.add(plate);
		} else if (flag == 1) {
			rightCatchedPlatesHeight -= plate.getHeight();
			plate.setCenter((int) (leftX + width - plate.getWidth()), rightCatchedPlatesHeight);
			rightCatchedPlates.add(plate);
		}
	}
}
