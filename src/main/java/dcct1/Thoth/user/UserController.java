package dcct1.Thoth.user;

/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	java.util.Scanner;


public class UserController 
	{
				
				private	UserConsoleListView	view;
				private	UserDAO	model;
				Scanner	input	=	new	Scanner(System.in);
				
			public	UserController(UserConsoleListView	view,	UserDAO	model)
			{
			this.view	=	view;
			this.model	=	model;
			}
			public	void	display()	
			{
								
			view.setUserList(model.getAllUsers());
			view.display();
			System.out.println(" \nPress enter	return to the main menu");
			this.input.nextLine();
								
			}	
	}