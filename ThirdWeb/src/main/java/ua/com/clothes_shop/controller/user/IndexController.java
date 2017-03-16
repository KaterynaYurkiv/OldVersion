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
	
	
	//��� ����� ���� ��������� �� ����� ���������� ����� �� ����
	@RequestMapping("/")
	public String index(){
		//������� �������� index.jsp (� ����� user)
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
	
	//� ��� ��� ���� ���������� ������� �� �o������� /admin
	@RequestMapping("/admin")
	public String admin(){
		//��� admin.jsp (� ����� admin)
		return "admin-admin";
	}
	
}
