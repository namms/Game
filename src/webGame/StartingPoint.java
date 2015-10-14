package webGame;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;

public class StartingPoint extends Applet implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	private Image i;
	private Graphics doubleG;
	Ball b;
	Platform p[]=new Platform[7];
	Item item[] = new Item[3];
	private int score;
	double cityX =0;
	double citydx=3;
	URL url;
	Image city;
	public void init(){
		setSize(800,600);
	 addKeyListener(this);
	 try{
		 url =getDocumentBase();
	 }catch(Exception e){
		 
	 }
	 city =getImage(url,"image/Screen Shot 2015-10-04 at 2.01.09 AM.png");
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void start(){
		b = new Ball();
		score =0;
		for(int i=0; i<p.length; i++){
			Random r =new Random();
			p[i] = new Platform(getWidth()+200*i,getHeight()-40-r.nextInt(400));
		}
		for(int i=0; i<item.length; i++){
			Random r =new Random();
			switch(r.nextInt(5)){
			case 0:
			item[i]=new GravUp(getWidth()+2000*i);
			break;
			case 1:
				item[i]=new GravDown(getWidth()+2000*i);
				break;
			case 2:
				item[i]=new AgilUp(getWidth()+200*i);
				break;
			case 3:
				item[i]=new AgilDown(getWidth()+200*i);
				break;
			case 4:
				item[i]=new ScorePlus(getWidth()+200*i,this);
				break;
				
		}
			
		}
		Thread thread =new Thread(this);
		thread.start();
	}
	public void  stop(){
		super.stop();
	}
    public void destroy(){
	super.destroy();
    }
    public void update(Graphics g){
    	if(i ==null)
    	{
    	i = createImage(this.getSize().width, this.getSize().height);
    	doubleG =i.getGraphics();
    	}
    	doubleG.setColor(getBackground());
    	doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
    	doubleG.setColor(getForeground());
    	paint(doubleG);
    	g.drawImage(i,0,0, this);
    }
    public void paint(Graphics g){
    	g.setColor(new Color(15,77,147));
    	g.fillRect(0, 0, getWidth(), getHeight());
    	g.drawImage(city, (int)cityX, 0, this);
    	g.drawImage(city, (int)cityX+getWidth(), 0, this);
    	
    	for(int i=0; i<p.length; i++){
			p[i].paint(g);
		}
    	for(int i=0; i<item.length; i++){
			item[i].paint(g);
		}
    	b.paint(g);
    	String s =Integer.toString(score);
    	Font font = new Font("Serif", Font.BOLD, 32);
    	g.setFont(font);
    	g.setColor(Color.black);
    	g.drawString(s,getWidth()-150+2, 50+2);
    	g.setColor(new Color(198,226,255));
    	g.drawString(s,getWidth()-150, 50);
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			if(cityX>getWidth()*-1){
			cityX -= citydx;
			}else{
				cityX=0;
			}
			Random r =new Random();
			score++;
		for(int i=0; i<item.length; i++){
			if(item[i].isCreateNew()){
				item[i]=null;
				switch(r.nextInt(5)){
				case 0:
				item[i]=new GravUp(getWidth()+10*r.nextInt(500));
				break;
				case 1:
					item[i]=new GravDown(getWidth()+10*r.nextInt(500));
					break;
				case 2:
					item[i]=new AgilUp(getWidth()+10*r.nextInt(500));
					break;
				case 3:
					item[i]=new AgilDown(getWidth()+10*r.nextInt(500));
					break;
				case 4:
					item[i]=new ScorePlus(getWidth()+10*r.nextInt(500),this);
					break;
					
			}
				item[i].setCreateNew(false);
		}
		}
			b.update(this);
       for(int i=0; i<p.length; i++){
			p[i].update(this, b);
		}
       for(int i=0; i<item.length; i++){
			item[i].update(this, b);
		}
			repaint();
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
				b.moveLeft();
		        break;
		case KeyEvent.VK_RIGHT:
			b.moveRight();
			break;
				
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
