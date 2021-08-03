package com.cml.demo.corunet.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cml.demo.corunet.model.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

	@Query( value = "SELECT * FROM PRICES WHERE BRAND_ID = :brandId AND PRODUCT_ID = :productId AND :date BETWEEN STAR_DATE AND END_DATE ORDER BY PRIORITY DESC",
			nativeQuery = true)
    Optional<List<Prices>> findProductOfBrandPriceAtMoment(
    		@Param("brandId") int brandID,
    		@Param("productId") int productId,
    		@Param("date") Date date);	
	
}
