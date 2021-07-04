package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class radio_button_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(radio_button_java.class, args);
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
		ButtonGroup group1=new ButtonGroup();
		RadioButton button1=new RadioButton();
		button1.setButtonData("hello");
		button1.setButtonGroup(group1);
		panel.add(button1);
		RadioButton button2=new RadioButton();
		button2.setButtonData("hi");
		button2.setButtonGroup(group1);
		panel.add(button2);
		RadioButton button3=new RadioButton();
		button3.setButtonData("hello");
		panel.add(button3);
		PushButton button4=new PushButton();
		button4.setButtonData("get selection");
		button4.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				System.out.println(group1.getSelection());
				System.out.println(group1.getSelection().equals(button1));
			}
				});
		panel.add(button4);
		window.setContent(panel);
		window.setTitle("Radio Buttons");
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