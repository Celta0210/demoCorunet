package com.cml.demo.corunet.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cml.demo.corunet.exception.ResourceNotFoundException;
import com.cml.demo.corunet.model.Prices;
import com.cml.demo.corunet.repository.PricesRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/cml")
public class PricesController {

	public static final String  ErrorFormat = "Product {0} of Brand {1} at date {2} not found";
	@Autowired	
	PricesRepository pricesRepository;

	public PricesController (){
		super();
	}

	@GetMapping("/products/{productId}/prices")
	public ResponseEntity<Prices> getProductOfBrandPriceAtMoment(
			@PathVariable(value = "productId") int productId,
			@RequestParam(required = true) int brandId, 
			@RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss") Date date)
			throws ResourceNotFoundException {
		List<Prices> prices = pricesRepository.findProductOfBrandPriceAtMoment(brandId, productId, date)
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorFormat,productId,brandId,date)));

	
		return ResponseEntity.ok().body(prices.get(0));
	}	
	
	@GetMapping("/prices")
	public List < Prices > getAllEmployees() {
		
        return pricesRepository.findAll().stream().filter(prices -> (prices.getPrice() > 31)).collect(Collectors.toList());
    }
}
