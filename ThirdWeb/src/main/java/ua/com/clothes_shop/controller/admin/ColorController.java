package ua.com.clothes_shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.clothes_shop.entity.Color;
import ua.com.clothes_shop.service.ColorService;

@Controller
@RequestMapping("/admin/color")
public class ColorController {
	
	@Autowired
	private ColorService colorService;
	@RequestMapping
	public String show(Model model){
		model.addAttribute("colors", colorService.findAll());
		return "admin-color";
	}

		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			colorService.delete(id);
			return "redirect:/admin/color";
		}
		
				@RequestMapping(method=POST)
				public String save(@RequestParam String color){
					Color c = new Color();
					c.setColor(color);
					colorService.save(c);
					return "redirect:/admin/color";
				}


}
