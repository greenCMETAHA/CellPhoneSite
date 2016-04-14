package controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.services.Service;

@Controller
@SessionAttributes({"user", "basket", "wishList"})
public class ErrorController {
	
	@Autowired
	SimpleDAO simpleDAO;
	
	@Autowired
	PhoneDAO phoneDAO;

	@Autowired
	UserDAO userDAO;
	

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex,
			@RequestParam(value = "variant", defaultValue = "", required = false) String variant,
			@RequestParam(value = "id", defaultValue = "0", required = false) int id, HttpServletRequest request,
			Locale locale) {
		
		System.out.println("ErrorController");

		ModelAndView model = new ModelAndView("errorPage");
		model.addObject("errNumber", "Ошибка");
		model.addObject("errMessage", ex.getMessage());
		String strMessage = ex.getMessage();
		if (strMessage.length() > 185) {
			strMessage = strMessage.substring(0, 185);
		}
//
//		try {
//			Service.sendTheErrorToAdmin(ex.getMessage(), infoDAO.getInfo(Service.ADMIN_EMAIL));
//		} catch (Exception e) {
//			Service.sendTheErrorToAdmin(ex.getMessage(), "phylife@mail.ru");
//
//		}
//
//		try {
//			User user = Service.getUser(request.getUserPrincipal(), logDAO, userDAO);
//			logDAO.createLog(new Log(0, user, new GregorianCalendar().getTime(), null, "!!!Ошибка: " + strMessage));
//		} catch (Exception e) {
//			// ---
//		}

		return model;

	}

	@RequestMapping(value = "/error", method = { RequestMethod.POST, RequestMethod.GET })
	public String errorGlobal(@RequestParam(value = "variant", defaultValue = "", required = false) String variant,
			@RequestParam(value = "id", defaultValue = "0", required = false) int id, HttpServletRequest request,
			Locale locale, Model model) {

		Service.defaultAttributes(model, simpleDAO, userDAO, request);
		
		
		model.addAttribute("errNumber", "403");
		model.addAttribute("errMessage", "У Вас нет доступа к этой странице.");
		System.out.println("/error");

		return "ErrorPage";
	}	
	
	
	 @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	 public String viewEdit(@PathVariable("name") final String name, Model model
			,HttpServletRequest request,HttpServletResponse response) {
		
		 Service.defaultAttributes(model, simpleDAO, userDAO, request);
		 
		 System.out.println("/{name}");
		 return "Page404";

    }	

}
