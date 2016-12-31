import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//����ɪ�Class,�Ψ���ɧP�w�B�L�X���(demo�����ե�)
public class Boundary 
{
	private int width;
	private int length;
	private char boundary[][];
	private int choise;
	public Boundary()	//��l����ɬ�10x10 [8x8 �|�P�Ť@�Ʒ����]
	{
		choise = 0;
		width = 10;
		length = 10;
		boundary = new char[width][length];
		for(int i = 0;i < width;i++)
		{
			for(int j = 0;j < length;j++)
			{
				if(j == 0 || j == length-1)
					boundary[i][j] = '-';
				else if(i == 0 || i == width-1)
					boundary[i][j] = '|';
				else
					boundary[i][j] = ' ';
			}
		}
		
	}
	public boolean checkWeapon(Weapon weapon) //��K�b���class�P�_�O�_���X��
	{
		return weapon.checkBoundary(width, length);
	}
	public void prtBoundary()
	{
		for(int i = 0;i < length; i++)
		{
			for(int j = 0;j < width; j++)
			{
				System.out.print(boundary[j][i]);
			}
			System.out.println("");
		}
	}
	public void controlPanel()
	{
		Scanner scanner = new Scanner(System.in);
		this.prtChoise();
		choise = scanner.nextInt();
		while(choise != -1)
		{
			switch(choise)
			{
			case 1:CreateRandomWeapon(this);break;
			case 2:CreateMissile(this);break;
			case 3:CreateLaser(this);break;
			}
			this.prtBoundary();		//��C�����ج[�L�X��(demo)
			try {
				TimeUnit.SECONDS.sleep(1);			//�t�Υ𮧤@��(Delay)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.prtChoise();
			choise = scanner.nextInt();
		}
		System.out.println("�C�������I");
	}
	private void CreateLaser(Boundary boundary) 
	{
		Alarm alarm = null;
		Direct direct;
		Weapon weapon = null;
		Random random = new Random();
		int wall = random.nextInt(4); //0�O����,1�O�U��,2�O�k��,3�O�W��
		int hole = random.nextInt(8);
		switch(wall)
		{
		//�V�k
		case 0:
			direct = Direct.Right;
			alarm = new Alarm(0, hole+1);
			weapon = new Laser(0, hole+1, 0, direct);
			break;
		//�V�W
		case 1:
			direct = Direct.Up;
			alarm = new Alarm(hole+1, 9);
			weapon = new Laser(hole+1, 9, 0, direct);
			break;
		//�V��
		case 2:
			direct = Direct.Left;
			alarm = new Alarm(9, hole+1);
			weapon = new Laser(9, hole+1, 0, direct);
			break;
		//�V�U
		case 3:
			direct = Direct.Down;
			alarm = new Alarm(hole+1, 0);
			weapon = new Laser(hole+1, 0, 0, direct);
			break;
		}
		alarm.prtAlarm(boundary);
		weapon.prtWeapon(boundary);
	}
	public void prtChoise()
	{
		System.out.println("�п�ܭn�����ʧ@");
		System.out.println("1.�гy�@���H��Weapon");
		System.out.println("2.�гy�@�ӭ��u");
		System.out.println("3.�гy�@�ӹp�g����");
		System.out.println("-1.���}�C��");
	}
	public void CreateRandomWeapon(Boundary boundary)
	{
		Random random = new Random();
		int temp = random.nextInt(2);
		switch(temp)
		{
		case 0:
			CreateMissile(boundary);
		case 1:
			CreateLaser(boundary);
		}
	}
	public void CreateMissile(Boundary boundary)
	{
		Alarm alarm = null;
		Direct direct;
		Weapon weapon = null;
		Random random = new Random();
		int wall = random.nextInt(4); //0�O����,1�O�U��,2�O�k��,3�O�W��
		int hole = random.nextInt(8);
		switch(wall)
		{
		//�V�k
		case 0:
			direct = Direct.Right;
			alarm = new Alarm(0, hole+1);
			weapon = new Missile(0, hole+1, 0, direct);
			break;
		//�V�W
		case 1:
			direct = Direct.Up;
			alarm = new Alarm(hole+1, 9);
			weapon = new Missile(hole+1, 9, 0, direct);
			break;
		//�V��
		case 2:
			direct = Direct.Left;
			alarm = new Alarm(9, hole+1);
			weapon = new Missile(9, hole+1, 0, direct);
			break;
		//�V�U
		case 3:
			direct = Direct.Down;
			alarm = new Alarm(hole+1, 0);
			weapon = new Missile(hole+1, 0, 0, direct);
			break;
		}
		alarm.prtAlarm(boundary);
		weapon.prtWeapon(boundary);
	}
	public void setBoundaryXYToWhat(int X,int Y,char what)
	{
		boundary[X][Y] = what;
	};
	public void ClearBoundary()
	{
		for(int i = 0;i < width;i++)
		{
			for(int j = 0;j < length;j++)
			{
				if(j == 0 || j == length-1)
					boundary[i][j] = '-';
				else if(i == 0 || i == width-1)
					boundary[i][j] = '|';
				else
					boundary[i][j] = ' ';
			}
		}
	}
}
