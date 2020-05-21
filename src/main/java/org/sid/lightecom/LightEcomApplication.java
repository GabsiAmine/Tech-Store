package org.sid.lightecom;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.MagasinRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Magasin;
import org.sid.lightecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import net.bytebuddy.utility.RandomString;


@SpringBootApplication
@EnableJpaAuditing
public class LightEcomApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private MagasinRepository magasinRepository;;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(LightEcomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
		categoryRepository.save(new Category(null,"Computer",null,null,null));
		categoryRepository.save(new Category(null,"Printer",null,null,null));
		categoryRepository.save(new Category(null,"SmatPhone",null,null,null));
		
		Random rnd = new Random();
//		
//		for (int i = 0; i < 10; i++) {
//			
//			categoryRepository.findAll().forEach(c->{
//				Product p = new Product();
//				p.setName(RandomString.make(18));
//				p.setCurrentprice(100+rnd.nextInt(1000));
//				p.setAvailable(rnd.nextBoolean());
//				p.setSelected(rnd.nextBoolean());
//				p.setPromotion(rnd.nextBoolean());
//				p.setCategory(c);
//				p.setPhotoName("unknown.png");
//				productRepository.save(p);
//				});
//		}
		
		Magasin m = new Magasin();
		m.setName("Monoprix");
		m.setDesciption("Monoprix");
		Magasin m2 = new Magasin();
		m2.setName("MG");
		m2.setDesciption("MG");
		Magasin m3 = new Magasin();
		m3.setName("AZIZA");
		m3.setDesciption("AZIZA");
		magasinRepository.save(m);
		magasinRepository.save(m2);
		magasinRepository.save(m3);
		
		Set<Magasin> listmag  =new HashSet<Magasin>();
		listmag.add(m);
		listmag.add(m2);
		listmag.add(m3);
		Set<Product> produits  =new HashSet<Product>();
	
		for (int i = 0; i < 3; i++) {
			
		magasinRepository.findAll().forEach(mag->{
			categoryRepository.findAll().forEach(c->{
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCurrentprice(100+rnd.nextInt(1000));
				p.setAvailable(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setCategory(c);
				p.setPhotoName("unknown.png");
				p.setMagasin(listmag);
				productRepository.save(p);
				produits.add(p);
				});

		});
		}
		
		
		
	}

}
