package dcct1.Thoth.playlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dcct1.Thoth.data.IDataManager;
import dcct1.Thoth.playlist.Playlist;
import dcct1.Thoth.playlist.PlaylistDAO;

public class PlaylistDAO implements IPlaylistDAO{
	private	IDataManager	dataManager;
	
	//	This	is	added	to	every	class	that	needs	to	log	with	one	change
	//	The	getLogger(	)	part	should	contain	the	name	of	the	class	its	in
	//	So	you	know	the	messages	that	came	from	objects	of	this	class
private final	Logger	LOG	=	LogManager.getLogger(PlaylistDAO.class);
	
	public PlaylistDAO(	IDataManager	dataManager	)
	{
					
		this.dataManager	=	dataManager;
	}
	
	
	public	ArrayList<Playlist>	getAllPlaylists(){
					
		ArrayList<Playlist>	playList	=	new	ArrayList<Playlist>();
					
					
		Connection	connection	=	null;
					
		try
		{
	 		connection	=	this.dataManager.getConnectionObject();
						 	 	 								
			Statement	statement	=	connection.createStatement();
			statement.setQueryTimeout(30);		//	set	timeout	to	30	sec.
							
			ResultSet resultSet = statement.executeQuery("select * from user-music");
							
							
							
		while(resultSet.next())
		{
			Playlist playlist = new	Playlist(
						 	resultSet.getInt("playlistID"),
				 	 		resultSet.getInt("userID"),
				 	 		resultSet.getString("playlistMessage")
						 
				 	 	
						 );
											

			playList.add(playlist);
											
											
		LOG.debug(	"	playlist:	"	+	playlist);
			}
						 		
		}
		catch(SQLException	e)
		{
			LOG.error(e.getMessage());
		}	
	
		
		finally
		{
			
			
		try
		{
		
			if(connection	!=	null)
			this.dataManager.disconnect();
		}
							
		catch(SQLException	e)
			{
								
			LOG.error(e.getMessage());
			}
		
		}
					
	return	playList;
	}
	
	public Playlist	getPlaylist(int	playlistID) {
					throw new	UnsupportedOperationException();
	}
	
	
	public int addPlaylist(	Playlist	aPlaylist) {
					throw new	UnsupportedOperationException();
	}
	
	
	public void updatePlaylist(	Playlist	aPlaylist) {
					throw new	UnsupportedOperationException();
	}
	
	public void deletePlaylist(	Playlist	aPlaylist) {
					throw new	UnsupportedOperationException();
	}
	
	public String	printPlaylist(	int	playlistID) {
					throw new	UnsupportedOperationException();
	}


	public ArrayList<Playlist> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	public Playlist getplaylistID(int playlistID) {
		// TODO Auto-generated method stub
		return null;
	}


	public int addplaylistID(Playlist aPlaylist) {
		// TODO Auto-generated method stub
		return 0;
	}


	public void updateplaylistID(Playlist aPlaylist) {
		// TODO Auto-generated method stub
		
	}


	public void deleteplaylistiD(Playlist aPlaylist) {
		// TODO Auto-generated method stub
		
	}


	public String printPlaylistID(int playlistID) {
		// TODO Auto-generated method stub
		return null;
	}

}
