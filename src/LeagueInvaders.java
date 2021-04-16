import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gPanel;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args) {
		
		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
	
	public void setup() {
		frame.add(gPanel);
		frame.addKeyListener(gPanel);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	LeagueInvaders() {
		frame = new JFrame();
		gPanel = new GamePanel();
		
	}
}
