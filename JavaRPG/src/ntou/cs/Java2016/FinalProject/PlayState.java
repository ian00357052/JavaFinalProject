// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

package ntou.cs.Java2016.FinalProject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PlayState extends GameState {
	
	// player
	private Player player;
	
	// tilemap
	private TileMap tileMap;

	// Missiles
	private Direct direct;
	private ArrayList<Missile> missile = null;
	
	// items
	private ArrayList<Item> items;
	
	// sparkles
	private ArrayList<Sparkle> sparkles;
	
	// camera position
	private int xsector;
	private int ysector;
	private int sectorSize; 
	
	//計數用
	private int count = 0;
	
	// hud
	private Hud hud;
	
	// events
	private boolean blockInput;
	private boolean eventStart;
	private boolean eventFinish;
	private int eventTick;
	
	//for save and load
	public static String charName = "";
	public String MyCharName; 
	public String[] files={"","","","","",""};
	public int check = 1;
	public int whileCheck=0;
	public int counter=0;
	private String tempName="";
	// transition box
	private ArrayList<Rectangle> boxes;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		//set player's name
		if(Player.playerName == null)
		{
			File f = new File("saves");
			File [] f1 = f.listFiles();
			for(int i =0;i<f.listFiles().length;i++)
			{
				String temp = f1[i].getName();
				temp = temp.replace(".txt", "");
				files[i]=temp;
			}	
			tempName = JOptionPane.showInputDialog("請輸入您的大名:"); 
						
			//init: whileCheck=0,check=1;
			while(whileCheck==0)
			{
				if(check==1)
				{
					for(int i =0;i<3;i++)
					{
						if(tempName.equals(files[i])==true)
						{
							check=-1;
							break;
						}
						else
							check = 0;
					}
				}
				if (check==0) //if no same
				{
					MyCharName = tempName;
					Player.playerName = MyCharName;
					whileCheck=-1; //end while
				}
				if (check ==-1)//if same
				{	
					tempName = JOptionPane.showInputDialog("這個名字已經被使用過了，請再試一次"); 
					check=1;//back to check again
					counter=0;
				}	
			}
		}
		// create lists
		
		missile = new ArrayList<Missile>();
		sparkles = new ArrayList<Sparkle>();
		items = new ArrayList<Item>();
		
		// load map
		tileMap = new TileMap(16);
		tileMap.loadTiles("/Tilesets/testtileset.gif");
		tileMap.loadMap("/Maps/testmap.map");
		
		// create player
		player = new Player(tileMap);
		player.reset();
		player.setStage(0);
		// fill lists
		//populateDiamond();
		populateItems();
		putMissile();
		
		// initialize player
		player.setTilePosition(5, 5);
		player.setTotalDiamonds(15);
		
		// set up camera position
		sectorSize = GamePanel.WIDTH;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
		
		// load hud
		hud = new Hud(player);
		
		// load music
		JukeBox.load("/Music/bgmusic1.mp3", "music1");
		JukeBox.setVolume("music1", -5);
		JukeBox.loop("music1", 1000, 1000, JukeBox.getFrames("music1") - 1000);
		JukeBox.load("/Music/finish.mp3", "finish");
		JukeBox.setVolume("finish", -10);
		
		// load sfx
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/mapmove.wav", "mapmove");
		JukeBox.load("/SFX/tilechange.wav", "tilechange");
		JukeBox.load("/SFX/splash.wav", "splash");
		
		// start event
		boxes = new ArrayList<Rectangle>();
		eventStart = true;
		eventStart();
			
	}
	
	private void putMissile()
	{
		Missile weapon = null;
		Random random = new Random();
		int wall = random.nextInt(4); //0是左壁,1是下壁,2是右壁,3是上壁
		int hole = random.nextInt(8);
		switch(wall)
		{
		//向右
		case 0:
			direct = Direct.Right;
			weapon = new Missile(tileMap,0, hole+1, 0, direct);
			weapon.setTilePosition(0, hole+1);
			missile.add(weapon);
			break;
		//向上
		case 1:
			direct = Direct.Up;
			weapon = new Missile(tileMap,hole+1, 9, 0, direct);
			weapon.setTilePosition(hole+1, 9);
			missile.add(weapon);
			break;
		//向左
		case 2:
			direct = Direct.Left;
			weapon = new Missile(tileMap,9, hole+1, 0, direct);
			weapon.setTilePosition(9, hole+1);
			missile.add(weapon);
			break;
		//向下
		case 3:
			direct = Direct.Down;
			weapon = new Missile(tileMap,hole+1, 0, 0, direct);
			weapon.setTilePosition(hole+1, 0);
			missile.add(weapon);
			break;
		}
		
	}
	
	private void populateItems() {
		
		Item item;
		
		item = new Item(tileMap);
		item.setType(Item.Flash);
		item.setTilePosition(3, 3);
		items.add(item);
		
		item = new Item(tileMap);
		item.setType(Item.Recover);
		item.setTilePosition(4, 4);
		items.add(item);
		
	}
	
	public void update() {
		//計數，每到30的倍數就產生一顆飛彈
		count++;
		if(count % 30 == 0)
		{
			for(int i = 0;i < 1;i++)
				putMissile();
		}
		
		// update Missle
		for(int i = 0; i < missile.size(); i++) {
			
			
			Missile m = missile.get(i);
			int x = m.getx();
			int y = m.gety();
			switch(m.getDirect())
			{
			case Up:
				m.setPosition(x-1, y);
				break;
			case Down:
				m.setPosition(x+1, y);
				break;
			case Right:
				m.setPosition(x, y+1);
				break;
			case Left:
				m.setPosition(x, y-1);
				break;
			}
			m.update();
			
			// player hit by missile
			if(player.intersects(m)) {
				
				// remove from list
				missile.remove(i);
				i--;
				
				// increment amount of collected diamonds
				player.decreaseHP(1);
				
				// play collect sound
				JukeBox.play("collect");
				
				// add new sparkle
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(m.getx(), m.gety());
				sparkles.add(s);
				
				// make any changes to tile map
				ArrayList<int[]> ali = m.getChanges();
				for(int[] j : ali) {
					tileMap.setTile(j[0], j[1], j[2]);
				}
				if(ali.size() != 0) {
					JukeBox.play("tilechange");
				}
				
			}
		}
		
		
		// check keys
		handleInput();
		
		// check events
		if(eventStart) eventStart();
		if(eventFinish) eventFinish();
		
		if(player.getHP() <= 0 || player.getTicks() == 0) {
			eventFinish = blockInput = true;
		}
		
		// update camera
		int oldxs = xsector;
		int oldys = ysector;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tileMap.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tileMap.update();
		
		if(oldxs != xsector || oldys != ysector) {
			JukeBox.play("mapmove");
		}
		
		if(tileMap.isMoving()) return;
		
		// update player
		player.update();
		
		// update sparkles
		for(int i = 0; i < sparkles.size(); i++) {
			Sparkle s = sparkles.get(i);
			s.update();
			if(s.shouldRemove()) {
				sparkles.remove(i);
				i--;
			}
		}
		
		// update items
		for(int i = 0; i < items.size(); i++) 
		{
			Item item = items.get(i);
			if(player.intersects(item)) 
			{
				items.remove(i);
				i--;
				item.collected(player);
				JukeBox.play("collect");
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(item.getx(), item.gety());
				sparkles.add(s);
			}
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw tilemap
		tileMap.draw(g);
		
		// draw player
		player.draw(g);

		// draw Missile
		for(Missile m : missile) {
					m.draw(g);
		}
				
		// draw sparkles
		for(Sparkle s : sparkles) {
			s.draw(g);
		}
		
		// draw items
		for(Item i : items) {
			i.draw(g);
		}
		
		// draw hud
		hud.draw(g);
		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		for(int i = 0; i < boxes.size(); i++) {
			g.fill(boxes.get(i));
		}
		
	}
	 public void clearFile(String name)
	    {
		 String filePath = name+".txt";
	        try{
	            java.io.File file = new java.io.File("saves\\"+filePath);
	            java.io.FileWriter fw = new java.io.FileWriter(file, false);
	            fw.flush(); fw.close();
	        }catch(Exception e){
	            //
	        }
	    }
	 
	public void SaveFiles(String name,int stage,int skillPoint,int hpPoint,int recoveryRate,int speedPoint) 
	{
		String mStage = Integer.toString(stage);
		String mSkillPoint = Integer.toString(skillPoint);
		String mHpPoint = Integer.toString(hpPoint);
		String mRecoveryRate = Integer.toString(recoveryRate);
		String mSpeedPoint = Integer.toString(speedPoint);
		try {
			String a = name+".txt";
			FileWriter fw = new FileWriter("saves\\"+a);
			final String LINE_SEPARATOR = System.getProperty("line.separator"); //+LINE_SEPARATOR 可以換行	
	
			 fw.write(mStage+LINE_SEPARATOR);
			 fw.write(mSkillPoint+LINE_SEPARATOR);
			 fw.write(mHpPoint+LINE_SEPARATOR);
			 fw.write(mRecoveryRate+LINE_SEPARATOR);
			 fw.write(mSpeedPoint+LINE_SEPARATOR);
			
			 fw.flush();	
			 fw.close();
		} 
		  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			JukeBox.stop("music1");
			gsm.setPaused(true);
		}
		if(blockInput) return;
		if(Keys.isDown(Keys.LEFT)) player.setLeft();
		if(Keys.isDown(Keys.RIGHT)) player.setRight();
		if(Keys.isDown(Keys.UP)) player.setUp();
		if(Keys.isDown(Keys.DOWN)) player.setDown();
		if(Keys.isPressed(Keys.SPACE)) player.setAction();
		if(Keys.isPressed(Keys.Q))
		{
			if(player.getItemRecovery() || player.getCheatMode())
			{
				JukeBox.play("collect");
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(player.getx(), player.gety());
				sparkles.add(s);
			}
			player.useFlash();
		}
		if(Keys.isPressed(Keys.E))
		{
			
			if(player.getItemRecovery() || player.getCheatMode())
			{
				JukeBox.play("collect");
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(player.getx(), player.gety());
				sparkles.add(s);
			}
			player.recover();
		}
		if(Keys.isPressed(Keys.Q) && Keys.isPressed(Keys.E) && Keys.isPressed(Keys.LEFT) && Keys.isPressed(Keys.RIGHT))
			player.setCheatMode();
		if(Keys.isPressed(Keys.F2)) 
		{
			clearFile(MyCharName);
			SaveFiles(MyCharName, player.getStage(),player.getSkillPoint(),player.getHpPoint(),player.getRecoveryRate(),player.getSpeedPoint());
		}
	}
	
	//===============================================
	
	private void eventStart() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 11; i++) {
				boxes.add(new Rectangle(0, i * 16, GamePanel.WIDTH, 16));
			}
		}
		if(eventTick > 1 && eventTick < 32) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					r.x -= 4;
				}
				else {
					r.x += 4;
				}
			}
		}
		if(eventTick == 33) {
			boxes.clear();
			eventStart = false;
			eventTick = 0;
		}
	}
	
	private void eventFinish() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 11; i++) {
				if(i % 2 == 0) boxes.add(new Rectangle(-128, i * 16, GamePanel.WIDTH, 16));
				else boxes.add(new Rectangle(128, i * 16, GamePanel.WIDTH, 16));
			}
			JukeBox.stop("music1");
			JukeBox.play("finish");
		}
		if(eventTick > 1) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					if(r.x < 0) r.x += 4;
				}
				else {
					if(r.x > 0) r.x -= 4;
				}
			}
		}
		if(eventTick > 33) {
			if(!JukeBox.isPlaying("finish")) 
			{
				if(player.getHP() != 0)
				{
					gsm.setState(GameStateManager.GAMEOVER);
				}
				else
				{
					gsm.setState(GameStateManager.GAMEOVERDEAD);
				}
			}
		}
	}
	
}
