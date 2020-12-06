package servlets;

import metier.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		if( (login.equals("") || login.equals(null) ) || ( password.equals("") || password.equals(null) ) ) {
			request.getRequestDispatcher("Login.jsp?empty=true").forward(request, response);
		}
		else {
			GestUsers g=new GestUsers();
			Utilisateur u=g.Chercher(login, password);
			if (u !=null) {
				HttpSession maSession = request.getSession(true);
				maSession.setAttribute("user", u);
				request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Login.jsp?error=true").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
