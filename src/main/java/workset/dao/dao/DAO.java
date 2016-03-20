package workset.dao.dao;

import workset.beans.entities.BatteryType;
import workset.beans.entities.Manufacturer;
import workset.dao.dao.exceptions.DAOException;
import workset.dao.interfaces.InterfaceDAO;
import workset.dao.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import workset.services.ConstantsGroup;
import workset.services.WorkLog;
import workset.services.WorkWithBundle;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> implements InterfaceDAO<T> {
	/* implemented from interface InterfaceDAO */

    /* variable for working with class. Pattern Singleton*/
    private static DAO sessionDAO;

    private static Logger log = Logger.getLogger(DAO.class);
    private Transaction transaction = null;

    /* variable for gettig text constants */
    private static ConstantsGroup Constants;


    public DAO() {
        Constants = ConstantsGroup.start();
    }

    /* Method for realization of pattern Singleton */
    public static DAO startDAO(){
        if(sessionDAO == null)
            sessionDAO = new DAO();

        if (sessionDAO==null) //ooops...
            WorkLog.writeInLog("Can not open database");

        return sessionDAO;
    }
    
    public void saveOrUpdate(T t) throws DAOException{
        try {
            HibernateUtil util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error: can't save or update object in Dao" + e);
            transaction.rollback();
            throw new DAOException(e);
        }
    }

    public T get(Class objectClass, Serializable id) throws DAOException {
        T t = null;
        try {
            HibernateUtil util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.get(objectClass, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error("Error: can't get " + getPersistentClass() + " in Dao" + e);
            throw new DAOException(e);
        }
        return t;
    }

    public T load(Class objectClass, Serializable id) throws DAOException {
        T t = null;
        try {
            HibernateUtil util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.load(objectClass, id);
            session.isDirty();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return t;
    }

    public void delete(T t) throws DAOException {
        try {
            HibernateUtil util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error: can't delete in Dao" + e);
            transaction.rollback();
            throw new DAOException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }




}
