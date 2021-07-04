package background_thread;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;
import org.apache.pivot.collections.*;
import org.apache.pivot.util.concurrent.*;

class ThreadSafeA extends Task<String>
{
	public ThreadSafeA()
	{
	}
	@Override
	public String execute() throws TaskExecutionException
	{
		int doing=0;
		while(doing<10)
		{
			System.out.println("hello");
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException err)
			{
			}
			doing+=1;
		}
		while(doing<300)
		{
			System.out.println("hello");
			doing++;
		}
		return "";
	}
}

public class thread_safe_A implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(thread_safe_A.class, args);
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
		ActivityIndicator activityindicator=new ActivityIndicator();
		activityindicator.setActive(true);
		panel.add(activityindicator);
		window.setContent(s);
		window.setTitle("Thread safe");
		window.setMaximized(true);
		window.open(display);
		ThreadSafeA t=new ThreadSafeA();
		t.execute(new TaskAdapter<String>(new TaskListener<String>()
		{
			@Override
			public void executeFailed(Task<String> arg0) {
			}
			@Override
			public void taskExecuted(Task<String> arg0) {
				activityindicator.setActive(false);
			}
		}));
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