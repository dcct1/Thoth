package dcct1.Thoth.playlist;

import java.util.Scanner;

import dcct1.Thoth.data.DataManagerSQLite;
import dcct1.Thoth.menu.IExecuatable;
/*
import dcct1.Thoth.menu.ConsoleControls;
import dcct1.Thoth.playlist.PlaylistConsoleListView;
import dcct1.Thoth.playlist.PlaylistController;
import dcct1.Thoth.playlist.PlaylistDAO;
*/
public class PlaylistViewMenuItem implements IExecuatable {

	public	PlaylistViewMenuItem(){}
	
	public	void	execute()
	{
		//System.out.println("I	ran:	"	+	UserViewMenuItem.class.getName());
								
		//Get	the	User	data
		PlaylistDAO	model	=	new PlaylistDAO(	DataManagerSQLite.getInstance()	);
		
		PlaylistConsoleListView	view	=	new PlaylistConsoleListView();
		
		PlaylistController	controller	=	new PlaylistController(	view,	model);
		
		controller.display();
								
	}
}

