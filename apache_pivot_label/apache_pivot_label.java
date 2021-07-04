package apache_pivot_label;

import org.apache.pivot.wtk.*;
import java.io.IOException;
import org.apache.pivot.beans.*;
import org.apache.pivot.collections.*;
import org.apache.pivot.serialization.SerializationException;

public class apache_pivot_label implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		DesktopApplicationContext.main(apache_pivot_label.class, args);
	}
	@Override
	public void startup(Display display, Map<String, String>properties) throws IOException, SerializationException
	{
		BXMLSerializer bxmlSerializer=new BXMLSerializer();
		window=(Window)bxmlSerializer.readObject(apache_pivot_label.class, "label.bxml");
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