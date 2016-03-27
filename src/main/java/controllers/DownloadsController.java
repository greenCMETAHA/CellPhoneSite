package controllers;

import java.util.Locale;

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

import workset.dao.dao.PhoneDAO;
import workset.dao.dao.SimpleDAO;
import workset.dao.dao.UserDAO;

@Controller
@SessionAttributes({"user", "basket", "wishList"})
public class DownloadsController {
	@Autowired
	PhoneDAO phoneDAO;
	
	@RequestMapping(value = "/downloadPhones", method = {RequestMethod.POST, RequestMethod.GET})
	public String downloadPhones(
			@RequestParam(value = "fileExcel", required = false) MultipartFile fileExcel,
			HttpServletRequest request,Locale locale, Model model) {

		model.addAttribute("header", "Файл с информацией по телефонам загружен");

		return "AdminPanel";
	}

	@RequestMapping(value = "/downloadPhonePrices", method = {RequestMethod.POST, RequestMethod.GET})
	public String downloadPhonePrices(
			@RequestParam(value = "fileExcel", required = false) MultipartFile fileExcel,
			HttpServletRequest request,Locale locale, Model model) {

		
		model.addAttribute("header", "Файл с ценами по телефонам загружен");

		return "AdminPanel";
	}
	
	@RequestMapping(value = "/downloadPhonePhotos", method = {RequestMethod.POST, RequestMethod.GET})
	public String downloadPhonePhotos(
			@RequestParam(value = "fileExcel", required = false) MultipartFile fileExcel,
			HttpServletRequest request,Locale locale, Model model) {

		model.addAttribute("header", "Файл с фотографиями телефонов загружен");

		return "AdminPanel";
	}
		

}
