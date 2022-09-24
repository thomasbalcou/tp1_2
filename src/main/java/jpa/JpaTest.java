package jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.*;
import jpa.modele.*;

public class JpaTest {

	private EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager=manager;
	}
	
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		//tx.begin();


		try {
			test.createExemple();

		} catch (Exception e) {
			System.out.println("erreur" );
			e.printStackTrace();
		}
		
		test.listRDV();
		//tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
	
	private void createExemple() throws ParseException {
			
		RDVDao rdvdao =new RDVDao();
		int nbrdv = rdvdao.findAll().size();
			if(nbrdv == 0) {
				ProfessionnelDao prodao=new ProfessionnelDao();
				Professeur pro = new Professeur("paul","paul@gmail.com","0611223344","informatique");
				Professeur pro2 = new Professeur("nicolas","nicolas@gmail.com","0611223344","math");
				prodao.save(pro);
				prodao.save(pro2);
			UtilisateurDao userdao =new UtilisateurDao();
				Utilisateur user = new Utilisateur("pierre","pierre@gmail.com","0611223344");
				Utilisateur user2 = new Utilisateur("maxime","maxime@gmail.com","0611223344");
				userdao.save(user);
				userdao.save(user2);
				
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = formatter.parse("2022/12/12 12:00:00");
			rdvdao.save(new RDV("conversation",30,date,pro,user));
			rdvdao.save(new RDV("conversation2",60,date,pro2,user2));
		
		}
	}
	

	private void listRDV() {
		RDVDao rdvdao = new RDVDao();
		List<RDV> resultList = rdvdao.getAllRDVcriteriaQuery();
		System.out.println("nombres de rdv:" + resultList.size());
			for(RDV s: resultList) {
				String NomPro = s.getPro().getNom();
				String NomUser = s.getUser().getNom();
				System.out.println("rdv:" + s.getIntitule() +" duree:" + s.getDuree() +" date:" + s.getDate()+" professionnel:"+NomPro +" utilisateur:"+NomUser);
			}
		}


}
