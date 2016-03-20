package workset.dao.interfaces;

import workset.beans.entities.BatteryType;
import workset.beans.entities.Manufacturer;
import workset.dao.dao.exceptions.DAOException;

import java.io.Serializable;
import java.util.ArrayList;

public interface InterfaceDAO<T> extends Serializable {
    void saveOrUpdate(T t) throws DAOException;

    T get(Class objectClass, Serializable id) throws DAOException;

    T load(Class objectClass, Serializable id) throws DAOException;

    void delete(T t) throws DAOException;

}
