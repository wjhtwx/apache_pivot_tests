package buttons;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;
import org.apache.pivot.collections.*;

public class visible_button implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(visible_button.class, args);
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
		activityindicator.getActivityIndicatorListeners().add(new ActivityIndicatorListener()
				{
					@Override
					public void activeChanged(ActivityIndicator activityindicator) {
						System.out.println(activityindicator.isActive());
					}
				});
		panel.add(activityindicator);
		PushButton button=new PushButton();
		button.setPreferredSize(150, 100);
		button.setVisible(false);
		button.setButtonData("setActive(true/false)");
		button.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				if(activityindicator.isActive())
				{
					activityindicator.setActive(false);
				}
				else
				{
					activityindicator.setActive(true);
				}
			}
				});
		panel.add(button);
		window.setContent(s);
		window.setTitle("ActivityIndicators");
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