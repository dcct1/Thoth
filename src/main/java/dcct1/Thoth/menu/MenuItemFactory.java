package dcct1.Thoth.menu;

import	org.apache.logging.log4j.LogManager;
import	org.apache.logging.log4j.Logger;
import	dcct1.Thoth.App;
import	dcct1.Thoth.music.MusicViewMenuItem;
import	dcct1.Thoth.playlist.PlaylistViewMenuItem;
import	dcct1.Thoth.user.UserViewMenuItem;
/*
	*	This	class	could	be	used	instead	of	the	generic	Factory	class
	*/
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
								
		//	for	each	menu	item	take	a	copy	of	an	if	line	above	change	the	class	it	is	looking	f						//	and	the	class	to	use
		
								//	this	catches	deliberetly	undefined	menu	items	and	errors
								
		if	("dcct1.Thoth.playlist.UndefinedMenuItem".equals(className))	{
		
			return	(IExecuatable)	new UndefinedMenuItem();
			
		}
		
		else
					
		
		{
		
			LOG.error("Undefined	class	requested"	+	className);
							
			
			return	(IExecuatable)	new UndefinedMenuItem();
							
			
		}
								
		
	}
}