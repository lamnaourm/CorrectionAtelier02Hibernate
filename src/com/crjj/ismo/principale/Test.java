package com.crjj.ismo.principale;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crjj.ismo.entities.Entreprise;
import com.crjj.ismo.entities.Inventeur;
import com.exemple.Utils.HibernateUtils;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession(); 
		Transaction t = session.beginTransaction();
		
		List<Entreprise> entreprises = session.createQuery("from Entreprise").getResultList();
		
		System.out.println("Liste des entreprises : ");
		for(Entreprise e: entreprises) {
			System.out.println(e);
			for(Inventeur i : e.getInventeurs()) {
				System.out.println(" - " + i);
			}
		}
		
		t.commit();
		session.close();
	}

}
