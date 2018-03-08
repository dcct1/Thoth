package dcct1.Thoth.music;
/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	java.sql.Connection;
import	java.sql.DriverManager;
import	java.sql.ResultSet;
import	java.sql.SQLException;
import	java.sql.Statement;
import	java.util.ArrayList;
import	org.apache.logging.log4j.LogManager;
import	org.apache.logging.log4j.Logger;
import	dcct1.Thoth.data.IDataManager;


public class MusicDAO implements IMusicDAO
	{


		private	IDataManager	dataManager;

				//	This	is	added	to	every	class	that	needs	to	log	with	one	change
				//	The	getLogger(	)	part	should	contain	the	name	of	the	class	its	in
				//	So	you	know	the	messages	that	came	from	objects	of	this	class
		private final	Logger	LOG	=	LogManager.getLogger(MusicDAO.class);

		public MusicDAO(	IDataManager	dataManager	)

			{


			this.dataManager	=	dataManager;

			}



		public	ArrayList<Music>	getAllMusic(){


			ArrayList<Music>	musicList	=	new	ArrayList<Music>();


			Connection	connection	=	null;

		try

			{

				connection	=	this.dataManager.getConnectionObject();

				Statement	statement	=	connection.createStatement();
				statement.setQueryTimeout(30);		

				ResultSet resultSet = statement.executeQuery("select * from music");



		while(resultSet.next())
			{
			Music music = new Music
			(
			resultSet.getInt("songID"),
			resultSet.getString("songName"),
			resultSet.getString("artist"),
			resultSet.getInt("yearPublished"),
			resultSet.getString("link"),
			resultSet.getInt("playlistID"),
			resultSet.getString("songMessage")

			);


					musicList.add(music);


					LOG.debug(	"Music	object	:	"	+ music);
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

				return	musicList;
				}

				public Music	getMusic(int	userID) {
								throw new	UnsupportedOperationException();
				}

				public int addMusic(	Music	aMusic) {
								throw new	UnsupportedOperationException();
				}

				public void updateMusic(	Music	aMusic) {
								throw new	UnsupportedOperationException();
				}

				public void deleteMusic(	Music	aMusic) {
								throw new	UnsupportedOperationException();
				}

				public String	printMusic(	int	MusicID) {
								throw new	UnsupportedOperationException();
				}
}
