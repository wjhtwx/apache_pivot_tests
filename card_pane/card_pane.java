package card_pane;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.skin.CardPaneSkin;
import org.apache.pivot.collections.*;

public class card_pane implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(card_pane.class, args);
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
		CardPane card_pane1=new CardPane();
		card_pane1.add(new Label("hello"));
		card_pane1.add(new RadioButton("hi"));
		card_pane1.add(new TextInput());
		card_pane1.getStyles().put("backgroundColor", "#E0E0E0");
		card_pane1.getStyles().put("padding", 10);
		card_pane1.setSelectedIndex(0);
		PushButton button1=new PushButton();
		button1.setButtonData("next");
		button1.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				card_pane1.getStyles().put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.HORIZONTAL_SLIDE);
				card_pane1.setSelectedIndex(card_pane1.getSelectedIndex()+1);
			}
				});
		PushButton button2=new PushButton();
		button2.setButtonData("back");
		button2.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				card_pane1.getStyles().put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.HORIZONTAL_FLIP);
				card_pane1.setSelectedIndex(card_pane1.getSelectedIndex()-1);
			}
				});
		panel.add(button2);
		panel.add(card_pane1);
		panel.add(button1);
		panel.getStyles().put("padding", 10);
		window.setContent(panel);
		window.setTitle("CardPanes");
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