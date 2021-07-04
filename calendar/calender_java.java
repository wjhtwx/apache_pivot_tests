package calendar;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class calender_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(calender_java.class, args);
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
		Calendar calendar1=new Calendar();
		panel.add(calendar1);
		panel.getStyles().put("padding", 10);
		PushButton button1=new PushButton("Get date");
		button1.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				System.out.println(calendar1.getSelectedDate().year);
				System.out.println(calendar1.getSelectedDate().month+1);
				System.out.println(calendar1.getSelectedDate().day+1);
			}
				});
		panel.add(button1);
		window.setContent(panel);
		window.setTitle("Calendars");
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