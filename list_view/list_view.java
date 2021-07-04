package list_view;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.ListView.SelectMode;
import org.apache.pivot.collections.*;

public class list_view implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(list_view.class, args);
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
		ListView list_view1=new ListView();
		List<String>list_data=new ArrayList<String>();
		list_data.add("hello");
		list_data.add("hi");
		list_data.add("hello hello hello");
		list_data.add("ListView");
		list_view1.setListData(list_data);
		list_view1.setSelectMode(SelectMode.MULTI);
		list_view1.getListViewSelectionListeners().add(new ListViewSelectionListener()
				{
			@Override
			public void selectedRangeAdded(ListView listview, int rangeStart, int rangeEnd)
			{
				System.out.println(rangeStart);
				System.out.println(rangeEnd);
			}
			@Override
			public void selectedItemChanged(ListView listview, Object arg1)
			{
				System.out.println(arg1);
			}
			@Override
			public void selectedRangeRemoved(ListView listview, int rangeStart, int rangeEnd)
			{
				System.out.println(rangeStart);
				System.out.println(rangeEnd);
			}
			@Override
			public void selectedRangesChanged(ListView listview, Sequence<Span> list)
			{
			}
				});
		panel.add(list_view1);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("ListViews");
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