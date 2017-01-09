package ntou.cs.Java2016.FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level1 extends GameState implements ActionListener {
  JFrame f;

 
  public Level1(GameStateManager gsm) {
		super(gsm);
	}
  public void init(){
    //Setup JFrame


    JFrame.setDefaultLookAndFeelDecorated(false);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("第一章");
    f.setSize(750,750);
    f.setLocationRelativeTo(null);
    Container cp=f.getContentPane();
    cp.setLayout(null);
    f.setVisible(true);
    

    ImageIcon img = new ImageIcon("Resources/Talk/level1bg.jpg");
	JLabel imgLabel = new JLabel(img);
	f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	imgLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
	imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	((JPanel) cp).setOpaque(false);
    
    //Build Elements
    int mType=JOptionPane.QUESTION_MESSAGE;
    int oType=JOptionPane.YES_NO_OPTION;
    String[] options={"繼續"};
    JOptionPane.showOptionDialog(f,"哇～勇者你叫什麼名字","婷婷",oType,mType,new ImageIcon("Resources/Talk/婷開心.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"ㄜ...ㄜ...我叫勳勳","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"原來是勳勳超人阿！！","婷婷",oType,mType,new ImageIcon("Resources/Talk/婷開心.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"我是從大魔王小毅那邊跑出來的婷婷","婷婷",oType,mType,new ImageIcon("Resources/Talk/婷認真.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"心理OS：現在大魔王身邊的人都這麼性感嗎！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"現在大魔王在往學校的路上布滿了機關陷阱阻止好學生去上課","婷婷",oType,mType,new ImageIcon("Resources/Talk/婷認真.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"不能！我一定要去上課！！不然就不能跟我心愛的宴宴一起上課了","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"看來我要先去阿囉哈買奶茶幫助腸胃蠕動！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳懊惱.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"忘了跟你說大魔王也在阿囉哈早餐店附近布滿了機關","婷婷",oType,mType,new ImageIcon("Resources/Talk/婷認真.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"不管了！！！走吧！！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
     
    gsm.setState(GameStateManager.PLAY2);
    f.dispose();

    
    }
  public void actionPerformed(ActionEvent e) {
    //if (e.getSource()==id) {}
    }
@Override
public void update() {
	// TODO Auto-generated method stub
	
}
@Override
public void draw(Graphics2D g) {

	
}
@Override
public void handleInput() {
	
	
}
  }