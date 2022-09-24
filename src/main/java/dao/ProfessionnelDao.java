package dao;

import jpa.EntityManagerHelper;
import jpa.modele.Professionnel;
import jpa.modele.RDV;

public class ProfessionnelDao extends AbstractJpaDao<String, Professionnel>{

	public ProfessionnelDao() {
		super(Professionnel.class);
		// TODO Auto-generated constructor stub
	}
	
	public Professionnel getProInfoMail(String mail) {
		String query = "select f from Professionnel as f " + "where f.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query, Professionnel.class).setParameter("mail", mail).getSingleResult();
	}

}
