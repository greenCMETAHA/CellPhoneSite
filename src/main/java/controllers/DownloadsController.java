package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import workset.beans.entities.Phone;
import workset.beans.entities.Price;
import workset.beans.entities.User;
import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;
import workset.services.Service;
import workset.services.WorkWithExcel;

@Controller
@SessionAttributes({"user", "basket", "wishList"})
public class DownloadsController {
	@Autowired
	SimpleDAO simpleDAO;
	
	@Autowired
	PhoneDAO phoneDAO;

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/downloadPhones", method = {RequestMethod.POST, RequestMethod.GET})
	public String downloadPhones(
			@RequestParam(value = "fileExcel", required = false) MultipartFile fileExcel,
			HttpServletRequest request,Locale locale, Model model) {
		
		User user=userDAO.getUser(1); //временная загрушка
		
		ArrayList<String> list=new ArrayList<String>();	//list - список с ошибками при загрузке 
		list=WorkWithExcel.downloadExcel("Product", Service.PHONES_PREFIX, user, fileExcel, simpleDAO, phoneDAO, userDAO, request.getSession());
		if (list.size()==0){
			model.addAttribute("header", "Файл с информацией по телефонам загружен");
		}else{
			model.addAttribute("header", "Файл с информацией по телефонам загружен с ошибками");
		}
		model.addAttribute("list",list);

		return "AdminPanel";
	}

	@RequestMapping(value = "/downloadPhonePrices", method = {RequestMethod.POST, RequestMethod.GET})
	public String downloadPhonePrices(
			@RequestParam(value = "fileExcel", required = false) MultipartFile fileExcel,
			HttpServletRequest request,Locale locale, Model model) {

		User user=userDAO.getUser(1); //временная загрушка
		
		ArrayList<String> list=new ArrayList<String>();	//list - список с ошибками при загрузке 
		list=WorkWithExcel.downloadExcel("Price", Service.PHONES_PREFIX, user, fileExcel, simpleDAO, phoneDAO, userDAO, request.getSession());
		if (list.size()==0){
			model.addAttribute("header", "Файл с ценами по телефонам загружен");
		}else{
			model.addAttribute("header", "Файл с ценами по телефонам загружен с ошибками");
		}
		model.addAttribute("list",list);
		
		ArrayList<Phone> ll=phoneDAO.getPhones();
		for (Phone current: ll){
			System.out.println(current.getName());
			Set<Price> pp= current.getPrices();
			for (Price price: pp){
				System.out.println(" --- "+price.getTime()+":  "+price.getPrice());
			}
			
		}
		
		
		return "AdminPanel";
	}
	
	@RequestMapping(value = "/downloadPhonePhotos", method = {RequestMethod.POST, RequestMethod.GET})
	public String downloadPhonePhotos(
			@RequestParam(value = "fileExcel", required = false) MultipartFile fileExcel,
			HttpServletRequest request,Locale locale, Model model) {

		User user=userDAO.getUser(1); //временная загрушка
		
		ArrayList<String> list=new ArrayList<String>();	//list - список с ошибками при загрузке 
		list=WorkWithExcel.downloadExcel("Photo", Service.PHONES_PREFIX, user, fileExcel, simpleDAO, phoneDAO, userDAO, request.getSession());
		if (list.size()==0){
			model.addAttribute("header", "Файл с фотографиями телефонов загружен");
		}else{
			model.addAttribute("header", "Файл с фотографиями телефонов загружен с ошибками");
		}		
		model.addAttribute("list",list); 
		
		return "AdminPanel";
	}
		

}
