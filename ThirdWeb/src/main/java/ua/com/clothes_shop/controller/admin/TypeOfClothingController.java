package ua.com.clothes_shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.clothes_shop.service.TypeOfClothingService;

@Controller
@RequestMapping("/admin/toc")
public class TypeOfClothingController {
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	@RequestMapping
	public String show(Model model){
		model.addAttribute("typesOfClothing", typeOfClothingService.findAll());
		return "admin-typeOfClothing";
	}

		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			typeOfClothingService.delete(id);
			return "redirect:/admin/toc";
		}
		
		@RequestMapping(method=POST)
		public String save(@RequestParam String itemType){
			typeOfClothingService.save(itemType);
			return "redirect:/admin/toc";
		}

}
