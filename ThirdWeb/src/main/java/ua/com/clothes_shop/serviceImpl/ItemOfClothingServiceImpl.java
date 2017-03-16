package ua.com.clothes_shop.serviceImpl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.clothes_shop.dao.ColorDao;
import ua.com.clothes_shop.dao.ItemOfClothingDao;
import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.service.ItemOfClothingService;

@Service //в контексті спрінга створює біни
public class ItemOfClothingServiceImpl implements ItemOfClothingService{
	
	@Autowired
	private ItemOfClothingDao itemOfClothingDao;
	
	@Autowired
	private ColorDao colorDao;

	@Override
	public void save(ItemOfClothing itemOfClothing) {
		itemOfClothingDao.save(itemOfClothing);
	}

	@Override
	@Transactional
	public List<ItemOfClothing> findAll() {
		 List<ItemOfClothing> list = itemOfClothingDao.findAll();
		 for (ItemOfClothing itemOfClothing : list) {
			Hibernate.initialize(itemOfClothing.getSizes());
		}
		return itemOfClothingDao.findAll();
	}
	
	@Override
	public List<ItemOfClothing> findAllWithoutColorsAndSizes() {
		
		return itemOfClothingDao.findAllWithoutColorsAndSizes();
	}

	@Override
	public ItemOfClothing findOne(int id) {
		return itemOfClothingDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		itemOfClothingDao.delete(id);
	}

	@Override
	public void update(ItemOfClothing itemOfClothing) {
		itemOfClothingDao.save(itemOfClothing);
	}

	@Override
	public ItemOfClothing findByMarking(int marking) {
		return itemOfClothingDao.findByMarking(marking);
	}

    @Override
    public List<ItemOfClothing> findByColor(int id) {
    	return itemOfClothingDao.findByColor(id);
}

	@Override
	public List<ItemOfClothing> findByBrandId(int id) {
		return itemOfClothingDao.findByBrandId(id);
	}

	@Override
	public List<ItemOfClothing> findByTargetAudienceId(int id) {
		return itemOfClothingDao.findByTargetAudienceId(id);
	}

	@Override
	public List<ItemOfClothing> findByTypeOfClothingId(int id) {
		return itemOfClothingDao.findByTypeOfClothingId(id);
	}

	@Override
	public List<ItemOfClothing> findBySizeId(int id) {
		return itemOfClothingDao.findBySizeId(id);
	}


}
