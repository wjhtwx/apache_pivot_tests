package styles;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class backgroundColor implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(backgroundColor.class, args);
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
		button1.getStyles().put("color", "#FFFFFF");
		Checkbox button2=new Checkbox();
		button2.setButtonData("hi");
		button2.getStyles().put("color", "#FFFFFF");
		panel.add(button2);
		panel.getStyles().put("padding", 10);
		window.getStyles().put("backgroundColor", "#000000");
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