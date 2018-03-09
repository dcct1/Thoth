package dcct1.Thoth.playlist;

/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import java.util.Scanner;

import dcct1.Thoth.data.DataManagerSQLite;
import dcct1.Thoth.menu.IExecuatable;

public class PlaylistViewMenuItem implements IExecuatable {

	public	PlaylistViewMenuItem(){}
	
	public	void	execute()
	{
		
		PlaylistDAO	model	=	new PlaylistDAO(	DataManagerSQLite.getInstance()	);
		
		PlaylistConsoleListView	view	=	new PlaylistConsoleListView();
		
		PlaylistController	controller	=	new PlaylistController(	view,	model);
		
		controller.display();
								
	}
}

