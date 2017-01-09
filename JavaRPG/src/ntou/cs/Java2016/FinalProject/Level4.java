package ntou.cs.Java2016.FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level4 extends GameState implements ActionListener {
  JFrame f;

 
  public Level4(GameStateManager gsm) {
		super(gsm);
	}
  public void init(){
    //Setup JFrame

    JFrame.setDefaultLookAndFeelDecorated(false);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("最終章");
    f.setSize(750,750);
    f.setLocationRelativeTo(null);
    Container cp=f.getContentPane();
    cp.setLayout(null);
    f.setVisible(true);
    

    ImageIcon img = new ImageIcon("Resources/Talk/level3bg.jpg");
	JLabel imgLabel = new JLabel(img);
	f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	imgLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
	imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	((JPanel) cp).setOpaque(false);
    
    //Build Elements
    int mType=JOptionPane.QUESTION_MESSAGE;
    int oType=JOptionPane.YES_NO_OPTION;
    String[] options={"繼續"};
    JOptionPane.showOptionDialog(f,"哈～～終於打敗大魔王到學校了！！","小語",oType,mType,new ImageIcon("Resources/Talk/勳勳開心.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"是勳勳呀！你怎麼在這裡～走吧 一起上課吧<3","宴宴",oType,mType,new ImageIcon("Resources/Talk/宴開心.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"叮叮～～叮～～叮叮～～","鬧鐘",oType,mType,new ImageIcon("Resources/Talk/images.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"嗯～～啊！！什麼呀 原來是夢阿","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳傻眼.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"喔不！！！居然已經中午12點了！ JAVA已經下課了QQ","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳嚇到.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"不....我的宴宴...","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳懊惱.jpg"),options,null);     
    gsm.setState(GameStateManager.GAMEOVER4);
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