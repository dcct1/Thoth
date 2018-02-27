package dcct1.Thoth.menu;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Feb 2018
 *  @author Declan
 *	ref CCT Softwrae Dev lab 06 code 
 */

public class MenuBuilder {

	
	Menu aMenu;
	
	//constructors
	
	public MenuBuilder() {
		
		buildMenu();
		
	}
	
	private void buildMenu() 
	{
		
		// the menu
		
		this.aMenu = new Menu ("Music and life","|Appreciate the music of others through their life exoierence ");
	
		MenuHeading playHeading = new MenuHeading (1,"Review", "Music and life playlist review");
		
		MenuHeading maintainHeading = new MenuHeading (2, "Maintenance", "add users, playlists and music");
		
		MenuHeading adminHeading = new MenuHeading (3, "Administration", "Music and Life program administration options");
		
		aMenu.add(playHeading);
		aMenu.add(maintainHeading);
		aMenu.add(adminHeading);
		
		
		playHeading.add(new MenuItem(1, "List Playlists", "List the playlists available in the system", "dcct1.thoth.playlist.PlayListViewMenuItem"));
	
		playHeading.add(new MenuItem(2, "List music", "List the music available in the system", "dcct1.thoth.music.MusicViewMenuItem"));
		
		playHeading.add(new MenuItem(3, "List Users", "List the users available in the system", "dcct1.thoth.User.ViewMenuItem"));
		
		maintainHeading.add(new MenuItem(1, "Add Music", "Add music", "dcct1.thoth.menu.UndefinedMenuItem"));
		
		maintainHeading.add(new MenuItem(2, "Add Music", "Add music", "dcct1.thoth.menu.UndefinedMenuItem"));

		maintainHeading.add(new MenuItem(3, "Add Music", "Add music", "dcct1.thoth.menu.UndefinedMenuItem"));

		maintainHeading.add(new MenuItem(4, "Edit Music", "Edit music", "dcct1.thoth.menu.UndefinedMenuItem"));

		maintainHeading.add(new MenuItem(5, "Edit Playlist", "Edit playlist", "dcct1.thoth.menu.UndefinedMenuItem"));

		adminHeading.add(	new	MenuItem(1,"Remove	a	User","Remove	a	user","dcct1.thoth.menu.UndefinedMenuItem"));
		
		adminHeading.add(	new	MenuItem(2,"Remove	Music","Remove music","dcct1.thoth.menu.UndefinedMenuItem"));

		adminHeading.add(	new	MenuItem(3,"Remove	a	Playlist","Remove	a playing","dcct1.thoth.menu.UndefinedMenuItem"));

	}
	
	public Menu getMenu()
	{
		return this.aMenu;
	}
	
	public void print()
	{
		this.aMenu.print();
	}
	
	public String display() {
	
	return this.aMenu.toString();
	}
	
	
	}