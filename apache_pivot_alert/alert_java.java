package apache_pivot_alert;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class alert_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(alert_java.class, args);
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
		button1.setButtonData("hello");
		button1.getButtonPressListeners().add(new ButtonPressListener()
		{
	@Override
	public void buttonPressed(Button button)
	{
		Alert.alert(MessageType.ERROR, "MessageType.ERROR", window);
		Alert.alert(MessageType.INFO, "MessageType.INFO", window);
		Alert.alert(MessageType.QUESTION, "MessageType.QUESTION", window);
		Alert.alert(MessageType.WARNING, "MessageType.WARNING", window);
	}
		});
		panel.add(button1);
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