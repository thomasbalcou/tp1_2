package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import jpa.EntityManagerHelper;
import jpa.modele.RDV;

public class RDVDao extends AbstractJpaDao<Long, RDV>{

	public RDVDao() {
		super(RDV.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<RDV> getRDVLibelle(String libelle) {
		String query = "select f from RDV as f " + "where f.libelle = :libelle";
		return EntityManagerHelper.getEntityManager().createQuery(query, RDV.class).setParameter("libelle", libelle).getResultList();
	}
	
	public List<RDV> getRDVUser(String mail) {
		String query = "select f from RDV as f " + "where f.pro_mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query, RDV.class).setParameter("mail", mail).getResultList();
	}
	public List<RDV> getRDVPro(String mail) {
		String query = "select f from RDV as f " + "where f.user_mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query, RDV.class).setParameter("mail", mail).getResultList();
	}


	public List<RDV> getAllRDVcriteriaQuery() {
		  
		EntityManager em = EntityManagerHelper.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<RDV> q = cb.createQuery(RDV.class);
		Root<RDV> c = q.from(RDV.class);
		q.select(c);
		TypedQuery<RDV> query = em.createQuery(q);
		List<RDV> results = query.getResultList();
		return results;
		
		

	}

}
