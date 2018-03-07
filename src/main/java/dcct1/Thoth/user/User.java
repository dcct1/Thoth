package dcct1.Thoth.user;

public class User {
	
		/**
		 * Date March 2018
		 * Author Declan kenny
		 */
	
		private int userID;
		private String userName;
		private String userEmail;
		private String userRole;
		private String userToken;
		private int userStatus;
		private String userLastUpdate;
		public User(int userID, String userName, String userEmail, String userRole, String userToken, int userStatus,
				
				
			String userLastUpdate) {
			this.userID = userID;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userRole = userRole;
			this.userToken = userToken;
			this.userStatus = userStatus;
			this.userLastUpdate = userLastUpdate;
		}
		@Override
		public String toString() {
			return String.format(
					"User [userID=%s, userName=%s,  userEmail=%s,  userRole=%s, userToken=%s, userStatus=%s, userLastUpdate=%s \n]",
					userID, userName, userEmail, userRole, userToken, userStatus, userLastUpdate);
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserRole() {
			return userRole;
		}
		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		public String getUserToken() {
			return userToken;
		}
		public void setUserToken(String userToken) {
			this.userToken = userToken;
		}
		public int getUserStatus() {
			return userStatus;
		}
		public void setUserStatus(int userStatus) {
			this.userStatus = userStatus;
		}
		public String getUserLastUpdate() {
			return userLastUpdate;
		}
		public void setUserLastUpdate(String userLastUpdate) {
			this.userLastUpdate = userLastUpdate;
		}
		public void display() {
			System.out.println(this.toString());
			
		}
		
}
