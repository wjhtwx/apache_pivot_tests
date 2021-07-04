package text;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class text_java implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(text_java.class, args);
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
		TextInput textinput1=new TextInput();
		textinput1.setText("hello");
		panel.add(textinput1);
		
		PushButton button1=new PushButton();
		button1.setButtonData("getIndex0");
		button1.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				Alert.alert(Character.toString(textinput1.getCharacterAt(0)), window);
			}
				});
		panel.add(button1);
		PushButton button2=new PushButton();
		button2.setButtonData("getCharacterNumber");
		button2.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				Alert.alert(Integer.toString(textinput1.getCharacterCount()), window);
			}
				});
		panel.add(button2);
		PushButton button3=new PushButton();
		button3.setButtonData("Information");
		button3.getButtonPressListeners().add(new ButtonPressListener()
				{
			@Override
			public void buttonPressed(Button button)
			{
				textinput1.setSelection(1, 4);
				System.out.println(textinput1.getMaximumLength());
				System.out.println(textinput1.getPrompt());
				System.out.println(textinput1.getSelectedText());
				System.out.println(textinput1.getSelectionLength());
				System.out.println(textinput1.getSelectionStart());
				System.out.println(textinput1.getSelection());
				System.out.println(textinput1.getText());
				System.out.println(textinput1.getText(0, 5));
				System.out.println(textinput1.isEditable());
				System.out.println(textinput1.isPassword());
				textinput1.clearSelection();
				textinput1.setPassword(true);
			}
				});
		panel.add(button3);
		
		window.setContent(panel);
		window.setTitle("TextInput");
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