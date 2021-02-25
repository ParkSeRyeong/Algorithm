package ssafy_0222;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunRace extends Frame  implements ActionListener
{
	private Button bt=new Button("출발");
	private int count;
	private Racer[] ra;	
	
	public RunRace(int count, String[] hn)
	{
		super.setTitle("경마");
		this.count = count;
		ra = new Racer[this.count];
		setLayout(new BorderLayout());
		Panel p = new Panel(new GridLayout(this.count, 1));
		for(int i = 0; i < this.count; i++){
			ra[i] = new Racer( hn[i + 1]);
			p.add(ra[i]);
		}	
		add("Center", p);
		Panel p1 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(bt);

		//이벤트처리
		bt.addActionListener(this);
		
		
		add("South", p1);
		setSize(600, 200);
		setVisible(true);		
		
		super.addWindowListener(
			new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt)
		{
			Thread[] th = new Thread[count];
			for(int i=0; i<count; i++)
			{
				th[i] = new Thread(ra[i]);                    //쓰레드객체생성   Racer클래스에 implements Runnable추가
				th[i].setName(ra[i].getName());    
				th[i].setPriority((int)(Math.random() * 10) +1);
			}
			for(int i=0; i<count; i++)
			{
				th[i].start();    // th[i] 쓰레드 생성후  Racer클래스의 run()메서드 실행
			}
		}		
	}
	
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("사용법 : 출전말의수 , 말이름1, 말이름2, 말이름3....");
			System.exit(0);
		}
		
		int cnt = Integer.parseInt(args[0]);
		if((cnt+1) != args.length)
		{
			System.out.println("에러 : 출전말의수와 말이름의 갯수가 일치하지 않음");
			System.exit(0);
		}
		
		new RunRace(cnt, args);
	}
}








