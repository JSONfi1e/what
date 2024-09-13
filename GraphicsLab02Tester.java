// GraphicsLab02.java
// Student starting version of the GraphicsLab02 assignment.
// Resave this program as GraphicsLab0280 for the 80 point version.
// Repeat this process as you progress to the 90 and 100 point versions.
// 80 Point Version. Your program has one class with three or more methods.
// 90 Point Version. Your program has one class with three or more methods.It has a second class with two or more methods.
// 100 Point Version. Your program has one class with three or more methods.It has a second class with two or more methods.
//                    It has a third class with one or more methods.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import javax.sound.sampled.*;
import java.awt.Toolkit;
import java.net.*;
public class GraphicsLab02Tester
{
	static File file; 
    static AudioInputStream stream; 
    static Clip music;
	public static void main(String...args) throws Exception
	{
		file = new File("minecraftmusic.wav");//File must be .WAV, .AU, or .AIFF
		stream = AudioSystem.getAudioInputStream(file);
		music = AudioSystem.getClip();
		music.open(stream);
		music.start(); //Start the music
		music.loop(Clip.LOOP_CONTINUOUSLY); //Loop the music
		//music.stop(); //Stop the music
		//music.close(); //Unload the clip from memory
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanel m = new MyPanel();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
				  //use setContentPane() sometimes works better then just add b/c of greater efficiency.
		
		j.setVisible(true); //allows the frame to be shown.
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
	}    
}     
class MyPanel extends JPanel implements ActionListener, MouseListener, KeyListener
{
	private Timer time;
	private int x,y,q,k,alt,hor,cloudPos,length,blinkPos;
	private int add;
	
