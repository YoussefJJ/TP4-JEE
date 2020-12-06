package servlets;
import metier.*;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAjout
 */
@WebServlet("/ServletAjout")
public class ServletAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession maSession=request.getSession(false);
		if(maSession==null) {
			request.getRequestDispatcher("Login.jsp?session=true").forward(request, response);
		}
		else {
			Utilisateur u=(Utilisateur)maSession.getAttribute("user");
			if(u!=null) {
				GestUsers g=new GestUsers();
				String login=request.getParameter("login");
				String name=request.getParameter("name");
				String password=request.getParameter("password");
				String email=request.getParameter("email");
				String ville=request.getParameter("ville");
				Utilisateur u1=new Utilisateur();
				u1.setLogin(login);
				u1.setEmail(email);
				u1.setName(name);
				u1.setPass(password);
				u1.setVille(ville);
				g.ajouter(u1);
				request.getRequestDispatcher("ServletAffichage").forward(request, response);
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
