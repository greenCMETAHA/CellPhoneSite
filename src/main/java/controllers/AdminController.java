package controllers;

import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import workset.beans.entities.Log;
import workset.beans.entities.User;
import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.dao.dao.exceptions.DAOException;
import workset.services.Service;

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
	
	@RequestMapping(value = { "/login"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String login(
			@RequestParam(value = "variant", defaultValue="", required=false) String variant
			,@RequestParam(value = "id", defaultValue="0", required=false) int id
			,HttpServletRequest request,Locale locale, Model model) {
		
		HttpSession session=request.getSession();
		User user=Service.getUser(request.getUserPrincipal(), userDAO);
			
		return "login";
	}	
	
	@RequestMapping(value = { "/logout"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String logout(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		HttpSession session=request.getSession();
		User user=Service.getUser(request.getUserPrincipal(), userDAO);
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
        	try {
				simpleDAO.saveOrUpdate(new Log(user, new GregorianCalendar().getTime(), "User", ""+user.getId(), user.getName()
							,"Пользователь вышел из системы"));
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            (new SecurityContextLogoutHandler()).logout(request, response, auth);
        }		
		
		return "redirect:index";
	}			
}
