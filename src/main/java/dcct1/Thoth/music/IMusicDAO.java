package dcct1.Thoth.music;

import	java.util.ArrayList;
public interface IMusicDAO
	{

				public	ArrayList<Music>getAllMusic();
				public	Music	getMusic(int	musicID);
				public int addMusic(Music	aMusic);
				public void updateMusic(	Music	aMusic);
				public void deleteMusic(	Music	aMusic);
				public	String	printMusic(	int	userID);
}