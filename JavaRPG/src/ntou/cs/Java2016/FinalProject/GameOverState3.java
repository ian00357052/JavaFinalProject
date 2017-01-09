package ntou.cs.Java2016.FinalProject;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameOverState3 extends GameState {
	
	private Color color;

	public GameOverState3(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(238, 238, 209);
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "Level 3 Completed.", 15,40);
	
		Content.drawString(g, "press enter to cont.", 4, 110);
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setState(GameStateManager.Level3);
			JukeBox.play("collect");
		}
	}
	
}
