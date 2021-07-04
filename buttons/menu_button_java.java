package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class menu_button_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(menu_button_java.class, args);
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
		MenuButton button1=new MenuButton();
		List<String> l=new ArrayList<String>();
		l.add("hello");
		l.add("hi");
		button1.setMenu(new Menu());
		panel.add(button1);
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