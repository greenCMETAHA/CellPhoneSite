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
import workset.beans.entities.PhoneType;
import workset.beans.entities.Photo;
import workset.beans.entities.Price;
import workset.beans.entities.Processor;
import workset.beans.entities.ScratchProtect;
import workset.beans.entities.ScreenResolution;
import workset.beans.entities.ScreenTechnology;
import workset.beans.entities.Shop;
import workset.beans.entities.SimCardFormat;
import workset.dao.dao.exceptions.DAOException;

public interface InterfaceSimpleDAO extends Serializable, InterfaceDAO {

	ArrayList<BatteryType> getBatteryTypes();
	BatteryType getBatteryType(int id);
	BatteryType getBatteryType(String name);	
	
	ArrayList<Manufacturer> getManufacturers();
	Manufacturer getManufacturer(int id);
	Manufacturer getManufacturer(String name);
    
	ArrayList<BodyColor> getBodyColors();
	BodyColor getBodyColor(int id);
	BodyColor getBodyColor(String name);

	ArrayList<BodyStuff> getBodyStuff();
	BodyStuff getBodyStuff(int id);
	BodyStuff getBodyStuff(String name);
    
    ArrayList<BodyType> getBodyTypes();
    BodyType getBodyType(int id);
    BodyType getBodyType(String name);
    
    ArrayList<Country> getCountries();
    Country getCountry(int id);
    Country getCountry(String name);
    
    ArrayList<Customer> getCustomers();
    Customer getCustomer(int id);
    Customer getCustomer(String name);
  
    ArrayList<Os> getOses();
    Os getOs(int id);
    Os getOs(String name);
    
    ArrayList<PhoneType> getPhoneTypes();
    PhoneType getPhoneType(int id);
    PhoneType getPhoneType(String name);
   
    ArrayList<Processor> getProcessors();
    Processor getProcessor(int id);
    Processor getProcessor(String name);

    ArrayList<ScratchProtect> getScratchProtects();
    ScratchProtect getScratchProtect(int id);
    ScratchProtect getScratchProtect(String name);

    ArrayList<ScreenResolution> getScreenResolutions();
    ScreenResolution getScreenResolution(int id);
    ScreenResolution getScreenResolution(String name);

    ArrayList<ScreenTechnology> getScreenTechnologies();
    ScreenTechnology getScreenTechnology(int id);
    ScreenTechnology getScreenTechnology(String name);

    ArrayList<SimCardFormat> getSimCardFormats();
    SimCardFormat getSimCardFormat(int id);
    SimCardFormat getSimCardFormat(String name);
    
    ArrayList<Shop> getShops();
    Shop getShop(int id);
    
    String getInfo(String name);
    
    ArrayList<Log> getLog(int lastQuantity);
    ArrayList<Log> getLog(int pageNum, int lastQuantity);
}
