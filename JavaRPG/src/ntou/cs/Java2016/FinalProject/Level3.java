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
    f=new JFrame("�ĤT��");
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
    String[] options={"�~��"};
    JOptionPane.showOptionDialog(f,"��...��......���...�i��...�|....","�p�y",oType,mType,new ImageIcon("Resources/Talk/�y�ͮ�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�b�ڪ����z��y�٤U�S�����򤣥i�઺�I","����",oType,mType,new ImageIcon("Resources/Talk/���L��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�Q����s�ڪ��Ĥ@�r�N�p�y����F....","�p��",oType,mType,new ImageIcon("Resources/Talk/�ݶ̲�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ݨӳ̫��٬O�n�a�ڤF...","�p��",oType,mType,new ImageIcon("Resources/Talk/�ݳ���.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�j�]���ӧa�I���ѧA�ڴN�i�H�h�W�ҤF�I�I","����",oType,mType,new ImageIcon("Resources/Talk/���Ҵo.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�r�����I�I�������I�I�I","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);     
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
