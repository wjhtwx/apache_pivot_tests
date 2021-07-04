package tree;

import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.content.*;
import org.apache.pivot.collections.*;

public class tree implements Application
{
	private Window window=null;
	public static void main(String [] args)
	{
		try
		{
			DesktopApplicationContext.main(tree.class, args);
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
		TreeBranch treebranch1=new TreeBranch();
		TreeView tree=new TreeView(treebranch1);
		treebranch1.add(new TreeNode("hello"));
		treebranch1.add(new TreeNode("hi"));
		panel.add(tree);
		window.setContent(panel);
		window.setTitle("Trees");
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