package ua.com.clothes_shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.clothes_shop.service.BrandService;

@Controller
//якщо над класом стоїть @RequestMapping з посиланням це означає що всі такі анотації
//продовжують це посилання якщо мають такий атрибут, якщо ж не мають то працюють за цим посиланням
@RequestMapping("/admin/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	//тут немає посилання тому цей метод спрацює за посиланням /admin/brand та методом GET
	@RequestMapping
	//все що нам потрібно можна прописати у вхідних параметрах і спрінг передасть це в метод
	public String show(Model model){
		//Model інтерфейс за допомогою якого передаємо дані на представлення
		//перший параметр методу вказує яке буде імя в списку категорій на представлені
		model.addAttribute("brands", brandService.findAll());
		return "admin-brand";
	}
	//а цей метод спрацює за посиланням /admin/brand/delete/{якась цифра}
		@RequestMapping("/delete/{id}")
		//@PathVariable - анотація яка витягує певну змінну частину з посилання
		//використовується тоді коли посилання без цієї частини не працює
		//в цьому прикладі додаток не реагує на посилання /admin/brand/delete
		//також можна відразу вказати необхідний тип даних в результаті виконання цього методу
		//обов'язково потрібно перенаправити користувача на інше посилання
		//тому що якщо користувач залишиться за цим посиланням і оновить сторінку то викличе повторне спрацьовування цього методу, а такого id в базі вже немає(
		public String delete(@PathVariable int id){
			brandService.delete(id);
			return "redirect:/admin/brand";
		}
		
		//вказуємо що це метод POST (статичний імпорт)
		@RequestMapping(method=POST)
		//вказуємо що в параметрах буде параметр name
		//може бути кілька @RequestParam, просто ставимо кому після brandName, і пишемо знов @RequestParam тип і назву
		public String save(@RequestParam String brandName){
			//передаємо в сервіс для збереження об'єкту Brand
			brandService.save(brandName);
			//після пост методів в більшості випадків потрібно робити радірект, щоб запобігти
			//повторній відправці форми після редіректу всі параметри будуть видалені
			return "redirect:/admin/brand";
		}

}
