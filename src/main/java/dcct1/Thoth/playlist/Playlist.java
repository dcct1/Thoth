package dcct1.Thoth.playlist;

public class Playlist {
	
		private int playlistID;
		private int userID;
		private String playlistMessage;
		
		
		@Override
		public String toString() {

			return String.format(" Song \n[Playlist Number: %s \nUser ID: %s \nMessage this playlist gives: %s \n]\n", playlistID, userID,

					playlistMessage);
		}


		public int getPlaylistID() {
			return playlistID;
		}


		public void setPlaylistID(int playlistID) {
			this.playlistID = playlistID;
		}


		public int userID() {
			return userID;
		}


		public void setuserID(int userID) {
			this.userID = userID;
		}


		public String getPlaylistMessage() {
			return playlistMessage;
		}


		public void setPlaylistMessage(String playlistMessage) {
			this.playlistMessage = playlistMessage;
		}


		public Playlist(int playlistID, int userID, String playlistMessage) {
			this.playlistID = playlistID;
			this.userID = userID;
			this.playlistMessage = playlistMessage;
		}


		public void display() {
			System.out.println(this.toString());
			
		}

}
