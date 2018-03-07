package dcct1.Thoth.playlist;

import java.util.Scanner;

import dcct1.Thoth.playlist.PlaylistConsoleListView;
import dcct1.Thoth.playlist.PlaylistDAO;

public class PlaylistController {
	
	private	PlaylistConsoleListView	view;
	private	PlaylistDAO	model;
	Scanner	input	=	new	Scanner(System.in);
	
public	PlaylistController(PlaylistConsoleListView	view,	PlaylistDAO	model)
{
this.view	=	view;
this.model	=	model;
}
public	void	display()	
{
					
view.setPlayList(model.getAllUsers());
view.display();
System.out.println(" \nPress enter	return to the main menu");
this.input.nextLine();
					
}

}
