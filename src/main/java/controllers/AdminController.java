package controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;

@Controller
@SessionAttributes({"user", "basket", "wishList"})
public class AdminController {
	@Autowired
	SimpleDAO simpleDAO;
	
	@Autowired
	PhoneDAO phoneDAO;

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = { "/AdminPanel"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String logout(
			HttpServletRequest request,Locale locale, Model model) {
		
		model.addAttribute("isAdmin", true);
		
		return "AdminPanel";  //login
	}	
}
