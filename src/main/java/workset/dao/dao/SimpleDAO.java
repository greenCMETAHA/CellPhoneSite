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

import workset.beans.entities.BatteryType;
import workset.beans.entities.BodyColor;
import workset.beans.entities.BodyStuff;
import workset.beans.entities.BodyType;
import workset.beans.entities.Country;
import workset.beans.entities.Customer;
import workset.beans.entities.Info;
import workset.beans.entities.Log;
import workset.beans.entities.Manufacturer;
import workset.beans.entities.Os;
import workset.beans.entities.PhoneType;
import workset.beans.entities.Processor;
import workset.beans.entities.ScratchProtect;
import workset.beans.entities.ScreenResolution;
import workset.beans.entities.ScreenTechnology;
import workset.beans.entities.Shop;
import workset.beans.entities.SimCardFormat;
import workset.dao.dao.exceptions.DAOException;
import workset.dao.interfaces.InterfaceSimpleDAO;
import workset.dao.utils.HibernateUtil;
import workset.services.ConstantsGroup;
import workset.services.Service;
import workset.services.WorkLog;

@Repository
public class SimpleDAO extends DAO implements InterfaceSimpleDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
    private static SimpleDAO sessionDAO;

    private static Logger log = Logger.getLogger(DAO.class);
    private Transaction transaction = null;

    /* variable for gettig text constants */
    private static ConstantsGroup Constants;


    public SimpleDAO() {
        Constants = ConstantsGroup.start();
    }

    /* Method for realization of pattern Singleton */
    public static SimpleDAO startDAO(){
        if(sessionDAO == null)
            sessionDAO = new SimpleDAO();

        if (sessionDAO==null) //ooops...
            WorkLog.writeInLog("Can not open database");

        return sessionDAO;
    }	 

	 @Override
     public BatteryType getBatteryType(int id) {
    	BatteryType result=new BatteryType();

         HibernateUtil util = HibernateUtil.getHibernateUtil();
         Session session = util.getSession();

         try {
             transaction = session.beginTransaction();
             Query query=session.createQuery("from BatteryType where id=:valueID");
             query.setParameter("valueID", id);
             List <BatteryType> list=query.list();
             if (list.size()>0) {
                 result=list.get(0);
             }
             transaction.commit();
         } catch (HibernateException e) {
        	 System.out.println(e);
             log.error("Error: can't getBatteryType("+id+"): " + e);
             transaction.rollback();
             // throw new DAOException(e);
         }
    	return result;
    }
	 
	 @Override
     public BatteryType getBatteryType(String name) {
    	BatteryType result=new BatteryType();

         HibernateUtil util = HibernateUtil.getHibernateUtil();
         Session session = util.getSession();

         try {
             transaction = session.beginTransaction();
             Query query=session.createQuery("from BatteryType where name=:valueName");
             query.setParameter("valueName", name);
             List <BatteryType> list=query.list();
             if (list.size()>0) {
                 result=list.get(0);
             }
             transaction.commit();
         } catch (HibernateException e) {
        	 System.out.println(e);
             log.error("Error: can't getBatteryType("+name+"): " + e);
             transaction.rollback();
             // throw new DAOException(e);
         }
    	return result;
    }	 
	 
	 @Override  
     public ArrayList<BatteryType> getBatteryTypes(){
    	ArrayList<BatteryType> result=new ArrayList<BatteryType>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from BatteryType"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getBatteryTypes(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;
    	
     }

	 @Override
	 public ArrayList<Manufacturer> getManufacturers() {
			ArrayList<Manufacturer> result=new ArrayList<Manufacturer>();

	    	HibernateUtil util = HibernateUtil.getHibernateUtil();
	        Session session = util.getSession();

	        try {
		        transaction = session.beginTransaction();
		        Query query=session.createQuery("from Manufacturer"); 
		        result=(ArrayList)query.list();
		        transaction.commit();
	        } catch (HibernateException e) {
	        	System.out.println(e);
		        log.error("Error: can't getManufacturers(): " + e);
		        transaction.rollback();
		        // throw new DAOException(e);
	        }
	        return result;
		}

	 @Override
	public Manufacturer getManufacturer(int manufacturer_id) {
		Manufacturer result=new Manufacturer();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Manufacturer where id=:valueID");
            query.setParameter("valueID", manufacturer_id);
            List <Manufacturer> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getManufacturer("+manufacturer_id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;
	}
	 
	@Override
	public Manufacturer getManufacturer(String name) {
		Manufacturer result=new Manufacturer();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Manufacturer where name=:valueName");
            query.setParameter("valueName", name);
            List <Manufacturer> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getManufacturer("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;
	}	 

	@Override
	public ArrayList<BodyColor> getBodyColors() {
		ArrayList<BodyColor> result=new ArrayList<BodyColor>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from BodyColor"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getBodyColors(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;
	}

	@Override
	public BodyColor getBodyColor(int id) {
		BodyColor result=new BodyColor();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from BodyColor where id=:valueID");
            query.setParameter("valueID", id);
            List <BodyColor> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getBodyColor("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
    }

	@Override
	public BodyColor getBodyColor(String name) {
		BodyColor result=new BodyColor();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from BodyColor where name=:valueName");
            query.setParameter("valueName", name);
            List <BodyColor> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getBodyColor("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}
	

	@Override
	public ArrayList<BodyStuff> getBodyStuff() {
		ArrayList<BodyStuff> result=new ArrayList<BodyStuff>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from BodyStuff"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getBodyStuff(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;
	}

	@Override
	public BodyStuff getBodyStuff(int id) {
		BodyStuff result=new BodyStuff();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from BodyStuff where id=:valueID");
            query.setParameter("valueID", id);
            List <BodyStuff> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getBodyStuff("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}
	
	@Override
	public BodyStuff getBodyStuff(String name) {
		BodyStuff result=new BodyStuff();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from BodyStuff where name=:valueName");
            query.setParameter("valueName", name);
            List <BodyStuff> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getBodyStuff("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}	

	@Override
	public ArrayList<BodyType> getBodyTypes() {
		ArrayList<BodyType> result=new ArrayList<BodyType>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from BodyType"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getBodyType(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
    }

	@Override
	public BodyType getBodyType(int id) {
		BodyType result=new BodyType();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from BodyType where id=:valueID");
            query.setParameter("valueID", id);
            List <BodyType> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getBodyType("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
    }
	
	@Override
	public BodyType getBodyType(String name) {
		BodyType result=new BodyType();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from BodyType where name=:valueName");
            query.setParameter("valueName", name);
            List <BodyType> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getBodyType("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}	

	@Override
	public ArrayList<Country> getCountries() {
		ArrayList<Country> result=new ArrayList<Country>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Country"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getCountries(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public Country getCountry(int id) {
		Country result=new Country();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Country where id=:valueID");
            query.setParameter("valueID", id);
            List <Country> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getCountry("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public Country getCountry(String name) {
		Country result=new Country();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Country where name=:valueName");
            query.setParameter("valueName", name);
            List <Country> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getCountry("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}	

	@Override
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> result=new ArrayList<Customer>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Customer"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getCustomers(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	

	}

	@Override
	public Customer getCustomer(int id) {
		Customer result=new Customer();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Customer where id=:valueID");
            query.setParameter("valueID", id);
            List <Customer> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getCustomer("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public Customer getCustomer(String name) {
		Customer result=new Customer();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Customer where name=:valueName");
            query.setParameter("valueName", name);
            List <Customer> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getCustomer("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}	

	@Override
	public ArrayList<Os> getOses() {
		ArrayList<Os> result=new ArrayList<Os>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Os"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getOses(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public Os getOs(int id) {
		Os result=new Os();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Os where id=:valueID");
            query.setParameter("valueID", id);
            List <Os> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getOs("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public Os getOs(String name) {
		Os result=new Os();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Os where name=:valueName");
            query.setParameter("valueName", name);
            List <Os> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getOs("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	

	@Override
	public ArrayList<PhoneType> getPhoneTypes() {
		ArrayList<PhoneType> result=new ArrayList<PhoneType>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from PhoneType"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getPhoneTypes(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public PhoneType getPhoneType(int id) {
		PhoneType result=new PhoneType();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from PhoneType where id=:valueID");
            query.setParameter("valueID", id);
            List <PhoneType> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getPhoneType("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public PhoneType getPhoneType(String name) {
		PhoneType result=new PhoneType();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from PhoneType where name=:valueName");
            query.setParameter("valueName", name);
            List <PhoneType> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getPhoneType("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}	

	@Override
	public ArrayList<Processor> getProcessors() {
		ArrayList<Processor> result=new ArrayList<Processor>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Processor"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getProcessor(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public Processor getProcessor(int id) {
		Processor result=new Processor();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Processor where id=:valueID");
            query.setParameter("valueID", id);
            List <Processor> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getProcessor("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public Processor getProcessor(String name) {
		Processor result=new Processor();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Processor where name=:valueName");
            query.setParameter("valueName", name);
            List <Processor> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getProcessor("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}
	

	@Override
	public ArrayList<ScratchProtect> getScratchProtects() {
		ArrayList<ScratchProtect> result=new ArrayList<ScratchProtect>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from ScratchProtect"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getScratchProtects(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public ScratchProtect getScratchProtect(int id) {
		ScratchProtect result=new ScratchProtect();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from ScratchProtect where id=:valueID");
            query.setParameter("valueID", id);
            List <ScratchProtect> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getScratchProtect("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public ScratchProtect getScratchProtect(String name) {
		ScratchProtect result=new ScratchProtect();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from ScratchProtect where name=:valueName");
            query.setParameter("valueName", name);
            List <ScratchProtect> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getScratchProtect("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}	

	@Override
	public ArrayList<ScreenResolution> getScreenResolutions() {
		ArrayList<ScreenResolution> result=new ArrayList<ScreenResolution>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from ScreenResolution"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getScreenResolutions(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public ScreenResolution getScreenResolution(int id) {
		ScreenResolution result=new ScreenResolution();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from ScreenResolution where id=:valueID");
            query.setParameter("valueID", id);
            List <ScreenResolution> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getScreenResolution("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public ScreenResolution getScreenResolution(String name) {
		ScreenResolution result=new ScreenResolution();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from ScreenResolution where resolution=:valueName");
            query.setParameter("valueName", name);
            List <ScreenResolution> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getScreenResolution("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	

	@Override
	public ArrayList<ScreenTechnology> getScreenTechnologies() {
		ArrayList<ScreenTechnology> result=new ArrayList<ScreenTechnology>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from ScreenTechnology"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getScreenTechnologies(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public ScreenTechnology getScreenTechnology(int id) {
		ScreenTechnology result=new ScreenTechnology();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from ScreenTechnology where id=:valueID");
            query.setParameter("valueID", id);
            List <ScreenTechnology> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getScreenTechnology("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	
	@Override
	public ScreenTechnology getScreenTechnology(String name) {
		ScreenTechnology result=new ScreenTechnology();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from ScreenTechnology where name=:valueName");
            query.setParameter("valueName", name);
            List <ScreenTechnology> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getScreenTechnology("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}
	

	@Override
	public ArrayList<SimCardFormat> getSimCardFormats() {
		ArrayList<SimCardFormat> result=new ArrayList<SimCardFormat>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from SimCardFormat"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getSimCardFormats(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
	}

	@Override
	public SimCardFormat getSimCardFormat(int id) {
		SimCardFormat result=new SimCardFormat();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from SimCardFormat where id=:valueID");
            query.setParameter("valueID", id);
            List <SimCardFormat> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getSimCardFormat("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}
	

	@Override
	public SimCardFormat getSimCardFormat(String name) {
		SimCardFormat result=new SimCardFormat();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from SimCardFormat where name=:valueName");
            query.setParameter("valueName", name);
            List <SimCardFormat> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getSimCardFormat("+name+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;	
	}	
    
	@Override
	public String getInfo(String valueName){
		String result="";
		
		HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Info where name=:valueName");
            query.setParameter("valueName", valueName);
            List <Info> list=query.list();
            if (list.size()>0) {
                result=list.get(0).getValue();
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getInfo("+valueName+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
		
		return result;	
	}
	
	@Override
	public ArrayList<Log> getLog(int pageNumber, int lastQuantity){
		ArrayList<Log> result=new ArrayList<Log>();
		
		HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Log order by time desc");
            query.setFirstResult((pageNumber>0?pageNumber-1:0)*Service.LOG_ON_PAGE);
            query.setMaxResults(lastQuantity);
            result=(ArrayList<Log>) query.list();
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getLog("+lastQuantity+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
		
		return result;			
	
	}
	
	@Override
	public ArrayList<Log> getLog(int lastQuantity){
		ArrayList<Log> result = getLog(0, lastQuantity);
		
		return result;	
	}

	@Override
	public ArrayList<Shop> getShops() {
		ArrayList<Shop> result=new ArrayList<Shop>();

    	HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
	        transaction = session.beginTransaction();
	        Query query=session.createQuery("from Shop"); 
	        result=(ArrayList)query.list();
	        transaction.commit();
        } catch (HibernateException e) {
        	System.out.println(e);
	        log.error("Error: can't getShops(): " + e);
	        transaction.rollback();
	        // throw new DAOException(e);
        }
        return result;	
    }

	@Override
	public Shop getShop(int id) {
		Shop result=new Shop();

        HibernateUtil util = HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        try {
            transaction = session.beginTransaction();
            Query query=session.createQuery("from Shop where id=:valueID");
            query.setParameter("valueID", id);
            List <Shop> list=query.list();
            if (list.size()>0) {
                result=list.get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
       	 System.out.println(e);
            log.error("Error: can't getShop("+id+"): " + e);
            transaction.rollback();
            // throw new DAOException(e);
        }
        return result;		
	}






	








	
	



	
}
