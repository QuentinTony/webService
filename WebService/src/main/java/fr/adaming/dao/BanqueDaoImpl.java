package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Banque;

@Repository
public class BanqueDaoImpl implements IBanqueDao{
	
	@Autowired
	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Banque getCompte(Banque banque) {
		Session s=sf.getCurrentSession();
		
		return (Banque) s.get(Banque.class, banque.getId());
	}

	@Override
	public int updateCompte(Banque banque) {
		
		try {
		Session s=sf.getCurrentSession();
		
		s.saveOrUpdate(banque);
		return 1;
		}catch(Exception ex) {
			return 0;
		}
	}

	@Override
	public Banque virement(Banque b, Double somme) {
		
		
		return null;
	}

	@Override
	public Banque getCompte1(Banque banque) {
		Session s=sf.getCurrentSession();
		String req="FROM Banque b WHERE b.numeroCarte=:pNum";
		Query q=s.createQuery(req);
		q.setParameter("pNum", banque.getNumeroCarte());
		
		return (Banque) q.uniqueResult();
	}

	
}
