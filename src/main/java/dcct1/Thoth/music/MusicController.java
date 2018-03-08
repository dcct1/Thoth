package dcct1.Thoth.music;
/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	java.util.Scanner;


public class MusicController
	{

				private	MusicConsoleListView	view;
				private	MusicDAO	model;
				Scanner	input	=	new	Scanner(System.in);

			public	MusicController(MusicConsoleListView	view,	MusicDAO	model)
			{
			this.view	=	view;
			this.model	=	model;
			}
			public	void	display()
			{

			view.setMusicList(model.getAllMusic());
			view.display();
			System.out.println(" \nPress enter	return to the main menu");
			this.input.nextLine();

			}
	}