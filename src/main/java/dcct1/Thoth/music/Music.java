package dcct1.Thoth.music;

public class Music {

		/**
		 * Date March 2018
		 * Author DCCT1
		 * Lab code copied in here
		 */

	private int	songID;
	private String songName;
	private String artist;
	private int yearPublished;
	private String link;
	
	
	public Music(int songID, String songName, String artist, int yearPublished, String link, int playlistID,
			String songMessage)
	{
		this.songID = songID;
		this.songName = songName;
		this.artist = artist;
		this.yearPublished = yearPublished;
		this.link = link;
		this.playlistID = playlistID;
		this.songMessage = songMessage;
	}

	@Override
	public String toString() {
		return String.format(

				"Music \n [Song ID:  %s \n Title of the Song: %s \n Artist Name: %s \n Year Song was Published:  %s \n Link To The Song:  %s \n Playlist Number: %s \n Message of this Song: %s \n]\n",

				songID, songName, artist, yearPublished, link, playlistID, songMessage);
	}

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getPlaylistID() {
		return playlistID;
	}

	public void setPlaylistID(int playlistID) {
		this.playlistID = playlistID;
	}

	public String getSongMessage() {
		return songMessage;
	}

	public void setSongMessage(String songMessage) {
		this.songMessage = songMessage;
	}

	private int playlistID;
	private String songMessage;

		public void display() {
			System.out.println(this.toString());

		}

}