package org.sid.lightecom.web;

import org.sid.lightecom.entities.Product;
import org.sid.lightecom.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class ProductRestController {

	private ProductService productService;
	
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}
	

	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Product p){
		 productService.serviceAddProduct(p);	
		 System.out.println("REst is ok");
	}
}
