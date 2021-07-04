package buttons;

import org.apache.pivot.wtk.*;
import java.io.File;
import java.net.URL;

import org.apache.pivot.collections.*;

public class image_button_update implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(image_button_update.class, args);
		}
		catch(Throwable err)
		{
		}
	}
	@Override
	public void startup(Display display, Map<String, String>properties) throws Exception
	{
		window=new Window();
		BoxPane panel=new BoxPane();
		panel.getStyles().put("padding", 10);
		PushButton button1=new PushButton();
		if(new File("play.png").exists()==true)
		{
			button1.setButtonData(new URL("file:/C:/Java_projects/Apache_Pivot_tests/play.png"));
			button1.setPreferredSize(32, 32);
		}
		else
		{
			Alert.alert("Error", window);
		}
		panel.add(button1);
		window.setContent(panel);
		window.setTitle("Image");
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