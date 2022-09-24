package dao;

import jpa.EntityManagerHelper;
import jpa.modele.Professionnel;
import jpa.modele.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur>{

	public UtilisateurDao() {
		super(Utilisateur.class);
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur getUserInfoMail(String mail) {
		String query = "select f from Utilisateur as f " + "where f.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).setParameter("mail", mail).getSingleResult();
	}


}
