package workset.dao.connector;

/**
 * %W% %E% Gleb Vasilchenko
 * 15.2.2015
 * Interface for class DAO for our database
 *
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
//import org..apache.commons.dbcp.*;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import workset.services.*;

public class ConnectionPool implements Serializable{
    private static ConstantsGroup Constants;
    private static ConnectionPool connectionPool;
    private static DataSource dataSource;
    private static Context contextDB;

    private ConnectionPool() {
        dataSource=null;
        contextDB=null;
        Constants = ConstantsGroup.start();

       // String host=WorkWithBundle.getBundle(Constants.HOST);
       // String database=WorkWithBundle.getBundle(Constants.DB);
        //String strDatabase="jdbc:mysql://"+host+"/"+database+"?useUnicode=true&characterEncoding=utf-8";
        String strDatabase=WorkWithBundle.getBundle(Constants.DB_POOL); //java:/comp/env/jdbc/newssite
        try {
            contextDB=new InitialContext();
            dataSource = (DataSource) contextDB.lookup(strDatabase);

            //InitialContext initContext = new InitialContext();
            //DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/dbconnect");

        } catch (NamingException e) {
            WorkLog.writeInLog("Error of connect to database");
            e.printStackTrace();
        }
    }

    public static ConnectionPool start(){
        ConnectionPool result=null;

        if(connectionPool == null){
            connectionPool = new ConnectionPool();
        }
        if (connectionPool==null) //ooops...
            WorkLog.writeInLog("Error of creating a pool connection");

        return result;

    }

    public static Connection getConnection(){
        Connection result=null;

        start();

        try {
            result=dataSource.getConnection();
        } catch (SQLException e) {
            WorkLog.writeInLog("Error of creating a pool connection");
            e.printStackTrace();
        }


        return result;
    }



}
