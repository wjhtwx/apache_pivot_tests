package spinner_java;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class spinner_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(spinner_java.class, args);
		}
		catch(Throwable err)
		{
		}
	}
	@Override
	public void startup(Display display, Map<String, String>properties)
	{
		window=new Window();
		window.setPreferredSize(200, 100);
		display.setPreferredSize(200, 100);
		BoxPane panel=new BoxPane();
		Spinner spinner1=new Spinner();
		List<Integer> l=new ArrayList<Integer>();
		for(int doing=0;doing<100;doing++)
		{
			l.add(doing+1);
		}
		spinner1.setSpinnerData(l);
		spinner1.setPreferredHeight(50);
		spinner1.setPreferredWidth(100);
		panel.add(spinner1);
		PushButton button1=new PushButton();
		button1.setButtonData("get spinner");
		button1.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				System.out.println(spinner1.getSelectedIndex());
				System.out.println(spinner1.getSelectedItem());
				System.out.println();
			}
				});
		panel.add(button1);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("Spinners");
		//window.setMaximized(true);
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