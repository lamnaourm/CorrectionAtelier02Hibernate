package com.crjj.ismo.daotest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.crjj.ismo.dao.DaoFactory;
import com.crjj.ismo.dao.IDao;
import com.crjj.ismo.dao.TypeDao;
import com.crjj.ismo.entities.Entreprise;

class DaoEntrepriseTest {

	@Test
	void getAlltest() {
		IDao dao = DaoFactory.getDAO(TypeDao.ENTREPRISE);
		List<Entreprise> ents = dao.getAll();
		
		assertNotNull(ents);
		assertEquals(ents.size(), 16);
	}
	
	@Test
	void getOnetest_1() {
		IDao dao = DaoFactory.getDAO(TypeDao.ENTREPRISE);
		Entreprise ent = (Entreprise) dao.getOne(3);

		assertEquals(ent.getNumero(), 3);
		assertEquals(ent.getNom(), "MAROC TELECOM");
		assertEquals(ent.getActivite(), "TELECOM");
		assertEquals(ent.getCa(), 4355900);
		assertEquals(ent.getVille(), "RABAT");
	}
	
	@Test
	void getOnetest_2() {
		IDao dao = DaoFactory.getDAO(TypeDao.ENTREPRISE);
		Entreprise ent = (Entreprise) dao.getOne(3000);

		assertNull(ent);
	}
	
	@Test
	void savetest() {
		IDao dao = DaoFactory.getDAO(TypeDao.ENTREPRISE);
		List<Entreprise> ents_before = dao.getAll();
		Entreprise e = new Entreprise(0, "Test Nom entre", "Test Nom Activite", 23455, null, null);
		dao.save(e);
		List<Entreprise> ents_after = dao.getAll();
		assertEquals(ents_before.size()+1, ents_after.size());
	}

}
