package fr.adaming.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBanqueDao;
import fr.adaming.model.Banque;

@Service("baService")
@Transactional
public class BanqueServiceImpl implements IBanqueService {

	@Autowired
	private IBanqueDao baDao;

	public void setBaDao(IBanqueDao baDao) {
		this.baDao = baDao;
	}

	@Override
	public Banque virement(Banque b, Double somme) {
		// récuperer le compte de boVoyage
		Banque bIn = new Banque();
		bIn.setId(1);
		System.out.println("je suis dans la méthode service virement");

		Banque bOut = baDao.getCompte(bIn);

		// faire le virement si le compte est correct
		Banque bVerif = baDao.getCompte1(b);

		System.out.println("banque b est " + b.toString());
		System.out.println("bverif est " + bVerif.toString());

		// transformation de la date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String daate = sdf.format(bVerif.getDateExperiation());
		String daate1 = sdf.format(b.getDateExperiation());

		long d1 = bVerif.getDateExperiation().getMonth();
		long d1bis = b.getDateExperiation().getMonth();
		long d2 = bVerif.getDateExperiation().getYear();
		long d2bis = bVerif.getDateExperiation().getYear();

		System.out.println("d1 = " + d1);
		System.out.println("d1bis = " + d1bis);
		System.out.println("d2 = " + d2);
		System.out.println("d2bis = " + d2bis);

		if (bVerif.getNumeroCarte() == b.getNumeroCarte() && d1 == d1bis && d2 == d2bis
				&& bVerif.getCleSecurite() == b.getCleSecurite() && bVerif.getSolde() - somme >= 0) {
			bVerif.setSolde(bVerif.getSolde() - somme);
			baDao.updateCompte(bVerif);

			System.out.println("je lance la methode retrait et dépot");

			bOut.setSolde(bOut.getSolde() + somme);
			baDao.updateCompte(bOut);
		}

		return baDao.getCompte(bOut);
	}

	@Override
	public Banque getCompte(long id) {
		Banque bIn = new Banque();
		bIn.setId(id);
		return baDao.getCompte(bIn);
	}

	@Override
	public int updateCompte(long id) {
		Banque bIn = new Banque();
		bIn.setId(id);
		return baDao.updateCompte(bIn);
	}

	@Override
	public Banque verif(Banque b) {
		// récuperer le compte de boVoyage
		Banque bIn = new Banque();
		bIn.setId(1);

		Banque bOut = baDao.getCompte(bIn);

		// faire le virement si le compte est correct
		Banque bVerif = baDao.getCompte1(b);

		System.out.println("banque b est " + b.toString());
		System.out.println("bverif est " + bVerif.toString());

		// transformation de la date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String daate = sdf.format(bVerif.getDateExperiation());
		String daate1 = sdf.format(b.getDateExperiation());

		long d1 = bVerif.getDateExperiation().getMonth();
		long d1bis = b.getDateExperiation().getMonth();
		long d2 = bVerif.getDateExperiation().getYear();
		long d2bis = bVerif.getDateExperiation().getYear();

		System.out.println("d1 = " + d1);
		System.out.println("d1bis = " + d1bis);
		System.out.println("d2 = " + d2);
		System.out.println("d2bis = " + d2bis);

		if (bVerif.getNumeroCarte() == b.getNumeroCarte() && d1 == d1bis && d2 == d2bis
				&& bVerif.getCleSecurite() == b.getCleSecurite()) {
			return bVerif;
		}else {
			return null;
		}

		
		
	}
	
	

}
