package com.crjj.ismo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crjj.ismo.entities.Entreprise;
import com.crjj.ismo.entities.Inventeur;
import com.exemple.Utils.HibernateUtils;

public class DaoEntreprise implements IDao<Entreprise> {

	@Override
	public List<Entreprise> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Entreprise> entreprises = session.createQuery("from Entreprise").getResultList();

		t.commit();
		session.close();

		return entreprises;
	}

	@Override
	public Entreprise getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Entreprise entreprise = session.get(Entreprise.class, id);

		t.commit();
		session.close();

		return entreprise;
	}

	@Override
	public boolean save(Entreprise obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			Object o = session.save(obj);

			System.out.println(o);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Entreprise obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Entreprise obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
