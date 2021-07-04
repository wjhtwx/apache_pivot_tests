package exception_lines;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class exception_lines implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(exception_lines.class, args);
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
		window.setContent(panel);
		window.setTitle("");
		window.setMaximized(true);
		window.open(display);
		Alert.alert("hello", window);
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