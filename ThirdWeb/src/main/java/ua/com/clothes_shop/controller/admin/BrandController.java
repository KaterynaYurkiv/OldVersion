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
//���� ��� ������ ����� @RequestMapping � ���������� �� ������ �� �� ��� ��������
//����������� �� ��������� ���� ����� ����� �������, ���� � �� ����� �� �������� �� ��� ����������
@RequestMapping("/admin/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	//��� ���� ��������� ���� ��� ����� ������� �� ���������� /admin/brand �� ������� GET
	@RequestMapping
	//��� �� ��� ������� ����� ��������� � ������� ���������� � ����� ��������� �� � �����
	public String show(Model model){
		//Model ��������� �� ��������� ����� �������� ��� �� �������������
		//������ �������� ������ ����� ��� ���� ��� � ������ �������� �� �����������
		model.addAttribute("brands", brandService.findAll());
		return "admin-brand";
	}
	//� ��� ����� ������� �� ���������� /admin/brand/delete/{����� �����}
		@RequestMapping("/delete/{id}")
		//@PathVariable - �������� ��� ������ ����� ����� ������� � ���������
		//��������������� ��� ���� ��������� ��� ���� ������� �� ������
		//� ����� ������� ������� �� ����� �� ��������� /admin/brand/delete
		//����� ����� ������ ������� ���������� ��� ����� � ��������� ��������� ����� ������
		//����'������ ������� ������������� ����������� �� ���� ���������
		//���� �� ���� ���������� ���������� �� ��� ���������� � ������� ������� �� ������� �������� �������������� ����� ������, � ������ id � ��� ��� ����(
		public String delete(@PathVariable int id){
			brandService.delete(id);
			return "redirect:/admin/brand";
		}
		
		//������� �� �� ����� POST (��������� ������)
		@RequestMapping(method=POST)
		//������� �� � ���������� ���� �������� name
		//���� ���� ����� @RequestParam, ������ ������� ���� ���� brandName, � ������ ���� @RequestParam ��� � �����
		public String save(@RequestParam String brandName){
			//�������� � ����� ��� ���������� ��'���� Brand
			brandService.save(brandName);
			//���� ���� ������ � ������� ������� ������� ������ �������, ��� ��������
			//�������� �������� ����� ���� �������� �� ��������� ������ �������
			return "redirect:/admin/brand";
		}

}
