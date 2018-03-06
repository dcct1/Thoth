package dcct1.Thoth.music;

import	java.util.ArrayList;

import dcct1.Thoth.user.User;


public interface IMusicDAO 
{
			
			public	ArrayList<User>	getAllUsers();
			public	User	getUser(int	userID);
			public int addUser(	User	aUser);
			public void updateUser(	User	aUser);
			public void deleteUser(	User	aUser);
			public	String	printUser(	int	userID);
}