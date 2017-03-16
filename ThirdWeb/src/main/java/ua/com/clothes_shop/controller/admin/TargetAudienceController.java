package ua.com.clothes_shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.clothes_shop.service.TargetAudienceService;

@Controller
@RequestMapping("/admin/targeta")
public class TargetAudienceController {
	
	@Autowired
	private TargetAudienceService targetAudienceService;
	@RequestMapping
	public String show(Model model){
		model.addAttribute("targetAudiences", targetAudienceService.findAll());
		return "admin-targetAudience";
	}

		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			targetAudienceService.delete(id);
			return "redirect:/admin/targeta";
		}
		
				@RequestMapping(method=POST)
				public String save(@RequestParam String category){
					targetAudienceService.save(category);
					return "redirect:/admin/targeta";
				}

}
