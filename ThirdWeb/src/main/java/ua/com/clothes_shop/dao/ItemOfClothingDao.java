package ua.com.clothes_shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.clothes_shop.entity.ItemOfClothing;

public interface ItemOfClothingDao extends JpaRepository<ItemOfClothing, Integer>{
	
	ItemOfClothing findByMarking(int marking);
	
	//робимо distinct, щоб вит€гувати екземпл€рм, €к≥ в≥др≥зн€ютьс€
	@Query("SELECT distinct i FROM ItemOfClothing i LEFT JOIN FETCH i.brand LEFT JOIN FETCH i.targetAudience LEFT JOIN FETCH i.typeOfClothing JOIN FETCH i.colors")
	List<ItemOfClothing> findAll();
	
	@Query("SELECT i FROM ItemOfClothing i LEFT JOIN FETCH i.brand LEFT JOIN FETCH i.targetAudience LEFT JOIN FETCH i.typeOfClothing")
	List<ItemOfClothing> findAllWithoutColorsAndSizes();
	
	@Query("SELECT i FROM ItemOfClothing i JOIN i.colors c WHERE c.id = ?1")
	List<ItemOfClothing> findByColor(int id);
	
	@Query("SELECT i FROM ItemOfClothing i WHERE i.brand.id = ?1")
	List<ItemOfClothing> findByBrandId(int id);
	
	@Query("SELECT i FROM ItemOfClothing i WHERE i.targetAudience.id = ?1")
	List<ItemOfClothing> findByTargetAudienceId(int id);
	
	@Query("SELECT i FROM ItemOfClothing i WHERE i.typeOfClothing.id = ?1")
	List<ItemOfClothing> findByTypeOfClothingId(int id);
	
	@Query("SELECT i FROM ItemOfClothing i JOIN i.sizes s WHERE s.id = ?1")
	List<ItemOfClothing> findBySizeId(int id);

}
