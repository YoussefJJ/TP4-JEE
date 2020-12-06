package servlets;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.GestUsers;
import metier.Utilisateur;

/**
 * Servlet implementation class ServletUpdate
 */
@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpdate() {
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
		PrintWriter out=response.getWriter();
		HttpSession maSession = request.getSession(false);
		if (maSession == null) {
			request.getRequestDispatcher("Login.jsp?session=true").forward(request, response);
		} else {
			Utilisateur u = (Utilisateur) maSession.getAttribute("user");
			if (u != null) {
				out.println("test");
				if (request.getParameter("newlogin") == null) {
					String login = request.getParameter("login");
					request.setAttribute("login",login);
					request.getRequestDispatcher("Update.jsp").forward(request, response);
				} else {
					
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GestUsers g = new GestUsers();
		String login = request.getParameter("login");
		Utilisateur u1 = g.Select(login);
		String newlogin = request.getParameter("newlogin");
		String newname = request.getParameter("newname");
		String newemail = request.getParameter("newemail");
		String newpassword = request.getParameter("newpassword");
		String newville = request.getParameter("newville");
		Utilisateur nu = new Utilisateur();
		nu.setLogin(newlogin);
		nu.setEmail(newemail);
		nu.setName(newname);
		nu.setPass(newpassword);
		nu.setVille(newville);
		g.miseajour(u1, nu);
		response.sendRedirect("ServletAffichage");
	}

}
