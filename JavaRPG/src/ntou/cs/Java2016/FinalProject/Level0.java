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
    f=new JFrame("�ǳ�");
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
    String[] options={"�~��"};
    JOptionPane.showOptionDialog(f,"�m���m�m����m�m�m","�x��",oType,mType,new ImageIcon("Resources/Talk/images.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ڡI�I���J�F JAVA�ҭn���F","����",oType,mType,new ImageIcon("Resources/Talk/�����}��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"����I�ڭn���֥X�̤~��I�I","����",oType,mType,new ImageIcon("Resources/Talk/�����}��.jpg"),options,null);
    ImageIcon img1 = new ImageIcon("level1bg.jpg");
	imgLabel = new JLabel(img1);
	f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	imgLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
	imgLabel.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
	((JPanel) cp).setOpaque(false);
    JOptionPane.showOptionDialog(f,"��������������������I�I","����",oType,mType,new ImageIcon("Resources/Talk/�z�z�U��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�I�I�I�I�I�I�I�I�I�I","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�o�ͤ���Ʊ��F���I�I","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"��...��...�����D,�@���_�ӤW�ҴN�o�ˤF�I�I","����",oType,mType,new ImageIcon("Resources/Talk/�z�z�U��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�������S�ӤF�I�������I�I","����",oType,mType,new ImageIcon("Resources/Talk/�z�z�U��.jpg"),options,null);
     
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
