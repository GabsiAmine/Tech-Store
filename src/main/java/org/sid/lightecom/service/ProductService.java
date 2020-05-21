package org.sid.lightecom.service;

import java.util.HashSet;
import java.util.Set;

import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.MagasinRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Magasin;
import org.sid.lightecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private MagasinRepository magasinRepository;	
	@Autowired
	private CategoryRepository categoryRepository;
	 
	
	public void serviceAddProduct(Product product) {
		
		Category cat = categoryRepository.findById((long) 1).get();
				
		Product p = new Product();
		p.setName(product.getName());	
		p.setDesciption(product.getDesciption());
		p.setCurrentprice(product.getCurrentprice());
		p.setPromotion(product.isPromotion());
		p.setCategory(cat);
		productRepository.save(p);
		System.out.println("Service is ok");
				
	}
		
	
	
	
	
	
	
	



}