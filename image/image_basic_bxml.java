package image;

import org.apache.pivot.wtk.*;
import org.apache.pivot.beans.*;
import org.apache.pivot.collections.*;

public class image_basic_bxml implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		DesktopApplicationContext.main(image_basic_bxml.class, args);
	}
	@Override
	public void startup(Display display, Map<String, String>properties) throws Exception
	{
		BXMLSerializer bxmlSerializer=new BXMLSerializer();
		window=(Window)bxmlSerializer.readObject(image_basic_bxml.class, "image.bxml");
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