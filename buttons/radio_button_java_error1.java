package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class radio_button_java_error1 implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(radio_button_java_error1.class, args);
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
		RadioButton button1=new RadioButton();
		button1.setButtonData("hello");
		panel.add(button1);
		RadioButton button2=new RadioButton();
		button2.setButtonData("hi");
		panel.add(button2);
		RadioButton button3=new RadioButton();
		button3.setButtonData("hello");
		panel.add(button3);
		window.setContent(panel);
		window.setTitle("Radio Buttons");
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