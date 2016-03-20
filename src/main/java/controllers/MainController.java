package controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import workset.beans.entities.User;
import workset.services.Service;

@Controller
@SessionAttributes({"user"})
public class MainController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/index"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String index(
//			@RequestParam(value = "variant", defaultValue="", required=false) String variant,
//			@RequestParam(value = "id", defaultValue="0", required=false) int id,
//			@RequestParam(value = "adminpanel", defaultValue="false", required=false) boolean adminpanel,
			HttpServletRequest request,Locale locale, Model model) {

		HttpSession session=request.getSession();
	
//		User user=Service.getUser(request.getUserPrincipal(), logDAO, userDAO);
//		if (user.getId()!=0){
//			logDAO.createLog(new Log(0, user, new GregorianCalendar().getTime(), user, "Пользователь зашел в систему"));
//		}
//		
//		LinkedList<Basket>  basket =  (LinkedList<Basket>) session.getAttribute("basket");
//		if (basket==null){
//			basket=createBasket();
//		}
//		LinkedList<Wishlist>  wishlist =  (LinkedList<Wishlist>) session.getAttribute("wishlist");
//		if (wishlist==null){
//			wishlist=createWishlist();
//		}
//		if (user.getId()>0){
//			wishlist=wishlistDAO.getWishList(user.getId());
//		}
//		
//		LinkedList<InterfaceGood> compare = (LinkedList<InterfaceGood>) session.getAttribute("compare");
//		if (compare==null){
//			compare=createComparement();
//		}
//		
//		Service.workWithList(id, Service.BRAKING_FLUID_PREFIX, 0, false, variant, user, basket, wishlist, compare, brakingFluidDAO, motorOilDAO, gearBoxOilDAO
//				, logDAO, clientDAO, manufacturerDAO, offerStatusDAO,  infoDAO, demandDAO, payDAO, wishlistDAO, session, 0,0, 0, 1, new Customer());
//		
//		session.setAttribute("user", user);
//		session.setAttribute("basket", basket);
//		session.setAttribute("wishlist", wishlist);
//		session.setAttribute("compare", compare);
//			
//		//model.addAttribute("user", user);
//		model.addAttribute("user", user);
//		model=Service.createHeader(model, user, basket,wishlist, compare, infoDAO, wishlistDAO);

		return "index";
	}
	
	
	
//	@ModelAttribute("user")
//	public LinkedList<OilStuff> createOilStuffFilter(){
//		LinkedList<OilStuff> list = new LinkedList<OilStuff>(oilStuffDAO.getOilStuffs());
//		
//		return list;
//	}

}
