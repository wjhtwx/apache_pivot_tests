package text;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class text_area_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(text_area_java.class, args);
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
		Border border=new Border();
		border.setTitle("text area");
		TextArea text1=new TextArea();
		text1.setText("hello");
		border.setContent(text1);
		panel.add(border);
		window.setContent(panel);
		window.setTitle("TextInput");
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