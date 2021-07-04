package hello_world;

import org.apache.pivot.wtk.*;
import java.awt.Color;
import java.awt.Font;
import org.apache.pivot.collections.*;

public class hello_world implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(hello_world.class, args);
		}
		catch(Throwable err)
		{
		}
	}
	@Override
	public void startup(Display display, Map<String, String>properties)
	{
		window=new Window();
		Label label=new Label();
		label.setText("Hello world");
		label.getStyles().put("color", Color.BLACK);
		label.getStyles().put("font", new Font("Segoe Print", Font.ITALIC, 24));
		label.getStyles().put("horizontalAlignment", HorizontalAlignment.CENTER);
		label.getStyles().put("verticalAlignment", VerticalAlignment.CENTER);
		window.setContent(label);
		window.setTitle("Hello world");
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