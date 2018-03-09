package dcct1.Thoth.data;
	/**
		 * Date March 2018
		 * Author DCCT1
		 * Lab code copied in here
		 */

import	java.sql.Connection;
import	java.sql.SQLException;
public interface IDataManager
	{

		public	Connection	getConnectionObject() throws	SQLException;
		public void disconnect() throws	SQLException;
	}
