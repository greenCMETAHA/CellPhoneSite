package workset.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.BodyType;
import org.apache.poi.hssf.usermodel.HSSFBorderFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import workset.beans.entities.BatteryType;
import workset.beans.entities.BodyColor;
import workset.beans.entities.BodyStuff;
import workset.beans.entities.Country;
import workset.beans.entities.Log;
import workset.beans.entities.Manufacturer;
import workset.beans.entities.Os;
import workset.beans.entities.Phone;
import workset.beans.entities.PhoneType;
import workset.beans.entities.Photo;
import workset.beans.entities.Price;
import workset.beans.entities.Processor;
import workset.beans.entities.ScratchProtect;
import workset.beans.entities.ScreenResolution;
import workset.beans.entities.ScreenTechnology;
import workset.beans.entities.SimCardFormat;
import workset.beans.entities.User;
import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.dao.dao.exceptions.DAOException;

public class WorkWithExcel {
	
	public WorkWithExcel(){
		
	}
	
	public static File convertMultipartFile(MultipartFile file){
		File result = new File(file.getOriginalFilename());
	    try {
	    	result.createNewFile();
		    FileOutputStream fos = new FileOutputStream(result); 
		    fos.write(file.getBytes());
		    fos.close(); 			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
	    return result;
	}	
	
	private HashSet separateString(String cell, String variant){
		HashSet result=null;
		if ("BodyStuff".equals(variant)){
			result=new HashSet<BodyStuff>();
			if (cell.length()>0){
				while(cell.indexOf(",")>0){
					String value=cell.substring(0, cell.indexOf(",")-1);
					cell=cell.substring(cell.indexOf(",")+1, cell.length());
					BodyStuff bodyStuff=new BodyStuff();
					bodyStuff.setName(value);
					result.add(bodyStuff);
				}
				if (cell.length()>0){
					BodyStuff bodyStuff=new BodyStuff();
					bodyStuff.setName(cell);
					result.add(bodyStuff);
				}
			}
			
			
		}else if ("BodyColor".equals(variant)){
			result=new HashSet<BodyColor>();
			if (cell.length()>0){
				while(cell.indexOf(",")>0){
					String value=cell.substring(0, cell.indexOf(",")-1);
					cell=cell.substring(cell.indexOf(",")+1, cell.length());
					BodyColor bodyColor=new BodyColor();
					bodyColor.setName(value);
					result.add(bodyColor);
				}
				if (cell.length()>0){
					BodyColor bodyColor=new BodyColor();
					bodyColor.setName(cell);
					result.add(bodyColor);
				}
			}		
		}
		
		return result;
	}
	
	public static ArrayList<Phone> importFromExcelPhones(File path, String GlobalPath){  //Только для .xlsx !!!!  .xls надо обрабаотывать через HSSF
		
       Workbook wb=null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Phone> list = new ArrayList<Phone>();
		
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);
            for (Row row : sheet) {
        	    Phone current = new  Phone();
        	    Manufacturer manufacturer = new Manufacturer();
           		Country country = new Country();
           		
           		BatteryType batteryType = new BatteryType();
           		workset.beans.entities.BodyType bodyType = new workset.beans.entities.BodyType();
           		Os os = new Os();
           		PhoneType phoneType = new PhoneType();
           		Processor processor = new Processor();
           		//ScratchProtect scratchProtect = new ScratchProtect();
           		ScreenResolution screenResolution = new ScreenResolution();
           		//ScreenTechnology screenTechnology = new ScreenTechnology();
           		SimCardFormat simCardFormat = new SimCardFormat();

               for (Cell cell : row) { //перебираем значения строки
               	switch (cell.getColumnIndex()) {
					case 0:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setName(cell.getStringCellValue());
						}
						break;
					}
					case 1:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setSpecification(cell.getStringCellValue());
						}
						break;
					}
					case 2:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setDescription(cell.getStringCellValue());
						}
						break;
					}
					case 3:{ 
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							manufacturer.setName(cell.getStringCellValue());
						}
						current.setManufacturer(manufacturer);
						break;
					}
					case 4:{ 
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							country.setName(cell.getStringCellValue());
						}
						manufacturer.setCountry(country);
						break;
					}
					case 5:{ 
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setModelYear(cell.getStringCellValue());
						}
						break;
					}
					case 6:{ 
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							phoneType.setName(cell.getStringCellValue());
						}
						current.setPhoneType(phoneType);
						break;
					}
					case 7:{ 
						if (cell.getCellType()==Cell.CELL_TYPE_STRING){
							os.setName(cell.getStringCellValue());
						}
						current.setOs(os);
						break;
					}					
					case 8:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							screenResolution.setResolution(cell.getStringCellValue());
						}
						current.setScreenResolution(screenResolution);
						break;
					}
					case 9:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setScreenSize(cell.getNumericCellValue());
						}
						break;
					}					
					case 10:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setOperationMemory(cell.getNumericCellValue());
						}
						break;
					}							
					case 11:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setFlashMemory(cell.getNumericCellValue());
						}
						break;
					}							
					case 12:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setDualSIM(cell.getNumericCellValue());
						}
						break;
					}							
					case 13:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setCamera(cell.getNumericCellValue());
						}
						break;
					}							
					case 14:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							processor.setName(cell.getStringCellValue());
						}
						current.setProcessor(processor);
						break;
					}							
					case 15:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setCoresNumber((byte)cell.getNumericCellValue());
						}
						break;
					}					
					case 16:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setProcessorFrequency(cell.getNumericCellValue());
						}
						break;
					}									
					case 17:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							bodyType.setName(cell.getStringCellValue());
						}
						current.setBodyType(bodyType);
						break;
					}									
					case 18:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							String cellValue=cell.getStringCellValue();
							HashSet<BodyStuff> listBodyStuff=new HashSet<BodyStuff>();
							if (cellValue.length()>0){
								while(cellValue.indexOf(",")>0){
									String value=cellValue.substring(0, cellValue.indexOf(",")-1);
									cellValue=cellValue.substring(cellValue.indexOf(",")+1, cellValue.length());
									BodyStuff bodyStuff=new BodyStuff();
									bodyStuff.setName(value);
									listBodyStuff.add(bodyStuff);
								}
								if (cellValue.length()>0){
									BodyStuff bodyStuff=new BodyStuff();
									bodyStuff.setName(cellValue);
									listBodyStuff.add(bodyStuff);
								}
								current.setBodyStuff(listBodyStuff);
							}
						}
						break;
					}
					case 19:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							String cellValue=cell.getStringCellValue();
							HashSet<BodyColor> listBodyColor=new HashSet<BodyColor>();
							if (cellValue.length()>0){
								while(cellValue.indexOf(",")>0){
									String value=cellValue.substring(0, cellValue.indexOf(",")-1);
									cellValue=cellValue.substring(cellValue.indexOf(",")+1, cellValue.length());
									BodyColor bodyColor=new BodyColor();
									bodyColor.setName(value);
									listBodyColor.add(bodyColor);
								}
								if (cellValue.length()>0){
									BodyColor bodyColor=new BodyColor();
									bodyColor.setName(cellValue);
									listBodyColor.add(bodyColor);
								}
								current.setBodyColor(listBodyColor);
							}
						}
						break;
					}					
					case 20:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setQwertyKeyboard((cell.getStringCellValue().length()>0?true:false));
						}
						break;
					}									
					case 21:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							simCardFormat.setName(cell.getStringCellValue());
						}
						current.setSimCardFormat(simCardFormat);
						break;
					}						
					case 22:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setFingerPrint((cell.getStringCellValue().length()>0?true:false));
						}
						break;
					}
					case 23:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setLength(cell.getNumericCellValue());
						}
						break;
					}						
					case 24:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setWidth(cell.getNumericCellValue());
						}
						break;
					}					
					case 25:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setThickness(cell.getNumericCellValue());
						}
						break;
					}
					case 26:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setWeight(cell.getNumericCellValue());
						}
						break;
					}					
					case 27:{
						if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
							current.setJudgement(cell.getNumericCellValue());
						}
						break;
					}					
					case 28:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setAccelerometer((cell.getStringCellValue().length()>0?true:false));
						}
						break;
					}								
					case 29:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setGlonass((cell.getStringCellValue().length()>0?true:false));
						}
						break;
					}								
					case 30:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setLightSensor((cell.getStringCellValue().length()>0?true:false));
						}
						break;
					}
					case 31:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							batteryType.setName(cell.getStringCellValue());
						}
						current.setBatteryType((BatteryType)batteryType);
						break;
					}
					case 32:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setTimeSpeak(cell.getStringCellValue());
						}
						break;
					}						
					case 33:{
						if (cell.getCellType()==cell.CELL_TYPE_STRING){
							current.setTimewait(cell.getStringCellValue());
						}
						break;
					}						
					default:
						break;
					}                	
               }
           	//теперь собираем список.
           	
           	//System.out.println(currentBF.toString());
           	if (current.getName().length()>0)
           		list.add(current);
           }
       }
		
		return list;
	}	
	
	
	public static ArrayList<Price> importFromExcelPrice(File path, String GlobalPath){  //Только для .xlsx !!!!  .xls надо обрабаотывать через HSSF
		
	       Workbook wb=null;
			try {
				wb = new XSSFWorkbook(new FileInputStream(path));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<Price> list = new ArrayList<Price>();
			
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);
	            for (Row row : sheet) {
	            	Price price = new  Price();
	            	Phone phone = new Phone();

	               for (Cell cell : row) { //перебираем значения строки
	               	switch (cell.getColumnIndex()) {
						case 0:{
							if (cell.getCellType()==cell.CELL_TYPE_STRING){
								phone.setName(cell.getStringCellValue());
							}
							break;
						}
						case 1:{
							if (cell.getCellType()==cell.CELL_TYPE_STRING){
								price.setTime(cell.getDateCellValue());
								price.setGoodPrefix(Service.PHONES_PREFIX);
								price.setPhone(phone);
							}
							break;
						}
						case 2:{
							if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
								price.setPrice(cell.getNumericCellValue());
							}
							break;
						}
	               	}
	               }
	           	//System.out.println(currentBF.toString());
	           	if (price.getPrice()>0){
	           		list.add(price);
	           	}
	           }
	       }
			
			return list;
		}
	
		public static ArrayList<Photo> importFromExcelPhoto(File path, String GlobalPath){  //Только для .xlsx !!!!  .xls надо обрабаотывать через HSSF
		
	       Workbook wb=null;
			try {
				wb = new XSSFWorkbook(new FileInputStream(path));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<Photo> list = new ArrayList<Photo>();
			
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);
	            for (Row row : sheet) {
	            	Photo photo = new  Photo();
	            	Phone phone = new Phone();

	               for (Cell cell : row) { //перебираем значения строки
	               	switch (cell.getColumnIndex()) {
						case 0:{
							if (cell.getCellType()==cell.CELL_TYPE_STRING){
								phone.setName(cell.getStringCellValue());
							}
							break;
						}
						case 1:{
							if (cell.getCellType()==cell.CELL_TYPE_STRING){
								photo.setName(cell.getStringCellValue());
								photo.setGoodPrefix(Service.PHONES_PREFIX);
								photo.setPhone(phone);
							}
							break;
						}
						case 2:{
							String value=cell.getStringCellValue().trim();
							if (value.length()>0){
								photo.setMain(true);
							}
							break;
						}
	               	}
	               }
	           	if (photo.getName().length()>0)
	           		list.add(photo);
	           }
	       }
			
			return list;
		}	

	public static ArrayList<String> downloadExcel(String variant, String good, User user, MultipartFile fileExcel
			, SimpleDAO simpleDAO, PhoneDAO phoneDAO, UserDAO userDAO, HttpSession session) {
		ArrayList<String> errors=new ArrayList<String>();
		
		 if ("Product".equals(variant)){
			String productFile=fileExcel.getOriginalFilename().trim();
    			if (!productFile.contains(".xlsx")){
    				errors.add("Указанный Вами файл с номенклатурой не соответствует формату. Используйте Excel-файл с расширением *.xlsx");
    			}else{
    				if (Service.PHONES_PREFIX.equals(good)){
    					ArrayList<Phone> list = importFromExcelPhones(convertMultipartFile(fileExcel)  //прочитали excel, собрали коллекцию...
    							,session.getServletContext().getRealPath("/"));
    				
	    			    synchronized (list){
	    		        	for (Phone current:list){    		        		//теперь запишем её
	    		        		Manufacturer manufacturer=(Manufacturer)current.getManufacturer();
	    		    			if (manufacturer.getId()==0){   //значит такого в базе ещё нет
	    		    				Country country=manufacturer.getCountry();
	    		    				if (country.getId()==0){
	    		    					if (country.getName().isEmpty()){
    		    							country.setName(Service.EMPTY);
    		    						}
	    		    					Country value=simpleDAO.getCountry(country.getName());
	    		    					if (value.getId()==0){
	    		    						
		    		    					try{
			    		    					simpleDAO.saveOrUpdate(country);
			    		    					country=simpleDAO.getCountry(country.getName());
			    		    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
			    		    							,"Country",""+country.getId(),country.getName(), "Загрузили из Excel"));
			    		    					manufacturer.setCountry(country);
		    		    					}catch(DAOException e){
		    		    						System.out.println(e.getStackTrace());
		    		    						errors.add(e.getStackTrace().toString());
		    		    					}
	    		    						
	    		    					}else{
	    		    						country=value;
	    		    					}
	    		    				}
	    		    				if (manufacturer.getName().isEmpty()){
	    		    					manufacturer.setName(Service.EMPTY);
		    						}	    		    				
	    		    				Manufacturer value=simpleDAO.getManufacturer(manufacturer.getName());
	    		    				if (value.getId()==0){
		    		    				try{
			    		    				simpleDAO.saveOrUpdate(manufacturer);
			    		    				manufacturer=simpleDAO.getManufacturer(manufacturer.getName());
			    		    				simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
			    		    						,"Manufacturer",""+manufacturer.getId(),manufacturer.getName(), "Загрузили из Excel"));
		    		    				}catch(DAOException e){
		    		    					System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
	    		    				}else{
	    		    					manufacturer=value;
	    		    				}
	    		    			}
	    		    			current.setManufacturer(manufacturer);
	    		    			
	    		        		Os os=(Os) current.getOs();
			    				if (os.getId()==0){
			    					if (os.getName().isEmpty()){
			    						os.setName(Service.EMPTY);
		    						}	    	
    		    					Os value=simpleDAO.getOs(os.getName());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(os);
					    					os=simpleDAO.getOs(os.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"OS",""+os.getId(),os.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						os=value;
    		    					}
			    				}
			    				current.setOs(os);
	    		        		 
			    				ScreenResolution screenResolution=(ScreenResolution) current.getScreenResolution();
			    				if (screenResolution.getId()==0){
			    					if (screenResolution.getResolution().isEmpty()){
			    						screenResolution.setResolution(Service.EMPTY);
		    						}	    
			    					ScreenResolution value=simpleDAO.getScreenResolution(screenResolution.getResolution());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(screenResolution);
					    					screenResolution=simpleDAO.getScreenResolution(screenResolution.getResolution());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"ScreenResolution",""+screenResolution.getId(),screenResolution.getResolution(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						screenResolution=value;
    		    					}
			    				}
			    					
			    				current.setScreenResolution(screenResolution);

//			    				ScreenTechnology screenTechnology=(ScreenTechnology) current.getScreenTechnology();
//			    				if (screenTechnology.getId()==0){
//			    					ScreenTechnology value=simpleDAO.getScreenTechnology(screenTechnology.getName());
//    		    					if (value.getId()==0){
//				    					try{
//					    					simpleDAO.saveOrUpdate(screenTechnology);
//					    					screenResolution=simpleDAO.getScreenResolution(screenTechnology.getName());
//					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
//					    							,"ScreenTechnology",""+screenTechnology.getId(),screenTechnology.getName(), "Загрузили из Excel"));
//				    					}catch(DAOException e){
//	    		    						errors.add(e.getStackTrace().toString());
//	    		    					}
//    		    					}
//			    				}
//			    				current.setScreenTechnology(screenTechnology);
//			    				
			    				workset.beans.entities.BodyType bodyType=(workset.beans.entities.BodyType)current.getBodyType();
			    				if (bodyType.getId()==0){
			    					if (bodyType.getName().isEmpty()){
			    						bodyType.setName(Service.EMPTY);
		    						}	 
			    					workset.beans.entities.BodyType value=simpleDAO.getBodyType(bodyType.getName());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(bodyType);
					    					bodyType=simpleDAO.getBodyType(bodyType.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"BodyType",""+bodyType.getId(),bodyType.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						bodyType=value;
    		    					}
			    				}
			    				current.setBodyType(bodyType);

			    				PhoneType phoneType=(PhoneType) current.getPhoneType();
			    				if (phoneType.getId()==0){
			    					if (phoneType.getName().isEmpty()){
			    						phoneType.setName(Service.EMPTY);
		    						}	
			    					PhoneType value=simpleDAO.getPhoneType(phoneType.getName());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(phoneType);
					    					phoneType=simpleDAO.getPhoneType(phoneType.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"PhoneType",""+phoneType.getId(),phoneType.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						phoneType=value;
    		    					}
			    				}
			    				current.setPhoneType(phoneType);

//			    				ScratchProtect scratchprotect=(ScratchProtect) current.getScratchprotect();
//			    				if (scratchprotect.getId()==0){
//			    					ScratchProtect value=simpleDAO.getScratchProtect(scratchprotect.getName());
//    		    					if (value.getId()==0){
//				    					try{
//					    					simpleDAO.saveOrUpdate(scratchprotect);
//					    					scratchprotect=simpleDAO.getScratchProtect(scratchprotect.getName());
//					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
//					    							,"ScratchProtect",""+scratchprotect.getId(),scratchprotect.getName(), "Загрузили из Excel"));
//				    					}catch(DAOException e){
//	    		    						errors.add(e.getStackTrace().toString());
//	    		    					}
//    		    					}
//			    				}
//			    				current.setScratchprotect(scratchprotect);

			    				Processor processor=(Processor) current.getProcessor();
			    				if (processor.getId()==0){
			    					if (processor.getName().isEmpty()){
			    						processor.setName(Service.EMPTY);
		    						}	
			    					Processor value=simpleDAO.getProcessor(processor.getName());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(processor);
					    					processor=simpleDAO.getProcessor(processor.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"Processor",""+processor.getId(),processor.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						processor=value;
    		    					}
			    				}
			    				current.setProcessor(processor);
			    				
			    				BatteryType batteryType=(BatteryType) current.getBatteryType();
			    				if (batteryType.getId()==0){
			    					if (batteryType.getName().isEmpty()){
			    						batteryType.setName(Service.EMPTY);
		    						}	
			    					BatteryType value=simpleDAO.getBatteryType(batteryType.getName());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(batteryType);
					    					batteryType=simpleDAO.getBatteryType(batteryType.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"BatteryType",""+batteryType.getId(),batteryType.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						batteryType=value;
    		    					}
			    				}
			    				current.setBatteryType(batteryType);

			    				SimCardFormat simCardFormat=(SimCardFormat) current.getSimCardFormat();
			    				if (simCardFormat.getId()==0){
			    					if (simCardFormat.getName().isEmpty()){
			    						simCardFormat.setName(Service.EMPTY);
		    						}	
			    					SimCardFormat value=simpleDAO.getSimCardFormat(batteryType.getName());
    		    					if (value.getId()==0){
				    					try{
					    					simpleDAO.saveOrUpdate(simCardFormat);
					    					simCardFormat=simpleDAO.getSimCardFormat(simCardFormat.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"SimCardFormat",""+simCardFormat.getId(),simCardFormat.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						simCardFormat=value;
    		    					}
			    				}
			    				current.setSimCardFormat(simCardFormat);
			    				
			    				Set<BodyColor> bodyColorList=current.getBodyColor();
			    				Set<BodyColor> newBodyColorList=new HashSet<BodyColor>();
			    				for(BodyColor currentColor: bodyColorList){
				    				if (currentColor.getId()==0){
				    					if (currentColor.getName().isEmpty()){
				    						currentColor.setName(Service.EMPTY);
			    						}	
				    					BodyColor value=simpleDAO.getBodyColor(currentColor.getName());
	    		    					if (value.getId()==0){
					    					try{
						    					simpleDAO.saveOrUpdate(currentColor);
						    					currentColor=simpleDAO.getBodyColor(currentColor.getName());
						    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
						    							,"BodyColor",""+currentColor.getId(),currentColor.getName(), "Загрузили из Excel"));
					    					}catch(DAOException e){
					    						System.out.println(e.getStackTrace());
		    		    						errors.add(e.getStackTrace().toString());
		    		    					}
	    		    					}else{
	    		    						currentColor=value;
	    		    					}
				    				}
				    				newBodyColorList.add(currentColor);
			    				}
			    				current.setBodyColor((HashSet<BodyColor>) newBodyColorList);
			    				
			    				Set<BodyStuff> bodyStuffList=current.getBodyStuff();
			    				Set<BodyStuff> newBodyStuffList=new HashSet<BodyStuff>();
			    				for(BodyStuff currentStuff: newBodyStuffList){
				    				if (currentStuff.getId()==0){
				    					if (currentStuff.getName().isEmpty()){
				    						currentStuff.setName(Service.EMPTY);
			    						}	
				    					BodyStuff value=simpleDAO.getBodyStuff(currentStuff.getName());
	    		    					if (value.getId()==0){
					    					try{
						    					simpleDAO.saveOrUpdate(currentStuff);
						    					currentStuff=simpleDAO.getBodyStuff(currentStuff.getName());
						    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
						    							,"BodyStuff",""+currentStuff.getId(),currentStuff.getName(), "Загрузили из Excel"));
					    					}catch(DAOException e){
					    						System.out.println(e.getStackTrace());
		    		    						errors.add(e.getStackTrace().toString());
		    		    					}
	    		    					}else{
	    		    						currentStuff=value;
	    		    					}
				    				}
				    				newBodyStuffList.add(currentStuff);
			    				}
			    				current.setBodyStuff((HashSet<BodyStuff>) newBodyStuffList);

			    				if (current.getId()==0){
			    					if (current.getName().isEmpty()){
			    						current.setName(Service.EMPTY);
		    						}	
			    					Phone value=phoneDAO.getPhone(current.getName());
    		    					if (value.getId()==0){
				    					try{
					    					phoneDAO.saveOrUpdate(current);
					    					current=phoneDAO.getPhone(current.getName());
					    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
					    							,"Phone",""+current.getId(),current.getName(), "Загрузили из Excel"));
				    					}catch(DAOException e){
				    						System.out.println(e.getStackTrace());
	    		    						errors.add(e.getStackTrace().toString());
	    		    					}
    		    					}else{
    		    						current=value;
    		    					}
			    				}
	    		        	
			    			}
			    		}

	    			}
	        	}
			//}
		}else if ("Price".equals(variant)){
			String priceFile=fileExcel.getOriginalFilename().trim();
			if (!priceFile.contains(".xlsx")){
				errors.add("Указанный Вами файл с ценами не соответствует формату. Используйте Excel-файл с расширением *.xlsx");
			}else{
				ArrayList<Price> list = importFromExcelPrice(convertMultipartFile(fileExcel),session.getServletContext().getRealPath("/"));   
	 	        synchronized (list){
	 	        	for (Price current:list){
	 	        		Phone phone = current.getPhone();
	 	        		
	 	        		if (phone.getId()==0){
	    					Phone value=phoneDAO.getPhone(phone.getName());
	    					if (value.getId()==0){
		    					try{
			    					phoneDAO.saveOrUpdate(phone);
			    					phone=phoneDAO.getPhone(phone.getName());
			    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
			    							,"Phone",""+phone.getId(),phone.getName(), "Загрузили из Excel"));
		    					}catch(DAOException e){
		    						System.out.println(e.getStackTrace());
		    						errors.add(e.getStackTrace().toString());
		    					}
	    					}
	    				}
	 	        		current.setUser(user);
	 	        		if (current.getId()==0){
	 	        			Price value=phoneDAO.getPriceByPrice(current.getPrice(), phone);
	    					if (value.getId()==0){
		    					try{
			    					phoneDAO.saveOrUpdate(current);
			    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
			    							,"Price",""+phone.getId(),phone.getName()+", "+current.getPrice(), "Загрузили из Excel"));
		    					}catch(DAOException e){
		    						System.out.println(e.getStackTrace());
		    						errors.add(e.getStackTrace().toString());
		    					}
	    					}
	    				}
					}
				}			
			}

		}else if ("Photo".equals(variant)){
			String priceFile=fileExcel.getOriginalFilename().trim();
			if (!priceFile.contains(".xlsx")){
				errors.add("Указанный Вами файл с ценами не соответствует формату. Используйте Excel-файл с расширением *.xlsx");
			}else{
				ArrayList<Photo> list = importFromExcelPhoto(convertMultipartFile(fileExcel),session.getServletContext().getRealPath("/"));   
	 	        synchronized (list){
	 	        	for (Photo current:list){
	 	        		Phone phone = current.getPhone();
	 	        		
	 	        		if (phone.getId()==0){
	    					Phone value=phoneDAO.getPhone(phone.getName());
	    					if (value.getId()==0){
		    					try{
			    					phoneDAO.saveOrUpdate(phone);
			    					phone=phoneDAO.getPhone(phone.getName());
			    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
			    							,"Phone",""+phone.getId(),phone.getName(), "Загрузили из Excel"));
		    					}catch(DAOException e){
		    						System.out.println(e.getStackTrace());
		    						errors.add(e.getStackTrace().toString());
		    					}
	    					}
	    				}
	 	        		if (current.getId()==0){
	 	        			Photo value=phoneDAO.getPhoto(current.getName(), phone);
	    					if (value.getId()==0){
		    					try{
			    					phoneDAO.saveOrUpdate(current);
			    					simpleDAO.saveOrUpdate(new Log(0, user, new GregorianCalendar().getTime()
			    							,"Photo",""+phone.getId(),phone.getName(), "Загрузили из Excel"));
		    					}catch(DAOException e){
		    						System.out.println(e.getStackTrace());
		    						errors.add(e.getStackTrace().toString());
		    					}
	    					}
	    				}
					}
				}			
			}

		}
		
		return errors;
	}	
}
