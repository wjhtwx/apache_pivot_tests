package text;

import org.apache.pivot.wtk.*;
import org.apache.pivot.collections.*;

public class suggestion_popup implements Application
{
	private Window window=null;
	private SuggestionPopup suggestionpopup=new SuggestionPopup();
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(suggestion_popup.class, args);
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
		ArrayList<String>suggestions=new ArrayList<String>();
		suggestions.setComparator(String.CASE_INSENSITIVE_ORDER);
		suggestions.add("hello");
		suggestions.add("hi");
		TextInput textinput1=new TextInput();
		textinput1.setText("hello");
		textinput1.getTextInputContentListeners().add(new TextInputContentListener.Adapter()
				{
			@Override
			public void textInserted(TextInput textinput, int index, int count)
			{
				String text=textinput.getText();
				ArrayList<String>arr=new ArrayList<String>();
				for(String str:suggestions)
				{
					if(str.toUpperCase().startsWith(text.toUpperCase()))
					{
						arr.add(str);
					}
				}
				if(arr.getLength()>0)
				{
					suggestionpopup.setSuggestionData(arr);
					suggestionpopup.open(textinput);
				}
			}
			@Override
			public void textRemoved(TextInput arg0, int arg1, int arg2)
			{
				suggestionpopup.close();
			}
				});
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