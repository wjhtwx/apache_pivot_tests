package rollup_java;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class expander_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(expander_java.class, args);
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
		Expander expander1=new Expander();
		expander1.setExpanded(true);
		expander1.setTitle("hello");
		panel.add(expander1);
		BoxPane panel1=new BoxPane();
		Label label1=new Label("hi");
		panel1.add(label1);
		panel1.add(new PushButton("hello"));
		expander1.setContent(panel1);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("Expander");
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