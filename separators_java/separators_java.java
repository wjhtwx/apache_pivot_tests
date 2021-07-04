package separators_java;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class separators_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(separators_java.class, args);
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
		panel.setOrientation(Orientation.VERTICAL);
		Separator separator1=new Separator();
		separator1.setHeading("hello");
		separator1.setPreferredWidth(500);
		panel.add(new Label("hello"));
		panel.add(separator1);
		panel.add(new Label("hello"));
		window.setContent(panel);
		window.setTitle("Separator");
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