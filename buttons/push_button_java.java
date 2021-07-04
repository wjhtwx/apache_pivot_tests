package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class push_button_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(push_button_java.class, args);
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
		PushButton button1=new PushButton();
		panel.add(button1);
		button1.setButtonData("hello");
		button1.getButtonPressListeners().add(new ButtonPressListener()
		{
	@Override
	public void buttonPressed(Button button)
	{
		Alert.alert(MessageType.ERROR, "button1", window);
	}
		});
		panel.add(new PushButton("button"));
		PushButton button2=new PushButton();
		button2.setButtonData("alert");
		button2.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				System.out.println("hello");
				Alert.alert("hello", window);
			}
				});
		panel.add(button2);
		window.setContent(panel);
		window.setTitle("Push Buttons");
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