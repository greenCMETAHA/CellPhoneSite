package workset.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import workset.beans.entities.BatteryType;
import workset.beans.entities.Role;
import workset.beans.entities.User;
import workset.dao.dao.exceptions.DAOException;
import workset.dao.interfaces.InterfaceUserDAO;
import workset.dao.utils.HibernateUtil;
import workset.services.ConstantsGroup;
import workset.services.WorkLog;

public class UserDAO extends DAO implements InterfaceUserDAO {
    private static UserDAO sessionDAO;

    private static Logger log = Logger.getLogger(DAO.class);
    private Transaction transaction = null;

    /* variable for gettig text constants */
    private static ConstantsGroup Constants;


    public UserDAO() {
        Constants = ConstantsGroup.start();
    }

    /* Method for realization of pattern Singleton */
    public static UserDAO startDAO(){
        if(sessionDAO == null)
            sessionDAO = new UserDAO();

        if (sessionDAO==null) //ooops...
            WorkLog.writeInLog("Can not open database");

        return sessionDAO;
    }
    
    
    
	@Override
	public ArrayList<Role> getRoles() throws DAOException {
    	ArrayList<Role> result=new ArrayList<Role>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Role"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getRoles(): " + e);
	        transaction.rollback();
	        throw new DAOException(e);
        }
        return result;
	}

	@Override
	public ArrayList<Role> getRolesForUser(User user) throws DAOException {
    	ArrayList<Role> result=new ArrayList<Role>();
    	
    	for (Role current:user.getRole()){
    		result.add(current);
    	}

        return result;
	}

	@Override
	public Role getRole(int id) throws DAOException {
		Role result=new Role();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Role where id=:valueID");
            query.setParameter("valueID", id);
            List <Role> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getRole("+id+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
	}

	@Override
	public ArrayList<User> getUsers() throws DAOException {
	   	ArrayList<User> result=new ArrayList<User>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from User");
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getUsers(): " + e);
	        transaction.rollback();
	        throw new DAOException(e);
        }
        return result;	
    }

	@Override
	public User getUser(int id) throws DAOException {
		User result=new User();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from User where id=:valueID");
            query.setParameter("valueID", id);
            List <User> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getUser("+id+"): " + e);
            transaction.rollback();
            throw new DAOException(e);
        }
        return result;
	}

}
