package ua.com.clothes_shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.clothes_shop.service.ColorService;
import ua.com.clothes_shop.service.ItemOfClothingService;

@Controller
@RequestMapping("/admin/ioc")
public class ItemOfClothingController {
	
	@Autowired
	private ItemOfClothingService itemOfClothingService;
	
	@Autowired
	private ColorService colorService;
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("itemsOfClothing", itemOfClothingService.findAll());
		return "admin-itemOfClothing";
	}

		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			itemOfClothingService.delete(id);
			return "redirect:/admin/ioc";
		}
		

}
