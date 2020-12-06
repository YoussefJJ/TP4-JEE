package metier;

import dao.GestUsersDAO;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class GestUsers {
	GestUsersDAO dao;

	public GestUsers() {
		dao = new GestUsersDAO();
	}

	public Utilisateur Chercher(String login, String pass) {
		return dao.loadUser(login, pass);
	}
	public Utilisateur Select(String l) {
		return dao.selectUser(l);
	}
	public void ajouter(Utilisateur u) {
		dao.addUser(u.getLogin(),u.getName(), u.getPass(), u.getEmail(), u.getVille());
	}

	public Vector lister() {
		return dao.selectAll();
	}
	public void supprimer(Utilisateur u) {
		dao.deleteUser(u);
	}
	public void miseajour(Utilisateur u,Utilisateur nu) {
		dao.updateUser(u,nu.getLogin(), nu.getName(), nu.getPass(), nu.getEmail(), nu.getVille());
	}
}