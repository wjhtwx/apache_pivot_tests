package scroll_pane;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;
import org.apache.pivot.collections.*;

public class scroll_pane implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(scroll_pane.class, args);
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
		BoxPane panel=new BoxPane();
		PushButton button1=new PushButton("hello");
		button1.setPreferredSize(5000, 1000);
		panel.add(button1);
		s.setView(panel);
		s.setHorizontalScrollBarPolicy(ScrollBarPolicy.AUTO);
		s.setVerticalScrollBarPolicy(ScrollBarPolicy.AUTO);
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
		window.setContent(s);
		window.setTitle("Separator");
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