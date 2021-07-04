package meter_java;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class meter_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(meter_java.class, args);
		}
		catch(Throwable err)
		{
		}
	}
	@Override
	public void startup(Display display, Map<String, String>properties)
	{
		window=new Window();
		BoxPane panel=new BoxPane();
		Meter meter1=new Meter();
		meter1.setPreferredSize(500, 5);
		meter1.setPercentage(0);
		panel.add(meter1);
		PushButton button1=new PushButton();
		button1.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				if(meter1.getPercentage()+0.1<=1)
				{
					meter1.setPercentage(meter1.getPercentage()+0.1);
				}
				else
				{
					meter1.setPercentage(0);
				}
			}
				});
		panel.add(button1);
		window.setContent(panel);
		window.setTitle("ProgressBar Meter");
		window.setMaximized(true);
		window.open(display);
	}
	@Override
	public boolean shutdown(boolean optional)
	{
		if(window!=null)
		{
			window.close();
		}
		return false;
	}
	@Override
	public void suspend()
	{
	}
	@Override
	public void resume()
	{
	}
}