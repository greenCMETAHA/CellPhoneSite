package workset.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import workset.beans.entities.Phone;
import workset.beans.entities.Photo;
import workset.beans.entities.Price;
import workset.beans.entities.SimCardFormat;
import workset.dao.dao.exceptions.DAOException;
import workset.dao.interfaces.InterfacePhoneDAO;
import workset.dao.interfaces.InterfaceSimpleDAO;
import workset.dao.utils.HibernateUtil;
import workset.services.ConstantsGroup;
import workset.services.WorkLog;

@Repository
public class PhoneDAO extends DAO implements InterfacePhoneDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
    private static PhoneDAO sessionDAO;

    private static Logger log = Logger.getLogger(DAO.class);
    private Transaction transaction = null;

    /* variable for gettig text constants */
    private static ConstantsGroup Constants;


    public PhoneDAO() {
        Constants = ConstantsGroup.start();
    }

    /* Method for realization of pattern Singleton */
    public static PhoneDAO startDAO(){
        if(sessionDAO == null)
            sessionDAO = new PhoneDAO();

        if (sessionDAO==null) //ooops...
            WorkLog.writeInLog("Can not open database");

        return sessionDAO;
    }
    
    //----------------------------------------------------------------------

	@Override
	public ArrayList<Phone> getPhones() throws DAOException {
		ArrayList<Phone> result=new ArrayList<Phone>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Phone"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getPhones(): " + e);
	        transaction.rollback();
	        throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public Phone getPhone(int id) throws DAOException {
		Phone result=new Phone();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Phone where id=:valueID");
            query.setParameter("valueID", id);
            List <Phone> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getPhone("+id+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
    }

	@Override
	public ArrayList<Photo> getPhotos(Phone phone) throws DAOException {
		ArrayList<Photo> result=new ArrayList<Photo>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Photo where phone_id=:phone_id"); 
	        query.setParameter("phone_id", phone.getId());
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getPhotos(): " + e);
	        transaction.rollback();
	        throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public Photo getMainPhoto(Phone phone) throws DAOException {
		Photo result=new Photo();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Photo where id=:phone_id AND ismain>0");
            query.setParameter("phone_id", phone.getId());
            List <Photo> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getMainPhoto("+phone.getId()+", "+phone.getName()+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
	}

	@Override
	public Photo getPhoto(int id) throws DAOException {
		Photo result=new Photo();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Photo where id=:valueID");
            query.setParameter("valueID", id);
            List <Photo> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getPhoto("+id+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
    }

	@Override
	public ArrayList<Price> getPrices(Phone phone) throws DAOException {
		ArrayList<Price> result=new ArrayList<Price>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Price where phone_id=:phone_id"); 
	        query.setParameter("phone_id", phone.getId());
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getPrices("+phone.getId()+", "+phone.getName()+"): " + e);
	        transaction.rollback();
	        throw new DAOException(e);
        }
        return result;	
    }

	@Override
	public Price getLastPrice(Phone phone) throws DAOException {
		Price result=new Price();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Price where id=:phone_id order by time desc");
            query.setParameter("phone_id", phone.getId());
            List <Price> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getLastPrice("+phone.getId()+", "+phone.getName()+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
    }

	@Override
	public Price getPrice(int id) throws DAOException {
		Price result=new Price();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Price where id=:valueID");
            query.setParameter("valueID", id);
            List <Price> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getPrice("+id+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
    }	 
}
