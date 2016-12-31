import java.util.concurrent.TimeUnit;

public class Missile extends Weapon
{
	public Missile(int X, int Y, int injure, Direct direct) 
	{
		super(X, Y, injure, direct);
	}

	@Override
	public void prtWeapon(Boundary boundary)
	{
		do
		{
			this.Move();
			boundary.setBoundaryXYToWhat(X, Y, 'O');
			boundary.prtBoundary();
			try {
				TimeUnit.SECONDS.sleep(1);			//¨t²Î¥ð®§¤@¬í(Delay)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boundary.ClearBoundary();
		}while(X > 0 && Y > 0 && X < 9 && Y < 9);
	}
	
}
