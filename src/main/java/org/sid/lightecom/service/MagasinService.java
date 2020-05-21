package org.sid.lightecom.service;

import org.sid.lightecom.dao.MagasinRepository;
import org.sid.lightecom.entities.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MagasinService {

	@Autowired
	private MagasinRepository magasinRepository;
	
	public void addMagasin(Magasin m) {
		 magasinRepository.save(m);
	}
	
}
