package webGame;

import java.awt.Color;
import java.awt.Graphics;

public class AgilUp extends Item {
	public AgilUp(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	public void performAction(Ball b){
		if(b.getAgility()<8){
		b.setGravity(b.getGravity()+1);
		}
	}
@Override
public void paint(Graphics g) {
	// TODO Auto-generated method stub
	g.setColor(Color.GREEN);
	super.paint(g);
	
}
}
