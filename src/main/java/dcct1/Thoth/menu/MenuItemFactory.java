package dcct1.Thoth.menu;
/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	org.apache.logging.log4j.LogManager;
import	org.apache.logging.log4j.Logger;
import	dcct1.Thoth.App;
import	dcct1.Thoth.music.MusicViewMenuItem;
import	dcct1.Thoth.playlist.PlaylistViewMenuItem;
import	dcct1.Thoth.user.UserViewMenuItem;

public class MenuItemFactory
	{
	private static	Logger	LOG;
				
		
	public	MenuItemFactory()	{
	
		LOG	=	LogManager.getLogger(MenuItemFactory.class);
		
	}
	
	public	IExecuatable	getMenuItem(String	className)	{
								
	
		if	("dcct1.Thoth.playlist.PlaylistViewMenuItem".equals(className))	{
	
			return	(IExecuatable)	new PlaylistViewMenuItem();
			
		}
								

		if	("dcct1.Thoth.music.MusicViewMenuItem".equals(className))	{
		
			return	(IExecuatable)	new MusicViewMenuItem();
			
		}
								
					
		if	("dcct1.Thoth.user.UserViewMenuItem".equals(className))	{
		
			return	(IExecuatable)	new UserViewMenuItem();
			
		}
								
	
								
		if	("dcct1.Thoth.playlist.UndefinedMenuItem".equals(className))	{
		
			return	(IExecuatable)	new PlaylistViewMenuItem();
			
		}
		
		else
					
		
		{
		
			LOG.error("Undefined	class	requested"	+	className);
							
			
			return	(IExecuatable)	new UndefinedMenuItem();
							
			
		}
								
		
	}
}