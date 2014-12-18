import java.awt.*;
import javax.swing.*;
import java.util.*;

class TortillaTimer extends JFrame implements Runnable
{
	// Global Objects
	Thread runner;
	Font myFont;
	
	// Create Window
	public TortillaTimer()
	{
		// Window Title
		super("Tortilla Timer");
		// Window Size
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Create Font Instance
		myFont = new Font("Serif", Font.BOLD, 40);
		
		// Components
		Container contentArea = getContentPane();
		
		TimePanel timeDisplay = new TimePanel();
		contentArea.add(timeDisplay);
		
		setContentPane(contentArea);
		
		// Start Thread Running
		start();
	}
	
	class TimePanel extends JPanel
	{
		public void paintComponent(Graphics painter)
		{
			painter.setColor(Color.white);
			painter.fillRect(0, 0, 300, 100);
			painter.setFont(myFont);
			painter.setColor(Color.blue);
//TODO:-----------------------------------
			painter.drawString(timeSet(), 60, 40);
		}
	}
	
	public String timeSet()
	{
		//-- get timer value
		int hrs = 0;// get hours
		int min = 2;// get mins
		int sec = 0;// get sec
		String time = zero(hrs) + ":" + zero(min) + ":" + zero(sec);
		return time;
	}
	
	public String zero(int num)
	{
		String number = (num < 10) ? ("0" + num) : ("" + num);
		return number;
	}
	
	public void start()
	{
		if(runner == null) runner = new Thread(this);
		runner start();
	}
	
	public void run()
	{
		while (runner == Thread.currentThread())
		{
			repaint();
			try { Thread.sleep(1000); }
			catch(InterruptedException e) {}
		}
	}
	
	public static void main(String[] args)
	{ TortillaTimer tt = new TortillaTimer; }
}