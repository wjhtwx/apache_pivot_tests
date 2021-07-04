package hello_world_bxml;

import org.apache.pivot.wtk.*;
import java.io.IOException;
import org.apache.pivot.beans.*;
import org.apache.pivot.collections.*;
import org.apache.pivot.serialization.SerializationException;

public class hello_world_bxml implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		DesktopApplicationContext.main(hello_world_bxml.class, args);
	}
	@Override
	public void startup(Display display, Map<String, String>properties) throws IOException, SerializationException
	{
		BXMLSerializer bxmlSerializer=new BXMLSerializer();
		window=(Window)bxmlSerializer.readObject(hello_world_bxml.class, "hello_world.bxml");
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