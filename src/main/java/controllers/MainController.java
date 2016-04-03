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

		HttpSession session=request.getSession();

		return "index";
	}
	
	@RequestMapping(value = {"/Catalog"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String list(
//			@RequestParam(value = "variant", defaultValue="", required=false) String variant,
//			@RequestParam(value = "id", defaultValue="0", required=false) int id,
//			@RequestParam(value = "adminpanel", defaultValue="false", required=false) boolean adminpanel,
			HttpServletRequest request,Locale locale, Model model) {
		
//		model.addAttribute("list", phoneDAO.getPhones());
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Список товаров:");
	
		return "Catalog";
	}
	
	@RequestMapping(value = {"/About"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String about(
			HttpServletRequest request,Locale locale, Model model) {
		
	
		return "About";
	}
	
	@RequestMapping(value = {"/Basket"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String basket(
			HttpServletRequest request,Locale locale, Model model) {
		
	
		return "Basket";
	}
	
	@RequestMapping(value = {"/Profile"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String profile(
			HttpServletRequest request,Locale locale, Model model) {
		
	
		return "Profile";
	}
	
	@RequestMapping(value = {"/ShopAddresses"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String shopAddresses(
			HttpServletRequest request,Locale locale, Model model) {
		
		ArrayList<Shop> list=simpleDAO.getShops();
		model.addAttribute("list", list);
	
		return "ShopAddresses";
	}
	
	@RequestMapping(value = {"/WayToPay"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String wayToPay(
			HttpServletRequest request,Locale locale, Model model) {
		
	
		return "WayToPay";
	}
	
	@RequestMapping(value = {"/searchThing"}, method ={RequestMethod.GET, RequestMethod.POST})   //хз, почему он не отрабатывает на Search
	public String searchThing(
			@RequestParam(value = "searchField", defaultValue="", required=false) String searchField
			,@RequestParam(value = "searchButton", defaultValue="", required=false) String searchButton
			,HttpServletRequest request,Locale locale, Model model) {

		
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Результаты поиска:");		
	
		return "Catalog";

	}
		 		
		
	@RequestMapping(value = {"/Select"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String select(
			HttpServletRequest request,Locale locale, Model model) {
		
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Результаты отбора:");
		
		return "Catalog";
	}
	
	@RequestMapping(value = {"/Compare"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String compare(
			HttpServletRequest request,Locale locale, Model model) {
		
		ArrayList<Phone> list=phoneDAO.getPhones(1);
		model.addAttribute("list", list);
		model.addAttribute("header", "Сравним товары:");
		
		return "Compare";
	}
	
	@RequestMapping(value = { "/login"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String login(
			HttpServletRequest request,Locale locale, Model model) {
		
		System.out.println("login");
		return "Page404";  //login
	}	
	
	@RequestMapping(value = { "/logout"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String logout(
			HttpServletRequest request,Locale locale, Model model) {
		
		System.out.println("logout");
		return "Page404";  //login
	}	
	

	
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
