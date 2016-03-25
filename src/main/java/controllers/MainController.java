package controllers;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import workset.beans.entities.Manufacturer;
import workset.beans.entities.User;
import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.dao.dao.exceptions.DAOException;
import workset.services.Service;

@Controller
@SessionAttributes({"user"})
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
		System.out.println("Мы в контроллере");

		return "index";
	}
	
	@RequestMapping(value = {"/List"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String list(
//			@RequestParam(value = "variant", defaultValue="", required=false) String variant,
//			@RequestParam(value = "id", defaultValue="0", required=false) int id,
//			@RequestParam(value = "adminpanel", defaultValue="false", required=false) boolean adminpanel,
			HttpServletRequest request,Locale locale, Model model) {
		
		System.out.println("Мы в листе");
//		model.addAttribute("list", phoneDAO.getPhones());
		try {
			ArrayList<Manufacturer> list=simpleDAO.getManufacturers();
			model.addAttribute("list", list);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "List";
	}
	
//	@ModelAttribute("user")
//	public LinkedList<OilStuff> createOilStuffFilter(){
//		LinkedList<OilStuff> list = new LinkedList<OilStuff>(oilStuffDAO.getOilStuffs());
//		
//		return list;
//	}

}
