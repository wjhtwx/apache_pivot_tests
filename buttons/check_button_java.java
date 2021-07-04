package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class check_button_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(check_button_java.class, args);
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
		Checkbox button1=new Checkbox();
		button1.setButtonData("hello");
		panel.add(button1);
		button1.setSelected(true);
		Checkbox button2=new Checkbox();
		button2.setButtonData("hi");
		panel.add(button2);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("Check Buttons");
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