package ntou.cs.Java2016.FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level2 extends GameState implements ActionListener {
  JFrame f;

 
  public Level2(GameStateManager gsm) {
		super(gsm);
	}
  public void init(){
    //Setup JFrame


    JFrame.setDefaultLookAndFeelDecorated(false);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("第二章");
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
    JOptionPane.showOptionDialog(f,"呼～～怎麼會有人這麼閒！在路上這麼多陷阱","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳傻眼.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"真是累死我了～不過終於買到烙賽奶茶了～","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳懊惱.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"站住！！！","小語",oType,mType,new ImageIcon("Resources/Talk/語不屑.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"你不能再往學校走了！！","小語",oType,mType,new ImageIcon("Resources/Talk/語生氣.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"你又是哪位了？？","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳傻眼.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"哼哼～我可是大魔王旗下第一猛將小語","小語",oType,mType,new ImageIcon("Resources/Talk/語微笑.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"我奉大魔王的命令要阻止任何人前往學校","小語",oType,mType,new ImageIcon("Resources/Talk/語生氣.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"不管你是誰都無法阻止我去上JAVA課的！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳微笑.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"看我的！\" 勳爆！！氣流斬！！！\"","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
     
    gsm.setState(GameStateManager.PLAY3);
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
