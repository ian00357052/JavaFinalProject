import java.util.concurrent.TimeUnit;

//Weapon列別的SuperClass,之後的武器都會沿著這個發展
public abstract class Weapon 
{
	protected int X; //X,Y代表Weapon的所在位置
	protected int Y;
	protected int injure; //injure代表Weapon對角色造成的傷害
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
