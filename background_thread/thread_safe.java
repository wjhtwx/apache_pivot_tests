package background_thread;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;
import org.apache.pivot.collections.*;
import org.apache.pivot.util.concurrent.*;

class ThreadSafe extends Task<String>
{
	public BoxPane panel=null;
	public ThreadSafe(BoxPane p)
	{
		panel=p;
	}
	@Override
	public String execute() throws TaskExecutionException
	{
		int doing=0;
		panel.setOrientation(Orientation.VERTICAL);
		while(doing<100)
		{
			panel.add(new Label("hello"));
			doing+=1;
		}
		while(doing<300)
		{
			System.out.println("hello");
		}
		return "";
	}
}

public class thread_safe implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(thread_safe.class, args);
		}
		catch(Throwable err)
		{
		}
	}
	@Override
	public void startup(Display display, Map<String, String>properties)
	{
		window=new Window();
		ScrollPane s=new ScrollPane();
		s.setVerticalScrollBarPolicy(ScrollBarPolicy.AUTO);
		BoxPane panel=new BoxPane();
		s.setView(panel);
		window.setContent(s);
		window.setTitle("Thread safe");
		window.setMaximized(true);
		window.open(display);
		ThreadSafe t=new ThreadSafe(panel);
		try
		{
			t.execute();
		}
		catch (TaskExecutionException err)
		{
		}
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