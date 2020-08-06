import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Hra extends JPanel implements KeyListener, ActionListener{
	private boolean play=false;
	private int score;
	
	private Timer timer;
	private int delay=10;
	
	private int playerOneY;
	
	HumanPlayer play1=new HumanPlayer();
	AiPlayer Ai=new AiPlayer();
	Ball b1=new Ball();
	
	public Hra() {
		newGame();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void newGame() {
		if(!play) {
			play=true;
			b1.setX(380);
			b1.setY(280);
			b1.setXVel(-3);
			b1.setYVel(-2);
			Ai.setY(230);

			score=0;
			repaint();
		}
	}
	
	public double randomDouble(double min,double max) {
		double number;
		number=Math.random()*(max-min);
		return number;
		
	}
	
	public void paint(Graphics g) {
		//pozadí
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 600);
		
		Ai.draw(g);
		play1.draw(g);
		b1.draw(g);
	
		//score
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("Score: "+score, 550, 30);
		
		if(b1.getX()<-20) {
			play=false;
			b1.setXVel(0);
			b1.setYVel(0);
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("You Won, Score: "+score, 200, 300);
			
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("Pres Enter to restart", 250, 350);
		}
		
		if(b1.getX()>700) {
			play=false;
			b1.setXVel(0);
			b1.setYVel(0);
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("You Won, Score: "+score, 200, 300);
			
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("Pres Enter to restart", 250, 350);
		}
		
		g.dispose();
	}

	
	
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			//contakt s AI
			if(b1.getX()>15) {
				if(new Rectangle(5+10,Ai.getY(),8,100).intersects(new Rectangle(b1.getX(),b1.getY(),20,20))) {
					b1.setXVel(-b1.getXVel());
				}
			}
			//contakt s hráèem
			if(b1.getX()<663) {
				if(new Rectangle(670+10,play1.getY(),8,100).intersects(new Rectangle(b1.getX(),b1.getY(),20,20))) {
					b1.setXVel(-b1.getXVel());
					score+=50;
					
					if(b1.getXVel()>0) {
						b1.setXVel(b1.getXVel()+randomDouble(0, 0.5));
					}
					if(b1.getXVel()<0) {
						b1.setXVel(b1.getXVel()-randomDouble(0, 0.5));
					}
					if(b1.getYVel()>0) {
						b1.setYVel(b1.getYVel()+randomDouble(0, 0.4));
					}
					if(b1.getXVel()<0) {
						b1.setYVel(b1.getYVel()-randomDouble(0, 0.4));
					}
					System.out.println(b1.xVel);
					System.out.println(b1.yVel);
					System.out.println("----------------------------------------");
				}
			}	
			Ai.setY(b1.getY()-50);
			
			/*if(b1.getX()<250) {
				if(Ai.getY()>b1.getY()+20) {
					Ai.setUpAccel(true);
					Ai.setDownAccel(false);
				}
				if(Ai.getY()+100<b1.getY()) {
					Ai.setDownAccel(true);
					Ai.setUpAccel(false);
				}
				if(Ai.getY()+50==b1.getY()+10) {
					Ai.setDownAccel(false);
					Ai.setUpAccel(false);
				}
			}else {
				Ai.setDownAccel(false);
				Ai.setUpAccel(false);
			}*/
			
			
			Ai.move();
			b1.move();
			play1.move();
		}
		
		
		repaint();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			newGame();
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			play1.setUpAccel(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			play1.setDownAccel(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			play1.setUpAccel(false);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			play1.setDownAccel(false);

		}
	}
}
