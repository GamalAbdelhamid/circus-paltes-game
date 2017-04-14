package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.StartFrame;
import jester.Player1;
import jester.Player2;

@SuppressWarnings("serial")
public class PlayFrame extends JFrame {
	StartFrame start;
	Area2 a ;
	JButton pauseButton;
	JButton resumeButton;
	JLabel timerNum = new JLabel("150");
	timer time ;
	JLabel scoreplayer1Num;
	JLabel scoreplayer2Num;
	JLabel timer;
	JLabel score;
	JLabel scoreplayer1;
	JLabel scoreplayer2;
	public PlayFrame() {	
		start = new StartFrame(this);
		this.setContentPane(new JLabel());
		this.setVisible(false);
		this.addKeyListener(a);
		this.setTitle("Game");
		this.setSize(1200, 700);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		done();
	}
	public void done() {
		JPanel x  = new JPanel(); 
		x.setBounds(1150, 0, 200, 700);
		x.setBackground(Color.GRAY);
		scoreplayer1Num = new JLabel("0");
		scoreplayer1Num.setBounds(1250,300 , 75, 50);
		this.add(scoreplayer1Num);
		scoreplayer2Num = new JLabel("0");
		scoreplayer2Num.setBounds(1250,400 , 75, 50);
		this.add(scoreplayer2Num);
		time = new timer(this,start);
		timer = new JLabel("Time");
		timer.setBounds(1250,100 , 75, 50);
		this.add(timer);
		timerNum.setText("150");
		timerNum.setBounds(1250,150 , 75, 50);
		this.add(timerNum);
		score = new JLabel("score");
		score.setBounds(1250,200 , 75, 50);
		this.add(score);
		scoreplayer1 = new JLabel("Player1");
		scoreplayer1.setBounds(1250,250 , 75, 50);
		this.add(scoreplayer1);
		scoreplayer2 = new JLabel("Player2");
		scoreplayer2.setBounds(1250,350 , 75, 50);
		this.add(scoreplayer2);
		time.time(timerNum);
		pauseButton = new JButton("Pause");
		resumeButton = new JButton("Resume");
		pauseButton.setBounds(1250, 550, 75, 50);
		resumeButton.setBounds(1250, 450, 75, 50);
//		this.add(pauseButton);
//		this.add(resumeButton);
		a = new Area2(scoreplayer1Num,scoreplayer2Num);
		this.addKeyListener(a);
		JPanel y = new JPanel();
		y.setLayout(null);
		y.setBounds(0, 0, 1250, 700);
		y.add(a);
		this.add(x);
		this.add(y);
		
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a.setPause(true);
				time.setPause(true);
			}
		});
		
		resumeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a.setPause(false);	
				time.setPause(false);
			}
		});
	}
	
}
