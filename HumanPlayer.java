import java.awt.Color;
import java.awt.Graphics;

public class HumanPlayer {
	
	private boolean upAccel,downAccel;
	private int x;
	private double y,yVel;
	final double GRAVITY=0.9;
	
	public HumanPlayer() {
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
		g.fillRect(670, (int) y, 8, 100);
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
		
		if(yVel>5)
			yVel=5;
		if(yVel<-5)
			yVel=-5;
		
		if(y<10)
			y=10;
		if(y>450)
			y=450;
	}
	
	
	
	

}
