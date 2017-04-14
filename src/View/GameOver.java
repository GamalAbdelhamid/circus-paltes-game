package View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameOver extends JPanel{
	JButton newGameButton;
	StartFrame start;
	
	public GameOver(final StartFrame start) {
		this.start = start;
		this.setSize(1000, 700);
		newGameButton = new JButton();
		Image imgIcon = new ImageIcon("images" + File.separator +"Play.png").getImage();
		newGameButton.setIcon(new ImageIcon(imgIcon));
		newGameButton.setBounds(350, 400, 400, 150);
		newGameButton.setOpaque(false);
		newGameButton.setContentAreaFilled(false);
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		Image imgIcon2 = new ImageIcon("images" + File.separator +"Load Button.jpg").getImage();
				this.setLayout(null);
		ImageIcon image = new ImageIcon("images" + File.separator +"unnamed.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setSize(1000, 700);
		label.add(newGameButton);
		this.add( label, null );
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				start.choose.panel.setVisible(true);
				setPanel(false);
			}
		});
	}
	public JPanel getPanel(){
		return this;
	}
	public void setPanel(boolean isVisible){
		this.setVisible(isVisible);
	}
}
