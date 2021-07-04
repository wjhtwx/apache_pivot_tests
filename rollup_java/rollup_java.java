package rollup_java;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class rollup_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(rollup_java.class, args);
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
		Rollup rollup1=new Rollup();
		rollup1.setHeading(new Label("hello"));
		rollup1.setExpanded(true);
		panel.add(rollup1);
		Label label1=new Label("hi");
		rollup1.setContent(label1);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("Rollups");
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