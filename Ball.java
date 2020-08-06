import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Ball {
	double x,y,xVel,yVel;
	
	public Ball(){
		x=350;
		y=250;
		yVel=-2;
		xVel=-2;
	}
	
	public void move() {
		x+=xVel;
		y+=yVel;
		
		if(y<10) {
			yVel=-yVel;
		}
		if(y>550) {
			yVel=-yVel;
		}	
		
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int) y-10, 20, 20);
	}
	
	public int getY() {
		return (int)y;
	}
	public int getX() {
		return (int)x;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	public void setXVel(double xVel) {
		this.xVel=xVel;
	}
	public double getXVel() {
		return xVel;
	}
	public void setYVel(double yVel) {
		this.yVel=yVel;
	}
	public double getYVel() {
		return yVel;
	}

}
