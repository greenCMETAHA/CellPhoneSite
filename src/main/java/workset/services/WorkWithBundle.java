/**
 * %W% %E% Gleb Vasilchenko
 * 15.2.2015 
 * Class for working with a file with properties: connection to our database and sql-queries
 *
 */
package workset.services;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author GreenCMETAHA
 * @version 1.0,  15 Feb 2015
 * @author Gleb Vasilchenko
 * Class for working a file with properties: connection to our database and sql-queries
 *
 */
public class WorkWithBundle implements Serializable{

	/* variable for working with class. Pattern Singleton*/
	private static WorkWithBundle logUnit;

	/* constructor */
	private WorkWithBundle(){}


	/* get data from the file with properties */
	public static String getBundle(String strCommand){
		if(logUnit == null)
			logUnit = new WorkWithBundle();
			
		if (logUnit==null) //ooops...
			WorkLog.writeInLog("Can't create a connection with WorkWithBundle");
		
		String result="<?>";
		//Locale loc=Locale.getDefault();
		Locale loc = Locale.US;
		
		//File file=new File("/MessageBundle.properties"); 
		//if (!file.exists()) WorkLog.writeInLog("Don't find file MessageBundle");
		//else {
			ResourceBundle resBundle = ResourceBundle.getBundle("MessageBundle",loc);
			result=resBundle.getString(strCommand);
			if (result.length()==0) {
				WorkLog.writeInLog("Don't find file property  " + strCommand + "   in MessageBundle");
			}
		//}
		
		return result;
	}	

}
