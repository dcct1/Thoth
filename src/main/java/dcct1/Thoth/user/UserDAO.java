package dcct1.Thoth.user;

import	java.sql.Connection;
import	java.sql.DriverManager;
import	java.sql.ResultSet;
import	java.sql.SQLException;
import	java.sql.Statement;
import	java.util.ArrayList;
import	org.apache.logging.log4j.LogManager;
import	org.apache.logging.log4j.Logger;
import	dcct1.Thoth.data.IDataManager;


public class UserDAO implements IUserDAO
		{
				
			private	IDataManager	dataManager;
				
				//	This	is	added	to	every	class	that	needs	to	log	with	one	change
				//	The	getLogger(	)	part	should	contain	the	name	of	the	class	its	in
				//	So	you	know	the	messages	that	came	from	objects	of	this	class
			private final	Logger	LOG	=	LogManager.getLogger(UserDAO.class);
				
				public UserDAO(	IDataManager	dataManager	)
				{
								
					this.dataManager	=	dataManager;
				}
				
				
				public	ArrayList<User>	getAllUsers(){
								
					ArrayList<User>	userList	=	new	ArrayList<User>();
								
								
					Connection	connection	=	null;
								
					try
					{
				 		connection	=	this.dataManager.getConnectionObject();
									 	 	 								
						Statement	statement	=	connection.createStatement();
						statement.setQueryTimeout(30);		//	set	timeout	to	30	sec.
										
						ResultSet	resultSet	=	statement.executeQuery("select	*	from User");
										
										
										
					while(resultSet.next())
					{
					User user = new	User(
									 	resultSet.getInt("userID"),
							 	 		resultSet.getString("userName"),
							 	 		resultSet.getString("userEmail"),
									 	resultSet.getString("userRole"),
							 	 		resultSet.getString("userToken"),
						 	 	 		resultSet.getInt("userStatus"),
							 	 		resultSet.getString("userLastUpdate")
									 );
														

					userList.add(user);
														
														
					LOG.debug(	"User	object	:	"	+	user);
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
								
				return	userList;
				}
				
				public User	getUser(int	userID) {
								throw new	UnsupportedOperationException();
				}
				
				public int addUser(	User	aUser) {
								throw new	UnsupportedOperationException();
				}
				
				public void updateUser(	User	aUser) {
								throw new	UnsupportedOperationException();
				}
				
				public void deleteUser(	User	aUser) {
								throw new	UnsupportedOperationException();
				}
				
				public String	printUser(	int	userID) {
								throw new	UnsupportedOperationException();
				}
}