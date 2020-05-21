package org.sid.lightecom.web;

import org.sid.lightecom.entities.Magasin;
import org.sid.lightecom.service.MagasinService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MagasinRestController {
	
	private MagasinService magasinService;
	
	public MagasinRestController(MagasinService magasinService) {
		this.magasinService = magasinService;
	}
	
	@PostMapping("/addmag")
	public void ajouterMagasin(@RequestBody Magasin mag) {
		magasinService.addMagasin(mag);
	}
}
