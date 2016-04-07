import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

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
import workset.beans.entities.Role;
import workset.beans.entities.ScratchProtect;
import workset.beans.entities.ScreenResolution;
import workset.beans.entities.ScreenTechnology;
import workset.beans.entities.Shop;
import workset.beans.entities.SimCardFormat;
import workset.beans.entities.User;
import workset.dao.dao.DAO;
import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.dao.dao.exceptions.DAOException;
import workset.dao.utils.HibernateUtil;

public class App {
	
	public static void main(String[] args) {
		System.out.println("tests");
		
		try {
			SimpleDAO simpleDAO=SimpleDAO.startDAO();
			UserDAO userDAO=UserDAO.startDAO();
			PhoneDAO phoneDAO=PhoneDAO.startDAO();
			
			
/*			ArrayList<BodyStuff> list3=simpleDAO.getBodyStuff();
			for (BodyStuff current:list3){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			BodyStuff bodyStuff=simpleDAO.getBodyStuff(1);
			System.out.println(""+bodyStuff.getId()+bodyStuff.getName());			
			
			System.out.println("===");  //--------------------------------------					
			
			
			ArrayList<BatteryType> list=simpleDAO.getBatteryTypes();
			for (BatteryType current:list){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			BatteryType batteryType=simpleDAO.getBatteryType(1);
			System.out.println(""+batteryType.getId()+batteryType.getName());
			
			System.out.println("===");		//--------------------------------------
			
			
			ArrayList<BodyColor> list2=simpleDAO.getBodyColors();
			for (BodyColor current:list2){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			BodyColor bodyColor=simpleDAO.getBodyColor(1);
			System.out.println(""+bodyColor.getId()+bodyColor.getName());			
			
			
			System.out.println("===");  //--------------------------------------			
			
		
			
			ArrayList<BodyType> list4=simpleDAO.getBodyTypes();
			for (BodyType current:list4){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			BodyType bodyType=simpleDAO.getBodyType(1);
			System.out.println(""+bodyType.getId()+bodyType.getName());			
			
			
			System.out.println("===");  //--------------------------------------				
			

			ArrayList<Country> list5=simpleDAO.getCountries();
			for (Country current:list5){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			Country country=simpleDAO.getCountry(1);
			System.out.println(""+country.getId()+country.getName());			
			
			
			System.out.println("===");  //--------------------------------------						
			
			
			ArrayList<Customer> list6=simpleDAO.getCustomers();
			for (Customer current:list6){
				System.out.println(""+current.getId()+current.getFullName());
			}
			System.out.println("===");
			
			Customer customer=simpleDAO.getCustomer(1);
			System.out.println(""+customer.getId()+", "+customer.getAddress()+", "+customer.getFullName()+", "+customer.getLastName()
				+", "+customer.getCompanyName()+", "+customer.getEMail()+", "+customer.getTown()+", "+customer.getZip());			
			
			
			System.out.println("===");  //--------------------------------------
			
			ArrayList<Os> list7=simpleDAO.getOses();
			for (Os current:list7){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			Os os=simpleDAO.getOs(1);
			System.out.println(""+os.getId()+", "+os.getName());			
			
			System.out.println("===");  //--------------------------------------						
			
			ArrayList<PhoneType> list8=simpleDAO.getPhoneTypes();
			for (PhoneType current:list8){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			PhoneType phoneType=simpleDAO.getPhoneType(1);
			System.out.println(""+phoneType.getId()+phoneType.getName());			
			
			
			System.out.println("===");  //--------------------------------------
			
			ArrayList<Processor> list9=simpleDAO.getProcessors();
			for (Processor current:list9){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			Processor processor=simpleDAO.getProcessor(1);
			System.out.println(""+processor.getId()+processor.getName());			
			
			
			System.out.println("===");  //--------------------------------------
				
			
			ArrayList<ScratchProtect> list10=simpleDAO.getScratchProtects();
			for (ScratchProtect current:list10){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			ScratchProtect scratchProtect=simpleDAO.getScratchProtect(1);
			System.out.println(""+scratchProtect.getId()+scratchProtect.getName());			
			
			
			System.out.println("===");  //--------------------------------------			
			
			ArrayList<ScreenResolution> list11=simpleDAO.getScreenResolutions();
			for (ScreenResolution current:list11){
				System.out.println(""+current.getId()+current.getResolution());
			}
			System.out.println("===");
			
			ScreenResolution screenResolution=simpleDAO.getScreenResolution(1);
			System.out.println(""+screenResolution.getId()+screenResolution.getResolution());			
			
			
			System.out.println("===");  //--------------------------------------				
			
			ArrayList<ScreenTechnology> list12=simpleDAO.getScreenTechnologies();
			for (ScreenTechnology current:list12){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			ScreenTechnology screenTechnology=simpleDAO.getScreenTechnology(1);
			System.out.println(""+screenTechnology.getId()+screenTechnology.getName());			
			
			
			System.out.println("===");  //--------------------------------------			
			
			ArrayList<SimCardFormat> list13=simpleDAO.getSimCardFormats();
			for (SimCardFormat current:list13){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			SimCardFormat simCardFormat=simpleDAO.getSimCardFormat(1);
			System.out.println(""+simCardFormat.getId()+simCardFormat.getName());			
			
			
			System.out.println("===");  //--------------------------------------				
			
			ArrayList<Manufacturer> list100=simpleDAO.getManufacturers();
			for (Manufacturer current:list100){
				System.out.println(""+current.getId()+current.getName());
				System.out.println("---->  "+current.getCountry().toString());
			}
			System.out.println("===");
			
			
			Manufacturer manufacturer=simpleDAO.getManufacturer(1);
			System.out.println(""+manufacturer.getId()+manufacturer.getName());
			
			manufacturer = new Manufacturer();
			manufacturer.setName("Added 2");
			manufacturer.setFullName("Added full 2");
			manufacturer.setCountry(new Country(21,""));
			simpleDAO.saveOrUpdate(manufacturer);
			
			list100=simpleDAO.getManufacturers();
			for (Manufacturer current:list100){
				System.out.println(""+current.getId()+current.getName());
				System.out.println("---->  "+current.getCountry().toString());
			}

			
			
			
			Role role=userDAO.getRole(1);
			System.out.println(""+role.getId()+role.getName());
			
			User user=userDAO.getUser(1);
			System.out.println(""+user.getId()+user.getName());	
			for (Role current:user.getRole()){
				System.out.println("--> "+current.getId()+current.getName());
			}
			
			ArrayList<User> list14 =userDAO.getUsers();
			for (User current:list14){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			
			ArrayList<Role> list15 = userDAO.getRoles();
			for (Role current:list15){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
						
			ArrayList<Role> list16 = userDAO.getRolesForUser(user);
			for (Role current:list16){
				System.out.println(""+current.getId()+current.getName());
			}

			System.out.println("===");
			
			String phone=simpleDAO.getInfo("phone");
			System.out.println(""+phone);
			System.out.println("===");
			
			ArrayList<Log> list17 = simpleDAO.getLog(10);
			for (Log current:list17){
				System.out.println(""+current.getId()+current.getInfo());
			}
			System.out.println("===");
			
			ArrayList<Log> list18 = simpleDAO.getLog(2,10);
			for (Log current:list18){
				System.out.println(""+current.getId()+current.getInfo());
			}
			System.out.println("===");
			
			PhoneDAO phoneDAO=PhoneDAO.startDAO();
			
			ArrayList<Phone> list19=phoneDAO.getPhones();
			for (Phone current:list19){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");

			
			Phone phone2=phoneDAO.getPhone(1);
			System.out.println(""+phone2.getId()+phone2.getName());

			ArrayList<Photo> list20=phoneDAO.getPhotos(phone2);
			for (Photo current:list20){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");			

			Photo photo=phoneDAO.getMainPhoto(phone2);
			System.out.println("getMainPhoto:  "+photo.getId()+photo.getName());
			
			photo=phoneDAO.getPhoto(1);
			System.out.println("getPhoto:  "+photo.getId()+photo.getName());
			
			System.out.println("===");	

			ArrayList<Price> list21=phoneDAO.getPrices(phone2);
			for (Price current:list21){
				System.out.println(""+current.getId()+current.getPrice());
			}
			System.out.println("===");					
			
			Price price = phoneDAO.getLastPrice(phone2);
			System.out.println("getLastPrice:  "+price.getId()+price.getPrice());
			
			price = phoneDAO.getPrice(1);
			System.out.println("getLastPrice:  "+price.getId()+price.getPrice());
	
			ArrayList<Shop> list22=simpleDAO.getShops();
			for (Shop current:list22){
				System.out.println(""+current.getId()+current.getName());
			}
			System.out.println("===");
			
			
			Shop shop = simpleDAO.getShop(1);
			System.out.println(":  "+shop.getId()+shop.getName());
			
			System.out.println("=========================================================");
			
			
		Phone phone1=(Phone)phoneDAO.get(Phone.class,1);
//			Photo photo=new Photo(0, "photo3", "comment3", "Phn", phone1);
//			
//			HashSet<Photo> photos1=new HashSet<Photo>();
//			photos1.add((Photo)phoneDAO.get(Photo.class,1));
//			photos1.add((Photo)phoneDAO.get(Photo.class,2));
//
//			phone1.setPhoto(photos1);
//			phoneDAO.saveOrUpdate(phone1);
			
			phone1=(Phone)phoneDAO.get(Phone.class,1);
			
			Set<Photo> list = phone1.getPhotos();
			System.out.println(""+list.size());
		
			for(Photo photo: list){
				System.out.println(""+photo.getId()+", "+photo.getName());
			}
			System.out.println("=========================================================");
			
			Phone phone2=phoneDAO.getPhone(2);
			BodyColor bc1=simpleDAO.getBodyColor(1);
			HashSet<BodyColor> list3 = new HashSet<BodyColor>();
			list3.add(bc1);
			bc1=simpleDAO.getBodyColor(2);
			list3.add(bc1);
			bc1=simpleDAO.getBodyColor(3);
			list3.add(bc1);
			phone2.setBodyColor(list3);
			phoneDAO.saveOrUpdate(phone2);
			
			System.out.println("     Saved....");
			phone1=phoneDAO.getPhone(2);
			Set<BodyColor> colors=phone1.getBodyColor();
			System.out.println(colors.size());
			for(BodyColor bc: colors){
				System.out.println(""+bc.getId()+", "+bc.getName());
			}
			
			
////			photos1.add(photo);
////			phone1.setPhotos(photos1);
////			phoneDAO.saveOrUpdate(phone1);
//			 
//			
//			
//			HashSet<Photo> photos=new HashSet<Photo>(); 
//
//			Phone phone= new Phone(3, "phone3"
//					,(Os)simpleDAO.get(Os.class, 1)
//					,(ScreenResolution)simpleDAO.get(ScreenResolution.class, 1)
//					,(ScreenTechnology)simpleDAO.get(ScreenTechnology.class, 1)
//					,(BodyType)simpleDAO.get(BodyType.class, 1)
//					,(PhoneType)simpleDAO.get(PhoneType.class, 1)
//					,(ScratchProtect)simpleDAO.get(ScratchProtect.class, 1)
//					,(Processor)simpleDAO.get(Processor.class, 1)
//					,(Manufacturer)simpleDAO.get(Manufacturer.class, 1)
//					,(BatteryType)simpleDAO.get(BatteryType.class, 1)
//					,(SimCardFormat)simpleDAO.get(SimCardFormat.class, 1),
//					photos);
//			phoneDAO.saveOrUpdate(phone);
//			Phone phone=(Phone)phoneDAO.get(Phone.class,1);
//			System.out.println(phone.getId()+", "+phone.getName());
//			
//			Set<Photo> photos=(Set<Photo>) phone.getPhoto();
//			System.out.println(photos.size());
*/
			
			ArrayList<User> userList=userDAO.getUsers();
			for(User current: userList){
				System.out.println(""+current.getId()+", "+current.getName());
				for(Role role: current.getRole()){
					System.out.println(" --- "+role.getId()+", "+role.getName());
					
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
