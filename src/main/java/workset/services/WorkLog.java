/**
 * %W% %E% Gleb Vasilchenko
 * 15.2.2015 
 * Class for class a working with log-file
 *
 */

package workset.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import org.apache.log4j.Logger;


/**
 * @author GreenCMETAHA
 * @version 1.0,  15 Feb 2015
 * @author Gleb Vasilchenko
 * Class for working with log-file
 *
 */
public class WorkLog implements Serializable{

	/* variable for working log4j*/
	private static Logger log = Logger.getLogger(WorkLog.class);

	/* variable for working with class. Pattern Singleton*/
	private static WorkLog session;

	/* constructor */	
	private WorkLog(){
		
	}

	/* Method for realization of pattern Singleton */
	public static void writeInLog(String errorString){
		if(session == null)
			session = new WorkLog();
		
		if (session!=null){
			log.error(errorString);
			/*
			File file=new File("/LogFile.txt"); //c:   	// check existance of a file
			if (!file.exists())
			try {
				file.createNewFile();			// create of the file
			} catch (IOException e1) {
				System.out.println("Can't create a file LogFile.txt");
				e1.printStackTrace();
			}
			
			FileWriter writeFile = null;	
			try {
				//synchronized (this){//writeFile) {
					writeFile = new FileWriter(file, true); // wrote in the file
					writeFile.write(errorString+"\n");
					writeFile.close();
				//}
			} catch (IOException e) {
				//System.out.println("Can't open a file LogFile.txt");
				//e.printStackTrace();
			}
			*/
		}
	}
}
