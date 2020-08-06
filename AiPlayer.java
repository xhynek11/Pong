import java.awt.Color;
import java.awt.Graphics;

public class AiPlayer {
	
	private boolean upAccel,downAccel;
	
	private double x,y,yVel;
	final double GRAVITY=0.9;
	
	public AiPlayer() {
		this.upAccel = false;
		this.downAccel = false;
		this.x = 670;
		this.y = 230;
		this.yVel = 0;
	}

	public boolean isUpAccel() {
		return upAccel;
	}

	public void setUpAccel(boolean upAccel) {
		this.upAccel = upAccel;
	}

	public boolean isDownAccel() {
		return downAccel;
	}

	public void setDownAccel(boolean downAccel) {
		this.downAccel = downAccel;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(5, (int) y, 8, 100);
	}
	
	public void move() {
		if(upAccel) {
			yVel-=2;
		}else if(downAccel){
			yVel+=2;
		}else if(!upAccel && !downAccel){
			yVel*=GRAVITY;
		}
		y+=yVel;
		
		if(yVel>2)
			yVel=2;
		if(yVel<-2)
			yVel=-2;
		
		if(y<10)
			y=10;
		if(y>450)
			y=450;
		
	}
	
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	
	
	
	

}