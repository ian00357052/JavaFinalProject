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
    f=new JFrame("�̲׳�");
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
    JOptionPane.showOptionDialog(f,"�����ש󥴱Ѥj�]����ǮդF�I�I","�p�y",oType,mType,new ImageIcon("Resources/Talk/�����}��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�O�����r�I�A���b�o�̡㨫�a �@�_�W�ҧa<3","�b�b",oType,mType,new ImageIcon("Resources/Talk/�b�}��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�m�m���m���m�m���","�x��",oType,mType,new ImageIcon("Resources/Talk/images.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"����ڡI�I����r ��ӬO�ڪ�","����",oType,mType,new ImageIcon("Resources/Talk/���̲�.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"�ᤣ�I�I�I�~�M�w�g����12�I�F�I JAVA�w�g�U�ҤFQQ","����",oType,mType,new ImageIcon("Resources/Talk/���~��.jpg"),options,null);
    JOptionPane.showOptionDialog(f,"��....�ڪ��b�b...","����",oType,mType,new ImageIcon("Resources/Talk/���Ҵo.jpg"),options,null);     
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