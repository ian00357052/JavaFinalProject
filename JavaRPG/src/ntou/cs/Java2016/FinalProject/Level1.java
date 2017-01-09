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
    f=new JFrame("�Ĥ@��");
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
    String[] options={"�~��"};
    JOptionPane.showOptionDialog(f,"�z��i�̧A�s����W�r","�@�@",oType,mType,new ImageIcon("Resources/Talk/�@�}��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"��...��...�ڥs����","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"��ӬO�����W�H���I�I","�@�@",oType,mType,new ImageIcon("Resources/Talk/�@�}��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ڬO�q�j�]���p�ݨ���]�X�Ӫ��@�@","�@�@",oType,mType,new ImageIcon("Resources/Talk/�@�{�u.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�߲zOS�G�{�b�j�]�����䪺�H���o��ʷP�ܡI","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�{�b�j�]���b���Ǯժ����W�����F������������n�ǥͥh�W��","�@�@",oType,mType,new ImageIcon("Resources/Talk/�@�{�u.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"����I�ڤ@�w�n�h�W�ҡI�I���M�N�����ڤ߷R���b�b�@�_�W�ҤF","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ݨӧڭn���h���o���R�������U�z�Gį�ʡI","����",oType,mType,new ImageIcon("Resources/Talk/���Ҵo.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ѤF��A���j�]���]�b���o�����\�����񥬺��F����","�@�@",oType,mType,new ImageIcon("Resources/Talk/�@�{�u.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"���ޤF�I�I�I���a�I�I","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
     
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