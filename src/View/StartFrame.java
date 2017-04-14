package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class StartFrame extends JFrame implements KeyListener {
	
	public MainMenue mainMenue;
	public ChooseLevel choose;
	public GameOver gameover;
	public PlayFrame play;
	public StartFrame(PlayFrame play) {
		choose = new ChooseLevel(this,play);
		mainMenue = new MainMenue(this);
		gameover = new GameOver(this);
		this.setContentPane(new JLabel(new ImageIcon("images" + File.separator +"unnamed.png")));
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		mainMenue.setVisible(false);
		gameover.setVisible(false);
		this.add(mainMenue);
		this.add(choose.panel);
		this.add(gameover);
	}
	public JFrame getFrame(){
		return this;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
