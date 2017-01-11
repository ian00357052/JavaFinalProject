package ntou.cs.Java2016.FinalProject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class LoadState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage point;
	private int currentOption = 0;
	private static String fileName="";
	ArrayList<File> Array=new ArrayList<File>();
	int count=0;
	private String[] options={"","","","BACK"};
	public LoadState(GameStateManager gsm) {
		super(gsm);		
	}
	
	public void init() {
		bg = Content.MENUBG[0][0];
		point = Content.POINT[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
		
		Array=fileSort.sort(1, "saves", false);	
		if(Array.size()>0)
		{
			String a[] = new String[Array.size()];
			for(int i=0;i<Array.size();i++)
			{	
				a[i] = Array.get(i).toString();
			}
			if(Array.size() >2)
			{
				for(int i=0;i<3;i++)
				{
					String temp = a[i];
					temp = temp.replace(".txt", "");
					temp = temp.replace("saves", "");
					temp = temp.replace("\\", "");
					options[i]=temp;
				}
			}
			else
			{
				for(int i=0;i<Array.size();i++)
				{
					String temp = a[i];
					temp = temp.replace(".txt", "");
					temp = temp.replace("saves", "");
					temp = temp.replace("\\", "");
					options[i]=temp;
				}
			}
		}
	
	}
	
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);
		if(options[0]!= "")
		{
			Content.drawString(g, options[0], 65, 90);
		}
		else
		{
			Content.drawString(g, "new story", 65, 90);
		}
		if(options[1]!= "")
		{
			Content.drawString(g, options[1], 65, 100);
		}
		else
		{
			Content.drawString(g, "new story", 65, 100);
		}
		if(options[2]!= "")
		{
			Content.drawString(g, options[2], 65, 110);
		}
		else
		{
			Content.drawString(g, "new story", 65, 110);
		}
		Content.drawString(g, options[3], 65, 120);
		
		if(currentOption == 0) g.drawImage(point, 50, 86, null);
		else if(currentOption == 1) g.drawImage(point, 50, 96, null);
		else if(currentOption == 2)	g.drawImage(point,50,106,null);
		else if(currentOption == 3)	g.drawImage(point,50,116,null);

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

	public void setFileName(int i){
		 fileName = options[i];		
	}
	public static String getFileName(){
		return fileName;		
	}
	
	private void selectOption() {
		Player.playerName = options[currentOption];
		if(currentOption == 0) {
			setFileName(0);
			FileReader fr;
			try {
				fr = new FileReader("saves\\"+options[0]+".txt");
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(fr);
				try {
					int stage = Integer.valueOf(br.readLine());
					
					switch(stage){
					case 0:gsm.setState(GameStateManager.Level0);
						break;
					case 1:gsm.setState(GameStateManager.Level1);
						break;
					case 2: gsm.setState(GameStateManager.Level2);
						break;
					case 3:gsm.setState(GameStateManager.Level3);
						break;
					case 4:gsm.setState(GameStateManager.Level4);
						break;
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(currentOption == 1) {
			setFileName(1);
			FileReader fr;
			try {
				fr = new FileReader("saves\\"+options[1]+".txt");
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(fr);
				try {
					int stage = Integer.valueOf(br.readLine());
					
					switch(stage){
					case 0:gsm.setState(GameStateManager.Level0);
						break;
					case 1:gsm.setState(GameStateManager.Level1);
						break;
					case 2: gsm.setState(GameStateManager.Level2);
						break;
					case 3:gsm.setState(GameStateManager.Level3);
						break;
					case 4:gsm.setState(GameStateManager.Level4);
						break;
					}
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(currentOption == 2) {
			setFileName(2);
			FileReader fr;
			try {
				fr = new FileReader("saves\\"+options[2]+".txt");
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(fr);
				try {
					int stage = Integer.valueOf(br.readLine());
					
					switch(stage){
					case 0:gsm.setState(GameStateManager.Level0);
						break;
					case 1:gsm.setState(GameStateManager.Level1);
						break;
					case 2: gsm.setState(GameStateManager.Level2);
						break;
					case 3:gsm.setState(GameStateManager.Level3);
						break;
					case 4:gsm.setState(GameStateManager.Level4);
						break;
					}
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(currentOption == 3) 
		{
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}