	MyPanel(){ 
		setSize(800, 600);
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=1;
		x=y=q=length=600;
		k=cloudPos=blinkPos=0;
		alt = (int)(Math.random()*580);
		hor = (int)(Math.random()*1700);
		addMouseListener(this); //adds mouse listener
		setFocusable(true);
		addKeyListener(this); //adds key listener
}

public void paintComponent(Graphics g)
{
	//makes background and calls objects
	Color background = new Color(139, 224, 247);
 	g.setColor(background);  
	g.fillRect(0,0,2000,1010);
	drawGrass(g, Color.GREEN, 600, y);
	stick(g, Color.CYAN, x, y);
	steveBody(g, Color.CYAN, x, y);
	zombieBody(g, Color.CYAN, q, y);
	cloud(g, Color.BLUE, cloudPos);
	bee(g, Color.YELLOW,alt);
	lightning(g);
	blink(g,background,blinkPos);
	//imports image of sun
  Image car;
		try
		{
			car = ImageIO.read(new File("sunFinal.png"));
			g.drawImage(car, 1750, 0, null);
		}
		catch(Exception e)	{}
}
//creates background image of grass and sky
public void drawGrass (Graphics g, Color c, int x, int y)
{
Color grass1 = new Color(146,108,77);
g.setColor(grass1);
g.fillRect(0,900,2000,120);
g.setColor(c);
g.fillRect(0,900,2000,22);
}

//creates Steve's stick

public void stick (Graphics g, Color c, int x, int y){
	
	Color stick = new Color(148,89,21);
	g.setColor(stick);
	g.drawLine(x+110,810,x+k+100,length+100);
	g.drawLine(x+110,811,x+k+100,length+101);
	g.drawLine(x+110,812,x+k+100,length+102);
	g.drawLine(x+110,813,x+k+100,length+103);
	g.drawLine(x+110,814,x+k+100,length+104);
}

//creates steve
   
public void steveBody (Graphics g, Color c, int x, int y)     

{
Color steve = new Color(181, 134, 98);
//face
g.setColor(steve);
g.fillRect(x+30,630,70,70);    
g.fillRect(x,700,130,120);   
g.setColor(c);
//arms   
g.fillRect(x+35,700,60,100);    
g.fillRect(x,700,130,30);
//pants 
Color pants = new Color(0, 75, 161);    
g.setColor(pants);    
g.fillRect(x+35,800,60,100);
//hair
Color hair = new Color(66, 41, 22);    
g.setColor(hair);     
g.fillRect(x+30,630,10,30);   
g.fillRect(x+90,630,10,30);   
g.fillRect(x+40,630,60,20);
//white part of eyes
Color eyesWhite = new Color(255, 255, 255);
g.setColor(eyesWhite);
g.fillRect(x+35,665,10,10); 
g.fillRect(x+85,665,10,10);
//blue part of eyes
Color eyesBlue = new Color (44,23,182); 
g.setColor(eyesBlue); 
g.fillRect(x+45,665,10,10); 
g.fillRect(x+75,665,10,10); 
//nose
Color nose = new Color(122,78,40); 
g.setColor(nose);
g.fillRect(x+55,675,20,10);
//mouth
Color mouth = new Color(51, 0, 0); 
g.setColor(mouth); 
g.fillRect(x+45, 685, 10, 15); 
g.fillRect(x+75, 685, 10, 15); 
g.fillRect(x+55, 695, 20, 5); 
//shoes
Color shoes = new Color(145, 141, 131); 
g.setColor(shoes); 
g.fillRect(x+35,890,60,10);
}     
//code for zombie
public void zombieBody (Graphics g, Color c, int q, int y) 
{	     
Color zombie = new Color(0, 153, 0);     
g.setColor(zombie);     
g.fillRect(q+230,630,70,70);    
g.fillRect(q+200,700,130,120);   
g.setColor(c);    
g.fillRect(q+235,700,60,100);
g.fillRect(q+200,700,130,30);
//zombie pants
Color pants = new Color(0, 75, 161);
g.setColor(pants); 
g.fillRect(q+235,800,60,100);
//zombie eyes
Color eyes = new Color(0, 0, 0);
g.setColor(eyes);
g.fillRect(q+235,665,20,10); 
g.fillRect(q+275,665,20,10);
//zombie nose
Color nose = new Color(4,71,19); 
g.setColor(nose);
g.fillRect(q+255,675,20,10);
//zombie shoes
Color shoes = new Color(145, 141, 131); 
g.setColor(shoes); 
g.fillRect(q+235,890,60,10);
}

//creates cloud object
public void cloud (Graphics g, Color c, int cloudPos){
	g.setColor(Color.WHITE);
	g.fillOval(cloudPos, 75, 100, 50);
	g.fillOval(cloudPos+50, 75, 100, 50);
	g.fillOval(cloudPos+100, 75, 100, 50);
	g.fillOval(cloudPos+50, 100, 100, 50);
	g.fillOval(cloudPos+50, 50, 100, 50);
}


//creates lightning
public void lightning(Graphics g) {
        int [] x = {1545, 1555, 1575, 1555, 1563, 1543, 1517, 1531, 1512, 1535, 1545};
        int [] y = {191, 265, 221, 283, 308, 238, 305, 228, 261, 213, 241};
        g.drawPolygon(x, y, 10);
        g.setColor(Color.YELLOW);
        g.fillPolygon(x, y, 10);
}

//blinks the lightning
public void blink (Graphics g, Color c,int blinkPos){
	int random = (int)(Math.random()*2);
	if(random==0){
		blinkPos = 1500;
	}
	else{
		blinkPos = 500000;
	}
	g.setColor(c);
	g.fillRect(blinkPos,170,100,180);
}

//creates bee object
public void bee (Graphics g, Color c, int alt){
	//creates new bee color
	Color bee = new Color(255, 224, 27);
	//makes bee body
	g.setColor(bee);     
	g.fillRect(hor,alt,80,50);
	//makes bee stripes
	Color beeBrown = new Color(141, 113, 22);
	g.setColor(beeBrown);
	g.fillRect(hor+20,alt,10,50);
	g.fillRect(hor+40,alt,10,50);
	g.fillRect(hor+60,alt,30,50);
	//makes bee eye
	g.setColor(Color.BLACK);
	g.fillRect(hor, alt+10, 15, 20);
	Color beeEyeBlue = new Color(28, 214, 252);
	g.setColor(beeEyeBlue);
	g.fillRect(hor, alt+10, 10, 10);
	//makes bee wing
	g.setColor(Color.WHITE);
	g.fillRect(hor+30, alt, 30, 10);
	//makes bee legs
	g.setColor(beeBrown);
	g.fillRect(hor+30, alt+50, 5, 10);
	g.fillRect(hor+40, alt+50, 5, 10);
	g.fillRect(hor+50, alt+50, 5, 10);
}

//moves objects based on use inputs

public void actionPerformed(ActionEvent e){
	if (cloudPos >=1750)
			cloudPos=1;
		cloudPos+=add;
		y+=add;
		if(cloudPos==2000 && y==200){
			add*=-1;
		}
		if(cloudPos==200 && y==20){
			add*=-1;
		}
	
		repaint();
	}  

public void keyPressed(KeyEvent e)
	{
		// code to move steve
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if (x>0)
			x-=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if (x<1790)
			x+=10;
		}
		//code to move zombie
		else if(e.getKeyCode()==KeyEvent.VK_D){
			if (q<1590)
			q+=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			if (q>-200)
			q-=10;
		}
		//code to move bee to random positions
		else if(e.getKeyCode()==KeyEvent.VK_ENTER){
			alt = (int)(Math.random()*580);
			hor = (int)(Math.random()*1700);
		}
		repaint();
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void mousePressed(MouseEvent e){length-=50;k+=120;repaint();}
	public void mouseReleased(MouseEvent e){length+=50;k-=120;repaint();}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}