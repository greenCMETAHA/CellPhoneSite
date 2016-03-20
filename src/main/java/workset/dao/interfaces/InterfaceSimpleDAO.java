package workset.dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import workset.beans.entities.BatteryType;
import workset.beans.entities.BodyColor;
import workset.beans.entities.BodyStuff;
import workset.beans.entities.BodyType;
import workset.beans.entities.Country;
import workset.beans.entities.Customer;
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
import workset.dao.dao.exceptions.DAOException;

public interface InterfaceSimpleDAO extends Serializable, InterfaceDAO {
	ArrayList<BatteryType> getBatteryTypes() throws DAOException;
	BatteryType getBatteryType(int id) throws DAOException;
	
	ArrayList<Manufacturer> getManufacturers() throws DAOException;
    Manufacturer getManufacturer(int id) throws DAOException;
    
	ArrayList<BodyColor> getBodyColors() throws DAOException;
	BodyColor getBodyColor(int id) throws DAOException;   

	ArrayList<BodyStuff> getBodyStuff() throws DAOException;
	BodyStuff getBodyStuff(int id) throws DAOException;
    
    ArrayList<BodyType> getBodyTypes() throws DAOException;
    BodyType getBodyType(int id) throws DAOException;	
    
    ArrayList<Country> getCountries() throws DAOException;
    Country getCountry(int id) throws DAOException;
    
    ArrayList<Customer> getCustomers() throws DAOException;
    Customer getCustomer(int id) throws DAOException;
  
    ArrayList<Os> getOses() throws DAOException;
    Os getOs(int id) throws DAOException;
    
    ArrayList<PhoneType> getPhoneTypes() throws DAOException;
    PhoneType getPhoneType(int id) throws DAOException;
   
    ArrayList<Processor> getProcessors() throws DAOException;
    Processor getProcessor(int id) throws DAOException;

    ArrayList<ScratchProtect> getScratchProtects() throws DAOException;
    ScratchProtect getScratchProtect(int id) throws DAOException;

    ArrayList<ScreenResolution> getScreenResolutions() throws DAOException;
    ScreenResolution getScreenResolution(int id) throws DAOException;  

    ArrayList<ScreenTechnology> getScreenTechnologies() throws DAOException;
    ScreenTechnology getScreenTechnology(int id) throws DAOException;

    ArrayList<SimCardFormat> getSimCardFormats() throws DAOException;
    SimCardFormat getSimCardFormat(int id) throws DAOException;
    
    String getInfo(String name) throws DAOException;
    
    ArrayList<Log> getLog(int lastQuantity) throws DAOException;
    ArrayList<Log> getLog(int pageNum, int lastQuantity) throws DAOException;
}
