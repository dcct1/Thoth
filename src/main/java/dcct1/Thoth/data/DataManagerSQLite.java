package dcct1.Thoth.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dcct1.Thoth.user.UserDAO;


public class DataManagerSQLite implements IDataManager {

	private final	Logger	LOG	=	LogManager.getLogger(DataManagerSQLite.class);
	private static	DataManagerSQLite	oneInstance	=	new	DataManagerSQLite();
	private	String	databaseFile	=	null;
	private	Connection	connection	=	null;
	
	
	
	private DataManagerSQLite() {}	
	
	public static	DataManagerSQLite	getInstance() {
					return	oneInstance;
	}
	
	
	
	public void setDataFile(String	databaseFile) {
					this.databaseFile	=	databaseFile;
	}
	
	//@Override
	public	Connection	getConnectionObject() 
			throws	SQLException	
	{
					
	if	(this.databaseFile	!=	null)	
	{
	this.connection	=	DriverManager.getConnection(this.databaseFile);
		LOG.debug("Database	connection	established");
				
	}
		else	
		{
			connection	=	null;
		}	
					
			return	connection;
	}
	
	//@Override
	public void disconnect() throws	SQLException	
	{
		connection.close();
		LOG.debug("Database	connection	established");
	}
	
}