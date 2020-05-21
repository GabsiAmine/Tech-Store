package org.sid.lightecom.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Product;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
public class CatalogueRestController {

	
	private ProductRepository productRepository;
	
	public CatalogueRestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping(path = "/photoproducts/{id}",produces = org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
		Product p = productRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ProjectImage/CatalogueWeb/products/"+p.getPhotoName()));
		
	}
	@PostMapping(path = "/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file,@PathVariable Long id) throws IOException {
		Product p = productRepository.findById(id).get();
		p.setPhotoName(id+".png");
		Files.write(Paths.get(System.getProperty("user.home")+"/ProjectImage/CatalogueWeb/products/"+p.getPhotoName()), file.getBytes());
		productRepository.save(p);
	}
	
}
