package horserun;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Racer  extends Canvas  implements Runnable
{
	private String name;
	private Image image=null;
	private int step=600;               //말이 한번에 뛸 픽셀
	private int pos;                       //말의 위치
	private static int  rank=1;  
	
	public Racer(String name){
		this.name=name;
		image=Toolkit.getDefaultToolkit().getImage("horse.gif");		
	}

	public String getName(){
		return name;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(0,  getSize().height/2, getSize().width, getSize().height/2);
		
//		System.out.println("pos = " + pos);
//		System.out.println(pos*getSize().width/step + "," + getSize().height);
		g.drawImage(image, pos*getSize().width/step, 0, 25, getSize().height, this);
		//super.paint(g);       -->  삭제할것
	}

	@Override
	public void run() {
		int i;
		for(i=0; i<=step; i+=((int)(Math.random()*10)+1))
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pos = i;
			repaint();
		}		
		System.out.println("i= " + i);
		System.out.println(rank + "등 말이름 : " + name);
	}	
}











