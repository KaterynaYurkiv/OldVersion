package ua.com.clothes_shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.clothes_shop.service.SizeService;

@Controller
@RequestMapping("/admin/size")
public class SizeController {
	
	@Autowired
	private SizeService sizeService;
	@RequestMapping
	public String show(Model model){
		model.addAttribute("sizes", sizeService.findAll());
		return "admin-size";
	}

		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			sizeService.delete(id);
			return "redirect:/admin/size";
		}
		
				@RequestMapping(method=POST)
				public String save(@RequestParam String size){
					sizeService.save(size);
					return "redirect:/admin/size";
				}

}
