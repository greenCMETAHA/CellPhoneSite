package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import workset.beans.entities.Basket;
import workset.beans.entities.Manufacturer;
import workset.beans.entities.Phone;
import workset.beans.entities.Shop;
import workset.beans.entities.User;
import workset.beans.interfaces.InterfaceBasket;
import workset.beans.interfaces.base.InterfaceGood;
import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.dao.dao.exceptions.DAOException;
import workset.services.Service;

@Controller
@SessionAttributes({"user", "basket", "wishList"})
public class MainController {
	
	@Autowired
	SimpleDAO simpleDAO;
	
	@Autowired
	PhoneDAO phoneDAO;

	@Autowired
	UserDAO userDAO;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/index"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String index(
//			@RequestParam(value = "variant", defaultValue="", required=false) String variant,
//			@RequestParam(value = "id", defaultValue="0", required=false) int id,
//			@RequestParam(value = "adminpanel", defaultValue="false", required=false) boolean adminpanel,
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		HttpSession session=request.getSession();

		return "index";
	}
	
	@RequestMapping(value = {"/FullCatalog"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String fullCatalog(HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		ArrayList<Phone> listPhones=phoneDAO.getPhones(1);
		
		ArrayList<Phone> listDesctops=new ArrayList<Phone>();

		model.addAttribute("listPhones", listPhones);
		model.addAttribute("listDesktops", listDesctops);
	
		return "FullCatalog";
	}	
	
	@RequestMapping(value = {"/Catalog"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String list(
//			@RequestParam(value = "variant", defaultValue="", required=false) String variant,
			@RequestParam(value = "phoneType", defaultValue="0", required=false) int phoneTypeValue,
			@RequestParam(value = "manufacturer", defaultValue="0", required=false) int manufacturerValue,
			@RequestParam(value = "page", defaultValue="1", required=false) int page,
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		ArrayList<Phone> list=new ArrayList<Phone>();
		if (phoneTypeValue!=0){
			list=phoneDAO.getPhonesByPhoneType(phoneTypeValue, page);
		}else if (manufacturerValue!=0){
			list=phoneDAO.getPhonesByManufacturer(manufacturerValue, page);
		}else{
			list=phoneDAO.getPhones();
		}

		model.addAttribute("list", list);
		model.addAttribute("header", "Список товаров:");
	
		return "Catalog";
	}
	
	@RequestMapping(value = {"/ShowOne"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String showOne(
			@RequestParam(value = "good", defaultValue="0", required=false) int good,
			HttpServletRequest request,Locale locale, Model model) {
		String result="index";
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		if (good!=0){
			model.addAttribute("good", phoneDAO.getPhone(good));
			result="ShowOne";
		}
	
		return result;
	}	
	
	
	@RequestMapping(value = {"/About"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String about(
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
	
		return "About";
	}
	
	@RequestMapping(value = {"/Basket"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String basket(
			@RequestParam(value = "good", defaultValue="", required=false) int goodId,
			@RequestParam(value = "back", defaultValue="", required=false) String backPage,
			HttpServletRequest request,Locale locale, Model model) {
		String result="Basket";
		
		HttpSession session=request.getSession();
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		HashSet<Basket>  basket =  (HashSet<Basket>) session.getAttribute("basket");
		if (basket==null){
			basket=createBasket();
		}
		if (goodId!=0){
			Phone phone=phoneDAO.getPhone(goodId);
			double price=phone.getPriceWithDiscount();
			basket.add(new Basket(phone,price,1));
		}
		
		if (backPage.length()>0){
			result="redirect:"+backPage;
		}else if (goodId>0){
			result="Catalog";
		}
		
		return result;
		
	}
	
	@RequestMapping(value = {"/Profile"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String profile(
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
	
		return "Profile";
	}
	
	@RequestMapping(value = {"/ShopAddresses"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String shopAddresses(
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		ArrayList<Shop> list=simpleDAO.getShops();
		model.addAttribute("list", list);
	
		return "ShopAddresses";
	}
	
	@RequestMapping(value = {"/WayToPay"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String wayToPay(
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
	
		return "WayToPay";
	}
	
	@RequestMapping(value = {"/searchThing"}, method ={RequestMethod.GET, RequestMethod.POST})   //хз, почему он не отрабатывает на Search
	public String searchThing(
			@RequestParam(value = "searchField", defaultValue="", required=false) String searchField
			,@RequestParam(value = "searchButton", defaultValue="", required=false) String searchButton
			,HttpServletRequest request,Locale locale, Model model) {

		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Результаты поиска:");		
	
		return "Catalog";

	}
		 		
		
	@RequestMapping(value = {"/Select"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String select(
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Результаты отбора:");
		
		return "Catalog";
	}
	
	@RequestMapping(value = {"/Compare"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String compare(
			HttpServletRequest request,Locale locale, Model model) {
		
		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Сравним товары:");
		
		return "Compare";
	}
//	
//	@RequestMapping(value = { "/login"}, method = {RequestMethod.POST, RequestMethod.GET})
//	public String login(
//			HttpServletRequest request,Locale locale, Model model) {
//		
//		System.out.println("login");
//		return "Page404";  //login
//	}	
//	
//	@RequestMapping(value = { "/logout"}, method = {RequestMethod.POST, RequestMethod.GET})
//	public String logout(
//			HttpServletRequest request,Locale locale, Model model) {
//		
//		System.out.println("logout");
//		return "Page404";  //login
//	}	
//	

	
	//атрибуты сессии
	
	@ModelAttribute("basket")
	public HashSet<Basket> createBasket(){
		HashSet<Basket> result = new HashSet<Basket>();
		
		return result;
	}
	
	@ModelAttribute("wishList")
	public HashSet<InterfaceGood> createWishList(){
		HashSet<InterfaceGood> result = new HashSet<InterfaceGood>();
		
		return result;
	}	
	
	
	@ModelAttribute("user")
	public User createUser(){
		User result = new User();
		
		return result;
	}

}
