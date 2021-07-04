package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class list_button_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(list_button_java.class, args);
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
		ListButton button1=new ListButton();
		ArrayList<String> list1=new ArrayList<>();
		list1.add("hello");
		list1.add("hi");
		button1.setListData(list1);
		button1.setButtonData("please select");
		panel.add(button1);
		PushButton button2=new PushButton();
		button2.setButtonData("clear selection");
		ListButton button4=new ListButton();
		button2.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				button1.clearSelection();
				button1.setButtonData("please select");
				System.out.println(button1.getListData());
				button4.setButtonData("please select");
				System.out.println(button4.getSelectedIndex());
			}
				});
		panel.add(button2);
		ListButton button3=new ListButton();
		button3.setButtonData("hello");
		panel.add(button3);
		button4.setButtonData("please select");
		button4.setListData(list1);
		button4.setSelectedIndex(0);
		panel.add(button4);
		window.setContent(panel);
		window.setTitle("List Buttons");
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