package com.crjj.ismo.dao;

public class DaoFactory {
	
	
	public static IDao getDAO(TypeDao type) {
		switch (type) {
			case ENTREPRISE: return new DaoEntreprise();
			case INVENTEUR: return new DaoInventeur();
			case BREVET: return new DaoBrevet();
			case INVENTION: return new DaoInvention();
			case DOMAINE: return new DaoDomaine();
		}
		return null;
	}

}
