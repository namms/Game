package webGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Item {
 private int x,y,dx,radius;
 private StartingPoint sp;
 private boolean createNew =false;
	public Item(int x) {
		this.x=x;
		Random r =new Random();
		y=r.nextInt(400)+radius;
		radius =10;
		dx =-2;
	}
	
	
	public boolean isCreateNew() {
		return createNew;
	}


	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void update(StartingPoint sp, Ball b){
	    x+=dx;
	    this.sp=sp;
		checkForCollision(b);
		if(x<0-radius){
			createNew=true;
		}
		
	}
   private void checkForCollision(Ball b) {
	
	int ballX = b.getX();
	int ballY =b.getY();
	int ballR =b.getRadius();
	int a =x-ballX;
	int bb =y-ballY;
	int collide =radius +ballR;
	double c =Math.sqrt((double)(a*a)+(double)(bb*bb));//distance between objects

	if(c < collide){
		performAction(b);
		createNew=true;
		}
	}
public void performAction(Ball b) {
	// TODO Auto-generated method stub
	
}

public void paint(Graphics g)
	{
		//g.setColor(Color.GREEN);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}


}
