package org.sid.lightecom.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String desciption;
	private double currentprice;
	private boolean promotion;
	private boolean selected;
	private boolean available;
	private String photoName;
	@CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

	
	@ManyToOne
	private Category category;
	@Transient
	private int quantity = 1;
	@ManyToMany	
	private Set<Magasin> magasin;
}
