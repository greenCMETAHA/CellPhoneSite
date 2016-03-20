package workset.dao.connector;

/**
 * %W% %E% Gleb Vasilchenko
 * 15.2.2015
 * Interface for class DAO for our database
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import workset.services.*;


public class ConnectorToDB {
	private static ConnectorToDB thisClass;
	private static Connection connectToDB;

	/* variable for gettig text constants */
	private static ConstantsGroup Constants;
	
	private ConnectorToDB() {
		Constants = ConstantsGroup.start();
	}
	
	private static Connection CreateConnection(){
		Connection connectToDB=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException clE) {
			WorkLog.writeInLog("Error loading driver: " + clE);
			clE.printStackTrace();
		}
		
		String host=WorkWithBundle.getBundle(Constants.HOST);
		String database=WorkWithBundle.getBundle(Constants.DB);
		String user=WorkWithBundle.getBundle(Constants.USER);
		String password=WorkWithBundle.getBundle(Constants.PASSWORD);

		try {
			String str="jdbc:mysql://"+host+"/"+database+"?useUnicode=true&characterEncoding=utf-8";
			connectToDB = DriverManager.getConnection(str,user, password);
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pltSystem?useUnicode=true&characterEncoding=utf-8","root", "");
			
		} catch (SQLException e) {
			WorkLog.writeInLog("Wrong connect to the database: " + e.getMessage());
			e.printStackTrace();
		}
		return connectToDB;				
	}
	
	public static Connection Start(){
		if(thisClass == null){
			thisClass = new ConnectorToDB();
			connectToDB=thisClass.CreateConnection();
		}	
		if (thisClass==null) //ooops...
			WorkLog.writeInLog("Error: can't create a connection with DB, ConnectorToDB, Start()");
		
		return connectToDB;				
		
	}
	
	public void finalize(){
		try {
			connectToDB.close();
		} catch (SQLException e) {
			WorkLog.writeInLog("Can't close the connection to database: " + e.getMessage());
			e.printStackTrace();
		}		
		
	}	

}
