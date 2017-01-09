// The main menu GameState.

package ntou.cs.Java2016.FinalProject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage point;
	
	private int currentOption = 0;
	private String[] options = {
		"Start",
		"Load",
		"End"
	};
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		bg = Content.MENUBG[0][0];
		point = Content.POINT[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);
		
		Content.drawString(g, options[0], 60, 90);
		Content.drawString(g, options[1], 60, 100);
		Content.drawString(g, options[2], 60, 110);
		
		if(currentOption == 0) g.drawImage(point, 45, 86, null);
		else if(currentOption == 1) g.drawImage(point, 45, 96, null);
		else if(currentOption == 2)	g.drawImage(point,45,106,null);
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
			JukeBox.play("menuoption");
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) {
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) {
			JukeBox.play("collect");
			selectOption();
		}
		
	}
	
	private void selectOption() 
	{
		if(currentOption == 0) 
		{
			gsm.setState(GameStateManager.Level0);
		}
		if(currentOption == 1) 
		{
			gsm.setState(GameStateManager.LOAD);
			
		}
		if(currentOption == 2) 
		{
			System.exit(0);
		}
		
	}
	
}
