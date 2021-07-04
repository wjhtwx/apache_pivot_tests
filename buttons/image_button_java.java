package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.Mouse.Button;
import java.io.File;
import java.net.URL;

import org.apache.pivot.collections.*;

public class image_button_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(image_button_java.class, args);
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
		ImageView image1=new ImageView();
		if(new File("play.png").exists()==true)
		{
			image1.setImage(new URL("file:/C:/Java_projects/Apache_Pivot_tests/play.png"));
			image1.setPreferredSize(32, 32);
		}
		else
		{
			Alert.alert("Error", window);
		}
		image1.getComponentMouseButtonListeners().add(new ComponentMouseButtonListener()
				{
			@Override
	        public boolean mouseClick(Component component, Mouse.Button button, int x, int y, int count)
			{
	            Alert.alert("hello", window);
				return false;
	        }

			@Override
			public boolean mouseDown(Component arg0, Button arg1, int arg2, int arg3)
			{
				return false;
			}

			@Override
			public boolean mouseUp(Component arg0, Button arg1, int arg2, int arg3)
			{
				return false;
			}
				});
		panel.add(image1);
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