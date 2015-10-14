package webGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ScorePlus extends Item{
private StartingPoint appletinfo;
	public ScorePlus(int x, StartingPoint appletinfo) {
		super(x);
		this.appletinfo=appletinfo;
		// TODO Auto-generated constructor stub
	}
	public void performAction(Ball b){
		super.performAction(b);
		Random r =new Random();
		appletinfo.setScore(appletinfo.getScore()+500+r.nextInt(2000));
		}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		super.paint(g);
	}

}
