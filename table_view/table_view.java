package table_view;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class table_view implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(table_view.class, args);
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
		TableView table_view1=new TableView();
		List<String> l=new ArrayList<String>();
		l.add("hello");
		l.add("hi");
		table_view1.setTableData(l);
		panel.add(table_view1);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("TableViews");
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