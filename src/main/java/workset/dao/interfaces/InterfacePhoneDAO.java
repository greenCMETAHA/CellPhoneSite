package workset.dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import workset.beans.entities.Phone;
import workset.beans.entities.Photo;
import workset.beans.entities.Price;
import workset.dao.dao.exceptions.DAOException;

public interface InterfacePhoneDAO extends Serializable, InterfaceDAO {
    ArrayList<Phone> getPhones() throws DAOException;
    Phone getPhone(int id) throws DAOException;	

    ArrayList<Photo> getPhotos(Phone phone) throws DAOException;
    Photo getMainPhoto(Phone phone) throws DAOException;
    Photo getPhoto(int id) throws DAOException;

    ArrayList<Price> getPrices(Phone phone) throws DAOException;
    Price getLastPrice(Phone phone) throws DAOException;
    Price getPrice(int id) throws DAOException;
}
