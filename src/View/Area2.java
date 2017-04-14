package View;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import jester.Jester;
import jester.Player1;
import jester.Player2;
import layer.Layer;
import layer.Left1;
import layer.Left2;
import layer.Left3;
import layer.Right1;
import layer.Right2;
import layer.Right3;
import level.Easy;
import level.Hard;
import level.Level;
import level.Medium;

public class Area2 extends JComponent implements KeyListener, MouseMotionListener {

	
	boolean pause = false;

	Jester player1;
	Jester player2;
	Level level = new Medium();
	Layer layer1 = new Left1(level);
	Layer layer2 = new Right1(level);
	Layer layer3 = new Left2(level);
	Layer layer4 = new Right2(level);
	Layer layer5 = new Left3(level);
	Layer layer6 = new Right3(level);
	JLabel player1score;
	JLabel player2score;
	private int dx = 10;

	public Area2(JLabel player1score , JLabel player2score) {
		this.player1score = player1score;
		this.player2score = player2score;
		this.setBounds(0, 0, 1200, 700);
		this.setBackground(Color.gray);
		player1 = Player1.getInstance();
		player2 = Player2.getInstance();
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	@Override
	public final void paint(final Graphics g) {
		Graphics2D k = (Graphics2D) g;
		player1.draw(k);
			player2.draw(k);
		layer1.draw(k);
		layer2.draw(k);
		layer3.draw(k);
		layer4.draw(k);
		layer5.draw(k);
		layer6.draw(k);
	}

	public void run() {
		long dt = 0;
		long tStart = System.currentTimeMillis();
		long t = System.currentTimeMillis();
		long timeCreation = System.currentTimeMillis();
		while (true) {
			player1score.setText(player1.getScore());
			player2score.setText(player2.getScore());
			while(pause){
				System.out.print("");
			}
			if (System.currentTimeMillis() - t >= level.getDt() * 3) {
				t = System.currentTimeMillis();
				layer1.move();
				layer2.move();
				layer3.move();
				layer4.move();
				layer5.move();
				layer6.move();
				repaint();
				dt = System.currentTimeMillis() - timeCreation;
				if (dt >= 3000) {
					layer1.addPlate();
					layer2.addPlate();
					layer3.addPlate();
					layer4.addPlate();
					layer5.addPlate();
					layer6.addPlate();
					timeCreation = System.currentTimeMillis();
				}
			}

		}
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (arg0.getX() > 1000) {
			player1.move(1080);
		} else {
			player1.move(arg0.getX());
		}
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("here");
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_RIGHT) {
			if (player2.getLeftX() + player2.getWidth() <= 1150) {
				player2.move(dx);
			}
		} else if (keyCode == KeyEvent.VK_LEFT) {
			if (player2.getLeftX() > 30) {
				player2.move(dx * -1);
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setLevel(int level) {
		if (level == 1) {
			this.level = new Easy();
		} else if (level == 2) {
			this.level = new Medium();
		} else if (level == 3) {
			this.level = new Hard();
		}
	}
}
