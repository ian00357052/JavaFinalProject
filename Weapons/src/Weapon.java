import java.util.concurrent.TimeUnit;

//Weapon�C�O��SuperClass,���᪺�Z�����|�u�۳o�ӵo�i
public abstract class Weapon 
{
	protected int X; //X,Y�N��Weapon���Ҧb��m
	protected int Y;
	protected int injure; //injure�N��Weapon�﨤��y�����ˮ`
	private Direct direct;
	public Weapon(int X,int Y,int injure,Direct direct) 
	{
		this.X = X;
		this.Y = Y;
		this.injure = injure;
		this.direct = direct;
	}
	public void Move()
	{
		switch(direct)
		{
		case Up:Y--;	break;
		case Down:Y++;	break;
		case Left:X--;	break;
		case Right:X++;	break;
		}
	}
	public boolean checkBoundary(int width,int length)
	{
		if(X > 1 && X < width && Y > 1 && Y < length)
			return true;
		return false;
	}
	public abstract void prtWeapon(Boundary boundary);
}
