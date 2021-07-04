package tools.multi_files_replace;


import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;

import java.io.*;

import org.apache.pivot.collections.*;

public class multi_files_replace implements Application
{
	private Window window=null;
	private ArrayList<String> files=new ArrayList<String>();
	ListView list=new ListView();
	Label title=new Label();
	PushButton add_button=new PushButton();
	PushButton remove_button=new PushButton();
	Separator separator=new Separator();
	PushButton replace_button=new PushButton();
	TextInput wait_to_replace=new TextInput();
	TextInput replace_to=new TextInput();
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(multi_files_replace.class, args);
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
		
		//title
		title.getStyles().put("font", "Lucida Console 30");
		title.setText("multi files replace");
		panel.add(title);
		
		//add files button
		add_button.setButtonData("add files");
		panel.add(add_button);
		add_button.getButtonPressListeners().add(new ButtonPressListener()
				{
			public void buttonPressed(Button button)
			{
				add_files();
			}
				});
		
		//remove files button
		remove_button.setButtonData("remove all files");
		panel.add(remove_button);
		remove_button.getButtonPressListeners().add(new ButtonPressListener()
		{
	public void buttonPressed(Button button)
	{
		remove_all_files();
	}
		});
		
		//separator
		separator.setPreferredWidth(500);
		panel.add(separator);
		
		panel.add(new Label("all files"));
		
		//show files
		panel.add(list);
		list.setListData(files);
		
		//text
		panel.add(wait_to_replace);
		wait_to_replace.setText("text to be replaced");
		
		//text
		panel.add(replace_to);
		replace_to.setText("replace with");
		
		//replace files button
		replace_button.setButtonData("replace");
		panel.add(replace_button);
		replace_button.getButtonPressListeners().add(new ButtonPressListener()
				{
			public void buttonPressed(Button button)
			{
				replace();
			}
				});
		
		panel.getStyles().put("padding", "10");
		panel.setOrientation(Orientation.VERTICAL);
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
		window.setTitle("Multi Files replace");
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
	
	void refresh_list()
	{
		list.setListData(new ArrayList<String>());
		list.setListData(files);
	}
	
	void add_files()
	{
		FileBrowserSheet browser=new FileBrowserSheet();
		browser.setSelectedFile(new File(browser.getRootDirectory(), "NewFile"));
		browser.setMode(FileBrowserSheet.Mode.OPEN_MULTIPLE);
		browser.open(window, new SheetCloseListener()
				{
			@Override
			public void sheetClosed(Sheet sheet)
			{
				if(sheet.getResult())
				{
					Sequence<File> selectedFiles=browser.getSelectedFiles();
					for(int doing=0;doing<selectedFiles.getLength();doing++)
					{
						files.add(selectedFiles.get(doing).toString());
					}
				}
			}
				});
		refresh_list();
	}
	
	void remove_all_files()
	{
		files=new ArrayList<String>();
		refresh_list();
	}
	
	void replace()
	{
		String wait=wait_to_replace.getText();
		String to=replace_to.getText();
		for(int doing=0;doing<files.getLength();doing++)
		{
			try
			{
				String file="";
				BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(files.get(doing)), "UTF-8"));
				try
				{
					String line=null;
					while((line=reader.readLine())!=null)
					{
						file+=line+"\n";
					}
					file=file.replace(wait, to);
				}
				catch(Exception err)
				{
					Alert.alert("Can not read the file", window);
					continue;
				}
				reader.close();
				BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(files.get(doing))), "UTF-8"));
				writer.write(file);
				writer.close();
			}
			catch(Exception err)
			{
				Alert.alert("Can not open the file: "+files.get(doing), window);
				continue;
			}
		}
		Alert.alert("Alright", window);
	}
}