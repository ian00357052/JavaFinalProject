package ntou.cs.Java2016.FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level0 extends GameState implements ActionListener {
  JFrame f;

 
  public Level0(GameStateManager gsm) {
		super(gsm);
	}
  public void init(){
    //Setup JFrame


    JFrame.setDefaultLookAndFeelDecorated(false);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("序章");
    f.setSize(750,750);
    f.setLocationRelativeTo(null);
    Container cp=f.getContentPane();
    cp.setLayout(null);
    f.setVisible(true);
    
    ImageIcon img = new ImageIcon("Resources/Talk/bed.jpg");
	JLabel imgLabel = new JLabel(img);
	f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	imgLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
	imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	((JPanel) cp).setOpaque(false);
    
    //Build Elements
    int mType=JOptionPane.QUESTION_MESSAGE;
    int oType=JOptionPane.YES_NO_OPTION;
    String[] options={"繼續"};
    JOptionPane.showOptionDialog(f,"叮～～叮叮～～～叮叮叮","鬧鐘",oType,mType,new ImageIcon("Resources/Talk/images.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"啊！！完蛋了 JAVA課要遲到了","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳勳開心.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"不行！我要趕快出們才行！！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳勳開心.jpg"),options,null);
    ImageIcon img1 = new ImageIcon("level1bg.jpg");
	imgLabel = new JLabel(img1);
	f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	imgLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
	imgLabel.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
	((JPanel) cp).setOpaque(false);
    JOptionPane.showOptionDialog(f,"阿阿阿阿阿～～～塊陶阿！！","金金",oType,mType,new ImageIcon("Resources/Talk/津津下到.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"！！！！！！！！！！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"發生什麼事情了阿！！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"不...不...不知道,一早起來上課就這樣了！！","金金",oType,mType,new ImageIcon("Resources/Talk/津津下到.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"阿阿阿又來了！塊陶阿！！","金金",oType,mType,new ImageIcon("Resources/Talk/津津下到.jpg"),options,null);
     
    gsm.setState(GameStateManager.PLAY);
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
	if(Keys.isPressed(Keys.ENTER)) {
		gsm.setState(GameStateManager.PLAY);
	}
	
}
  }
