package fr.adaming.rest;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Banque;
import fr.adaming.service.BanqueServiceImpl;
import fr.adaming.service.IBanqueService;
@RestController
@RequestMapping("/compte")
@Controller
public class Banquecontroller {
	
	
	@Autowired
	IBanqueService baService;
	
	
	


	@RequestMapping(value="/get/{idB}",method=RequestMethod.GET,produces="application/json")
	public Banque getCompte(@PathVariable("idB") long id) {
		
		return baService.getCompte(id);
		
	}
	
	
	@RequestMapping(value="/virement/{dSomme}",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public Banque doVirement(@RequestBody Banque b,@PathVariable("dSomme") Double somme) {
		System.out.println("je lance la méthode de virement");
		
		return baService.virement(b, somme);
	}
	

}
