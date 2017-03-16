package ua.com.clothes_shop.service;

import java.util.List;

import ua.com.clothes_shop.entity.ItemOfClothing;

public interface ItemOfClothingService {
	
    void save(ItemOfClothing itemOfClothing);
	
	List<ItemOfClothing> findAll();
	
	List<ItemOfClothing> findAllWithoutColorsAndSizes();
	
	ItemOfClothing findOne(int id);
	
	void delete(int id);
	
	void update (ItemOfClothing itemOfClothing);
	
	ItemOfClothing findByMarking(int marking);
	
	List<ItemOfClothing> findByColor(int id);
	
	List<ItemOfClothing> findByBrandId (int id);
	
	List<ItemOfClothing> findByTargetAudienceId (int id);
	
	List<ItemOfClothing> findByTypeOfClothingId (int id);
	
	List<ItemOfClothing> findBySizeId (int id);

}
