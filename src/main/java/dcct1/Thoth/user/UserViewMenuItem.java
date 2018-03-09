package dcct1.Thoth.user;

/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	dcct1.Thoth.data.DataManagerSQLite;
import	dcct1.Thoth.menu.IExecuatable;
 
public class UserViewMenuItem implements IExecuatable 
	{
				
	public	UserViewMenuItem(){}
				
	public	void	execute()
	{
		
		UserDAO	model	=	new UserDAO(	DataManagerSQLite.getInstance()	);
		
		UserConsoleListView	view	=	new UserConsoleListView();
		
		UserController	controller	=	new UserController(	view,	model);
		
		controller.display();
								
	}
				
}