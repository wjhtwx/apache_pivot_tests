package buttons;

import org.apache.pivot.wtk.*;
import java.io.IOException;
import org.apache.pivot.beans.*;
import org.apache.pivot.collections.*;
import org.apache.pivot.serialization.SerializationException;

public class push_button_test implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		DesktopApplicationContext.main(push_button_test.class, args);
	}
	@Override
	public void startup(Display display, Map<String, String>properties) throws IOException, SerializationException
	{
		BXMLSerializer bxmlSerializer=new BXMLSerializer();
		window=(Window)bxmlSerializer.readObject(push_button_test.class, "push_button.bxml");
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