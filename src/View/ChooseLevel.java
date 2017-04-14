package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseLevel {
	JPanel panel = new JPanel();
	public JButton level1;
	JButton level2;
	JButton level3;
	JButton returnToMain;
	PlayFrame frame;
	StartFrame start;
	private boolean isClicked;

	public ChooseLevel(final StartFrame start1, PlayFrame play) {
		this.frame = play;
		start = start1;
		panel.setSize(1000, 700);
		panel.setLayout(null);
		level1 = new JButton();
		level2 = new JButton();
		level3 = new JButton();
		returnToMain = new JButton();
		level1.setBounds(200, 100, 400, 150);
		level2.setBounds(50, 300, 400, 150);
		level3.setBounds(200, 500, 400, 150);

		level1.setIcon(new ImageIcon("images" + File.separator + "unnamed1.png"));
		level2.setIcon(new ImageIcon("images" + File.separator + "unnamed3.png"));
		level3.setIcon(new ImageIcon("images" + File.separator + "unnamed2.png"));
		level1.setOpaque(false);
		level1.setContentAreaFilled(false);
		level1.setBorderPainted(false);
		level2.setOpaque(false);
		level2.setContentAreaFilled(false);
		level2.setBorderPainted(false);
		level3.setOpaque(false);
		level3.setContentAreaFilled(false);
		level3.setBorderPainted(false);
		level1.setBorderPainted(false);
		level1.setFocusPainted(false);

		level2.setBorderPainted(false);
		level2.setFocusPainted(false);

		level3.setBorderPainted(false);
		level3.setFocusPainted(false);
		////////////////////////////////////

		ImageIcon image = new ImageIcon("images" + File.separator + "unnamed.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setSize(1000, 700);
		label.add(level1);
		label.add(level2);
		label.add(level3);
		panel.add(label, null);
		panel.setVisible(false);
		level1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				frame.setVisible(true);
				frame.a.setLevel(1);
			}
		});
		level2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				frame.setVisible(true);
				frame.a.setLevel(2);
			}
		});
		level3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				frame.setVisible(true);
				frame.a.setLevel(3);
			}
		});
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public void setPanel(boolean isVisivble) {
		this.panel.setVisible(isVisivble);
	}

	public void setFrame(PlayFrame frame) {
		this.frame = frame;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

}
