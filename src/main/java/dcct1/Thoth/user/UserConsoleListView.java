package dcct1.Thoth.user;

/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	java.util.ArrayList;
import	java.util.Iterator;


import	dcct1.Thoth.menu.ConsoleControls;

public class UserConsoleListView 
	
{
				

	ArrayList<User>	userList;
				
	
	public UserConsoleListView() {
	
	}
	
	public void setUserList(	ArrayList<User>	userList) {
	
		this.userList	=	userList;
		
	}
				
		public void display() 
			{
								
			System.out.println(	ConsoleControls.ANSI_BLUE_BRIGHT	+	"		...	   USER	VIEWER	..."	+	ConsoleControls.ANSI_RESET);
			System.out.println("\n");
			Iterator<User>	iterator = this.userList.iterator();
			
			while	(iterator.hasNext())	{
						
					User aUser = (User)iterator.next();
					aUser.display();
				}
				
				
				}
}
