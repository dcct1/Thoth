package dcct1.Thoth.playlist;

import java.util.ArrayList;

	

public interface IPlaylistDAO {
	
		
		public	ArrayList<Playlist>	getAllPlaylists();
		public	Playlist	getplaylistID(int	playlistID);
		public int addplaylistID(	Playlist	aPlaylist);
		public void updateplaylistID(	Playlist	aPlaylist);
		public void deleteplaylistiD(	Playlist	aPlaylist);
		public	String	printPlaylistID(	int	playlistID);


}
