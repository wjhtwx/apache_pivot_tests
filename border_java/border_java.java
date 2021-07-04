package border_java;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class border_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(border_java.class, args);
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
		Border border1=new Border();
		border1.setTitle("border");
		border1.setContent(new TextArea());
		panel.add(border1);
		window.setContent(panel);
		window.setTitle("border");
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