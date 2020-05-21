package org.sid.lightecom.dao;

import java.util.List;

import org.sid.lightecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

	@RestResource(path = "/selectedProducts")
	public List<Product> findBySelectedIsTrue();
	@RestResource(path = "/productByKeyword")
	public List<Product> findByNameContains(@Param(value = "mc") String mc);
	@RestResource(path = "/promotionProducts")
	public List<Product> findByPromotionIsTrue();
	@RestResource(path = "/dispoProducts")
	public List<Product> findByAvailableIsTrue();
	
	
}
