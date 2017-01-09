package ntou.cs.Java2016.FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level3 extends GameState implements ActionListener {
  JFrame f;

 
  public Level3(GameStateManager gsm) {
		super(gsm);
	}
  public void init(){
    //Setup JFrame

    JFrame.setDefaultLookAndFeelDecorated(false);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("第三章");
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
    JOptionPane.showOptionDialog(f,"ㄜ...阿......怎麼...可能...會....","小語",oType,mType,new ImageIcon("Resources/Talk/語生氣.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"在我的勳爆氣流斬下沒有什麼不可能的！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳微笑.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"想不到連我的第一猛將小語都輸了....","小毅",oType,mType,new ImageIcon("Resources/Talk/毅傻眼.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"看來最後還是要靠我了...","小毅",oType,mType,new ImageIcon("Resources/Talk/毅閉眼.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"大魔王來吧！打敗你我就可以去上課了！！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳懊惱.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"呀阿阿！！阿阿阿！！！","勳勳",oType,mType,new ImageIcon("Resources/Talk/勳驚訝.jpg"),options,null);     
    gsm.setState(GameStateManager.PLAY4);
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
