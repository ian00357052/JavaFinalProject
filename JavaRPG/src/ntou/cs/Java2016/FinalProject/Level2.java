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
    f=new JFrame("�ĤG��");
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
    JOptionPane.showOptionDialog(f,"�I�����|���H�o�򶢡I�b���W�o��h����","����",oType,mType,new ImageIcon("Resources/Talk/���̲�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�u�O�֦��ڤF�㤣�L�ש�R��O�ɥ����F��","����",oType,mType,new ImageIcon("Resources/Talk/���Ҵo.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"����I�I�I","�p�y",oType,mType,new ImageIcon("Resources/Talk/�y���h.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�A����A���Ǯը��F�I�I","�p�y",oType,mType,new ImageIcon("Resources/Talk/�y�ͮ�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�A�S�O����F�H�H","����",oType,mType,new ImageIcon("Resources/Talk/���̲�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"����ڥi�O�j�]���X�U�Ĥ@�r�N�p�y","�p�y",oType,mType,new ImageIcon("Resources/Talk/�y�L��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ک^�j�]�����R�O�n�������H�e���Ǯ�","�p�y",oType,mType,new ImageIcon("Resources/Talk/�y�ͮ�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"���ާA�O�ֳ��L�k����ڥh�WJAVA�Ҫ��I","����",oType,mType,new ImageIcon("Resources/Talk/���L��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ݧڪ��I\" ���z�I�I��y�١I�I�I\"","����",oType,mType,new ImageIcon("Resources/Talk/����Y.jpg"),options,null);
     
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
