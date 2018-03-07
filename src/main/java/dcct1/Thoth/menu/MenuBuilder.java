package dcct1.Thoth.menu;

import	java.util.ArrayList;
import	java.util.Iterator;
/*****************************************************************
*
*	 Date:	2018
*	 @author Declan

*****************************************************************/
public	class MenuBuilder {
				Menu	aMenu;
				
				public	MenuBuilder()	
				{
					buildMenu();
								
				}
				
				
				private	void	buildMenu()
				{			
								
					this.aMenu	=	new	Menu(	"Music	and	Life",	"	Appreciate	the	music	of	others	through	their	life	experiences");
								
								
								
					MenuHeading	playHeading	= new	MenuHeading	(1,"Review","Music	and	Life	playlist	review");
								
								
					MenuHeading	maintainHeading	= new	MenuHeading	(2,"Maintenance","Add	users,	playlists	and	music");	 	
												
								
					MenuHeading	adminHeading = new	MenuHeading	(3,"Admin","Music	and	Life	program	administration	options");
								
								
					aMenu.add(playHeading);
					
					aMenu.add(maintainHeading);
					
					aMenu.add(adminHeading);
								
								
					//	play	menu
								
								
					playHeading.add(new	MenuItem(1, "List	Playlists",
							"List	the	playlists	available	in	the	system",
							"dcct1.Thoth.playlist.PlaylistViewMenuItem"));
								
					
					playHeading.add(new	MenuItem
										(	
										2,
										"List	Music ",
										"List	the	music	available	in	the	system",
										"dcct1.Thoth.music.MusicViewMenuItem"
										));
								
					playHeading.add(	new	MenuItem(	
																
										3,
										"List	Users",
										"List	the	users	in	the	system",
										"dcct1.Thoth.user.UserViewMenuItem"
										));	
								
								
								
								maintainHeading.add(new	MenuItem(	
											1,
											"Add	User",
											"Add	a	user",
											"dcct1.Thoth.user.UserViewMenuItem"
											));	 	
								
								maintainHeading.add(new	MenuItem(	
												2,
												"Add	Music",
												"Add	music",
												"dcct1.Thoth.music.MusicViewMenuItem"
												));	 	 	
								maintainHeading.add(new	MenuItem(	
												3,
												"Add	Playlist",
												"Add	a	playlist",
												"dcct1.Thoth.playlistPlaylistViewMenuItem"
												));	
								
								maintainHeading.add(new	MenuItem(	
												4,
												"Edit	Music",
												"Edit	music",
												"dcct1.Thoth.music.MusicViewMenuItem"
												));	
								
								maintainHeading.add(new	MenuItem(	
												5,
												"Edit	Playlist",
												"Edit	a	playlist",
												"dcct1.Thoth.playlist.PlaylistViewMenuItem"
												));
								
								
								adminHeading.add(new MenuItem(	
												1,
												"Remove	a	User",
												"Remove	a	user",
												"dcct1.Thoth.user.UserViewMenuItem"
												));
								
								adminHeading.add(new MenuItem(	
											2,
											"Remove	Music",
											"Remove	music",
											"dcct1.Thoth.music.MusicViewMenuItem"
											));
								
								adminHeading.add(	new	MenuItem(	
											3,
											"Remove	a	Playlist",
											"Remove	a	playlist",
											"dcct1.Thoth.playlist.PlaylistViewMenuItem"
											));
				}
				
				public	Menu	getMenu()
				{
								return this.aMenu;
				}
				
				public	void print()
				{
								this.aMenu.print();
				}
				
				public	String	display()
				{
								return this.aMenu.toString();
				}
}