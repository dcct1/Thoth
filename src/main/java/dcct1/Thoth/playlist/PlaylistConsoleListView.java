package dcct1.Thoth.playlist;
/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import java.util.ArrayList;
import	java.util.Iterator;


import	dcct1.Thoth.menu.ConsoleControls;

public class PlaylistConsoleListView 
{
	ArrayList<Playlist>	playList;
				
	
	public PlaylistConsoleListView() {
	
	}
	
	public void setPlayList(	ArrayList<Playlist>	playList) {
	
		this.playList	=	playList;
		
	}
				
	public void display() 
	{
		System.out.println(	ConsoleControls.ANSI_RED_BRIGHT	+	"...	Playlist	VIEWER	..."	+	ConsoleControls.ANSI_RESET);
		System.out.println("\n");
		Iterator<Playlist>	iterator = this.playList.iterator();
			
		while	(iterator.hasNext())	
		{
			Playlist aPlaylist = (Playlist)iterator.next();
			aPlaylist.display();
		}
				
				
	}

}
