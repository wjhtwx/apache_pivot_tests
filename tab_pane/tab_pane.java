package tab_pane;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class tab_pane implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(tab_pane.class, args);
		}
		catch(Throwable err)
		{
		}
	}
	@Override
	public void startup(Display display, Map<String, String>properties)
	{
		window=new Window();
		TabPane s=new TabPane();
		BoxPane panel=new BoxPane();
		PushButton button1=new PushButton("hello");
		BoxPane panel1=new BoxPane();
		panel1.add(new Label("hello"));
		panel1.add(new Label("hi"));
		panel1.add(new PushButton("hello"));
		s.getTabs().add(button1);
		s.getTabs().add(panel1);
		ArrayList<PushButton>buttons=new ArrayList<PushButton>();
		PushButton button2=new PushButton("New Tab");
		button2.getButtonPressListeners().add(new ButtonPressListener(){
			@Override
			public void buttonPressed(Button button)
			{
				buttons.add(new PushButton("hello"));
				s.getTabs().add(buttons.get(buttons.getLength()-1));
				TabPane.setTabData(buttons.get(buttons.getLength()-1), "hello");
			}
		});
		s.setCorner(button2);
		TabPane.setTabData(button1, "hello");
		TabPane.setTabData(panel1, "hello, panel");
		s.getComponentMouseListeners().add(new ComponentMouseListener()
				{

					@Override
					public boolean mouseMove(Component arg0, int arg1, int arg2) {
						panel.repaint();
						s.repaint();
						return false;
					}

					@Override
					public void mouseOut(Component arg0) {
						panel.repaint();
						s.repaint();
					}

					@Override
					public void mouseOver(Component arg0) {
						panel.repaint();
						s.repaint();
					}
			
				});
		panel.add(s);
		window.setContent(panel);
		window.setTitle("TabPane");
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