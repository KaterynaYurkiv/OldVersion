package ua.com.clothes_shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.clothes_shop.service.ColorService;
import ua.com.clothes_shop.service.ItemOfClothingService;

@Controller
public class IndexController {
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private ItemOfClothingService itemOfClothingService;
	
	
	//цей метод буде працювати як тільки користувач зайде на сайт
	@RequestMapping("/")
	public String index(){
		//потрібно показати index.jsp (в папці user)
		return "user-index";
	}
	
//	@RequestMapping("/")
//	public String index(Model model){
//		model.addAttribute("colors", colorService.findAll());
//		return "user-index";
//	}
	
//	@RequestMapping("/color/{id}")
//	public String category(@PathVariable int id, Model model){
//		model.addAttribute("color", colorService.findOne(id));
//		model.addAttribute("itemsOfClothing", itemOfClothingService.findByColor(id));
//		return "user-color";
//	}
	
	//а цей тоді коли користувач натисне на пoсилання /admin
	@RequestMapping("/admin")
	public String admin(){
		//тут admin.jsp (в папці admin)
		return "admin-admin";
	}
	
}
