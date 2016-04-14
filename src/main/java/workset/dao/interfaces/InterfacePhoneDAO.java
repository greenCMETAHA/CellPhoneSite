package workset.dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import workset.beans.entities.Phone;
import workset.beans.entities.Photo;
import workset.beans.entities.Price;
import workset.dao.dao.exceptions.DAOException;

public interface InterfacePhoneDAO extends Serializable, InterfaceDAO {

	ArrayList<Phone> getPhones();
	ArrayList<Phone> getPhonesByPhoneType(int id, int page);
	ArrayList<Phone> getPhonesByManufacturer(int id, int page);
	ArrayList<Phone> getPhones(int page);
	Phone getPhone(int id);
	Phone getPhone(String name);

    ArrayList<Photo> getPhotos(Phone phone);
    Photo getMainPhoto(Phone phone);
    Photo getPhoto(int id);
    Photo getPhoto(String filename);
    Photo getPhoto(String filename, Phone phone);

    ArrayList<Price> getPrices(Phone phone);
    Price getLastPrice(Phone phone);
    Price getPrice(int id);
    Price getPriceByPrice(double price, Phone phone);
}
