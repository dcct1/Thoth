package dcct1.Thoth.music;
/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */
import	dcct1.Thoth.data.DataManagerSQLite;
import	dcct1.Thoth.menu.IExecuatable;
 
public class MusicViewMenuItem implements IExecuatable 
	{
				
	public	MusicViewMenuItem(){}
				
	public	void	execute()
	{
		//System.out.println("I	ran:	"	+	UserViewMenuItem.class.getName());
								
		//Get	the	User	data
		MusicDAO	model	=	new MusicDAO(	DataManagerSQLite.getInstance()	);
		
		MusicConsoleListView	view	=	new MusicConsoleListView();
		
		MusicController	controller	=	new MusicController(	view,	model);
		
		controller.display();
								
	}
				
}
                     