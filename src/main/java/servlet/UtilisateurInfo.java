	package servlet;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Collections;
	import java.util.Enumeration;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;
import jpa.modele.Utilisateur;

	@WebServlet(name="UtilisateurInfo",
	urlPatterns={"/UtilisateurInfo"})
	public class UtilisateurInfo extends HttpServlet {

		
	UtilisateurDao userDao;
	@Override
	public void init() throws ServletException {
		super.init();
		this.userDao = new UtilisateurDao();
	}
	
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
		 throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		
		Utilisateur user = new Utilisateur(request.getParameter("nom"),request.getParameter("mail"),request.getParameter("tel"));
		userDao.save(user);
		
		
		
		
		out.println("<HTML>\n<BODY>\n" +
					"<H1>Recapitulatif des informations</H1>\n" +
					"<UL>\n" +			
			" <LI>mail: "
					+ request.getParameter("mail") + "\n" +
					" <LI>nom: "
					+ request.getParameter("nom") + "\n"+
					" <LI>tel: "
					+ request.getParameter("tel") + "\n" 
					+
					"</UL>\n" +				
			"</BODY></HTML>");
	}
	}