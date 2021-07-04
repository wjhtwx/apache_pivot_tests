package file_browser;

import org.apache.pivot.wtk.*;

import java.io.*;
import org.apache.pivot.collections.*;
import org.apache.pivot.util.concurrent.Task;
import org.apache.pivot.util.concurrent.TaskExecutionException;

class ThreadSafe extends Task<String>
{
	public Window window=null;
	public ThreadSafe(Window w)
	{
		window=w;
	}
	@Override
	public String execute() throws TaskExecutionException
	{
		FileBrowserSheet browser=new FileBrowserSheet();
		browser.setSelectedFile(new File(browser.getRootDirectory(), "NewFile"));
		browser.setMode(FileBrowserSheet.Mode.SAVE_AS);
		browser.open(window, new SheetCloseListener()
				{
			@Override
			public void sheetClosed(Sheet sheet)
			{
				if(sheet.getResult())
				{
					Sequence<File> selectedFiles=browser.getSelectedFiles();
					System.out.println(selectedFiles.get(0));
				}
			}
				});
		return "";
	}
}

public class file_browser implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(file_browser.class, args);
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
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("FileBrowser");
		window.setMaximized(true);
		window.open(display);
		ThreadSafe t=new ThreadSafe(window);
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