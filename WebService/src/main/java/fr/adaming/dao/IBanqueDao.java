package fr.adaming.dao;

import fr.adaming.model.Banque;

public interface IBanqueDao {
	
	public Banque virement(Banque b, Double somme);
	
	public Banque getCompte(Banque banque);
	
	public int updateCompte(Banque banque);
	
	public Banque getCompte1(Banque banque);

}
