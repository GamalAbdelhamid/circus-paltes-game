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
public class MainMenue extends JPanel{
	JButton newGameButton;
	JButton loadPlates;
	StartFrame start;
	
	public MainMenue(final StartFrame start) {
		this.start = start;
		this.setSize(1000, 700);
		newGameButton = new JButton();
		loadPlates = new JButton();
		
		Image imgIcon = new ImageIcon("images" + File.separator +"Play.png").getImage();
		newGameButton.setIcon(new ImageIcon(imgIcon));
		newGameButton.setBounds(350, 250, 400, 150);
		newGameButton.setOpaque(false);
		newGameButton.setContentAreaFilled(false);
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		Image imgIcon2 = new ImageIcon("images" + File.separator +"Load Button.jpg").getImage();
		loadPlates.setIcon(new ImageIcon(imgIcon2));
		loadPlates.setBounds(350, 450, 400, 150);
		loadPlates.setOpaque(false);
		loadPlates.setContentAreaFilled(false);
		loadPlates.setBorderPainted(false);
		loadPlates.setFocusPainted(false);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("images" + File.separator +"unnamed.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setSize(1000, 700);
		label.add(newGameButton);
		label.add(loadPlates);
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
