package servlets;

import metier.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Utilisateur;

/**
 * Servlet implementation class ServletAffichage
 */
@WebServlet("/ServletAffichage")
public class ServletAffichage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAffichage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession maSession = request.getSession(false);
		if (maSession==null) {
			request.getRequestDispatcher("Login.jsp?session=true").forward(request, response);
		} else {
			Utilisateur u = (Utilisateur)maSession.getAttribute("user");
			if (u != null) {
				GestUsers g=new GestUsers();
				Vector<Utilisateur> lu=g.lister();
				maSession.setAttribute("userlist", lu);
				request.getRequestDispatcher("Listing.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
