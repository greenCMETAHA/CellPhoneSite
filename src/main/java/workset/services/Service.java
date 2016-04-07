package workset.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;

import workset.beans.entities.User;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;

public class Service {
	public static String PATH_TO_JPG="resources\\jpg\\";
	public static String EMPTY="<empty>";
	public static int ID_EMPTY_CUSTOMER=0;
	public static int LOG_ON_PAGE=20;
	public static int ELEMENTS_ON_PAGE=10;
	
	public static String PHONES_PREFIX="Phn";
	
	public Service(){
		
	}
	
	public static boolean isFileExist(String file){
		File oldFile=new File(file);
		
		return oldFile.exists();	
		
	}
	
	public static String validateString(String value, int size){
		String result = value;
		
		if (value.length()>size) 
			result=value.substring(0, size-1);
		
		return result;
	}
	
	public static synchronized String copyPhoto(String oldPhoto, String globalPath){
		String result="";
		
		if ((!"http".equals(oldPhoto.substring(0,4))) & (!":\\".equals(oldPhoto.substring(1,2)))){ //значит, он уже лежит на серваке
			result=oldPhoto;
		}
		
		File oldFile=new File(oldPhoto);
		File newFile=new File(globalPath+PATH_TO_JPG+oldFile.getName());
		if (newFile.exists()){
			result=newFile.getName();
		}else{
			try {
				newFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			InputStream is = null;
		    OutputStream os = null;
		    try {
		        is = new FileInputStream(oldFile);
		        os = new FileOutputStream(newFile);
		        byte[] buffer = new byte[1024];
		        int length;
		        while ((length = is.read(buffer)) > 0) {
		            os.write(buffer, 0, length);
		        }
		        result=newFile.getName();
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        try {
					is.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		    }
		}

		return result;
	}
	
	public static User getUser(Principal userPrincipal, UserDAO userDAO){
		User result=new User();
		if (userPrincipal!=null){
			result=userDAO.getUser(userPrincipal.getName());		//сделал так чтобы выцепить реальное имя пользователя, а не логин
		}
		
		return result;
	}

}
