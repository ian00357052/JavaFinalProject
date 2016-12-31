import java.util.concurrent.TimeUnit;

public class Alarm 
{
	private int X;
	private int Y;
	public Alarm(int X,int Y)
	{
		this.X = X;
		this.Y = Y;
	}
	public void prtAlarm(Boundary boundary)
	{
		for(int i = 0;i < 3;i++)
		{
			boundary.setBoundaryXYToWhat(X, Y, 'A');
			boundary.prtBoundary();
			try {
				TimeUnit.SECONDS.sleep(1);			//系統休息一秒(Delay)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boundary.ClearBoundary();;
			boundary.prtBoundary();
			try {
				TimeUnit.SECONDS.sleep(1);			//系統休息一秒(Delay)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
